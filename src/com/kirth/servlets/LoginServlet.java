/**
 * This is the servlet which will capture the
 * input parameter from the jsp and validate it
 * against the LoginDao
 * 
 * @version: v.1.0 - 09 apr 2016 22:15:41 
 * @author: Marco Canavese
 */
package com.kirth.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.kirth.dao.*;

public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * This method processes the login parameters typed by the end user at the login page.
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("username");
		String p = request.getParameter("userpass");
		HttpSession session = request.getSession(false);
		// set user session to 1 hour
		session.setMaxInactiveInterval(3600);
		if (session != null)
			session.setAttribute("name", n);
		if (LoginDao.validate(n, p))
		{
			// insert code to check role
			if (LoginDao.checkRole(n).equals("user"))
			{
				System.out.println("System checked the user role");
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else if (LoginDao.checkRole(n).equals("manager"))
			{
				System.out.println("System checked the manager role");
				RequestDispatcher rd = request.getRequestDispatcher("welcomemanager.jsp");
				rd.forward(request, response);
			} else
			{
				// TODO - jsp page for missing role + page for administrator role
				System.out.println("There is no defined role for this user.");
			}

		} else
		{
			out.print("<p style=\"color:red\">Sorry username or password error</p>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		out.close();
	}
}