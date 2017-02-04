/**
 * This is a utility class for database
 * connection
 * 
 * @version: v.1.0 - 10 mag 2016 19:08:28 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnection
{

	String driver = null;
	String url = null;
	String user = null;
	String pass = null;
	Connection con = null;
	ResourceBundle rb = null;

	public DBConnection()
	{
		rb = ResourceBundle.getBundle("com.kirth.util\\DB");
		this.driver = rb.getString("driver");
		System.out.println("Driver string is: " + driver);
		this.url = rb.getString("url");
		System.out.println("url string is: " + url);
		this.user = rb.getString("user");
		System.out.println("user string is: " + user);
		this.pass = rb.getString("pass");
		System.out.println("pass string is: " + pass);
	}

	/**
	 * This method establish a database connection.
	 * 
	 * @return a valid connection object
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception
	{

		try
		{
			Class.forName(driver);
			this.con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e)
		{
			throw new Exception("Exception occured at getConnection " + e.getMessage());
		}
		return con;

	}
}
