/**
 * This servlet processes end user planning requests.
 * by approving or rejecting them.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kirth.dao.SavePlanningAction;
import com.kirth.model.Planning;

/**
 * Servlet implementation class ApproveRejectAllServlet
 */
@WebServlet(name = "ApproveRejectAllServlet", urlPatterns = { "/ApproveRejectRequests",
		"/approve-reject-request" })

public class ApproveRejectAllServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApproveRejectAllServlet()
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * This method processes planning requests by approving/approving all, rejecting/rejecting all
	 * the items.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String actionValue = "";
		String paramName = "";
		String reqId = "";
		String approveOrReject = "";

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements())
		{
			paramName = (String) paramNames.nextElement();
			System.out.println("Button name clicked is: " + paramName);
			reqId = paramName.substring(paramName.indexOf("_") + 1);
			System.out.println("Request Id is: " + reqId);
			System.out.println("Index of: " + paramName.indexOf("_"));

			String[] paramValues = request.getParameterValues(paramName);
			for (int i = 0; i < paramValues.length; i++)
			{
				String paramValue = paramValues[i];
				System.out.println("Parameter value: " + paramValue);

				switch (paramValue)
				{
				case "Approve":
					actionValue = request.getParameter(paramName);
					break;
				case "Reject":
					actionValue = request.getParameter(paramName);
					break;
				case "Approve All":
					actionValue = request.getParameter(paramName);
					break;
				case "Reject All":
					actionValue = request.getParameter(paramName);
					break;
				default:
					break;
				}
			}
		}

		boolean isManaged = true;
		String checked = String.valueOf(isManaged);
		// request.setAttribute("managed", checked);
		request.setAttribute("message",
				"Planning request id " + paramName + " has been submitted for " + actionValue);
		// request.getRequestDispatcher("/ViewAllRequests.jsp").forward(request, response);
		request.getRequestDispatcher("/ApproveRejectResult.jsp").forward(request, response);
		if (request.getParameter("approveAll") != null)
		{
			System.out.println("Clicked approve all button do some job now...");
			Planning planning = new Planning();
			SavePlanningAction spa = new SavePlanningAction();
			try
			{
				spa.updateApproveAll(planning);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (request.getParameter("rejectAll") != null)
		{
			System.out.println("Clicked reject all button do some job now...");
			Planning planning = new Planning();
			SavePlanningAction spa = new SavePlanningAction();
			try
			{
				spa.updateRejectAll(planning);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (actionValue.equals("Approve"))
		{
			// code for click on specific approval requestId
			System.out.println(
					"Clicked on specific approve button do some job now...reqId: " + reqId);
			Planning planning = new Planning();
			int id = Integer.parseInt(reqId);
			planning.setPlanningId(id);
			planning.setManaged(checked);
			System.out.println("the value of the managed attribute is: " + checked);
			SavePlanningAction spa = new SavePlanningAction();
			try
			{
				spa.updateApproveReqId(planning);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		else if (actionValue.equals("Reject"))
		{
			System.out
					.println("Clicked on specific reject button do some job now...reqId: " + reqId);
			Planning planning = new Planning();
			int id = Integer.parseInt(reqId);
			planning.setPlanningId(id);
			SavePlanningAction spa = new SavePlanningAction();
			try
			{
				spa.updateRejectReqId(planning);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else
		{
			// code for handling not proper case
			System.out.println("We are here for a logic error...");
		}
	}

}
