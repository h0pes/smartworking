/**
 * This servlet processes end user requests
 * to edit an already submitted but not approved
 * or rejected smart working planning, submitting the
 * actual edited data.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kirth.dao.SavePlanningAction;
import com.kirth.model.Planning;

/**
 * Servlet implementation class SubmitEditRequestServlet
 */
@WebServlet(name = "SubmitEditRequestServlet", urlPatterns = { "/SubmitEditRequestServlet",
		"/submit-edit-my-requests" })
public class SubmitEditRequestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitEditRequestServlet()
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
	 * This method actually performs the smart working planning request edit, modifying the end user
	 * request.
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
		String thisWeek;
		int firstWeek;
		String nextWeek;
		int secondWeek;
		String nextToNextWeek;
		// execute an action
		if ("submit-edit-my-requests".equals(action))
		{
			// add code to manage requests edit
			session = request.getSession();
			String user = (String) session.getAttribute("name");
			thisWeek = request.getParameter("planningWeek");
			currentWeek = Integer.parseInt(thisWeek);
			nextWeek = request.getParameter("firstWeek");
			firstWeek = Integer.parseInt(nextWeek);
			nextToNextWeek = request.getParameter("secondWeek");
			secondWeek = Integer.parseInt(nextToNextWeek);
			// get all days and day notes parameters from jsp page

			String mondayFirstWeek = request.getParameter("mondayFirstWeek");
			String tuesdayFirstWeek = request.getParameter("tuesdayFirstWeek");
			String wednesdayFirstWeek = request.getParameter("wednesdayFirstWeek");
			String thursdayFirstWeek = request.getParameter("thursdayFirstWeek");
			String fridayFirstWeek = request.getParameter("fridayFirstWeek");

			String notesMondayFirstWeek = request.getParameter("notesMondayFirstWeek");
			String notesTuesdayFirstWeek = request.getParameter("notesTuesdayFirstWeek");
			String notesWednesdayFirstWeek = request.getParameter("notesWednesdayFirstWeek");
			String notesThursdayFirstWeek = request.getParameter("notesThursdayFirstWeek");
			String notesFridayFirstWeek = request.getParameter("notesFridayFirstWeek");

			String mondaySecondWeek = request.getParameter("mondaySecondWeek");
			String tuesdaySecondWeek = request.getParameter("tuesdaySecondWeek");
			String wednesdaySecondWeek = request.getParameter("wednesdaySecondWeek");
			String thursdaySecondWeek = request.getParameter("thursdaySecondWeek");
			String fridaySecondWeek = request.getParameter("fridaySecondWeek");

			String notesMondaySecondWeek = request.getParameter("notesMondaySecondWeek");
			String notesTuesdaySecondWeek = request.getParameter("notesTuesdaySecondWeek");
			String notesWednesdaySecondWeek = request.getParameter("notesWednesdaySecondtWeek");
			String notesThursdaySecondWeek = request.getParameter("notesThursdaySecondWeek");
			String notesFridaySecondWeek = request.getParameter("notesFridaySecondWeek");

			// create model
			Planning editPlanning = new Planning();
			editPlanning.setUserId(user);
			editPlanning.setPlanningWeek(currentWeek);
			editPlanning.setFirstWeek(firstWeek);
			editPlanning.setSecondWeek(secondWeek);
			DateFormat format = new SimpleDateFormat("yyyy/MM/dd");

			// first week days
			if (mondayFirstWeek != null && !mondayFirstWeek.isEmpty())
			{
				Date dateMondayFirstWeek = format.parse(mondayFirstWeek);
				editPlanning.setMondayFirstWeek(dateMondayFirstWeek);
			}

			if (tuesdayFirstWeek != null && !tuesdayFirstWeek.isEmpty())
			{
				Date dateTuesdayFirstWeek = format.parse(tuesdayFirstWeek);
				editPlanning.setTuesdayFirstWeek(dateTuesdayFirstWeek);
			}

			if (wednesdayFirstWeek != null && !wednesdayFirstWeek.isEmpty())
			{
				Date dateWednesdayFirstWeek = format.parse(wednesdayFirstWeek);
				editPlanning.setWednesdayFirstWeek(dateWednesdayFirstWeek);
			}

			if (thursdayFirstWeek != null && !thursdayFirstWeek.isEmpty())
			{
				Date dateThursdayFirstWeek = format.parse(thursdayFirstWeek);
				editPlanning.setThursdayFirstWeek(dateThursdayFirstWeek);
			}

			if (fridayFirstWeek != null && !fridayFirstWeek.isEmpty())
			{
				Date dateFridayFirstWeek = format.parse(fridayFirstWeek);
				editPlanning.setFridayFirstWeek(dateFridayFirstWeek);
			}

			// first week notes
			if (notesMondayFirstWeek != null && !notesMondayFirstWeek.isEmpty())
			{
				editPlanning.setNotesMondayFirstWeek(notesMondayFirstWeek);
			}

			if (notesTuesdayFirstWeek != null && !notesTuesdayFirstWeek.isEmpty())
			{
				editPlanning.setNotesTuesdayFirstWeek(notesTuesdayFirstWeek);
			}

			if (notesWednesdayFirstWeek != null && !notesWednesdayFirstWeek.isEmpty())
			{
				editPlanning.setNotesWednesdayFirstWeek(notesWednesdayFirstWeek);
			}

			if (notesThursdayFirstWeek != null && !notesThursdayFirstWeek.isEmpty())
			{
				editPlanning.setNotesThursdayFirstWeek(notesThursdayFirstWeek);
			}

			if (notesFridayFirstWeek != null && !notesFridayFirstWeek.isEmpty())
			{
				editPlanning.setNotesFridayFirstWeek(notesFridayFirstWeek);
			}

			// second week days
			if (mondaySecondWeek != null && !mondaySecondWeek.isEmpty())
			{
				Date dateMondaySecondWeek = format.parse(mondaySecondWeek);
				editPlanning.setMondaySecondWeek(dateMondaySecondWeek);
			}

			if (tuesdaySecondWeek != null && !tuesdaySecondWeek.isEmpty())
			{
				Date dateTuesdaySecondWeek = format.parse(tuesdaySecondWeek);
				editPlanning.setTuesdaySecondWeek(dateTuesdaySecondWeek);
			}

			if (wednesdaySecondWeek != null && !wednesdaySecondWeek.isEmpty())
			{
				Date dateWednesdaySecondWeek = format.parse(wednesdaySecondWeek);
				editPlanning.setWednesdaySecondWeek(dateWednesdaySecondWeek);
			}

			if (thursdaySecondWeek != null && !thursdaySecondWeek.isEmpty())
			{
				Date dateThursdaySecondWeek = format.parse(thursdaySecondWeek);
				editPlanning.setThursdaySecondWeek(dateThursdaySecondWeek);
			}

			if (fridaySecondWeek != null && !fridaySecondWeek.isEmpty())
			{
				Date dateFridaySecondtWeek = format.parse(fridaySecondWeek);
				editPlanning.setFridaySecondWeek(dateFridaySecondtWeek);
			}

			// second week notes
			if (notesMondaySecondWeek != null && !notesMondaySecondWeek.isEmpty())
			{
				editPlanning.setNotesMondaySecondWeek(notesMondaySecondWeek);
			}

			if (notesTuesdaySecondWeek != null && !notesTuesdaySecondWeek.isEmpty())
			{
				editPlanning.setNotesTuesdaySecondWeek(notesTuesdaySecondWeek);
			}

			if (notesWednesdaySecondWeek != null && !notesWednesdaySecondWeek.isEmpty())
			{
				editPlanning.setNotesWednesdaySecondWeek(notesWednesdaySecondWeek);
			}

			if (notesThursdaySecondWeek != null && !notesThursdaySecondWeek.isEmpty())
			{
				editPlanning.setNotesThursdaySecondWeek(notesThursdaySecondWeek);
			}

			if (notesFridaySecondWeek != null && !notesFridaySecondWeek.isEmpty())
			{
				editPlanning.setNotesFridaySecondWeek(notesFridaySecondWeek);
			}

			System.out.println("Parameters in servlet being passed to query are: [username]: "
					+ user + " [curentWeek]: " + currentWeek + "[firstWeek]: " + firstWeek
					+ "[secondWeek]: " + secondWeek);

			// execute action method
			SavePlanningAction savePlanningAction = new SavePlanningAction();

			try
			{
				// update editPlanning request
				int update = savePlanningAction.updatePlanningRequest(editPlanning);
				if (update == 1)
				{
					request.getSession().setAttribute("editPlanning", editPlanning);
					dispatchUrl = "PlanningDetailsEdited.jsp";
					// add code to store model in a session variable
					session = request.getSession();
					session.setAttribute("editPlanning", editPlanning);
				} else
				{
					// add code to output message on the page that the planning is not updatable
					System.out.println("Your smart working request is not updatable.");
					String message = "Your smart working request is not updatable.";
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
			// add code if action is of another type
		}

		if (dispatchUrl != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			System.out.println("Dispatch url is: " + dispatchUrl);
			rd.forward(request, response);
		}
	}
}
