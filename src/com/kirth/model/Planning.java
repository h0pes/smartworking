/**
 * This class allows to create instances of 
 * Planning objects
 * 
 * @version: v.1.0 - 17 apr 2016 12:21:11 
 * @author: Marco Canavese
 */
package com.kirth.model;

import java.io.Serializable;
import java.util.Date;

public class Planning implements Serializable
{

	private static final long serialVersionUID = 1L;
	private int planningId;
	private String userId;
	private String days;

	private Date requestDate;

	private Date mondayFirstWeek;
	private Date tuesdayFirstWeek;
	private Date wednesdayFirstWeek;
	private Date thursdayFirstWeek;
	private Date fridayFirstWeek;

	private Date mondaySecondWeek;
	private Date tuesdaySecondWeek;
	private Date wednesdaySecondWeek;
	private Date thursdaySecondWeek;
	private Date fridaySecondWeek;

	private String status;

	private String notes;

	private String notesMondayFirstWeek;
	private String notesTuesdayFirstWeek;
	private String notesWednesdayFirstWeek;
	private String notesThursdayFirstWeek;
	private String notesFridayFirstWeek;

	private String notesMondaySecondWeek;
	private String notesTuesdaySecondWeek;
	private String notesWednesdaySecondWeek;
	private String notesThursdaySecondWeek;
	private String notesFridaySecondWeek;

	private int planningWeek;
	private int firstWeek;
	private int secondWeek;

	private String managed;

	/**
	 * This method retrieves the first day of the first week.
	 * 
	 * @return the mondayFirstWeek
	 */
	public Date getMondayFirstWeek()
	{
		return mondayFirstWeek;
	}

	/**
	 * This method sets the first day of the first week.
	 * 
	 * @param mondayFirstWeek
	 *            the mondayFirstWeek to set
	 */
	public void setMondayFirstWeek(Date mondayFirstWeek)
	{
		this.mondayFirstWeek = mondayFirstWeek;
	}

	/**
	 * This method retrieves the second day of the first week.
	 * 
	 * @return the tuesdayFirstWeek
	 */
	public Date getTuesdayFirstWeek()
	{
		return tuesdayFirstWeek;
	}

	/**
	 * This method sets the second day of the first week.
	 * 
	 * @param tuesdayFirstWeek
	 *            the tuesdayFirstWeek to set
	 */
	public void setTuesdayFirstWeek(Date tuesdayFirstWeek)
	{
		this.tuesdayFirstWeek = tuesdayFirstWeek;
	}

	/**
	 * This method retrieves the third day of the first week.
	 * 
	 * @return the wednesdayFirstWeek
	 */
	public Date getWednesdayFirstWeek()
	{
		return wednesdayFirstWeek;
	}

	/**
	 * This method sets the third day of the first week.
	 * 
	 * @param wednesdayFirstWeek
	 *            the wednesdayFirstWeek to set
	 */
	public void setWednesdayFirstWeek(Date wednesdayFirstWeek)
	{
		this.wednesdayFirstWeek = wednesdayFirstWeek;
	}

	/**
	 * This method retrieves the fourth day of the first week.
	 * 
	 * @return the thursdayFirstWeek
	 */
	public Date getThursdayFirstWeek()
	{
		return thursdayFirstWeek;
	}

	/**
	 * This method sets the fourth day of the first week.
	 * 
	 * @param thursdayFirstWeek
	 *            the thursdayFirstWeek to set
	 */
	public void setThursdayFirstWeek(Date thursdayFirstWeek)
	{
		this.thursdayFirstWeek = thursdayFirstWeek;
	}

	/**
	 * This method retrieves the fifth day of the first week.
	 * 
	 * @return the fridayFirstWeek
	 */
	public Date getFridayFirstWeek()
	{
		return fridayFirstWeek;
	}

	/**
	 * This method sets the fifth day of the first week.
	 * 
	 * @param fridayFirstWeek
	 *            the fridayFirstWeek to set
	 */
	public void setFridayFirstWeek(Date fridayFirstWeek)
	{
		this.fridayFirstWeek = fridayFirstWeek;
	}

