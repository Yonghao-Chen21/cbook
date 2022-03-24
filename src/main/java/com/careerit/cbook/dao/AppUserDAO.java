package com.careerit.cbook.dao;

import com.careerit.cbook.domain.AppUser;

interface AppUserDAO {
	// check if the user exist;
	public boolean ifUserExist();

	// Insert registered user to DB
	public void insertUser();

	// get the login information and return user information
	public AppUser getUserProfile();

}
