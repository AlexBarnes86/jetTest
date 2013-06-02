package com.toastedbits.jettest.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toastedbits.jettest.repositories.RoleRepository;
import com.toastedbits.jettest.models.Role;

import com.toastedbits.jettest.services.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepo;
	
	public Role getRole(String role) {
		return roleRepo.getRole(role);
	}
	
	public void save(Role role) {
		roleRepo.save(role);
	}
}
