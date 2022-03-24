package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.dao.AppUserDAO;
import com.careerit.cbook.dao.AppUserDAOImpl;
import com.careerit.cbook.domain.AppUser;

public class AppUserServiceImpl implements AppUserService {

	@Override
	public AppUser findUserByNameAndPassword(String userName, String password) {

		AppUserDAO appUserDAO = new AppUserDAOImpl();
		AppUser appUser = appUserDAO.findUserByNameAndPassword(userName, password);
		
		return appUser;
	}

}
