package com.toastedbits.jettest.repositories;

import com.toastedbits.jettest.models.User;

public interface UserRepository {
	public User getUser(String login);
	public void save(User user);
}