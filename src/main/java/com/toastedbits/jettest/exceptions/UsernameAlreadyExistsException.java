package com.toastedbits.jettest.exceptions;

public class UsernameAlreadyExistsException extends Exception {
	private static final long serialVersionUID = -554469629506636173L;
	
	public UsernameAlreadyExistsException(String username) {
		super("Username " + username + " already exists");
	}
}