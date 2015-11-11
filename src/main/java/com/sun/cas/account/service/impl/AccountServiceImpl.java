package com.sun.cas.account.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.cas.account.dao.AccountDaoImpl;
import com.sun.wen.lou.newtec.entity.UserAccount;
import com.sun.wen.lou.newtec.service.UserAccountService;

public class AccountServiceImpl {

	/**
	 * url=jdbc:mysql://localhost:3306/cas?useUnicode=true&characterEncoding=
	 * UTF8 username=root password=123456
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
@Autowired

private UserAccountService useraccountservice;

	public UserAccountService getUseraccountservice() {
		return useraccountservice;
	}

	public void setUseraccountservice(UserAccountService useraccountservice) {
		this.useraccountservice = useraccountservice;
	}

	private static Connection getConn() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/newtecanolegy?useUnicode=true&characterEncoding=UTF8";
		String username = "root";
		String password = "123456";
		try {

			Class.forName("com.mysql.jdbc.Driver");//
			conn = DriverManager.getConnection(url, username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public   UserAccount getCasUser(String username) {
		UserAccount user = useraccountservice.queryByUserName(username);
		/*try {
			Statement stmt = getConn().createStatement();
			ResultSet rs = stmt.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值

			user = new UserAccount();
			while (rs.next()) {
				user.setUserAccountId(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return user;
	}

	/**
	 * 检查是否是数据库中的用户
	 * 
	 * @param username
	 * @param pwd
	 * @return
	 */
	public boolean checkAccount(String username, String pwd) {
		UserAccount user = getCasUser(username);
		if (null == user) {
			return false;
		}
		if (!(pwd.trim().equals(user.getPwd()))) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
//		System.out.println("是数据库中的用户吗：" + checkAccount("sun", "1"));
	}
	
	private AccountDaoImpl accountDao;

	public AccountDaoImpl getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDaoImpl accountDao) {
		this.accountDao = accountDao;
	}
	
}
