/**
 * This class is used to set and get 
 * MailReport objects properties
 * 
 * @version: v.1.0 - 13 mag 2016 09:42:03 
 * @author:  Marco Canavese
 */
package com.kirth.model;

import java.io.Serializable;

public class MailReport implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String dateToReport;
	private String toAddress;
	private String ccAddress;
	private String subject;
	private String body;
	private String sentDate;
	private String username;

	/**
	 * This method allows to retrieve the date the mail report has been sent.
	 * 
	 * @return the date when the mail report has been sent
	 */
	public String getDateToReport()
	{
		return dateToReport;
	}

	/**
	 * This method sets the date the mail report has been sent.
	 * 
	 * @param dateToReport
	 *            the dateToReport to set
	 */
	public void setDateToReport(String dateToReport)
	{
		this.dateToReport = dateToReport;
	}

	/**
	 * This method allows to retrieve the recipient the mail report has been sent to.
	 * 
	 * @return the toAddress
	 */
	public String getToAddress()
	{
		return toAddress;
	}

	/**
	 * This method sets the recipient the mail report has been sent to.
	 * 
	 * @param toAddress
	 *            the toAddress to set
	 */
	public void setToAddress(String toAddress)
	{
		this.toAddress = toAddress;
	}

	/**
	 * This method allows to retrieve the carbon copy address the mail report has been sent to.
	 * 
	 * @return the ccAddress
	 */
	public String getCcAddress()
	{
		return ccAddress;
	}

	/**
	 * This method allows to set the carbon copy address the mail report has been sent to.
	 * 
	 * @param ccAddress
	 *            the ccAddress to set
	 */
	public void setCcAddress(String ccAddress)
	{
		this.ccAddress = ccAddress;
	}

	/**
	 * This method allows to retrieve the subject of the mail report.
	 * 
	 * @return the subject
	 */
	public String getSubject()
	{
		return subject;
	}

	/**
	 * This method allows to set the subject of the mail report.
	 * 
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	/**
	 * This method allows to retrieve the body of the mail report.
	 * 
	 * @return the body
	 */
	public String getBody()
	{
		return body;
	}

	/**
	 * This method allows to set the subject of the mail report.
	 * 
	 * @param body
	 *            the body to set
	 */
	public void setBody(String body)
	{
		this.body = body;
	}

	/**
	 * This method allows to retrieve the Date the mail report has been sent on.
	 * 
	 * @return the sentDate
	 */
	public String getSentDate()
	{
		return sentDate;
	}

	/**
	 * This method allows to set the Date the mail report has been sent on.
	 * 
	 * @param sentDate
	 *            the sentDate to set
	 */
	public void setSentDate(String sentDate)
	{
		this.sentDate = sentDate;
	}

	/**
	 * This method allows to retrieve the username who has sent the mail report.
	 * 
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * This method allows to set the username who has sent the mail report.
	 * 
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
}
