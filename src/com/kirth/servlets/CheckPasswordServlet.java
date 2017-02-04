/**
 * This servlet processes end user passwords
 * providing encryption functionalities.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kirth.util.*;

/**
 * Servlet implementation class CheckPasswordServlet
 */
@WebServlet("/CheckPasswordServlet")

public class CheckPasswordServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	/**
	 * This method processes end user login requests checking for password validity.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		// get parameters from the request
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// check strength requirements
		String message;
		try
		{
			PasswordUtil.checkPasswordStrength(password);
			message = "";
		} catch (Exception e)
		{
			message = e.getMessage();
		}
		request.setAttribute("message", message);

		// hash and salt password
		String hashedPassword;
		String salt = "";
		String saltedAndHashedPassword;
		try
		{
			hashedPassword = PasswordUtil.hashPassword(password);
			salt = PasswordUtil.getSalt();
			saltedAndHashedPassword = PasswordUtil.hashAndSaltPassword(password);

		} catch (NoSuchAlgorithmException ex)
		{
			hashedPassword = ex.getMessage();
			saltedAndHashedPassword = ex.getMessage();
		}
		request.setAttribute("hashedPassword", hashedPassword);
		request.setAttribute("salt", salt);
		request.setAttribute("saltedAndHashedPassword", saltedAndHashedPassword);

		String url = "/index.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
