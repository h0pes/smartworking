/**
 * This servlet processes end user requests
 * to export in Excel format some data.
 * 
 * @version: v.1.0 - 17 apr 2016 12:06:00 
 * @author: Marco Canavese
 */

package com.kirth.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.kirth.dao.HolidayDao;
import com.kirth.model.Holiday;
import com.kirth.util.ExcelWriter;;

/**
 * Servlet implementation class ExportToExcelServelt
 */
@WebServlet("/ExportToExcelServlet")
public class ExportToExcelServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExportToExcelServlet()
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
	 * This method processes users requests to export data in Excel format.
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
		if (request.getParameter("export-all") != null)
		{

			String chosenYear = request.getParameter("myYear");
			String chosenMonth = request.getParameter("myMonth");
			String chosenUsername = request.getParameter("myUserId");

			System.out.println("DEBUG: Do we get parameters? Year: " + chosenYear + " Month: "
					+ chosenMonth + " UserId: " + chosenUsername);

			List<Holiday> holidayList;
			HolidayDao holDao = new HolidayDao();

			try
			{
				holidayList = holDao.getHolidays(chosenYear, chosenMonth);
				request.getSession().setAttribute("viewholidaysforexcel", holidayList);

				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition", "attachment; filename=UBCMHolidays.xls");
				ExcelWriter excelWriter = new ExcelWriter();
				String excelFilePath = "JavaHolidayInServlet.xls";
				HSSFWorkbook workbook = (HSSFWorkbook) excelWriter.writeExcel(holidayList,
						excelFilePath);
				response.getOutputStream().flush();
				workbook.write(response.getOutputStream()); // Write workbook to response.
				workbook.close();

				System.out.println("DEBUG: completed excel export procedure...");

				System.out.println("Debugging session attribute...: " + holidayList);

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				e.printStackTrace();
			}

		} else if (request.getParameter("export-one") != null)
		{

			String dispatchUrl = null;
			String chosenYear = request.getParameter("myYear");
			String chosenMonth = request.getParameter("myMonth");
			String chosenUsername = request.getParameter("myUserId");

			System.out.println("DEBUG: Do we get parameters? Year: " + chosenYear + " Month: "
					+ chosenMonth + " UserId: " + chosenUsername);

			List<Holiday> holidayList;
			HolidayDao holDao = new HolidayDao();

			try
			{
				holidayList = holDao.getHoliday(chosenYear, chosenMonth, chosenUsername);
				request.getSession().setAttribute("viewholidaysforexcel", holidayList);

				response.setContentType("application/vnd.ms-excel");
				response.setHeader("Content-Disposition",
						"attachment; filename=UBCMHolidays_" + chosenUsername + ".xls");
				ExcelWriter excelWriter = new ExcelWriter();
				String excelFilePath = "JavaHolidayInServlet.xls";
				HSSFWorkbook workbook = (HSSFWorkbook) excelWriter.writeExcel(holidayList,
						excelFilePath);
				response.getOutputStream().flush();
				workbook.write(response.getOutputStream()); // Write workbook to response.
				workbook.close();

				System.out.println("DEBUG: completed excel export procedure...");

				System.out.println("Debugging session attribute...: " + holidayList);
				dispatchUrl = "ExportToExcel.jsp";

			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

}
