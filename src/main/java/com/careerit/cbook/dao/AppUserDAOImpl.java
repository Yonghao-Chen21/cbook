package com.careerit.cbook.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.careerit.cbook.domain.AppUser;
import com.careerit.cbook.util.CbookReaderUtil;

public class AppUserDAOImpl implements AppUserDAO {

	@Override
	public List<AppUser> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser findUserByNameAndPassword(String userName, String password) {

		AppUser user = null;
		String sql_str = "select id,username, pwd, email, dob, phone_no from user_info  where username=? and pwd = ?";
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = CbookReaderUtil.obj.getConnection();
			pst = con.prepareStatement(sql_str);
			pst.setString(1, userName);
			pst.setString(2, password);
			rs = pst.executeQuery();
			while (rs.next()) {
				Long pid = rs.getLong("id");
				String username = rs.getString("username");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				Date date = rs.getDate("dob");
				String phone = rs.getString("phone_no");

				user = AppUser.builder().uid(pid).name(username).password(pwd).email(email).dob(date).mobile(phone).build();

			}
		} catch (SQLException e) {
			System.out.println("While connecting with db :" + e);
		} finally {
			CbookReaderUtil.obj.close(rs, pst, con);
		}
		return user;
	}
}
