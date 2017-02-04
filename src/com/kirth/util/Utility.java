/**
 * This is a general utility class to generate
 * random token
 * 
 * @version: v.1.0 - 10 mag 2016 16:43:20 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.text.SimpleDateFormat;

import com.kirth.util.AESEncryption;
import com.kirth.util.Base64Coder;

public class Utility implements Cloneable
{
	private static Utility instance;

	private Utility()
	{
		// no-ops
	}

	/**
	 * This method retrieves the instance of a Utility using the Singleton pattern.
	 * 
	 * @return a Utility instance
	 */
	public static synchronized Utility getInstance()
	{
		if (instance == null)
		{
			instance = new Utility();
		}
		return instance;
	}

	/**
	 * This method retrieves the current date.
	 * 
	 * @return today date in String representation
	 */
	public String getDate()
	{
		String date = null;
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = df1.format(new java.util.Date());
		return date;
	}

	/**
	 * This method generates a random token
	 * 
	 * @return a string representing the random token
	 */
	public String generateRandomToken()
	{
		long timeSeed = System.nanoTime(); // to get the current date time value
		double randSeed = Math.random() * 1000; // random number generation
		long midSeed = (long) (timeSeed * randSeed); // mixing up the time and
		// rand number.
		String s = midSeed + "";
		String subStr = s.substring(0, 8);
		return subStr;
	}

	/**
	 * This method manages operations related to the forgot password functionality
	 * 
	 * @param utid
	 * @param resetUrl
	 * @param emailId
	 * @return
	 * @throws Exception
	 */
	public String frameResetLink(String utid, String resetUrl, String emailId) throws Exception
	{
		String encrypt_token = null;
		String encrypt_email = null;
		String sub_tok = null;
		String email_tok = null;

		/*
		 * encrypt token value use AES encryption(Any encryption method can be used)
		 */
		sub_tok = AESEncryption.encrypt(utid);
		/*
		 * again encrypted using base64 encoding
		 */
		encrypt_token = Base64Coder.encodeString(sub_tok);

		/*
		 * encrypt email value use AES encryption(Any encryption method can be used)
		 */
		email_tok = AESEncryption.encrypt(emailId);

		/*
		 * again encrypted using base64 encoding
		 */
		encrypt_email = Base64Coder.encodeString(email_tok);

		// creating Reset Link
		String resetlink = resetUrl + "?USERID=" + encrypt_email + "&UTID=" + encrypt_token;
		String link = " Dear user:-" + "\n Please follow the link to reset your password\n"
				+ resetlink + "";
		return link;
	}

	/**
	 * This method decrypts some encrypted data.
	 * 
	 * @param encryptedData
	 * @return data in not encrypted format
	 * @throws Exception
	 */
	public String decryptData(String encryptedData) throws Exception
	{
		String decrypteddata = null;
		try
		{
			decrypteddata = AESEncryption.decrypt(Base64Coder.decodeString(encryptedData));
		} catch (Exception e)
		{
			throw new Exception("Error while authenticating user data<br>'Invalid Request found'");
		}

		return decrypteddata;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		throw new CloneNotSupportedException(
				this.getClass().getSimpleName() + " probhited Cloning");
	}
}