package com.careerit.cbook.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.careerit.cbook.dao.ContactDAOImpl;
import com.careerit.cbook.domain.Contact;

public class ContactServiceImpl implements ContactService{
	private Long uid;
	public List<Contact> contacts;
	private ContactDAOImpl dao = new ContactDAOImpl();

	public ContactServiceImpl(Long uid) {
		this.uid = uid;
	}

	@Override
	public void addContact(String name, String email, String mobile, String dob) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Contact contact;
		try {
			contact = Contact.builder().name(name).email(email).mobile(mobile).uid(uid).status(1).dob(formatter.parse(dob)).build();
			dao.createContact(contact);
			System.out.println("Successfully added");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		contacts = dao.getContacts(uid);
		return contacts;
	}

	@Override
	public List<Contact> searchContact(String name) {
		List<Contact> rs = new ArrayList<>();
		for (Contact contact:contacts) {
			if(contact.getName().equals(name)) {
				rs.add(contact);
			}
		}
		
		return rs;
	}

	@Override
	public List<Contact> getContactByMobile(String number) {
		List<Contact> rs = new ArrayList<>();
		for (Contact contact:contacts) {
			if(contact.getMobile().equals(number)) {
				rs.add(contact);
			}
		}
		return rs;
	}

	@Override
	public List<Contact> getContactByEmail(String email) {
		List<Contact> rs = new ArrayList<>();
		for (Contact contact:contacts) {
			if(contact.getEmail().equals(email)) {
				rs.add(contact);
			}
		}
		return rs;
	}

	@Override
	public Contact updateContact(String name, String email, Date dob, String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

}
