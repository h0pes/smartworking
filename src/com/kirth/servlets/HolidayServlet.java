/**
 * This servlet processes end user requests
 * for displaying holidays days.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kirth.dao.HolidayDao;
import com.kirth.model.Holiday;

/**
 * Servlet implementation class HolidayServlet
 */
@WebServlet(name = "HolidayServlet", urlPatterns = { "/HolidayServlet", "/view-holidays" })

public class HolidayServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolidayServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			process(request, response);
		} catch (ParseException e)
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
		try
		{
			process(request, response);
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method processes end users requests to view holidays days.
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 * @throws ParseException
	 */
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, ParseException
	{
		String uri = request.getRequestURI();
		/*
		 * uri is in this form: /contextName/resourceName, for example: /webapp/input-planning.
		 * However, in the event of a default context, the context name is empty, and uri has this
		 * form /resourceName, e.g.: /input-planning
		 */
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		// execute an action
		String dispatchUrl = null;

		if ("view-holidays".equals(action))
		{
			String chosenYear = request.getParameter("year");
			String chosenMonth = request.getParameter("month");
			String chosenUsername = request.getParameter("username");

			List<Holiday> holidayList;
			HolidayDao holDao = new HolidayDao();

			try
			{
				holidayList = holDao.getHoliday(chosenYear, chosenMonth, chosenUsername);
				request.getSession().setAttribute("viewholidays", holidayList);

				dispatchUrl = "ShowHolidays.jsp";

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				e.printStackTrace();
			}

		}

		if (dispatchUrl != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			System.out.println("Dispatch url is: " + dispatchUrl);
			rd.forward(request, response);
		}

	}
}
