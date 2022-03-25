package com.careerit.cbook.service;

import java.text.ParseException;
import com.careerit.cbook.DTO.userProfileDTO;
import com.careerit.cbook.dao.AppUserDAOImpl;
import com.careerit.cbook.domain.AppUser;

public class AppUserServiceImpl implements AppUserService {

	private AppUserDAOImpl dao = new AppUserDAOImpl();
	public AppUser user;

	@Override
	public void userRegister(String name, String password, String email, String dob, String mobile) {
		try {
			user = AppUser.builder().name(name).password(password).email(email).mobile(mobile)
					.dob(dao.formatter.parse(dob)).build();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dao.ifUserExist(user)) {
			System.out.println("User already exists. Please login");
		} else {
			dao.insertUser(user);
			System.out.println("Register succefully. Please login");
		}
	}

	@Override
	public void userEmailLogin(String email, String password) {
		AppUser tuser = AppUser.builder().email(email).password(password).build();
		if (!dao.ifUserExist(tuser)) {
			System.out.println("User doesn't exist. Please register");
		} else {
			AppUser rs = dao.getUserProfile("email", email, password);
			if (rs == null) {
				System.out.println("Wrong password. Please try again");
			} else {
				user = rs;
				System.out.println("Login succefully. Your uid: " + rs.getUid());
			}
		}
	}

	@Override
	public void userMobileLogin(String mobile, String password) {
		AppUser tuser = AppUser.builder().mobile(mobile).password(password).build();
		if (!dao.ifUserExist(tuser)) {
			System.out.println("User doesn't exist. Please register");
		} else {
			AppUser rs = dao.getUserProfile("mobile", mobile, password);
			if (rs == null) {
				System.out.println("Wrong password. Please try again");
			} else {
				user = rs;
				System.out.println("Login succefully. Your uid: " + user.getUid());
			}
		}
	}

	@Override
	public userProfileDTO getFile() {
		return new userProfileDTO(user.getUid(), user.getName(), user.getEmail());
	}

}
