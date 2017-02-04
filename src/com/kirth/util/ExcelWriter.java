/**
 * This class generates excel files
 * of Holiday objects using the Apache POI library
 * 
 * @version: v.1.0 - 19 mag 2016 16:26:32 
 * @author:  Marco Canavese
 */
package com.kirth.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kirth.model.Holiday;

public class ExcelWriter
{

	/**
	 * This method allows to write an Excel file of Holiday instances and save it to a given path.
	 * 
	 * @param listHoliday
	 * @param excelFilePath
	 * @return a Workbook representing the Excel file
	 * @throws IOException
	 */
	public Workbook writeExcel(List<Holiday> listHoliday, String excelFilePath) throws IOException
	{
		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.createSheet("UBCM holidays");

		int rowCount = 0;

		createHeaderRow(workbook, sheet);

		// Row row = sheet.createRow(rowCount);
		// writeHeader(row);
		rowCount++;

		for (Holiday aHoliday : listHoliday)
		{
			Row row = sheet.createRow(rowCount++);
			writeHoliday(aHoliday, row, sheet);
		}

		try (FileOutputStream outputStream = new FileOutputStream(excelFilePath))
		{
			workbook.write(outputStream);
		}

		return workbook;
	}

	/**
	 * This method allows to create the Excel worksheet header.
	 * 
	 * @param wb
	 * @param sheet
	 */
	public void createHeaderRow(Workbook wb, Sheet sheet)
	{

		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		Font font = sheet.getWorkbook().createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 12);
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

		Row row = sheet.createRow(0);

		Cell cellUserId = row.createCell(0);
		cellUserId.setCellStyle(cellStyle);
		cellUserId.setCellValue("UserId");

		Cell cellYear = row.createCell(1);
		cellYear.setCellStyle(cellStyle);
		cellYear.setCellValue("Year");

		Cell cellMonth = row.createCell(2);
		cellMonth.setCellStyle(cellStyle);
		cellMonth.setCellValue("Month");

		Cell cellDate = row.createCell(3);
		cellDate.setCellStyle(cellStyle);
		cellDate.setCellValue("Date");

		Cell cellDay = row.createCell(4);
		cellDay.setCellStyle(cellStyle);
		cellDay.setCellValue("Day");

		Cell cellType = row.createCell(5);
		cellType.setCellStyle(cellStyle);
		cellType.setCellValue("Type");
	}

	public void writeHeader(Row row)
	{
		Cell cell = row.createCell(0);
		cell.setCellValue("UserId");

		cell = row.createCell(1);
		cell.setCellValue("Year");

		cell = row.createCell(2);
		cell.setCellValue("Month");

		cell = row.createCell(3);
		cell.setCellValue("Date");

		cell = row.createCell(4);
		cell.setCellValue("WeekDay");

		cell = row.createCell(5);
		cell.setCellValue("DayType");
	}

	/**
	 * This method allows to actually write Holiday instances to the workbook rows.
	 * 
	 * @param aHoliday
	 * @param row
	 * @param sheet
	 */
	public void writeHoliday(Holiday aHoliday, Row row, Sheet sheet)
	{
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setRightBorderColor(IndexedColors.BLACK.getIndex());
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setTopBorderColor(IndexedColors.BLACK.getIndex());

		Cell cell = row.createCell(0);
		cell.setCellValue(aHoliday.getUserId());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(1);
		cell.setCellValue(aHoliday.getYear());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(2);
		cell.setCellValue(aHoliday.getMonthName());
		cell.setCellStyle(cellStyle);

		cell = row.createCell(3);
		Date dateHol = aHoliday.getUdate();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String myDate = formatter.format(dateHol);
		cell.setCellValue(myDate);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(4);
		int day = aHoliday.getDayOfWeek();
		String aDay = "";
		switch (day)
		{
		case 1:
			aDay = "Sunday";
			break;
		case 2:
			aDay = "Monday";
			break;
		case 3:
			aDay = "Tuesday";
			break;
		case 4:
			aDay = "Wednesay";
			break;
		case 5:
			aDay = "Thursday";
			break;
		case 6:
			aDay = "Friday";
			break;
		case 7:
			aDay = "Saturday";
			break;
		default:
			aDay = "Invalid day week";
			break;
		}
		cell.setCellValue(aDay);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(5);
		cell.setCellValue(aHoliday.getDayType());
		cell.setCellStyle(cellStyle);
	}

	public List<Holiday> getListHoliday() throws ParseException
	{

		Holiday holiday1 = new Holiday();
		Holiday holiday2 = new Holiday();
		holiday1.setUserId("u030523");
		holiday1.setYear(2016);
		holiday1.setMonthName("June");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateInString = "07/06/2013";
		Date date = null;
		try
		{

			date = formatter.parse(dateInString);
			System.out.println(date);
			System.out.println(formatter.format(date));

		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		holiday1.setUdate(date);

		holiday1.setDayOfWeek(3);
		holiday1.setDayType("ferie");

		holiday2.setUserId("u011111");
		holiday2.setYear(2016);
		holiday2.setMonthName("August");
		holiday2.setUdate(date);
		holiday2.setDayOfWeek(3);
		holiday2.setDayType("sospensione");

		List<Holiday> anHolidayList = Arrays.asList(holiday1, holiday2);

		return anHolidayList;
	}

	/**
	 * This method retrieve the workbook type to work with.
	 * 
	 * @param excelFilePath
	 * @return
	 * @throws IOException
	 */
	public Workbook getWorkbook(String excelFilePath) throws IOException
	{
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx"))
		{
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls"))
		{
			workbook = new HSSFWorkbook();
		} else
		{
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	public static void main(String[] args) throws IOException, ParseException
	{
		ExcelWriter excelWriter = new ExcelWriter();
		List<Holiday> listHoliday = excelWriter.getListHoliday();
		String excelFilePath = "JavaHolidays.xls";
		excelWriter.writeExcel(listHoliday, excelFilePath);

		excelFilePath = "JavaHolidays.xlsx";
		excelWriter.writeExcel(listHoliday, excelFilePath);
	}

}