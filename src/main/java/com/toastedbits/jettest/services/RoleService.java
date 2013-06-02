package com.toastedbits.jettest.services;

import com.toastedbits.jettest.models.Role;

public interface RoleService {
	public Role getRole(String role);
	public void save(Role role);
}
