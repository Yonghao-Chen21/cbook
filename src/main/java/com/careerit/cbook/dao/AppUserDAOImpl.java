package com.careerit.cbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.careerit.cbook.domain.AppUser;
import com.careerit.cbook.util.ConnectionUtil;

public class AppUserDAOImpl implements AppUserDAO {
	private ConnectionUtil conUtil = ConnectionUtil.obj;
	public SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public boolean ifUserExist(AppUser user) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (user.getEmail() != null) {
			String str = "select uid from appuser where email=?";
			try {
				con = conUtil.getConnection();
				pst = con.prepareStatement(str);
				pst.setString(1, user.getEmail());
				rs = pst.executeQuery();
				if (rs.next()) {
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conUtil.close(rs, pst, con);
			}
		} else {
			String str = "select uid from appuser where mobile=?";
			try {
				con = conUtil.getConnection();
				pst = con.prepareStatement(str);
				pst.setString(1, user.getMobile());
				rs = pst.executeQuery();
				if (rs.next()) {
					flag = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conUtil.close(rs, pst, con);
			}
		}
		return flag;
	}

	@Override
	public void insertUser(AppUser user) {
		String str = "insert into appuser(name,password,email,mobile,dob) values(?,?,?,?,?);";
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(str);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getMobile());
			if (user.getDob() != null) {
				pst.setDate(5, new java.sql.Date(user.getDob().getTime()));
			} else {
				pst.setDate(5, null);
			}
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(pst, con);
		}

	}

	@Override
	public AppUser getUserProfile(String method, String entry, String password) {
		String str = "select uid,name,email,mobile,dob from appuser where ";
		String sql = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		if (method.equals("email")) {
			sql = str + "email=? and password=?";
		} else if (method.equals("mobile")) {
			sql = str + "mobile=? and password=?";
		}
		try {
			con = conUtil.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, entry);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				Long uid = rs.getLong("uid");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				Date dob = rs.getDate("dob");
				AppUser user = AppUser.builder().uid(uid).name(name).email(email).mobile(mobile).dob(dob).build();
				return user;
			}

		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			conUtil.close(rs, pst, con);
		}
		return null;
	}

}
