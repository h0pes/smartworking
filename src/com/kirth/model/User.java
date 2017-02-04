/**
 * This class is used to model
 * User objects.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */
package com.kirth.model;

import java.io.Serializable;

/**
 *
 */
public class User implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String token;
	private String status;

	/**
	 * This method retrieves the userId of an User instance.
	 * 
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * This method sets the userId of an User instance.
	 * 
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * This method retrieves the first name of an User instance.
	 * 
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * This method sets the first name of an User instance.
	 * 
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * This method retrieves the last name of an User instance.
	 * 
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * This method sets the last name of an User instance.
	 * 
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * This method retrieves the email address of an User instance.
	 * 
	 * @return the email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * This method sets the email address of an User instance.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * This method retrieves the token associated with a forgot password request made by a User
	 * instance.
	 * 
	 * @return the token
	 */
	public String getToken()
	{
		return token;
	}

	/**
	 * This method sets the token associated with a forgot password request made by a User instance.
	 * 
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token)
	{
		this.token = token;
	}

	/**
	 * This method retrieves the status associated with a forgot password request made by a User
	 * instance.
	 * 
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * This method sets the status associated with a forgot password request made by a User
	 * instance.
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

}