	/**
	 * This method retrieves the first day of the second week.
	 * 
	 * @return the mondaySecondWeek
	 */
	public Date getMondaySecondWeek()
	{
		return mondaySecondWeek;
	}

	/**
	 * This method sets the first day of the second week.
	 * 
	 * @param mondaySecondWeek
	 *            the mondaySecondWeek to set
	 */
	public void setMondaySecondWeek(Date mondaySecondWeek)
	{
		this.mondaySecondWeek = mondaySecondWeek;
	}

	/**
	 * This method retrieves the second day of the second week.
	 * 
	 * @return the tuesdaySecondWeek
	 */
	public Date getTuesdaySecondWeek()
	{
		return tuesdaySecondWeek;
	}

	/**
	 * This method sets the second day of the second week.
	 * 
	 * @param tuesdaySecondWeek
	 *            the tuesdaySecondWeek to set
	 */
	public void setTuesdaySecondWeek(Date tuesdaySecondWeek)
	{
		this.tuesdaySecondWeek = tuesdaySecondWeek;
	}

	/**
	 * This method retrieves the third day of the second week.
	 * 
	 * @return the wednesdaySecondWeek
	 */
	public Date getWednesdaySecondWeek()
	{
		return wednesdaySecondWeek;
	}

	/**
	 * This method sets the third day of the second week.
	 * 
	 * @param wednesdaySecondWeek
	 *            the wednesdaySecondWeek to set
	 */
	public void setWednesdaySecondWeek(Date wednesdaySecondWeek)
	{
		this.wednesdaySecondWeek = wednesdaySecondWeek;
	}

	/**
	 * This method retrieves the fourth day of the second week.
	 * 
	 * @return the thursdaySecondWeek
	 */
	public Date getThursdaySecondWeek()
	{
		return thursdaySecondWeek;
	}

	/**
	 * This method sets the fourth day of the second week.
	 * 
	 * @param thursdaySecondWeek
	 *            the thursdaySecondWeek to set
	 */
	public void setThursdaySecondWeek(Date thursdaySecondWeek)
	{
		this.thursdaySecondWeek = thursdaySecondWeek;
	}

	/**
	 * This method retrieves the fifth day of the second week.
	 * 
	 * @return the fridaySecondWeek
	 */
	public Date getFridaySecondWeek()
	{
		return fridaySecondWeek;
	}

	/**
	 * This method sets the fifth day of the second week.
	 * 
	 * @param fridaySecondWeek
	 *            the fridaySecondWeek to set
	 */
	public void setFridaySecondWeek(Date fridaySecondWeek)
	{
		this.fridaySecondWeek = fridaySecondWeek;
	}

	/**
	 * This method retrieves the notes for the first day of the first week.
	 *
	 * @return the notesMondayFirstWeek
	 */
	public String getNotesMondayFirstWeek()
	{
		return notesMondayFirstWeek;
	}

	/**
	 * This method sets the notes for the first day of the first week.
	 *
	 * @param notesMondayFirstWeek
	 *            the notesMondayFirstWeek to set
	 */
	public void setNotesMondayFirstWeek(String notesMondayFirstWeek)
	{
		this.notesMondayFirstWeek = notesMondayFirstWeek;
	}

	/**
	 * This method retrieves the notes for the second day of the first week.
	 *
	 * @return the notesTuesdayFirstWeek
	 */
	public String getNotesTuesdayFirstWeek()
	{
		return notesTuesdayFirstWeek;
	}

	/**
	 * This method sets the notes for the second day of the first week.
	 *
	 * @param notesTuesdayFirstWeek
	 *            the notesTuesdayFirstWeek to set
	 */
	public void setNotesTuesdayFirstWeek(String notesTuesdayFirstWeek)
	{
		this.notesTuesdayFirstWeek = notesTuesdayFirstWeek;
	}

