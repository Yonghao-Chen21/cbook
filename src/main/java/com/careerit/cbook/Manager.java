package com.careerit.cbook;

import com.careerit.cbook.service.AppUserServiceImpl;
import com.careerit.cbook.service.ContactServiceImpl;

public class Manager {
	public static void main(String[] args) {
		AppUserServiceImpl obj = new AppUserServiceImpl();
		obj.userRegister("John", "123", "xyz@email.com", "2000-10-11", "203141");
		obj.userEmailLogin("xyz@email.com", "254");
		obj.userEmailLogin("xyz@email.com", "123");
		System.out.println(obj.getFile());
		ContactServiceImpl cobj = new ContactServiceImpl(obj.user.getUid());
		cobj.addContact("Mike", "aadsa@asda.com", "1213562", "1963-12-01");
		System.out.println(cobj.getAllContacts());

	}
}
