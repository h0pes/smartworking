/**
 * This class contains some utility methods for Date objects
 * 
 * @version: v.1.0 - 30 apr 2016 18:50:17 
 * @author:  Marco Canavese
 */

package com.kirth.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil
{

	/**
	 * This method retrieves the current week of the year.
	 * 
	 * @return an int number representing the current week
	 */
	public static int getCurrentWeek()
	{
		Calendar cal = Calendar.getInstance();
		Date today = new Date();
		cal.setTime(today);
		int currentWeek = cal.get(Calendar.WEEK_OF_YEAR);
		return currentWeek;
	}

	/**
	 * This method retrieves the first week after the current week for this year.
	 * 
	 * @return an int number representing the first week after the current week
	 */
	public static int getFirstWeek()
	{
		int baseWeek = getCurrentWeek();
		int firstWeek = baseWeek + 1;
		return firstWeek;
	}

	/**
	 * This method retrieves the second week after the current week for this year.
	 * 
	 * @return an int number representing the second week after the current week
	 */
	public static int getSecondWeek()
	{
		int baseWeek = getCurrentWeek();
		int secondWeek = baseWeek + 2;
		return secondWeek;
	}

	/**
	 * This method retrieves the total number of weeks for this year.
	 * 
	 * @return an int number representing the total number of weeks in the current week
	 */
	public static int getNumWeeksForYear(int year)
	{
		Calendar c = Calendar.getInstance();

		c.set(year, 0, 1);
		return c.getActualMaximum(Calendar.WEEK_OF_YEAR);
	}

	public static void main(String[] args)
	{
		int numberOfWeeksThisYear = getNumWeeksForYear(2016);
		System.out.println(numberOfWeeksThisYear);

		int numberOfCurrentWeek = getCurrentWeek();
		System.out.println(numberOfCurrentWeek);

	}
}
