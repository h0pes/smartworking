package com.kirth.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MultipleButtonServlet
 */
@WebServlet(name = "ViewRequestsServlet", urlPatterns ={ "/MultipleButtonServlet" })

public class MultipleButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultipleButtonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	         
//	        String username = request.getParameter("userName");
//	        request.setAttribute("message", "username row : " + username);
//	        request.getRequestDispatcher("/ViewAllRequests.jsp").forward(request, response);
		 
//		 	String actionValue = "";
//	        String button_selected = "";
//	        Enumeration en = request.getParameterNames();
//	        while (en.hasMoreElements()) {
//	            button_selected = (String) en.nextElement();
//	            System.out.println("Button name clicked is: " + button_selected);
//	            String reqId = button_selected.substring(button_selected.indexOf("_") +1);
//	            System.out.println("Request Id is: " + reqId);
//	            actionValue = request.getParameter(button_selected);
//	        }
//	         
//	        request.setAttribute("message", "username button name: " + button_selected + ": username Value : " + actionValue);
//	        request.getRequestDispatcher("/ViewAllRequests.jsp").forward(request, response);
	         
	    }

}
