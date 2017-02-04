/**
 * This servlet processes end user requests
 * to edit an already submitted but not approved
 * or rejected smart working planning.
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
import com.kirth.util.DateUtil;

/**
 * Servlet implementation class EditRequestServlet
 */
@WebServlet({ "/EditRequestServlet", "/edit-my-requests" })
public class EditRequestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditRequestServlet()
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
	 * This method processes end user requests to edit an already submitted but not approved or
	 * rejected smart working planning
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
		String dispatchUrl = null;
		HttpSession session = null;
		int currentWeek;
		int firstWeek;
		int secondWeek;
		// execute an action
		if ("edit-my-requests".equals(action))
		{
			// add code to manage requests edit
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
				// check if planning exists and its status is not approved or rejected.
				// in other words we allow editing a smart working request only if it
				// has been already submitted but not yet approved or rejected.
				if (savePlanningAction.readWithStatus(planning))
				{
					// store model in a scope variable for the view
					String status = "requested";
					ArrayList<Planning> editviewmyrequests;
					editviewmyrequests = savePlanningAction.getPlanningWithStatus(user, currentWeek,
							firstWeek, secondWeek, status);

					request.getSession().setAttribute("editviewmyrequests", editviewmyrequests);
					dispatchUrl = "EditMyRequests.jsp";
				} else
				{

					// add code to output message on the page that the planning is not available
					// because a
					// record already exists in the database for this period and for this user
					System.out.println(
							"Your plan cannot be modified because it has already been approved or rejected.");
					String message = "Your plan cannot be modified because it has already been approved or rejected.";
					request.setAttribute("message", message);
					dispatchUrl = "DisabledPlanningEdit.jsp";
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

		else
		{
			// add code to manage not allowed action
		}

		if (dispatchUrl != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			System.out.println("Dispatch url is: " + dispatchUrl);
			rd.forward(request, response);
		}
	}

}
