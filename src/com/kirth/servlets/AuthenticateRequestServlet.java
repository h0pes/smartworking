/**
 * This servlet processes end user forgot password
 * requests, authenticating them.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kirth.dao.FPDao;
import com.kirth.util.Utility;

/**
 * Servlet implementation class AuthenticateRequestServlet
 */
@WebServlet(name = "AuthenticateRequestServlet", urlPatterns = { "/AuthenticateRequestServlet",
		"/Authenticate" })
public class AuthenticateRequestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private Utility utility;
	private FPDao dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateRequestServlet()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * This method processes the end user request for recovery password,
	 * verifying and authenticating the request.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			utility = Utility.getInstance();
			String utid = utility.decryptData(request.getParameter("UTID"));
			String useremail = utility.decryptData(request.getParameter("USERID"));
			dao = new FPDao();
			Map<String, String> data = dao.verifyRequest(utid, useremail);
			if (data.get("RESULT").toString().equalsIgnoreCase("SUCCESS"))
			{
				session.setAttribute("tokenId", utid);
				response.sendRedirect(data.get("REASON").toString());
			} else if (data.get("RESULT").toString().equalsIgnoreCase("FAILURE")
					&& data.get("REASON").toString().equalsIgnoreCase("TIMEOUT"))
			{
				request.setAttribute("linkfailuremsg", "on");
				RequestDispatcher view = request.getRequestDispatcher("ResetPassword.jsp");
				view.forward(request, response);
			} else if (data.get("RESULT").toString().equalsIgnoreCase("FAILURE")
					&& data.get("REASON").toString().equalsIgnoreCase("INVALIDREQ"))
			{
				out.println(
						"<html> <head /> <body> <center> <div style='color: #D8000C; background-color: #FFBABA;'> <b>Invalid Request</b> </div> </center> </body> </html>");
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
