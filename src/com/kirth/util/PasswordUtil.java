/**
 * This class provide utility functions to perform
 * hash and salt of passwords with sha-256 (or any other
 * available algorithm)
 * 
 * @version: v.1.0 - 12 apr 2016 11:56:55 
 * @author: Marco Canavese
 */
package com.kirth.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class PasswordUtil
{

	/**
	 * This code uses SHA-256. If this algorithm isn't available to you, you can try a weaker level
	 * of encryption such as SHA-128.
	 * 
	 * @param password
	 * @return the hash representation of the password in plain text
	 * @throws NoSuchAlgorithmException
	 */
	public static String hashPassword(String password) throws NoSuchAlgorithmException
	{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.reset();
		md.update(password.getBytes());
		byte[] mdArray = md.digest();
		StringBuilder sb = new StringBuilder(mdArray.length * 2);
		for (byte b : mdArray)
		{
			int v = b & 0xff;
			if (v < 16)
			{
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		}
		return sb.toString();
	}

	/**
	 * This method retrieves the password salt in String format.
	 * 
	 * @return the password salt.
	 */
	public static String getSalt()
	{
		Random r = new SecureRandom();
		byte[] saltBytes = new byte[32];
		r.nextBytes(saltBytes);
		return Base64.getEncoder().encodeToString(saltBytes);
	}

	/**
	 * This method retrieves the hash and salt of the password.
	 * 
	 * @param password
	 * @return the hash and salt of the password
	 * @throws NoSuchAlgorithmException
	 */
	public static String hashAndSaltPassword(String password) throws NoSuchAlgorithmException
	{
		String salt = getSalt();
		return hashPassword(password + salt);
	}

	/**
	 * This method checks the password strength (length, etc)
	 * 
	 * @param password the password we need to check the strength
	 * @throws Exception
	 */
	public static void checkPasswordStrength(String password) throws Exception
	{
		if (password == null || password.trim().isEmpty())
		{
			throw new Exception("Password cannot be empty.");
		} else if (password.length() < 8)
		{
			throw new Exception("Password is to short. " + "Must be at least 8 characters long.");
		}
	}

	/**
	 * This method validates a password checking
	 * its strength.
	 * 
	 * @param password the password we need to validate
	 * @return true if the password is validated, false otherwise
	 */
	public static boolean validatePassword(String password)
	{
		try
		{
			checkPasswordStrength(password);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	/*
	 * This code tests the functionality of this class.
	 */
	public static void main(String[] args)
	{
		try
		{
			System.out.println("Hash for 'supersecret':\n" + hashPassword("supersecret"));
			System.out.println("Random salt:\n" + getSalt());
			System.out.println(
					"Salted hash for 'supersecret':\n" + hashAndSaltPassword("supersecret"));
		} catch (NoSuchAlgorithmException ex)
		{
			System.out.println(ex);
		}

		try
		{
			checkPasswordStrength("sesame1776");
			System.out.println("Password is valid.");
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}