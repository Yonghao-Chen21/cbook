package com.careerit.cbook.dao;

import java.util.List;

import com.careerit.cbook.domain.Contact;

interface ContactDAO {
	//get the contacts from uid
	public List<Contact> getContacts(Long uid);
	
	//create one contact in db
	public void createContact(Contact contact);
	
	//soft delete one contact in db
	public void deleteContact(Contact contact);
	
	//edit one contact in db
	public void editContact(Contact contact);
	

}
