/**
 * This class is used to create and manage Requests
 * objects
 * 
 * @version: v.1.0 - 30 apr 2016 19:20:02 
 * @author:  Marco Canavese
 */
package com.kirth.model;

import java.io.Serializable;
import java.util.Date;

public class Requests implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int planningId;
	private String userId;
	
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
	 * @return the planningId
	 */
	public int getPlanningId() {
		return planningId;
	}
	/**
	 * @param planningId the planningId to set
	 */
	public void setPlanningId(int planningId) {
		this.planningId = planningId;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the requestDate
	 */
	public Date getRequestDate() {
		return requestDate;
	}
	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * @return the mondayFirstWeek
	 */
	public Date getMondayFirstWeek() {
		return mondayFirstWeek;
	}
	/**
	 * @param mondayFirstWeek the mondayFirstWeek to set
	 */
	public void setMondayFirstWeek(Date mondayFirstWeek) {
		this.mondayFirstWeek = mondayFirstWeek;
	}
	/**
	 * @return the tuesdayFirstWeek
	 */
	public Date getTuesdayFirstWeek() {
		return tuesdayFirstWeek;
	}
	/**
	 * @param tuesdayFirstWeek the tuesdayFirstWeek to set
	 */
	public void setTuesdayFirstWeek(Date tuesdayFirstWeek) {
		this.tuesdayFirstWeek = tuesdayFirstWeek;
	}
	/**
	 * @return the wednesdayFirstWeek
	 */
	public Date getWednesdayFirstWeek() {
		return wednesdayFirstWeek;
	}
	/**
	 * @param wednesdayFirstWeek the wednesdayFirstWeek to set
	 */
	public void setWednesdayFirstWeek(Date wednesdayFirstWeek) {
		this.wednesdayFirstWeek = wednesdayFirstWeek;
	}
	/**
	 * @return the thursdayFirstWeek
	 */
	public Date getThursdayFirstWeek() {
		return thursdayFirstWeek;
	}
	/**
	 * @param thursdayFirstWeek the thursdayFirstWeek to set
	 */
	public void setThursdayFirstWeek(Date thursdayFirstWeek) {
		this.thursdayFirstWeek = thursdayFirstWeek;
	}
	/**
	 * @return the fridayFirstWeek
	 */
	public Date getFridayFirstWeek() {
		return fridayFirstWeek;
	}
	/**
	 * @param fridayFirstWeek the fridayFirstWeek to set
	 */
	public void setFridayFirstWeek(Date fridayFirstWeek) {
		this.fridayFirstWeek = fridayFirstWeek;
	}
	/**
	 * @return the mondaySecondWeek
	 */
	public Date getMondaySecondWeek() {
		return mondaySecondWeek;
	}
	/**
	 * @param mondaySecondWeek the mondaySecondWeek to set
	 */
	public void setMondaySecondWeek(Date mondaySecondWeek) {
		this.mondaySecondWeek = mondaySecondWeek;
	}
	/**
	 * @return the tuesdaySecondWeek
	 */
	public Date getTuesdaySecondWeek() {
		return tuesdaySecondWeek;
	}
	/**
	 * @param tuesdaySecondWeek the tuesdaySecondWeek to set
	 */
	public void setTuesdaySecondWeek(Date tuesdaySecondWeek) {
		this.tuesdaySecondWeek = tuesdaySecondWeek;
	}
	/**
	 * @return the wednesdaySecondWeek
	 */
	public Date getWednesdaySecondWeek() {
		return wednesdaySecondWeek;
	}
	/**
	 * @param wednesdaySecondWeek the wednesdaySecondWeek to set
	 */
	public void setWednesdaySecondWeek(Date wednesdaySecondWeek) {
		this.wednesdaySecondWeek = wednesdaySecondWeek;
	}
	/**
	 * @return the thursdaySecondWeek
	 */
	public Date getThursdaySecondWeek() {
		return thursdaySecondWeek;
	}
	/**
	 * @param thursdaySecondWeek the thursdaySecondWeek to set
	 */
	public void setThursdaySecondWeek(Date thursdaySecondWeek) {
		this.thursdaySecondWeek = thursdaySecondWeek;
	}
	/**
	 * @return the fridaySecondWeek
	 */
	public Date getFridaySecondWeek() {
		return fridaySecondWeek;
	}
	/**
	 * @param fridaySecondWeek the fridaySecondWeek to set
	 */
	public void setFridaySecondWeek(Date fridaySecondWeek) {
		this.fridaySecondWeek = fridaySecondWeek;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the notesMondayFirstWeek
	 */
	public String getNotesMondayFirstWeek() {
		return notesMondayFirstWeek;
	}
	/**
	 * @param notesMondayFirstWeek the notesMondayFirstWeek to set
	 */
	public void setNotesMondayFirstWeek(String notesMondayFirstWeek) {
		this.notesMondayFirstWeek = notesMondayFirstWeek;
	}
	/**
	 * @return the notesTuesdayFirstWeek
	 */
	public String getNotesTuesdayFirstWeek() {
		return notesTuesdayFirstWeek;
	}
	/**
	 * @param notesTuesdayFirstWeek the notesTuesdayFirstWeek to set
	 */
	public void setNotesTuesdayFirstWeek(String notesTuesdayFirstWeek) {
		this.notesTuesdayFirstWeek = notesTuesdayFirstWeek;
	}
	/**
	 * @return the notesWednesdayFirstWeek
	 */
	public String getNotesWednesdayFirstWeek() {
		return notesWednesdayFirstWeek;
	}
	/**
	 * @param notesWednesdayFirstWeek the notesWednesdayFirstWeek to set
	 */
	public void setNotesWednesdayFirstWeek(String notesWednesdayFirstWeek) {
		this.notesWednesdayFirstWeek = notesWednesdayFirstWeek;
	}
	/**
	 * @return the notesThursdayFirstWeek
	 */
	public String getNotesThursdayFirstWeek() {
		return notesThursdayFirstWeek;
	}
	/**
	 * @param notesThursdayFirstWeek the notesThursdayFirstWeek to set
	 */
	public void setNotesThursdayFirstWeek(String notesThursdayFirstWeek) {
		this.notesThursdayFirstWeek = notesThursdayFirstWeek;
	}
	/**
	 * @return the notesFridayFirstWeek
	 */
	public String getNotesFridayFirstWeek() {
		return notesFridayFirstWeek;
	}
	/**
	 * @param notesFridayFirstWeek the notesFridayFirstWeek to set
	 */
	public void setNotesFridayFirstWeek(String notesFridayFirstWeek) {
		this.notesFridayFirstWeek = notesFridayFirstWeek;
	}
	/**
	 * @return the notesMondaySecondWeek
	 */
	public String getNotesMondaySecondWeek() {
		return notesMondaySecondWeek;
	}
	/**
	 * @param notesMondaySecondWeek the notesMondaySecondWeek to set
	 */
	public void setNotesMondaySecondWeek(String notesMondaySecondWeek) {
		this.notesMondaySecondWeek = notesMondaySecondWeek;
	}
	/**
	 * @return the notesTuesdaySecondWeek
	 */
	public String getNotesTuesdaySecondWeek() {
		return notesTuesdaySecondWeek;
	}
	/**
	 * @param notesTuesdaySecondWeek the notesTuesdaySecondWeek to set
	 */
	public void setNotesTuesdaySecondWeek(String notesTuesdaySecondWeek) {
		this.notesTuesdaySecondWeek = notesTuesdaySecondWeek;
	}
	/**
	 * @return the notesWednesdaySecondWeek
	 */
	public String getNotesWednesdaySecondWeek() {
		return notesWednesdaySecondWeek;
	}
	/**
	 * @param notesWednesdaySecondWeek the notesWednesdaySecondWeek to set
	 */
	public void setNotesWednesdaySecondWeek(String notesWednesdaySecondWeek) {
		this.notesWednesdaySecondWeek = notesWednesdaySecondWeek;
	}
	/**
	 * @return the notesThursdaySecondWeek
	 */
	public String getNotesThursdaySecondWeek() {
		return notesThursdaySecondWeek;
	}
	/**
	 * @param notesThursdaySecondWeek the notesThursdaySecondWeek to set
	 */
	public void setNotesThursdaySecondWeek(String notesThursdaySecondWeek) {
		this.notesThursdaySecondWeek = notesThursdaySecondWeek;
	}
	/**
	 * @return the notesFridaySecondWeek
	 */
	public String getNotesFridaySecondWeek() {
		return notesFridaySecondWeek;
	}
	/**
	 * @param notesFridaySecondWeek the notesFridaySecondWeek to set
	 */
	public void setNotesFridaySecondWeek(String notesFridaySecondWeek) {
		this.notesFridaySecondWeek = notesFridaySecondWeek;
	}
	/**
	 * @return the planningWeek
	 */
	public int getPlanningWeek() {
		return planningWeek;
	}
	/**
	 * @param planningWeek the planningWeek to set
	 */
	public void setPlanningWeek(int planningWeek) {
		this.planningWeek = planningWeek;
	}
	/**
	 * @return the firstWeek
	 */
	public int getFirstWeek() {
		return firstWeek;
	}
	/**
	 * @param firstWeek the firstWeek to set
	 */
	public void setFirstWeek(int firstWeek) {
		this.firstWeek = firstWeek;
	}
	/**
	 * @return the secondWeek
	 */
	public int getSecondWeek() {
		return secondWeek;
	}
	/**
	 * @param secondWeek the secondWeek to set
	 */
	public void setSecondWeek(int secondWeek) {
		this.secondWeek = secondWeek;
	}
	/**
	 * @return the managed
	 */
	public String getManaged() {
		return managed;
	}
	/**
	 * @param managed the managed to set
	 */
	public void setManaged(String managed) {
		this.managed = managed;
	}


}
