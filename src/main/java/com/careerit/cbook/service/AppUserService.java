package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.domain.AppUser;

public interface AppUserService {
	public AppUser findUserByNameAndPassword(String userName, String password);


}
