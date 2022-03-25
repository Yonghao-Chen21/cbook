package com.careerit.cbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.careerit.cbook.domain.AppUser;
import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.util.ConnectionUtil;

public class ContactDAOImpl implements ContactDAO{
	private ConnectionUtil conUtil = ConnectionUtil.obj;

	@Override
	public List<Contact> getContacts(Long uid) {
		String str = "select cid,name,email,mobile,dob,status from contact where cid = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Contact> contacts = new ArrayList<>();
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setLong(1, uid);
			rs = pst.executeQuery();
			while (rs.next()) {
				Long cid = rs.getLong("cid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				Date dob = rs.getDate("dob");
				int status = rs.getInt("status");
				Contact contact = Contact.builder().cid(cid).name(name).email(email).mobile(mobile).dob(dob).status(status).uid(uid).build();
				contacts.add(contact);
			}

		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return contacts;
	}

	@Override
	public void createContact(Contact contact) {
		String str = "insert into contact(name,email,mobile,dob,status,uid) values(?,?,?,?,?,?);";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getEmail());
			pst.setString(3, contact.getMobile());
			pst.setDate(4, new java.sql.Date(contact.getDob().getTime()));
			pst.setInt(5, contact.getStatus());
			pst.setLong(6, contact.getUid());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
		
	}

	@Override
	public void deleteContact(Contact contact) {
		String str = "update contact set status = 0 where cid =?";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setLong(1, contact.getCid());
			System.out.println("record deleted");
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}
		
	}

	@Override
	public void editContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

}