	/**
	 * This method retrieves the notes for the third day of the first week.
	 *
	 * @return the notesWednesdayFirstWeek
	 */
	public String getNotesWednesdayFirstWeek()
	{
		return notesWednesdayFirstWeek;
	}

	/**
	 * This method sets the notes for the third day of the first week.
	 *
	 * @param notesWednesdayFirstWeek
	 *            the notesWednesdayFirstWeek to set
	 */
	public void setNotesWednesdayFirstWeek(String notesWednesdayFirstWeek)
	{
		this.notesWednesdayFirstWeek = notesWednesdayFirstWeek;
	}

	/**
	 * This method retrieves the notes for the fourth day of the first week.
	 *
	 * @return the notesThursdayFirstWeek
	 */
	public String getNotesThursdayFirstWeek()
	{
		return notesThursdayFirstWeek;
	}

	/**
	 * This method sets the notes for the fourth day of the first week.
	 *
	 * @param notesThursdayFirstWeek
	 *            the notesThursdayFirstWeek to set
	 */
	public void setNotesThursdayFirstWeek(String notesThursdayFirstWeek)
	{
		this.notesThursdayFirstWeek = notesThursdayFirstWeek;
	}

	/**
	 * This method retrieves the notes for the fifth day of the first week.
	 *
	 * @return the notesFridayFirstWeek
	 */
	public String getNotesFridayFirstWeek()
	{
		return notesFridayFirstWeek;
	}

	/**
	 * This method sets the notes for the fifth day of the first week.
	 *
	 * @param notesFridayFirstWeek
	 *            the notesFridayFirstWeek to set
	 */
	public void setNotesFridayFirstWeek(String notesFridayFirstWeek)
	{
		this.notesFridayFirstWeek = notesFridayFirstWeek;
	}

	/**
	 * This method retrieves the notes for the first day of the second week.
	 * 
	 * @return the notesMondaySecondWeek
	 */
	public String getNotesMondaySecondWeek()
	{
		return notesMondaySecondWeek;
	}

	/**
	 * This method sets the notes for the first day of the second week.
	 * 
	 * @param notesMondaySecondWeek
	 *            the notesMondaySecondWeek to set
	 */
	public void setNotesMondaySecondWeek(String notesMondaySecondWeek)
	{
		this.notesMondaySecondWeek = notesMondaySecondWeek;
	}

	/**
	 * This method retrieves the notes for the second day of the second week.
	 * 
	 * @return the notesTuesdaySecondWeek
	 */
	public String getNotesTuesdaySecondWeek()
	{
		return notesTuesdaySecondWeek;
	}

	/**
	 * This method sets the notes for the second day of the second week.
	 * 
	 * @param notesTuesdaySecondWeek
	 *            the notesTuesdaySecondWeek to set
	 */
	public void setNotesTuesdaySecondWeek(String notesTuesdaySecondWeek)
	{
		this.notesTuesdaySecondWeek = notesTuesdaySecondWeek;
	}

	/**
	 * This method retrieves the notes for the third day of the second week.
	 * 
	 * @return the notesWednesdaySecondWeek
	 */
	public String getNotesWednesdaySecondWeek()
	{
		return notesWednesdaySecondWeek;
	}

	/**
	 * This method sets the notes for the third day of the second week.
	 * 
	 * @param notesWednesdaySecondWeek
	 *            the notesWednesdaySecondWeek to set
	 */
	public void setNotesWednesdaySecondWeek(String notesWednesdaySecondWeek)
	{
		this.notesWednesdaySecondWeek = notesWednesdaySecondWeek;
	}

	/**
	 * This method retrieves the notes for the fourth day of the second week.
	 * 
	 * @return the notesThursdaySecondWeek
	 */
	public String getNotesThursdaySecondWeek()
	{
		return notesThursdaySecondWeek;
	}

	/**
	 * This method sets the notes for the fourth day of the second week.
	 * 
	 * @param notesThursdaySecondWeek
	 *            the notesThursdaySecondWeek to set
	 */
	public void setNotesThursdaySecondWeek(String notesThursdaySecondWeek)
	{
		this.notesThursdaySecondWeek = notesThursdaySecondWeek;
	}

