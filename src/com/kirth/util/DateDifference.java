/**
 *  This class is used to calculate the time
 *  difference between the date value stored in Database
 *  and the usage of the reset password token by the end
 *  user.
 * 
 * @version: v.1.0 - 10 mag 2016 13:21:07 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DateDifference
{

	private int expiredhour;
	private int expiredmin;
	private int expiredsec;
	private int expireddays;
	private ResourceBundle rb2;
	private String msg = null;

	public DateDifference() throws NullPointerException, MissingResourceException
	{
		rb2 = ResourceBundle.getBundle("com.kirth.util\\DB");
		this.expiredhour = Integer.parseInt(rb2.getString("expiredhour"));
		this.expiredmin = Integer.parseInt(rb2.getString("expiredmin"));
		this.expiredsec = Integer.parseInt(rb2.getString("expiredsec"));
		this.expireddays = Integer.parseInt(rb2.getString("expireddays"));
	}

	/**
	 * This method performs Date validation.
	 * 
	 * @param lastaccessdate
	 * @param todaydate
	 * @return valid if it's a valid date, invalid otherwise
	 * @throws Exception
	 */
	public String datevalidator(String lastaccessdate, String todaydate) throws Exception
	{
		String dateStart = lastaccessdate;
		String dateStop = todaydate;

		// HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = null;
		Date d2 = null;

		try
		{

			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			// in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			/*
			 * Here according to the properties values , reset password link is valid for 1 hour
			 * only from the time it is delivered to recipient.
			 */
			if ((diffHours > expiredhour && diffMinutes >= expiredmin && diffSeconds >= expiredsec)
					|| diffDays >= expireddays)
			{
				// if(diffMinutes>4){
				msg = "invalid";
			} else
			{
				msg = "valid";
			}

		} catch (Exception e)
		{
			throw new Exception("Exception occured in date validator:- Cause->[" + e + "]");
		}
		return msg;
	}

}
