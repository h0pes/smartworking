/**
 * This servlet processes end user requests
 * for password recovery, sending out reset link
 * to the registered email.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kirth.dao.FPDao;

/**
 * Servlet implementation class SendResetLinkServlet
 */

@WebServlet(name = "SendResetLinkServlet", urlPatterns = { "/SendResetLinkServlet", "/Send" })
public class SendResetLinkServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	FPDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendResetLinkServlet()
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
	 * This method processes end user requests sending out reset link to the user registered email.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			PrintWriter out = response.getWriter();
			String useremail = request.getParameter("emailId");
			System.out.println("we are here at least...useremail: " + useremail);
			dao = new FPDao();
			Map<String, String> data = dao.insertData(useremail);
			if (data.get("RESULT").toString().equalsIgnoreCase("SUCCESS"))
			{
				out.println(
						"<html> <head /> <body> <center> <div style='color: #4F8A10; background-color: #DFF2BF;'> <b>"
								+ data.get("REASON").toString()
								+ "</b> </div> </center> </body> </html>");
			} else if (data.get("RESULT").toString().equalsIgnoreCase("FAILURE"))
			{
				out.println(
						"<html> <head /> <body> <center> <div style='color: #D8000C; background-color: #FFBABA;'> <b>"
								+ data.get("REASON").toString()
								+ "</b> </div> </center> </body> </html>");
			} else if (data.get("RESULT").toString().equalsIgnoreCase("EXCEPTION"))
			{
				out.println(
						"<html> <head /> <body> <center> <div style='color: #D8000C; background-color: #FFBABA;'> <b>Internal Exception Occured! Please try Later<br />Reason:-"
								+ data.get("REASON").toString()
								+ "</b> </div> </center> </body> </html>");
			}

		} catch (Exception e)
		{
			response.getWriter().println(
					"<html> <head /> <body> <center> <div style='color: #D8000C; background-color: #FFBABA;'> <b>Internal Exception Occured! Please try Later<br />Reason:-"
							+ e.getMessage() + "</b> </div> </center> </body> </html>");
		}

	}

}
