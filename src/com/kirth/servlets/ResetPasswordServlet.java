/**
 * This servlet processes end user requests
 * for password recovery, resetting the password.
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
 * Servlet implementation class ResetPasswordServlet
 */
@WebServlet(name = "ResetPasswordServlet", urlPatterns = { "/ResetPasswordServlet", "/Reset" })
public class ResetPasswordServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResetPasswordServlet()
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
	 * This method processes end user requests for recovery password, resetting the password.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		FPDao fpdao;
		try
		{
			String newpass = request.getParameter("pwd");
			String mailid = request.getParameter("mailid");
			String utid = (String) request.getSession().getAttribute("tokenId");
			fpdao = new FPDao();
			Map<String, String> data = fpdao.insertData(utid, mailid, newpass);
			if (data.get("RESULT").toString().equalsIgnoreCase("SUCCESS"))
			{
				out.println(
						"<html> <head /> <body> <center> <div style='color: #4F8A10; background-color: #DFF2BF;'> <b>"
								+ data.get("REASON").toString()
								+ " Please return to the login page "
								+ "</b> <A HREF=\"http://localhost:8081//LoginTest\">Login</A> </div> </center> </body> </html>");
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

		} finally
		{
			out.close();
		}
	}
}
