/**
 * This class manages the inquiry 
 * of MailReport objects with the data
 * source.
 * 
 * @version: v.1.0 - 13 mag 2016 10:00:49 
 * @author:  Marco Canavese
 */
package com.kirth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.kirth.model.MailReport;

/**
 *
 */
public class MailReportDao
{

	/**
	 * This method store mail objects into the database
	 * 
	 * @param mailRep
	 *            a mail object
	 * @return an int representing the amount of mail objects saved to the database
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 */
	public int save(MailReport mailRep) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException, ParseException
	{
		// code to insert email report into the database
		Connection conn = LoginDao.getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO email_reports (date_to_report, to_address, cc_address, subject, body, sent_date, username)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = sdf.format(today);
		System.out.println("Date in String format: " + reportDate);

		try
		{
			ps = conn.prepareStatement(query);
			ps.setString(1, mailRep.getDateToReport());
			ps.setString(2, mailRep.getToAddress());
			ps.setString(3, mailRep.getCcAddress());
			ps.setString(4, mailRep.getSubject());
			ps.setString(5, mailRep.getBody());
			ps.setString(6, reportDate);
			ps.setString(7, mailRep.getUsername());

			return ps.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println(e);
			return 0;
		}

	}

}
