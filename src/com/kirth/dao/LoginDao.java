/**
 * This class enables to connect to the application
 *  with the backend database and execute the query to the DB
 * 
 * @version: v.1.0 - 09 apr 2016 21:53:51 
 * @author: Marco Canavese
 */
package com.kirth.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kirth.util.PasswordUtil;

public class LoginDao
{
	/**
	 * This method establish a valid connection to the backend database
	 * 
	 * @return a valid connection to the database
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, InstantiationException,
			IllegalAccessException, ClassNotFoundException
	{
		//Change the url parameter appropriately
		String url = "jdbc:mysql://localhost:3306/";
		//Change the database name parameter appropriately
		String dbName = "logintest";
		String driver = "com.mysql.jdbc.Driver";
		//Change the database administrator username parameter appropriately
		String userName = "root";
		//Change the database administrator password parameter appropriately
		String password = "";
		Class.forName(driver).newInstance();
		return DriverManager.getConnection(url + dbName, userName, password);
	}

	/**
	 * This method check the user role in the appropriate table of the database
	 * 
	 * @param name
	 *            the userid of the user
	 * @return the role of the user (manager/user/administrator)
	 */
	public static String checkRole(String name)
	{
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String userRole = "";
		try
		{
			conn = getConnection();
			pst = conn.prepareStatement(
					"SELECT username, role FROM users_roles " + "WHERE username = ?");
			pst.setString(1, name);
			rs = pst.executeQuery();

			while (rs.next())
			{
				userRole = rs.getString(2);
			}

		} catch (Exception e)
		{
			System.out.println(e);
		}

		return userRole;
	}

	/**
	 * This method authenticate the user if valid credentials are entered into the login form.
	 * 
	 * @param name
	 *            the username to log in
	 * @param pass
	 *            the password to log in
	 * @return true if valid credentials are entered false otherwise
	 */
	public static boolean validate(String name, String pass)
	{
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		// code block to use hashed and salted passwords
		// hash and salt password
		String hashedPassword;
		String salt = "";
		String saltedAndHashedPassword;
		try
		{
			hashedPassword = PasswordUtil.hashPassword(pass);
			salt = PasswordUtil.getSalt();
			saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(pass);
			System.out.println("Hashed password is: " + hashedPassword);

		} catch (NoSuchAlgorithmException ex)
		{
			hashedPassword = ex.getMessage();
			saltedAndHashedPassword = ex.getMessage();
		}
		// end code block to use hashed and salted passwords

		try
		{
			conn = getConnection();
			pst = conn.prepareStatement(
					"select user,password from users where user=? and password=?");
			pst.setString(1, name);
			pst.setString(2, hashedPassword);

			rs = pst.executeQuery();
			status = rs.next();

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (pst != null)
			{
				try
				{
					pst.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if (rs != null)
			{
				try
				{
					rs.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}
