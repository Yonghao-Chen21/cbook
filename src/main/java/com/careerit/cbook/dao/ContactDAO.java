package com.careerit.cbook.dao;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactDAO {

	List<Contact> findAllContacts();
	
}
