package com.toastedbits.jettest.repositories;

import com.toastedbits.jettest.models.Role;

public interface RoleRepository {
	public Role getRole(String role);
	public void save(Role role);
}
