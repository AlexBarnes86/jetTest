package com.toastedbits.jettest.launch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.toastedbits.jettest.exceptions.UsernameAlreadyExistsException;
import com.toastedbits.jettest.models.User;
import com.toastedbits.jettest.services.RoleService;
import com.toastedbits.jettest.services.UserService;

public class InitDB {
	private static final Logger LOG = LoggerFactory.getLogger(InitDB.class);
	
	private String adminLogin;
	private String adminPassword;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	public void start() throws UsernameAlreadyExistsException {
		createAdminUser();
	}
	
	private void createAdminUser() throws UsernameAlreadyExistsException {
		User admin = userService.getUser(adminLogin);
		if(admin == null) {
			LOG.info("No admin user found, creating default admin user");
			userService.createAdminUser(adminLogin, adminPassword);
		}
	}
	
	public String getAdminLogin() {
		return adminLogin;
	}
	
	public void setAdminLogin(String adminLogin) {
		this.adminLogin = adminLogin;
	}
	
	public String getAdminPassword() {
		return adminPassword;
	}
	
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
}