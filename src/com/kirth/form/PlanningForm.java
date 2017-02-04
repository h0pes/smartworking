/**
 * This class behaves as a bridge between the
 * input form and the data model for managing
 * Planning objects.
 * 
 * @version: v.1.0 - 17 apr 2016 12:30:22 
 * @author: Marco Canavese
 */
package com.kirth.form;

public class PlanningForm
{

	private String userId;
	private String days;
	private String status;
	private String notes;

	private String mondayFirstWeek;
	private String tuesdayFirstWeek;
	private String wednesdayFirstWeek;
	private String thursdayFirstWeek;
	private String fridayFirstWeek;

	private String mondaySecondWeek;
	private String tuesdaySecondWeek;
	private String wednesdaySecondWeek;
	private String thursdaySecondWeek;
	private String fridaySecondWeek;

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

	private String currentWeek;
	private String firstWeek;
	private String secondWeek;

	private String managed;

	/**
	 * This method retrieves the first day of the first week.
	 * 
	 * @return the mondayFirstWeek
	 */
	public String getMondayFirstWeek()
	{
		return mondayFirstWeek;
	}

	/**
	 * This method sets the first day of the first week.
	 * 
	 * @param mondayFirstWeek
	 *            the mondayFirstWeek to set
	 */
	public void setMondayFirstWeek(String mondayFirstWeek)
	{
		this.mondayFirstWeek = mondayFirstWeek;
	}

	/**
	 * This method retrieves the second day of the first week.
	 * 
	 * @return the tuesdayFirstWeek
	 */
	public String getTuesdayFirstWeek()
	{
		return tuesdayFirstWeek;
	}

	/**
	 * This method sets the second day of the first week.
	 * 
	 * @param tuesdayFirstWeek
	 *            the tuesdayFirstWeek to set
	 */
	public void setTuesdayFirstWeek(String tuesdayFirstWeek)
	{
		this.tuesdayFirstWeek = tuesdayFirstWeek;
	}

	/**
	 * This method retrieves the third day of the first week.
	 * 
	 * @return the wednesdayFirstWeek
	 */
	public String getWednesdayFirstWeek()
	{
		return wednesdayFirstWeek;
	}

	/**
	 * This method sets the third day of the first week.
	 * 
	 * @param wednesdayFirstWeek
	 *            the wednesdayFirstWeek to set
	 */
	public void setWednesdayFirstWeek(String wednesdayFirstWeek)
	{
		this.wednesdayFirstWeek = wednesdayFirstWeek;
	}

	/**
	 * This method retrieves the fourth day of the first week.
	 * 
	 * @return the thursdayFirstWeek
	 */
	public String getThursdayFirstWeek()
	{
		return thursdayFirstWeek;
	}

	/**
	 * This method sets the fourth day of the first week.
	 * 
	 * @param thursdayFirstWeek
	 *            the thursdayFirstWeek to set
	 */
	public void setThursdayFirstWeek(String thursdayFirstWeek)
	{
		this.thursdayFirstWeek = thursdayFirstWeek;
	}

	/**
	 * This method retrieves the fifth day of the first week.
	 * 
	 * @return the fridayFirstWeek
	 */
	public String getFridayFirstWeek()
	{
		return fridayFirstWeek;
	}

	/**
	 * This method sets the fifth day of the first week.
	 * 
	 * @param fridayFirstWeek
	 *            the fridayFirstWeek to set
	 */
	public void setFridayFirstWeek(String fridayFirstWeek)
	{
		this.fridayFirstWeek = fridayFirstWeek;
	}

	/**
	 * This method retrieves the first day of the second week.
	 * 
	 * @return the mondaySecondWeek
	 */
	public String getMondaySecondWeek()
	{
		return mondaySecondWeek;
	}

	/**
	 * This method sets the first day of the second week.
	 * 
	 * @param mondaySecondWeek
	 *            the mondaySecondWeek to set
	 */
	public void setMondaySecondWeek(String mondaySecondWeek)
	{
		this.mondaySecondWeek = mondaySecondWeek;
	}

	/**
	 * This method retrieves the second day of the second week.
	 * 
	 * @return the tuesdaySecondWeek
	 */
	public String getTuesdaySecondWeek()
	{
		return tuesdaySecondWeek;
	}

