package com.careerit.cbook.service;

import java.util.Date;
import java.util.List;

import com.careerit.cbook.domain.Contact;

interface ContactService {
	// insert one contact
	public void addContact(String name, String email, String mobile, String dob);

	// get the contacts from uid
	public List<Contact> getAllContacts();
	
	//get contact by user name
	public List<Contact> searchContact(String name);

	//get contact by user number
	public List<Contact> getContactByMobile(String number);

	//get contact by user email
	public List<Contact> getContactByEmail(String email);

	//update contact
	public Contact updateContact(String name, String email, Date dob, String mobile);

}
