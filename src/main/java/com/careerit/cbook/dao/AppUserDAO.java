package com.careerit.cbook.dao;

import java.util.List;

import com.careerit.cbook.domain.AppUser;

public interface AppUserDAO {

	public List<AppUser> findAllUsers();

	public AppUser findUserByNameAndPassword(String userName, String password);

}
