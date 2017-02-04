/**
 * This class manages forgot password
 * user requests. User will receive a token link
 * which has expiration date to be used for verifying the request and
 * then updating the password
 * 
 * @version: v.1.0 - 10 mag 2016 13:06:45 
 * @author:  Marco Canavese
 */
package com.kirth.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

//import com.kirth.model.User;
//import com.kirth.util.DBConnection;
import com.kirth.util.DateDifference;
import com.kirth.util.PasswordUtil;
import com.kirth.util.SendMail;
import com.kirth.util.Utility;
import com.kirth.dao.LoginDao;

/**
 *
 */
public class FPDao
{
	// DBConnection dBconn;
	Connection dBconn;
	Statement stmt;
	PreparedStatement pst;
	SendMail mail;
	ResourceBundle bundle;

	public FPDao() throws MissingResourceException, NullPointerException
	{
		this.bundle = ResourceBundle.getBundle("com.kirth.util\\DB");
	}

	/**
	 * This method set the token and the expiration date for the forgot password feature
	 * 
	 * @param emailId
	 *            the email address the user is registered with
	 * @return a collection containing results and reasons of the request
	 * @throws Exception
	 */
	public HashMap<String, String> insertData(String emailId) throws Exception
	{
		HashMap<String, String> dataMap = new HashMap<String, String>();
		Connection con = null;
		try
		{
			ResultSet rset;
			String token = Utility.getInstance().generateRandomToken();
			System.out.println("Generating random token...: " + token);

			con = LoginDao.getConnection();

			pst = con.prepareStatement("SELECT * FROM users " + "WHERE email = ?");
			pst.setString(1, emailId);
			rset = pst.executeQuery();

			if (rset.next())
			{
				String today = Utility.getInstance().getDate();
				pst = con.prepareStatement(
						"UPDATE users set token = ?, status = 'REQ', accessedtime = ? WHERE email = ?");
				pst.setString(1, token);
				pst.setString(2, today);
				pst.setString(3, emailId);
				int updatecount = pst.executeUpdate();

				if (updatecount >= 1)
				{
					mail = new SendMail();
					Boolean b = mail.sendMail(emailId, null,
							"New password request for Smart Working Account",
							Utility.getInstance().frameResetLink(token,
									bundle.getString("forgetpasswordlink"), emailId),
							null);
					if (b)
					{
						dataMap.put("RESULT", "SUCCESS");
						dataMap.put("REASON",
								"Your password reset link has been sent to the specified email address. Please check your inbox.");
					} else
					{
						dataMap.put("RESULT", "FAILURE");
						dataMap.put("REASON",
								"Problem in resetting the password. Please try again later.");
					}
				} else
				{
					dataMap.put("RESULT", "FAILURE");
					dataMap.put("REASON", "Unable to update in DataBase");
				}
			} else
			{
				dataMap.put("RESULT", "FAILURE");
				dataMap.put("REASON", "Email ID does not exist");
			}

		} catch (Exception e)
		{
			dataMap.put("RESULT", "EXCEPTION");
			dataMap.put("REASON", e.getMessage());
		} finally
		{
			con.close();
		}

		return dataMap;
	}

	/**
	 * This method actually reset the user password upon request verification process is successful
	 * 
	 * @param utid
	 *            the userid
	 * @param emailId
	 *            the email address for the userid
	 * @param newPassword
	 *            the new password chosen by the user
	 * @return a collection containing the result and reason of the operation
	 * @throws Exception
	 */
	public HashMap<String, String> insertData(String utid, String emailId, String newPassword)
			throws Exception
	{
		HashMap<String, String> dataMap = new HashMap<String, String>();
		Connection con = null;
		try
		{
			con = LoginDao.getConnection();

			pst = con.prepareStatement(
					"UPDATE users SET password = ?, status = 'CLOSE' WHERE email = ? AND token = ?");

			String hashedPassword = PasswordUtil.hashPassword(newPassword);

			pst.setString(1, hashedPassword);
			pst.setString(2, emailId);
			pst.setString(3, utid);

			int updatecount = pst.executeUpdate();

			if (updatecount >= 1)
			{
				dataMap.put("RESULT", "SUCCESS");
				dataMap.put("REASON", "Password changed successfully");
			} else
			{
				dataMap.put("RESULT", "FAILURE");
				dataMap.put("REASON",
						"Unable to change the password<br />Reason:- Invalid EmailId");
			}
		} catch (Exception e)
		{
			dataMap.put("RESULT", "EXCEPTION");
			dataMap.put("REASON", e.getMessage());
		} finally
		{
			con.close();
		}

		return dataMap;
	}

	/**
	 * This method checks the user request for a new password
	 * 
	 * @param utid
	 *            the userid
	 * @param emailId
	 *            the email address for the userid
	 * @return a collection containing the reason and result of the operation
	 * @throws Exception
	 */
	public HashMap<String, String> verifyRequest(String utid, String emailId) throws Exception
	{
		HashMap<String, String> dataMap = new HashMap<String, String>();
		Connection con = null;
		try
		{
			String accesstime = null;
			String status = null;
			ResultSet rset;

			con = LoginDao.getConnection();

			pst = con.prepareStatement(
					"SELECT accessedtime, status FROM users WHERE token = ? AND email = ?");
			pst.setString(1, utid);
			pst.setString(2, emailId);
			rset = pst.executeQuery();

			if (rset.next())
			{
				accesstime = rset.getString("accessedtime");
				status = rset.getString("status");
				String statusmessage = new DateDifference().datevalidator(accesstime,
						Utility.getInstance().getDate());
				if (statusmessage.equalsIgnoreCase("invalid") || status.equalsIgnoreCase("CLOSE")
						|| status.equalsIgnoreCase("CANCEL"))
				{
					pst = con.prepareStatement(
							"UPDATE users SET status = 'CANCEL' WHERE token = ? AND email = ?");
					pst.setString(1, utid);
					pst.setString(2, emailId);
					rset = pst.executeQuery();

					dataMap.put("RESULT", "FAILURE");
					dataMap.put("REASON", "TIMEOUT");

				} else
				{
					dataMap.put("RESULT", "SUCCESS");
					dataMap.put("REASON", bundle.getString("redirectUrl"));
				}

			} else
			{
				dataMap.put("RESULT", "FAILURE");
				dataMap.put("REASON", "INVALIDREQ");
			}

		} catch (Exception e)
		{
			dataMap.put("RESULT", "EXCEPTION");
			dataMap.put("REASON", e.getMessage());
		} finally
		{
			con.close();
		}

		return dataMap;
	}

}