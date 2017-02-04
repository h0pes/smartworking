/**
 * This class manages the inquiries of
 * Holiday objects with the data source.
 * 
 * @version: v.1.0 - 18 mag 2016 13:43:00 
 * @author:  Marco Canavese
 */
package com.kirth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kirth.model.Holiday;

public class HolidayDao
{
	/**
	 * This method return a list of holiday days for a given user, year and month
	 * 
	 * @param anYear
	 *            the year for which we want to know if exist holidays
	 * @param aMonth
	 *            the month for which we want to know if exist holidays
	 * @param aUser
	 *            the user for which we want to know if exist holidays
	 * @return a list of holiday days
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Holiday> getHoliday(String anYear, String aMonth, String aUser)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException
	{
		List<Holiday> officeHolidays = new ArrayList<Holiday>();

		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String query = "SELECT users_calendar.userId, users_calendar.udate, users_calendar.daytype, calendar.monthName, "
				+ "calendar.w, calendar.y, calendar.dw FROM users_calendar INNER JOIN calendar ON users_calendar.udate = calendar.dt "
				+ "WHERE calendar.y = ? and calendar.monthName = ? and users_calendar.userId LIKE ? and calendar.dw IN (1, 2, 3, 4, 5, 6, 7)"
				+ "order by users_calendar.userId, users_calendar.udate";

		pst = conn.prepareStatement(query);

		pst.setString(1, anYear);
		pst.setString(2, aMonth);
		pst.setString(3, aUser);

		ResultSet rs = pst.executeQuery();
		int recourdCount = 0;

		while (rs.next())
		{
			++recourdCount;
			Holiday holidays = new Holiday();

			holidays.setUserId(rs.getString(1));
			holidays.setUdate(rs.getDate(2));
			holidays.setDayType(rs.getString(3));
			holidays.setMonthName(rs.getString(4));
			holidays.setWeekNumber(rs.getInt(5));
			holidays.setYear(rs.getInt(6));
			holidays.setDayOfWeek(rs.getInt(7));

			officeHolidays.add(holidays);

		}
		System.out.println("record counted for the recordset: " + recourdCount);

		return officeHolidays;
	}

	/**
	 * This method return a list of holiday days for a given year and month
	 * 
	 * @param anYear
	 *            the year for which we want to know if exist holidays
	 * @param aMonth
	 *            the month for which we want to know if exist holidays
	 * @return a list of holiday days
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<Holiday> getHolidays(String anYear, String aMonth) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		List<Holiday> officeHolidays = new ArrayList<Holiday>();

		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String query = "SELECT users_calendar.userId, users_calendar.udate, users_calendar.daytype, calendar.monthName, "
				+ "calendar.w, calendar.y, calendar.dw FROM users_calendar INNER JOIN calendar ON users_calendar.udate = calendar.dt "
				+ "WHERE calendar.y = ? and calendar.monthName = ? and calendar.dw IN (1, 2, 3, 4, 5, 6, 7)"
				+ "order by users_calendar.userId, users_calendar.udate";

		pst = conn.prepareStatement(query);

		pst.setString(1, anYear);
		pst.setString(2, aMonth);

		ResultSet rs = pst.executeQuery();
		int recourdCount = 0;

		while (rs.next())
		{
			++recourdCount;
			Holiday holidays = new Holiday();

			holidays.setUserId(rs.getString(1));
			holidays.setUdate(rs.getDate(2));
			holidays.setDayType(rs.getString(3));
			holidays.setMonthName(rs.getString(4));
			holidays.setWeekNumber(rs.getInt(5));
			holidays.setYear(rs.getInt(6));
			holidays.setDayOfWeek(rs.getInt(7));

			officeHolidays.add(holidays);

		}
		System.out.println("record counted for the recordset: " + recourdCount);

		return officeHolidays;
	}
}