	/**
	 * This method sets the second day of the second week.
	 * 
	 * @param tuesdaySecondWeek
	 *            the tuesdaySecondWeek to set
	 */
	public void setTuesdaySecondWeek(String tuesdaySecondWeek)
	{
		this.tuesdaySecondWeek = tuesdaySecondWeek;
	}

	/**
	 * This method retrieves the third day of the second week.
	 * 
	 * @return the wednesdaySecondWeek
	 */
	public String getWednesdaySecondWeek()
	{
		return wednesdaySecondWeek;
	}

	/**
	 * This method sets the third day of the second week.
	 * 
	 * @param wednesdaySecondWeek
	 *            the wednesdaySecondWeek to set
	 */
	public void setWednesdaySecondWeek(String wednesdaySecondWeek)
	{
		this.wednesdaySecondWeek = wednesdaySecondWeek;
	}

	/**
	 * This method retrieves the fourth day of the second week.
	 * 
	 * @return the thursdaySecondWeek
	 */
	public String getThursdaySecondWeek()
	{
		return thursdaySecondWeek;
	}

	/**
	 * This method sets the first day of the second week.
	 * 
	 * @param thursdaySecondWeek
	 *            the thursdaySecondWeek to set
	 */
	public void setThursdaySecondWeek(String thursdaySecondWeek)
	{
		this.thursdaySecondWeek = thursdaySecondWeek;
	}

	/**
	 * This method retrieves the fifth day of the second week.
	 * 
	 * @return the fridaySecondWeek
	 */
	public String getFridaySecondWeek()
	{
		return fridaySecondWeek;
	}

	/**
	 * This method sets the fifth day of the second week.
	 * 
	 * @param fridaySecondWeek
	 *            the fridaySecondWeek to set
	 */
	public void setFridaySecondWeek(String fridaySecondWeek)
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
	 * This method returns the String representation of the days of the planning.
	 * 
	 * @return the days
	 */
	public String getDays()
	{
		return days;
	}

	/**
	 * This method sets the days of the planning request.
	 * 
	 * @param days
	 *            the days to set
	 */
	public void setDays(String days)
	{
		this.days = days;
	}

	/**
	 * This method retrieves the status of a planning item.
	 * 
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * This method sets the status of a planning item.
	 * 
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * This method retrieves the notes associated with a planning item.
	 * 
	 * @return the notes
	 */
	public String getNotes()
	{
		return notes;
	}

	/**
	 * This method sets the notes associated with a planning item.
	 * 
	 * @param notes
	 *            the notes to set
	 */
	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	/**
	 * This method retrieves the userid who to whom belongs a planning item.
	 * 
	 * @return the userId
	 */
	public String getUserId()
	{
		return userId;
	}

	/**
	 * This method sets the userid for a planning item.
	 * 
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	/**
	 * This method retrieves the current week of the planning.
	 * 
	 * @return the currentWeek
	 */
	public String getCurrentWeek()
	{
		return currentWeek;
	}

	/**
	 * This method sets the current week for the planning.
	 * 
	 * @param currentWeek
	 *            the currentWeek to set
	 */
	public void setCurrentWeek(String currentWeek)
	{
		this.currentWeek = currentWeek;
	}

	/**
	 * This method retrieves the first week for the planning.
	 * 
	 * @return the firstWeek
	 */
	public String getFirstWeek()
	{
		return firstWeek;
	}

	/**
	 * This method sets the first week for the planning.
	 * 
	 * @param firstWeek
	 *            the firstWeek to set
	 */
	public void setFirstWeek(String firstWeek)
	{
		this.firstWeek = firstWeek;
	}

	/**
	 * This method retrieves the second week for the planning.
	 * 
	 * @return the secondWeek
	 */
	public String getSecondWeek()
	{
		return secondWeek;
	}

	/**
	 * This method sets the second week for the planning.
	 * 
	 * @param secondWeek
	 *            the secondWeek to set
	 */
	public void setSecondWeek(String secondWeek)
	{
		this.secondWeek = secondWeek;
	}

	/**
	 * This method retrieves the managed status for a planning.
	 * 
	 * @return the managed
	 */
	public String getManaged()
	{
		return managed;
	}

	/**
	 * This method sets the managed status for a planning.
	 * 
	 * @param managed
	 *            the managed to set
	 */
	public void setManaged(String managed)
	{
		this.managed = managed;
	}
}
