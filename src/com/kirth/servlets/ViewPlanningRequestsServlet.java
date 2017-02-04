/**
 * This servlet processes end user requests
 * to view their own smart working requests
 * or the ones from the entire Unit.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kirth.dao.SavePlanningAction;
import com.kirth.model.Planning;
import com.kirth.model.Requests;
import com.kirth.util.DateUtil;

/**
 * Servlet implementation class ViewPlanningRequestsServlet
 */
@WebServlet(name = "ViewPlanningRequestsServlet", urlPatterns = { "/ViewPlanningRequestsServlet",
		"/view-my-requests", "/view-all-requests" })
public class ViewPlanningRequestsServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewPlanningRequestsServlet()
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
	 * This method processes end users requests to view their own or all smart working requests.
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
		HttpSession session = null;
		int currentWeek;
		int firstWeek;
		int secondWeek;
		if ("view-all-requests".equals(action))
		{
			// build code to show everyone request for the current period
			session = request.getSession();
			currentWeek = DateUtil.getCurrentWeek();
			firstWeek = DateUtil.getFirstWeek();
			secondWeek = DateUtil.getSecondWeek();

			Planning planning = new Planning();
			planning.setPlanningWeek(currentWeek);
			planning.setFirstWeek(firstWeek);
			planning.setSecondWeek(secondWeek);

			// debug
			System.out.println(
					"Parameters in servlet being passed to query for showing entire Office requests are:[curentWeek]: "
							+ currentWeek + "[firstWeek]: " + firstWeek + "[secondWeek]: "
							+ secondWeek);

			// execute action method
			SavePlanningAction savePlanningAction = new SavePlanningAction();

			try
			{
				// check if planning already exists
				if (savePlanningAction.readAll(planning))
				{
					// store model in a scope variable for the view
					ArrayList<Planning> viewothersrequests;
					viewothersrequests = savePlanningAction.getAllPlanning(currentWeek, firstWeek,
							secondWeek);

					request.getSession().setAttribute("viewothersrequests", viewothersrequests);
					dispatchUrl = "ViewOthersRequests.jsp";
				} else
				{

					// add code to output message on the page that the planning is not available
					// because a
					// record already exists in the database for this period and for the entire
					// Office
					System.out
							.println("No planning requests exist for the entire for this period!");
					String message = "No Planning request exists for the entire UBCM Office and given weeks.";
					request.setAttribute("message", message);
					dispatchUrl = "PlanningNotExists.jsp";
					session = request.getSession();
					session.setAttribute("anothermessage", message);
				}

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("view-my-requests".equals(action))
		{
			// create form
			session = request.getSession();
			String user = (String) session.getAttribute("name");
			currentWeek = DateUtil.getCurrentWeek();
			firstWeek = DateUtil.getFirstWeek();
			secondWeek = DateUtil.getSecondWeek();

			// create model
			Planning planning = new Planning();
			planning.setUserId(user);
			planning.setPlanningWeek(currentWeek);
			planning.setFirstWeek(firstWeek);
			planning.setSecondWeek(secondWeek);

			System.out.println("Parameters in servlet being passed to query are: [username]: "
					+ user + " [curentWeek]: " + currentWeek + "[firstWeek]: " + firstWeek
					+ "[secondWeek]: " + secondWeek);

			// execute action method
			SavePlanningAction savePlanningAction = new SavePlanningAction();

			try
			{
				// check if planning already exists
				if (savePlanningAction.read(planning))
				{
					// store model in a scope variable for the view
					ArrayList<Planning> viewmyrequests;
					viewmyrequests = savePlanningAction.getPlanning(user, currentWeek, firstWeek,
							secondWeek);

					request.getSession().setAttribute("viewmyrequests", viewmyrequests);
					dispatchUrl = "ViewMyRequests.jsp";
				} else
				{

					// add code to output message on the page that the planning is not available
					// because a
					// record already exists in the database for this period and for this user
					System.out.println("No planning requests exist for this user for this period!");
					String message = "No Planning request exists for given user and given weeks.";
					request.setAttribute("message", message);
					dispatchUrl = "PlanningNotExists.jsp";
					session = request.getSession();
					session.setAttribute("anothermessage", message);
				}

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				// TODO Auto-generated catch block
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
