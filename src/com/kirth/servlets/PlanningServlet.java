/**
 * This servlet processes end user requests
 * for smart working planning days.
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
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kirth.dao.SavePlanningAction;
import com.kirth.form.PlanningForm;
import com.kirth.model.Planning;

/**
 * Servlet implementation class PlanningServlet
 */
@WebServlet(name = "PlanningServlet", urlPatterns = { "/input-planning", "/save-planning" })

public class PlanningServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlanningServlet()
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
	 * This method processes end user requests to save smart working planning requests.
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
		if ("input-planning".equals(action))
		{
			// no action class, just forward
			dispatchUrl = "PlanningForm.jsp";
		} else if ("save-planning".equals(action))
		{
			// create form
			PlanningForm planningForm = new PlanningForm();
			// populate action properties
			String user = request.getParameter("userName");
			if (user != null && !user.isEmpty())
			{
				System.out.println(user);
				planningForm.setUserId(user);
			}

			String currentWeek = request.getParameter("planningWeek");
			if (currentWeek != null && !currentWeek.isEmpty())
			{
				System.out.println(currentWeek);
				planningForm.setCurrentWeek(request.getParameter("planningWeek"));
			}

			String firstWeek = request.getParameter("firstWeek");
			if (firstWeek != null && !firstWeek.isEmpty())
			{
				System.out.println(firstWeek);
				planningForm.setFirstWeek(request.getParameter("firstWeek"));
			}

			String secondWeek = request.getParameter("secondWeek");
			if (secondWeek != null && !secondWeek.isEmpty())
			{
				System.out.println(secondWeek);
				planningForm.setSecondWeek(request.getParameter("secondWeek"));
			}

			String mon = request.getParameter("mondayFirstWeek");
			if (mon != null && !mon.isEmpty())
			{
				System.out.println(mon);
				planningForm.setMondayFirstWeek(request.getParameter("mondayFirstWeek"));
			}

			String tue = request.getParameter("tuesdayFirstWeek");
			if (tue != null && !tue.isEmpty())
			{
				planningForm.setTuesdayFirstWeek(request.getParameter("tuesdayFirstWeek"));
			}

			String wed = request.getParameter("wednesdayFirstWeek");
			if (wed != null && !wed.isEmpty())
			{
				planningForm.setWednesdayFirstWeek(request.getParameter("wednesdayFirstWeek"));
			}

			String thu = request.getParameter("thursdayFirstWeek");
			if (thu != null && !thu.isEmpty())
			{
				planningForm.setThursdayFirstWeek(request.getParameter("thursdayFirstWeek"));
			}

			String fri = request.getParameter("fridayFirstWeek");
			if (fri != null && !fri.isEmpty())
			{
				planningForm.setFridayFirstWeek(request.getParameter("fridayFirstWeek"));
			}

			String nmon = request.getParameter("notesMondayFirstWeek");
			if (nmon != null && !nmon.isEmpty())
			{
				System.out.println(nmon);
				planningForm.setNotesMondayFirstWeek(request.getParameter("notesMondayFirstWeek"));
			}

			String ntue = request.getParameter("notesTuesdayFirstWeek");
			if (ntue != null && !ntue.isEmpty())
			{
				planningForm
						.setNotesTuesdayFirstWeek(request.getParameter("notesTuesdayFirstWeek"));
			}

			String nwed = request.getParameter("notesWednesdayFirstWeek");
			if (nwed != null && !nwed.isEmpty())
			{
				planningForm.setNotesWednesdayFirstWeek(
						request.getParameter("notesWednesdayFirstWeek"));
			}

			String nthu = request.getParameter("notesThursdayFirstWeek");
			if (nthu != null && !nthu.isEmpty())
			{
				planningForm
						.setNotesThursdayFirstWeek(request.getParameter("notesThursdayFirstWeek"));
			}

			String nfri = request.getParameter("notesFridayFirstWeek");
			if (nfri != null && !nfri.isEmpty())
			{
				planningForm.setNotesFridayFirstWeek(request.getParameter("notesFridayFirstWeek"));
			}

			String mon2 = request.getParameter("mondaySecondWeek");
			if (mon2 != null && !mon2.isEmpty())
			{
				System.out.println(mon2);
				planningForm.setMondaySecondWeek(request.getParameter("mondaySecondWeek"));
			}

			String tue2 = request.getParameter("tuesdaySecondWeek");
			if (tue2 != null && !tue2.isEmpty())
			{
				planningForm.setTuesdaySecondWeek(request.getParameter("tuesdaySecondWeek"));
			}

			String wed2 = request.getParameter("wednesdaySecondWeek");
			if (wed2 != null && !wed2.isEmpty())
			{
				planningForm.setWednesdaySecondWeek(request.getParameter("wednesdaySecondWeek"));
			}

			String thu2 = request.getParameter("thursdaySecondWeek");
			if (thu2 != null && !thu2.isEmpty())
			{
				planningForm.setThursdaySecondWeek(request.getParameter("thursdaySecondWeek"));
			}

			String fri2 = request.getParameter("fridaySecondWeek");
			if (fri2 != null && !fri2.isEmpty())
			{
				planningForm.setFridaySecondWeek(request.getParameter("fridaySecondWeek"));
			}

			String nmon2 = request.getParameter("notesMondaySecondWeek");
			if (nmon2 != null && !nmon2.isEmpty())
			{
				System.out.println(nmon2);
				planningForm
						.setNotesMondaySecondWeek(request.getParameter("notesMondaySecondWeek"));
			}

			String ntue2 = request.getParameter("notesTuesdaySecondWeek");
			if (ntue2 != null && !ntue2.isEmpty())
			{
				planningForm
						.setNotesTuesdaySecondWeek(request.getParameter("notesTuesdaySecondWeek"));
			}

			String nwed2 = request.getParameter("notesWednesdaySecondWeek");
			if (nwed2 != null && !nwed2.isEmpty())
			{
				planningForm.setNotesWednesdaySecondWeek(
						request.getParameter("notesWednesdaySecondWeek"));
			}

			String nthu2 = request.getParameter("notesThursdaySecondWeek");
			if (nthu2 != null && !nthu2.isEmpty())
			{
				planningForm.setNotesThursdaySecondWeek(
						request.getParameter("notesThursdaySecondWeek"));
			}

			String nfri2 = request.getParameter("notesFridaySecondWeek");
			if (nfri2 != null && !nfri2.isEmpty())
			{
				planningForm
						.setNotesFridaySecondWeek(request.getParameter("notesFridaySecondWeek"));
			}

			// create model
			Planning planning = new Planning();

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ITALY);

			if (planningForm.getUserId() != null && !planningForm.getUserId().isEmpty())
			{
				String userId = planningForm.getUserId();
				planning.setUserId(userId);
			}

			if (planningForm.getMondayFirstWeek() != null
					&& !planningForm.getMondayFirstWeek().isEmpty())
			{
				String firstMonday = planningForm.getMondayFirstWeek();
				Date submitFirstMonday = df.parse(firstMonday);
				planning.setMondayFirstWeek(submitFirstMonday);
			}

			if (planningForm.getTuesdayFirstWeek() != null
					&& !planningForm.getTuesdayFirstWeek().isEmpty())
			{
				String firstTuesday = planningForm.getTuesdayFirstWeek();
				Date submitFirstTuesday = df.parse(firstTuesday);
				planning.setTuesdayFirstWeek(submitFirstTuesday);
			}

			if (planningForm.getWednesdayFirstWeek() != null
					&& !planningForm.getWednesdayFirstWeek().isEmpty())
			{
				String firstWednesday = planningForm.getWednesdayFirstWeek();
				Date submitFirstWednesday = df.parse(firstWednesday);
				planning.setWednesdayFirstWeek(submitFirstWednesday);
			}

			if (planningForm.getThursdayFirstWeek() != null
					&& !planningForm.getThursdayFirstWeek().isEmpty())
			{
				String firstThursday = planningForm.getThursdayFirstWeek();
				Date submitFirstThursday = df.parse(firstThursday);
				planning.setThursdayFirstWeek(submitFirstThursday);
			}

			if (planningForm.getFridayFirstWeek() != null
					&& !planningForm.getFridayFirstWeek().isEmpty())
			{
				String firstFriday = planningForm.getFridayFirstWeek();
				Date submitFirstFriday = df.parse(firstFriday);
				planning.setFridayFirstWeek(submitFirstFriday);
			}

			if (planningForm.getNotesMondayFirstWeek() != null
					&& !planningForm.getNotesMondayFirstWeek().isEmpty())
			{
				String notesFirstMonday = planningForm.getNotesMondayFirstWeek();
				planning.setNotesMondayFirstWeek(notesFirstMonday);
			}

			if (planningForm.getNotesTuesdayFirstWeek() != null
					&& !planningForm.getNotesTuesdayFirstWeek().isEmpty())
			{
				String notesFirstTuesday = planningForm.getNotesTuesdayFirstWeek();
				planning.setNotesTuesdayFirstWeek(notesFirstTuesday);
			}

			if (planningForm.getNotesWednesdayFirstWeek() != null
					&& !planningForm.getNotesWednesdayFirstWeek().isEmpty())
			{
				String notesFirstWednesday = planningForm.getNotesWednesdayFirstWeek();
				planning.setNotesWednesdayFirstWeek(notesFirstWednesday);
			}

			if (planningForm.getNotesThursdayFirstWeek() != null
					&& !planningForm.getNotesThursdayFirstWeek().isEmpty())
			{
				String notesFirstThursday = planningForm.getNotesThursdayFirstWeek();
				planning.setNotesThursdayFirstWeek(notesFirstThursday);
			}

			if (planningForm.getNotesFridayFirstWeek() != null
					&& !planningForm.getNotesFridayFirstWeek().isEmpty())
			{
				String notesFirstFriday = planningForm.getNotesFridayFirstWeek();
				planning.setNotesFridayFirstWeek(notesFirstFriday);
			}

			if (planningForm.getMondaySecondWeek() != null
					&& !planningForm.getMondaySecondWeek().isEmpty())
			{
				String secondMonday = planningForm.getMondaySecondWeek();
				Date submitSecondMonday = df.parse(secondMonday);
				planning.setMondaySecondWeek(submitSecondMonday);
			}

			if (planningForm.getTuesdaySecondWeek() != null
					&& !planningForm.getTuesdaySecondWeek().isEmpty())
			{
				String secondTuesday = planningForm.getTuesdaySecondWeek();
				Date submitSecondTuesday = df.parse(secondTuesday);
				planning.setTuesdaySecondWeek(submitSecondTuesday);
			}

			if (planningForm.getWednesdaySecondWeek() != null
					&& !planningForm.getWednesdaySecondWeek().isEmpty())
			{
				String secondWednesday = planningForm.getWednesdaySecondWeek();
				Date submitSecondWednesday = df.parse(secondWednesday);
				planning.setWednesdaySecondWeek(submitSecondWednesday);
			}

			if (planningForm.getThursdaySecondWeek() != null
					&& !planningForm.getThursdaySecondWeek().isEmpty())
			{
				String secondThursday = planningForm.getThursdaySecondWeek();
				Date submitSecondThursday = df.parse(secondThursday);
				planning.setThursdaySecondWeek(submitSecondThursday);
			}

			if (planningForm.getFridaySecondWeek() != null
					&& !planningForm.getFridaySecondWeek().isEmpty())
			{
				String secondFriday = planningForm.getFridaySecondWeek();
				Date submitSecondFriday = df.parse(secondFriday);
				planning.setFridaySecondWeek(submitSecondFriday);
			}

			if (planningForm.getNotesMondaySecondWeek() != null
					&& !planningForm.getNotesMondaySecondWeek().isEmpty())
			{
				String notesSecondMonday = planningForm.getNotesMondaySecondWeek();
				planning.setNotesMondaySecondWeek(notesSecondMonday);
			}

			if (planningForm.getNotesTuesdaySecondWeek() != null
					&& !planningForm.getNotesTuesdaySecondWeek().isEmpty())
			{
				String notesSecondTuesday = planningForm.getNotesTuesdaySecondWeek();
				planning.setNotesTuesdaySecondWeek(notesSecondTuesday);
			}

			if (planningForm.getNotesWednesdaySecondWeek() != null
					&& !planningForm.getNotesWednesdaySecondWeek().isEmpty())
			{
				String notesSecondWednesday = planningForm.getNotesWednesdaySecondWeek();
				planning.setNotesWednesdaySecondWeek(notesSecondWednesday);
			}

			if (planningForm.getNotesThursdaySecondWeek() != null
					&& !planningForm.getNotesThursdaySecondWeek().isEmpty())
			{
				String notesSecondThursday = planningForm.getNotesThursdaySecondWeek();
				planning.setNotesThursdaySecondWeek(notesSecondThursday);
			}

			if (planningForm.getNotesFridaySecondWeek() != null
					&& !planningForm.getNotesFridaySecondWeek().isEmpty())
			{
				String notesSecondFriday = planningForm.getNotesFridaySecondWeek();
				planning.setNotesFridaySecondWeek(notesSecondFriday);
			}

			if (planningForm.getCurrentWeek() != null && !planningForm.getCurrentWeek().isEmpty())
			{
				String thisWeek = planningForm.getCurrentWeek();
				int curWeek = Integer.parseInt(thisWeek);
				planning.setPlanningWeek(curWeek);
			}

			if (planningForm.getFirstWeek() != null && !planningForm.getFirstWeek().isEmpty())
			{
				String weekOne = planningForm.getFirstWeek();
				int week1 = Integer.parseInt(weekOne);
				planning.setFirstWeek(week1);
			}

			if (planningForm.getSecondWeek() != null && !planningForm.getSecondWeek().isEmpty())
			{
				String weekTwo = planningForm.getSecondWeek();
				int week2 = Integer.parseInt(weekTwo);
				planning.setSecondWeek(week2);
			}

			// execute action method
			SavePlanningAction savePlanningAction = new SavePlanningAction();

			try
			{
				// check if planning already exists
				if (savePlanningAction.read(planning))
				{
					// add code to output message on the page that the planning is not available
					// because a
					// record already exists in the database for this period and for this user
					System.out.println("Planning already exists for this period!");
					String message = "Planning already exists for given user and given weeks. Operation not allowed.";
					request.setAttribute("message", message);
					dispatchUrl = "PlanningExists.jsp";
					HttpSession session = request.getSession();
					session.setAttribute("anothermessage", message);
				} else
				{

					savePlanningAction.save(planning);
					// store model in a scope variable for the view
					request.setAttribute("planning", planning);
					dispatchUrl = "PlanningDetails.jsp";

					// add code to store model in a session variable
					HttpSession session = request.getSession();
					session.setAttribute("requestedplanning", planning);
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
