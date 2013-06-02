package com.toastedbits.jettest.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toastedbits.jettest.exceptions.UsernameAlreadyExistsException;
import com.toastedbits.jettest.models.Role;
import com.toastedbits.jettest.models.User;
import com.toastedbits.jettest.repositories.RoleRepository;
import com.toastedbits.jettest.repositories.UserRepository;
import com.toastedbits.jettest.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User getUser(String login) {
		return userRepo.getUser(login);
	}
	
	public void save(User user) {
		userRepo.save(user);
	}
	
	public void createAdminUser(String username, String password) throws UsernameAlreadyExistsException {
		User user = addUser(username, password);
		grantRole(user, Role.ROLE_ADMIN);
	}
	
	public User addUser(String username, String password) throws UsernameAlreadyExistsException {
		User newUser = userRepo.getUser(username);
		
		if (newUser != null) {
			throw new UsernameAlreadyExistsException(username);
		}
		else {
			newUser = new User();
			newUser.setLogin(username);
			
			newUser.setPassword(passwordEncoder.encode(password));
			userRepo.save(newUser);
			return newUser;
		}
	}
	
	public void grantRole(User user, String roleName) {
		Role role = roleRepo.getRole(roleName);
		if(role == null) {
			role = new Role();
			role.setRole(roleName);
			roleRepo.save(role);
		}
		
		Set<Role> roles = user.getRoles();
		if(roles == null) {
			roles = new HashSet<Role>();
			user.setRoles(roles);
		}
		
		roles.add(role);
		userRepo.save(user);
	}
}
