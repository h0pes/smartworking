/**
 * This servlet deletes persistence cookies
 * from end user.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteCookiesServlet
 */
@WebServlet({ "/DeleteCookiesServlet", "/deleteCookies" })
public class DeleteCookiesServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCookiesServlet()
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
		String requestURI = request.getRequestURI();
		String url = "";
		if (requestURI.endsWith("/deleteCookies"))
		{
			url = deleteCookies(request, response);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * This method deletes end user cookies.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private String deleteCookies(HttpServletRequest request, HttpServletResponse response)
	{
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies)
		{
			cookie.setMaxAge(0); // delete the cookie
			cookie.setPath("/"); // entire application
			response.addCookie(cookie);
		}
		return "/delete_cookies.jsp";
	}

}
