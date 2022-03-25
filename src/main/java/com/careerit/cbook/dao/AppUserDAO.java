package com.careerit.cbook.dao;

import com.careerit.cbook.domain.AppUser;

interface AppUserDAO {
	// check if the user exist;
	public boolean ifUserExist(AppUser user);

	// Insert registered user to DB
	public void insertUser(AppUser user);

	// get the login information and return user information
	public AppUser getUserProfile(String method, String entry, String password);

}
