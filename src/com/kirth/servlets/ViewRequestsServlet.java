/**
 * This servlet processes end user requests
 * to view requests from the entire Unit.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */
package com.kirth.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kirth.dao.LoginDao;
import com.kirth.model.Requests;
import com.kirth.util.DateUtil;;

/**
 * Servlet implementation class ViewRequests
 */
@WebServlet(name = "ViewRequestsServlet", urlPatterns = { "/ViewRequests", "/view-requests" })
public class ViewRequestsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewRequestsServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method processes end user requests to view smart working requests from the entire
	 * Office.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			Connection conn = LoginDao.getConnection();

			String strAllRequests = "SELECT idusers_planning, userId, requestDate, day1, day2, day3, day4, day5, "
					+ "day6, day7, day8, day9, day10, status, "
					+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
					+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
					+ "planningWeek, firstWeek, secondWeek, managed FROM users_planning "
					+ "WHERE planningWeek = ? AND firstWeek = ? AND secondWeek = ? ";

			PreparedStatement pst = conn.prepareStatement(strAllRequests);

			ArrayList<Requests> requests = new ArrayList<Requests>();

			int baseWeek = DateUtil.getCurrentWeek();
			int firstWeek = DateUtil.getFirstWeek();
			int secondWeek = DateUtil.getSecondWeek();

			pst.setInt(1, baseWeek);
			pst.setInt(2, firstWeek);
			pst.setInt(3, secondWeek);

			ResultSet rs = pst.executeQuery();

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

			while (rs.next())
			{
				Requests req = new Requests();

				req.setPlanningId(rs.getInt(1));
				req.setUserId(rs.getString(2));

				req.setRequestDate(rs.getDate(3));

				req.setMondayFirstWeek(rs.getDate(4));
				req.setTuesdayFirstWeek(rs.getDate(5));
				req.setWednesdayFirstWeek(rs.getDate(6));
				req.setThursdayFirstWeek(rs.getDate(7));
				req.setFridayFirstWeek(rs.getDate(8));
				req.setMondaySecondWeek(rs.getDate(9));
				req.setTuesdaySecondWeek(rs.getDate(10));
				req.setWednesdaySecondWeek(rs.getDate(11));
				req.setThursdaySecondWeek(rs.getDate(12));
				req.setFridaySecondWeek(rs.getDate(13));
				req.setStatus(rs.getString(14));
				req.setNotesMondayFirstWeek(rs.getString(15));
				req.setNotesTuesdayFirstWeek(rs.getString(16));
				req.setNotesWednesdayFirstWeek(rs.getString(17));
				req.setNotesThursdayFirstWeek(rs.getString(18));
				req.setNotesFridayFirstWeek(rs.getString(19));
				req.setNotesMondaySecondWeek(rs.getString(20));
				req.setNotesTuesdaySecondWeek(rs.getString(21));
				req.setNotesWednesdaySecondWeek(rs.getString(22));
				req.setNotesThursdaySecondWeek(rs.getString(23));
				req.setNotesFridaySecondWeek(rs.getString(24));
				req.setPlanningWeek(rs.getInt(25));
				req.setFirstWeek(rs.getInt(26));
				req.setSecondWeek(rs.getInt(27));
				req.setManaged(rs.getString(28));

				requests.add(req);
			}
			request.getSession().setAttribute("requests", requests);

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ViewAllRequests.jsp");
			rd.forward(request, response);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
				| SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
