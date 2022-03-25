package com.careerit.cbook.service;

import com.careerit.cbook.DTO.userProfileDTO;

interface AppUserService {

	// register account
	public void userRegister(String name, String password, String email, String dob, String mobile);

	// login
	public void userEmailLogin(String email, String password);

	// login
	public void userMobileLogin(String mobile, String password);

	// get profile
	public userProfileDTO getFile();
}
