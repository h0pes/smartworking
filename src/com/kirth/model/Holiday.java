/**
 * This class models holiday objects
 * to represent users holidays
 * 
 * @version: v.1.0 - 18 mag 2016 13:39:32 
 * @author:  Marco Canavese
 */
package com.kirth.model;

import java.io.Serializable;
import java.util.Date;

public class Holiday implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private Date udate;
	private String dayType;
	private String monthName;
	private int weekNumber;
	private int year;
	private int dayOfWeek;

	/**
	 * This method retrieves the userId for an Holiday instance.
	 * 
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * This method sets the userId for an Holiday instance.
	 * 
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * This method retrieves the Date for an Holiday instance.
	 * 
	 * @return the udate
	 */
	public Date getUdate()
	{
		return udate;
	}

	/**
	 * This method sets the Date for an Holiday instance.
	 * 
	 * @param udate
	 *            the udate to set
	 */
	public void setUdate(Date udate)
	{
		this.udate = udate;
	}

	/**
	 * This method retrieves the day type (holiday, work, etc) for an Holiday instance.
	 * 
	 * @return the dayType
	 */
	public String getDayType()
	{
		return dayType;
	}

	/**
	 * This method sets the day type (holiday, work, etc) for an Holiday instance.
	 * 
	 * @param dayType
	 *            the dayType to set
	 */
	public void setDayType(String dayType)
	{
		this.dayType = dayType;
	}

	/**
	 * This method retrieves the month for an Holiday instance.
	 * 
	 * @return the monthName
	 */
	public String getMonthName()
	{
		return monthName;
	}

	/**
	 * This method sets the month for an Holiday instance.
	 * 
	 * @param monthName
	 *            the monthName to set
	 */
	public void setMonthName(String monthName)
	{
		this.monthName = monthName;
	}

	/**
	 * This method retrieves the week for an Holiday instance.
	 * 
	 * @return the weekNumber
	 */
	public int getWeekNumber()
	{
		return weekNumber;
	}

	/**
	 * This method sets the week for an Holiday instance.
	 * 
	 * @param weekNumber
	 *            the weekNumber to set
	 */
	public void setWeekNumber(int weekNumber)
	{
		this.weekNumber = weekNumber;
	}

	/**
	 * This method retrieves the year for an Holiday instance.
	 * 
	 * @return the year
	 */
	public int getYear()
	{
		return year;
	}

	/**
	 * This method sets the year for an Holiday instance.
	 * 
	 * @param year
	 *            the year to set
	 */
	public void setYear(int year)
	{
		this.year = year;
	}

	/**
	 * This method retrieves the day of the week for an Holiday instance.
	 * 
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek()
	{
		return dayOfWeek;
	}

	/**
	 * This method sets the day of the week for an Holiday instance.
	 * 
	 * @param dayOfWeek
	 *            the dayOfWeek to set
	 */
	public void setDayOfWeek(int dayOfWeek)
	{
		this.dayOfWeek = dayOfWeek;
	}

}