	/**
	 * This method retrieves the notes for the fifth day of the second week.
	 * 
	 * @return the notesFridaySecondWeek
	 */
	public String getNotesFridaySecondWeek()
	{
		return notesFridaySecondWeek;
	}

	/**
	 * This method sets the notes for the fifth day of the second week.
	 * 
	 * @param notesFridaySecondWeek
	 *            the notesFridaySecondWeek to set
	 */
	public void setNotesFridaySecondWeek(String notesFridaySecondWeek)
	{
		this.notesFridaySecondWeek = notesFridaySecondWeek;
	}

	/**
	 * This method retrieves the id of the planning.
	 * 
	 * @return the planningId
	 */
	public int getPlanningId()
	{
		return planningId;
	}

	/**
	 * This method sets the id of the planning.
	 * 
	 * @param planningId
	 *            the planningId to set
	 */
	public void setPlanningId(int planningId)
	{
		this.planningId = planningId;
	}

	/**
	 * This method retrieves the userid associated with the planning.
	 * 
	 * @return the user
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * This method sets the userid associated with the planning.
	 * 
	 * @param user
	 *            the user to set
	 */
	public void setUserId(String user)
	{
		this.userId = user;
	}

	/**
	 * This method retrieves the days associated with the planning.
	 * 
	 * @return the days
	 */
	public String getDays()
	{
		return days;
	}

	/**
	 * This method sets the days associated with the planning.
	 * 
	 * @param days
	 *            the days to set
	 */
	public void setDays(String days)
	{
		this.days = days;
	}

	/**
	 * This method retrieves the status of the planning.
	 * 
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * This method sets the status of the planning.
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * This method retrieves the notes of the planning.
	 * 
	 * @return the notes
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * This method sets the status of the planning.
	 * 
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	/**
	 * This method retrieves the Date of the planning request.
	 * 
	 * @return the requestDate
	 */
	public Date getRequestDate()
	{
		return requestDate;
	}

	/**
	 * This method sets the Date of the planning request.
	 * 
	 * @param requestDate
	 *            the requestDate to set
	 */
	public void setRequestDate(Date requestDate)
	{
		this.requestDate = requestDate;
	}

	/**
	 * This method retrieves the planning week (the week in which we are performing the request) of
	 * the planning request.
	 * 
	 * @return the planningWeek
	 */
	public int getPlanningWeek()
	{
		return planningWeek;
	}

	/**
	 * This method sets the planning week (the week in which we are performing the request) of the
	 * planning request.
	 * 
	 * @param planningWeek
	 *            the planningWeek to set
	 */
	public void setPlanningWeek(int planningWeek)
	{
		this.planningWeek = planningWeek;
	}

	/**
	 * This method retrieves the first week of the planning request.
	 * 
	 * @return the firstWeek
	 */
	public int getFirstWeek()
	{
		return firstWeek;
	}

	/**
	 * This method sets the first week of the planning request.
	 * 
	 * @param firstWeek
	 *            the firstWeek to set
	 */
	public void setFirstWeek(int firstWeek)
	{
		this.firstWeek = firstWeek;
	}

	/**
	 * This method retrieves the second week of the planning request.
	 * 
	 * @return the secondWeek
	 */
	public int getSecondWeek()
	{
		return secondWeek;
	}

	/**
	 * This method sets the second week of the planning request.
	 * 
	 * @param secondWeek
	 *            the secondWeek to set
	 */
	public void setSecondWeek(int secondWeek)
	{
		this.secondWeek = secondWeek;
	}

	/**
	 * This method retrieves the managed status of the planning request.
	 * 
	 * @return the managed
	 */
	public String getManaged()
	{
		return managed;
	}

	/**
	 * This method sets the managed status of the planning request.
	 * 
	 * @param managed
	 *            the managed to set
	 */
	public void setManaged(String managed)
	{
		this.managed = managed;
	}

}
