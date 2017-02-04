/**
 * This servlet processes end user emails
 * sent out using the application form.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kirth.dao.MailReportDao;
import com.kirth.model.MailReport;
//import com.kirth.util.EmailUtility;
import com.kirth.util.SendMail;

/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String user;
	private String pass;

	/**
	 * This method sets some configuration variables in order to use the mail features.
	 */
	public void init()
	{
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	/**
	 * This method processes the actual mail object being sent out using the application form.
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		MailReport mailRep = new MailReport();

		// reads form fields
		String username = (String) request.getSession().getAttribute("name");
		String ccaddress = request.getParameter("carboncopy");
		String recipient = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String date = request.getParameter("date");

		// build model
		if (username != null && !username.isEmpty())
		{
			System.out.println(username);
			mailRep.setUsername(username);
		}

		if (ccaddress != null && !ccaddress.isEmpty())
		{
			System.out.println(ccaddress);
			mailRep.setCcAddress(ccaddress);
		}

		if (recipient != null && !recipient.isEmpty())
		{
			System.out.println(recipient);
			mailRep.setToAddress(recipient);
		}

		if (subject != null && !subject.isEmpty())
		{
			System.out.println(subject);
			mailRep.setSubject(subject);
		}

		if (content != null && !content.isEmpty())
		{
			System.out.println(content);
			mailRep.setBody(content);
		}

		if (date != null && !date.isEmpty())
		{
			System.out.println(date);
			mailRep.setDateToReport(date);
		}

		MailReportDao mailRepDao = new MailReportDao();

		try
		{
			mailRepDao.save(mailRep);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
				| SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// add code to store model in a session variable

		HttpSession session = request.getSession();
		session.setAttribute("mailreport", mailRep);

		String resultMessage = "";

		try
		{
			SendMail.sendEmail(host, port, user, pass, recipient, subject, content, date);
			resultMessage = "An email was successfully sent by " + username + " to " + recipient
					+ " with the following content " + content
					+ ". This is for reporting smart working activities done on " + date;

		} catch (Exception ex)
		{
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally
		{
			request.setAttribute("Message", resultMessage);
			getServletContext().getRequestDispatcher("/EmailSentResult.jsp").forward(request,
					response);
		}
	}
}
