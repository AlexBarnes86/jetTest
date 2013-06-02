package com.toastedbits.jettest.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toastedbits.jettest.models.Role;
import com.toastedbits.jettest.repositories.UserRepository;

@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;
	
	public UserDetails loadUserByUsername(String login)
	throws UsernameNotFoundException {
		
		com.toastedbits.jettest.models.User domainUser = userRepo.getUser(login);
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new User(
			domainUser.getLogin(),
			domainUser.getPassword(),
			enabled,
			accountNonExpired,
			credentialsNonExpired,
			accountNonLocked,
			getAuthorities(domainUser)
		);
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(com.toastedbits.jettest.models.User user) {
		System.out.println("Roles for user: " + user.getLogin() + ": " + user.getRoles());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		return authorities;
	}
}
