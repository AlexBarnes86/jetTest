package com.toastedbits.jettest.services;

import com.toastedbits.jettest.exceptions.UsernameAlreadyExistsException;
import com.toastedbits.jettest.models.User;

public interface UserService {
	public User getUser(String login);
	public void save(User user);
	
	public void createAdminUser(String username, String password) throws UsernameAlreadyExistsException;
	public User addUser(String username, String password) throws UsernameAlreadyExistsException;
	public void grantRole(User user, String roleName);
}
