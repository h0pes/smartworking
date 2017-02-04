/**
 * This class manages all the inquiries
 * made to the backend database through
 * different types of CRUD operations for
 * the planning objects.
 * 
 * @version: v.1.0 - 17 apr 2016 12:58:56 
 * @author: Marco Canavese
 */
package com.kirth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.kirth.model.Planning;
import com.kirth.util.DateUtil;

public class SavePlanningAction
{

	/**
	 * This method save an instance of a Planning object into the backend system.
	 * 
	 * @param planning
	 *            an instance of Planning class
	 * @return an int representing the number of planning items saved
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int save(Planning planning) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException
	{
		// code to insert made planning into the database
		Connection conn = LoginDao.getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO users_planning (userId, requestDate, day1, day2, day3, day4, day5, "
				+ "day6, day7, day8, day9, day10, status, "
				+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
				+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
				+ "planningWeek, firstWeek, secondWeek)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		String requestDate = df.format(now);
		System.out.println("Requested date is: " + requestDate);

		String status = "requested";

		try
		{
			ps = conn.prepareStatement(query);
			ps.setString(1, planning.getUserId());
			ps.setDate(2, new java.sql.Date(now.getTime()));
			if (planning.getMondayFirstWeek() != null)
			{
				ps.setDate(3, new java.sql.Date(planning.getMondayFirstWeek().getTime()));
			} else
			{
				ps.setNull(3, java.sql.Types.DATE);
			}

			if (planning.getTuesdayFirstWeek() != null)
			{
				ps.setDate(4, new java.sql.Date(planning.getTuesdayFirstWeek().getTime()));
			} else
			{
				ps.setNull(4, java.sql.Types.DATE);
			}

			if (planning.getWednesdayFirstWeek() != null)
			{
				ps.setDate(5, new java.sql.Date(planning.getWednesdayFirstWeek().getTime()));
			} else
			{
				ps.setNull(5, java.sql.Types.DATE);
			}

			if (planning.getThursdayFirstWeek() != null)
			{
				ps.setDate(6, new java.sql.Date(planning.getThursdayFirstWeek().getTime()));
			} else
			{
				ps.setNull(6, java.sql.Types.DATE);
			}

			if (planning.getFridayFirstWeek() != null)
			{
				ps.setDate(7, new java.sql.Date(planning.getFridayFirstWeek().getTime()));
			} else
			{
				ps.setNull(7, java.sql.Types.DATE);
			}

			if (planning.getMondaySecondWeek() != null)
			{
				ps.setDate(8, new java.sql.Date(planning.getMondaySecondWeek().getTime()));
			} else
			{
				ps.setNull(8, java.sql.Types.DATE);
			}

			if (planning.getTuesdaySecondWeek() != null)
			{
				ps.setDate(9, new java.sql.Date(planning.getTuesdaySecondWeek().getTime()));
			} else
			{
				ps.setNull(9, java.sql.Types.DATE);
			}

			if (planning.getWednesdaySecondWeek() != null)
			{
				ps.setDate(10, new java.sql.Date(planning.getWednesdaySecondWeek().getTime()));
			} else
			{
				ps.setNull(10, java.sql.Types.DATE);
			}

			if (planning.getThursdaySecondWeek() != null)
			{
				ps.setDate(11, new java.sql.Date(planning.getThursdaySecondWeek().getTime()));
			} else
			{
				ps.setNull(11, java.sql.Types.DATE);
			}

			if (planning.getFridaySecondWeek() != null)
			{
				ps.setDate(12, new java.sql.Date(planning.getFridaySecondWeek().getTime()));
			} else
			{
				ps.setNull(12, java.sql.Types.DATE);
			}

			ps.setString(13, status);

			if (planning.getNotesMondayFirstWeek() != null)
			{
				ps.setString(14, planning.getNotesMondayFirstWeek());
			} else
			{
				ps.setNull(14, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesTuesdayFirstWeek() != null)
			{
				ps.setString(15, planning.getNotesTuesdayFirstWeek());
			} else
			{
				ps.setNull(15, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesWednesdayFirstWeek() != null)
			{
				ps.setString(16, planning.getNotesWednesdayFirstWeek());
			} else
			{
				ps.setNull(16, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesThursdayFirstWeek() != null)
			{
				ps.setString(17, planning.getNotesThursdayFirstWeek());
			} else
			{
				ps.setNull(17, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesFridayFirstWeek() != null)
			{
				ps.setString(18, planning.getNotesFridayFirstWeek());
			} else
			{
				ps.setNull(18, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesMondaySecondWeek() != null)
			{
				ps.setString(19, planning.getNotesMondaySecondWeek());
			} else
			{
				ps.setNull(19, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesTuesdaySecondWeek() != null)
			{
				ps.setString(20, planning.getNotesTuesdaySecondWeek());
			} else
			{
				ps.setNull(20, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesWednesdaySecondWeek() != null)
			{
				ps.setString(21, planning.getNotesWednesdaySecondWeek());
			} else
			{
				ps.setNull(21, java.sql.Types.VARCHAR);
			}
			if (planning.getNotesThursdaySecondWeek() != null)
			{
				ps.setString(22, planning.getNotesThursdaySecondWeek());
			} else
			{
				ps.setNull(22, java.sql.Types.VARCHAR);
			}

			if (planning.getNotesFridaySecondWeek() != null)
			{
				ps.setString(23, planning.getNotesFridaySecondWeek());
			} else
			{
				ps.setNull(23, java.sql.Types.VARCHAR);
			}

			if (planning.getPlanningWeek() != 0)
			{
				ps.setInt(24, planning.getPlanningWeek());
			} else
			{
				ps.setInt(24, 0);
			}

			if (planning.getFirstWeek() != 0)
			{
				ps.setInt(25, planning.getFirstWeek());
			} else
			{
				ps.setInt(25, 0);
			}

			if (planning.getSecondWeek() != 0)
			{
				ps.setInt(26, planning.getSecondWeek());
			} else
			{
				ps.setInt(26, 0);
			}

			return ps.executeUpdate();
		} catch (SQLException e)
		{
			System.out.println(e);
			return 0;
		}

	}

	/**
	 * This method reads the backend database looking for existing planning records.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return true if given planning exist false otherwise
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean read(Planning planning) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException
	{
		// implement code to retrieve planning records
		Connection conn = LoginDao.getConnection();
		boolean planningExists = false;

		String strRead = "SELECT userId, requestDate, day1, day2, day3, day4, day5, "
				+ "day6, day7, day8, day9, day10, status, "
				+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
				+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
				+ "planningWeek, firstWeek, secondWeek FROM users_planning"
				+ " WHERE userId = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

		PreparedStatement pst = conn.prepareStatement(strRead);

		pst.setString(1, planning.getUserId());
		pst.setInt(2, planning.getPlanningWeek());
		pst.setInt(3, planning.getFirstWeek());
		pst.setInt(4, planning.getSecondWeek());

		System.out.println("Same parameters inside query are: " + planning.getUserId() + "-"
				+ planning.getPlanningWeek() + "-" + "-" + planning.getFirstWeek() + "-"
				+ planning.getSecondWeek());

		ResultSet rs = pst.executeQuery();

		if (rs.next())
		{
			System.out.println("The recordset CONTAINS records");
			planningExists = true;
		} else
		{
			System.out.println("The recordset IS empty");
		}
		return planningExists;
	}

	/**
	 * This method reads the backend system looking for multiple existing planning items.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return true if such planning exist false otherwise
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean readAll(Planning planning) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException
	{
		// implement code to retrieve planning records
		Connection conn = LoginDao.getConnection();
		boolean planningExists = false;

		String strRead = "SELECT userId, requestDate, day1, day2, day3, day4, day5, "
				+ "day6, day7, day8, day9, day10, status, "
				+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
				+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
				+ "planningWeek, firstWeek, secondWeek FROM users_planning"
				+ " WHERE planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

		PreparedStatement pst = conn.prepareStatement(strRead);

		pst.setInt(1, planning.getPlanningWeek());
		pst.setInt(2, planning.getFirstWeek());
		pst.setInt(3, planning.getSecondWeek());

		System.out.println("Same parameters inside query are: " + planning.getPlanningWeek() + "-"
				+ planning.getFirstWeek() + "-" + planning.getSecondWeek());

		ResultSet rs = pst.executeQuery();

		if (rs.next())
		{
			System.out.println("The recordset CONTAINS records");
			planningExists = true;
		} else
		{
			System.out.println("The recordset IS empty");
		}
		return planningExists;
	}

	/**
	 * This method reads the backend system looking for planning with a given status.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return true if such planning exist false otherwise
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean readWithStatus(Planning planning) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// implement code to retrieve planning records
		Connection conn = LoginDao.getConnection();
		boolean planningExists = false;

		String strRead = "SELECT userId, requestDate, day1, day2, day3, day4, day5, "
				+ "day6, day7, day8, day9, day10, status, "
				+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
				+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
				+ "planningWeek, firstWeek, secondWeek FROM users_planning"
				+ " WHERE userId = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ? AND status = ?";

		PreparedStatement pst = conn.prepareStatement(strRead);

		String status = "requested";
		pst.setString(1, planning.getUserId());
		pst.setInt(2, planning.getPlanningWeek());
		pst.setInt(3, planning.getFirstWeek());
		pst.setInt(4, planning.getSecondWeek());
		pst.setString(5, status);

		System.out.println("Same parameters inside query of readWithStatus method are: "
				+ planning.getUserId() + "-" + planning.getPlanningWeek() + "-"
				+ planning.getFirstWeek() + "-" + planning.getSecondWeek() + "-" + status);

		ResultSet rs = pst.executeQuery();

		if (rs.next())
		{
			System.out.println("The recordset CONTAINS records");
			planningExists = true;
		} else
		{
			System.out.println("The recordset IS empty");
		}
		return planningExists;

	}

	/**
	 * This method updates an existing planning object into the database.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return the number of planning items updated
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int update(Planning planning) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException
	{
		// implement code to update planning records
		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strUpdate = "UPDATE users_planning SET status = ? "
				+ " WHERE userId = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

		pst = conn.prepareStatement(strUpdate);

		pst.setString(1, planning.getStatus());
		pst.setString(2, planning.getUserId());
		pst.setInt(3, planning.getPlanningWeek());
		pst.setInt(4, planning.getFirstWeek());
		pst.setInt(5, planning.getSecondWeek());

		ResultSet rs = pst.executeQuery();

		while (rs.next())
		{
			// add logic
		}
		return pst.executeUpdate();
	}

	/**
	 * This method updates existing planning items setting their status to approved and managed to
	 * true.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return the number of planning items updated
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updateApproveAll(Planning planning) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// implement code to update planning records
		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strUpdate = "UPDATE users_planning SET status = ?, managed = ? "
				+ " WHERE planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

		pst = conn.prepareStatement(strUpdate);

		pst.setString(1, "approved");
		pst.setString(2, "true");
		pst.setInt(3, DateUtil.getCurrentWeek());
		pst.setInt(4, DateUtil.getFirstWeek());
		pst.setInt(5, DateUtil.getSecondWeek());

		return pst.executeUpdate();
	}

	/**
	 * This method updates an existing planning id.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return the number of updated planning items
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updateApproveReqId(Planning planning) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// implement code to update planning records
		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strUpdate = "UPDATE users_planning SET status = ?, managed = ? "
				+ " WHERE idusers_planning = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ? ";

		pst = conn.prepareStatement(strUpdate);

		pst.setString(1, "approved");
		pst.setString(2, "true");
		pst.setInt(3, planning.getPlanningId());
		pst.setInt(4, DateUtil.getCurrentWeek());
		pst.setInt(5, DateUtil.getFirstWeek());
		pst.setInt(6, DateUtil.getSecondWeek());

		return pst.executeUpdate();
	}

	public int updateRejectAll(Planning planning) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// implement code to update planning records
		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strUpdate = "UPDATE users_planning SET status = ?, managed = ? "
				+ " WHERE planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

		pst = conn.prepareStatement(strUpdate);

		pst.setString(1, "rejected");
		pst.setString(2, "true");
		pst.setInt(3, DateUtil.getCurrentWeek());
		pst.setInt(4, DateUtil.getFirstWeek());
		pst.setInt(5, DateUtil.getSecondWeek());

		return pst.executeUpdate();
	}

	/**
	 * This method updates existing planning items setting their status to rejected and managed to
	 * true.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return the number of updated planning items
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updateRejectReqId(Planning planning) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// implement code to update planning records
		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strUpdate = "UPDATE users_planning SET status = ?, managed = ? "
				+ " WHERE idusers_planning = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ? ";

		pst = conn.prepareStatement(strUpdate);

		pst.setString(1, "rejected");
		pst.setString(2, "true");
		pst.setInt(3, planning.getPlanningId());
		pst.setInt(4, DateUtil.getCurrentWeek());
		pst.setInt(5, DateUtil.getFirstWeek());
		pst.setInt(6, DateUtil.getSecondWeek());

		return pst.executeUpdate();
	}

	/**
	 * This method updates planning items according to end user request.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return the number of the updated items
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int updatePlanningRequest(Planning planning) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// implement code to update planning records
		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strUpdate = "UPDATE users_planning SET status = ?, managed = ? , day1 = ?, day2 = ?, day3 = ?, day4 = ?, day5 = ?,"
				+ " day6 = ?, day7 = ?, day8 = ?, day9 = ?, day10 = ?, notesday1 = ?, notesday2 = ?, notesday3 = ?, notesday4 = ?, notesday5 = ?,"
				+ " notesday6 = ?, notesday7 = ?, notesday8 = ?, notesday9 = ?, notesday10 = ?, requestDate = ? "
				+ " WHERE planningWeek = ? AND firstWeek = ? AND secondWeek = ? AND userId = ? ";

		pst = conn.prepareStatement(strUpdate);

		Date now = new Date();
		pst.setString(1, "requested");
		pst.setString(2, "false");
		if (planning.getMondayFirstWeek() != null)
		{
			pst.setDate(3, new java.sql.Date(planning.getMondayFirstWeek().getTime()));
		} else
		{
			pst.setNull(3, java.sql.Types.DATE);
		}

		if (planning.getTuesdayFirstWeek() != null)
		{
			pst.setDate(4, new java.sql.Date(planning.getTuesdayFirstWeek().getTime()));
		} else
		{
			pst.setNull(4, java.sql.Types.DATE);
		}

		if (planning.getWednesdayFirstWeek() != null)
		{
			pst.setDate(5, new java.sql.Date(planning.getWednesdayFirstWeek().getTime()));
		} else
		{
			pst.setNull(5, java.sql.Types.DATE);
		}

		if (planning.getThursdayFirstWeek() != null)
		{
			pst.setDate(6, new java.sql.Date(planning.getThursdayFirstWeek().getTime()));
		} else
		{
			pst.setNull(6, java.sql.Types.DATE);
		}

		if (planning.getFridayFirstWeek() != null)
		{
			pst.setDate(7, new java.sql.Date(planning.getFridayFirstWeek().getTime()));
		} else
		{
			pst.setNull(7, java.sql.Types.DATE);
		}

		if (planning.getMondaySecondWeek() != null)
		{
			pst.setDate(8, new java.sql.Date(planning.getMondaySecondWeek().getTime()));
		} else
		{
			pst.setNull(8, java.sql.Types.DATE);
		}

		if (planning.getTuesdaySecondWeek() != null)
		{
			pst.setDate(9, new java.sql.Date(planning.getTuesdaySecondWeek().getTime()));
		} else
		{
			pst.setNull(9, java.sql.Types.DATE);
		}

		if (planning.getWednesdaySecondWeek() != null)
		{
			pst.setDate(10, new java.sql.Date(planning.getWednesdaySecondWeek().getTime()));
		} else
		{
			pst.setNull(10, java.sql.Types.DATE);
		}

		if (planning.getThursdaySecondWeek() != null)
		{
			pst.setDate(11, new java.sql.Date(planning.getThursdaySecondWeek().getTime()));
		} else
		{
			pst.setNull(11, java.sql.Types.DATE);
		}

		if (planning.getFridaySecondWeek() != null)
		{
			pst.setDate(12, new java.sql.Date(planning.getFridaySecondWeek().getTime()));
		} else
		{
			pst.setNull(12, java.sql.Types.DATE);
		}

		if (planning.getNotesMondayFirstWeek() != null)
		{
			pst.setString(13, planning.getNotesMondayFirstWeek());
		} else
		{
			pst.setNull(13, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesTuesdayFirstWeek() != null)
		{
			pst.setString(14, planning.getNotesTuesdayFirstWeek());
		} else
		{
			pst.setNull(14, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesWednesdayFirstWeek() != null)
		{
			pst.setString(15, planning.getNotesWednesdayFirstWeek());
		} else
		{
			pst.setNull(15, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesThursdayFirstWeek() != null)
		{
			pst.setString(16, planning.getNotesThursdayFirstWeek());
		} else
		{
			pst.setNull(16, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesFridayFirstWeek() != null)
		{
			pst.setString(17, planning.getNotesFridayFirstWeek());
		} else
		{
			pst.setNull(17, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesMondaySecondWeek() != null)
		{
			pst.setString(18, planning.getNotesMondaySecondWeek());
		} else
		{
			pst.setNull(18, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesTuesdaySecondWeek() != null)
		{
			pst.setString(19, planning.getNotesTuesdaySecondWeek());
		} else
		{
			pst.setNull(19, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesWednesdaySecondWeek() != null)
		{
			pst.setString(20, planning.getNotesWednesdaySecondWeek());
		} else
		{
			pst.setNull(20, java.sql.Types.VARCHAR);
		}
		if (planning.getNotesThursdaySecondWeek() != null)
		{
			pst.setString(21, planning.getNotesThursdaySecondWeek());
		} else
		{
			pst.setNull(21, java.sql.Types.VARCHAR);
		}

		if (planning.getNotesFridaySecondWeek() != null)
		{
			pst.setString(22, planning.getNotesFridaySecondWeek());
		} else
		{
			pst.setNull(22, java.sql.Types.VARCHAR);
		}

		pst.setDate(23, new java.sql.Date(now.getTime()));

		// pst.setInt(24, planning.getPlanningId());
		pst.setInt(24, planning.getPlanningWeek());
		pst.setInt(25, planning.getFirstWeek());
		pst.setInt(26, planning.getSecondWeek());

		pst.setString(27, planning.getUserId());

		System.out.println("DEBUG: planning content inside updatePlanningRequest method query");
		System.out.println(planning.getUserId() + "-" + planning.getFirstWeek() + "-"
				+ planning.getSecondWeek());

		int rowsAffected = pst.executeUpdate();
		System.out.println("DEBUG: - inside updatePlanningRequest method query - we have "
				+ rowsAffected + " rows that have been updated");
		return rowsAffected;
	}

	/**
	 * This method deletes an existing planning item from the backend database.
	 * 
	 * @param planning
	 *            an instance of the Planning class
	 * @return the number of the items being deleted
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int delete(Planning planning) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException
	{
		// implement code to delete planning records
		return 1;
	}

	/**
	 * This method checks whether the current week is enabled for planning or not.
	 * 
	 * @param currentWeek
	 *            the week to check
	 * @return true if the current week is enabled false otherwise
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean weekEnabledForPlanning(int currentWeek) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException
	{
		// add code to check whether the current week is enabled for planning or not
		boolean isEnabled = false;

		Connection conn = LoginDao.getConnection();
		PreparedStatement pst = null;

		String strRead = "SELECT * FROM planning_weeks WHERE weekNumber = ?";

		pst = conn.prepareStatement(strRead);

		pst.setInt(1, currentWeek);

		ResultSet rs = pst.executeQuery();

		while (rs.next())
		{
			String enabled = rs.getString(2);
			isEnabled = Boolean.parseBoolean(enabled);
			System.out.println("Current Week is enabled: " + enabled);
		}

		return isEnabled;
	}

	/**
	 * This method allows to retrieve a list of planning items.
	 * 
	 * @param id
	 *            the userid
	 * @param thisWeek
	 *            the current week
	 * @param weekOne
	 *            the first week
	 * @param weekTwo
	 *            the second week
	 * @return a List of planning items
	 */
	public ArrayList<Planning> getPlanning(String id, int thisWeek, int weekOne, int weekTwo)
	{
		try
		{
			Connection conn = LoginDao.getConnection();
			String strRead = "SELECT userId, requestDate, day1, day2, day3, day4, day5, "
					+ "day6, day7, day8, day9, day10, status, "
					+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
					+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
					+ "planningWeek, firstWeek, secondWeek, managed FROM users_planning"
					+ " WHERE userId = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

			PreparedStatement pst = conn.prepareStatement(strRead);

			pst.setString(1, id);
			pst.setInt(2, thisWeek);
			pst.setInt(3, weekOne);
			pst.setInt(4, weekTwo);

			System.out.println("Same parameters inside query are: " + id + "-" + thisWeek + "-"
					+ weekOne + "-" + weekTwo);

			ResultSet rs = pst.executeQuery();

			ArrayList<Planning> planningList = new ArrayList<Planning>();

			if (rs.next())
			{
				Planning planning = new Planning();

				planning.setUserId(rs.getString("userId"));
				planning.setRequestDate(rs.getDate("requestDate"));
				planning.setMondayFirstWeek(rs.getDate("day1"));
				planning.setTuesdayFirstWeek(rs.getDate("day2"));
				planning.setWednesdayFirstWeek(rs.getDate("day3"));
				planning.setThursdayFirstWeek(rs.getDate("day4"));
				planning.setFridayFirstWeek(rs.getDate("day5"));
				planning.setMondaySecondWeek(rs.getDate("day6"));
				planning.setTuesdaySecondWeek(rs.getDate("day7"));
				planning.setWednesdaySecondWeek(rs.getDate("day8"));
				planning.setThursdaySecondWeek(rs.getDate("day9"));
				planning.setFridaySecondWeek(rs.getDate("day10"));
				planning.setStatus(rs.getString("status"));
				planning.setNotesMondayFirstWeek(rs.getString("notesday1"));
				planning.setNotesTuesdayFirstWeek(rs.getString("notesday2"));
				planning.setNotesWednesdayFirstWeek(rs.getString("notesday3"));
				planning.setNotesThursdayFirstWeek(rs.getString("notesday4"));
				planning.setNotesFridayFirstWeek(rs.getString("notesday5"));
				planning.setNotesMondaySecondWeek(rs.getString("notesday6"));
				planning.setNotesTuesdaySecondWeek(rs.getString("notesday7"));
				planning.setNotesWednesdaySecondWeek(rs.getString("notesday8"));
				planning.setNotesThursdaySecondWeek(rs.getString("notesday9"));
				planning.setNotesFridaySecondWeek(rs.getString("notesday10"));
				planning.setPlanningWeek(rs.getInt("planningWeek"));
				planning.setFirstWeek(rs.getInt("firstWeek"));
				planning.setSecondWeek(rs.getInt("secondWeek"));
				planning.setManaged(rs.getString("managed"));

				planningList.add(planning);

				return planningList;
			}
		} catch (SQLException | InstantiationException | IllegalAccessException
				| ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method allows to retrieve a list of planning items with a given status.
	 * 
	 * @param id
	 *            the userid
	 * @param thisWeek
	 *            the current week
	 * @param weekOne
	 *            the first week
	 * @param weekTwo
	 *            the second week
	 * @param status
	 *            the status of the planning request
	 * @return a List of planning items
	 */
	public ArrayList<Planning> getPlanningWithStatus(String id, int thisWeek, int weekOne,
			int weekTwo, String status)
	{
		try
		{
			Connection conn = LoginDao.getConnection();
			String strRead = "SELECT userId, requestDate, day1, day2, day3, day4, day5, "
					+ "day6, day7, day8, day9, day10, status, "
					+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
					+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
					+ "planningWeek, firstWeek, secondWeek, managed FROM users_planning"
					+ " WHERE userId = ? AND planningWeek = ? AND firstWeek = ? AND secondWeek = ? AND status = ?";

			PreparedStatement pst = conn.prepareStatement(strRead);

			pst.setString(1, id);
			pst.setInt(2, thisWeek);
			pst.setInt(3, weekOne);
			pst.setInt(4, weekTwo);
			pst.setString(5, status);

			System.out.println("Same parameters inside query of getPlanningWithStatus method are: "
					+ id + "-" + thisWeek + "-" + weekOne + "-" + weekTwo + "-" + status);

			ResultSet rs = pst.executeQuery();

			ArrayList<Planning> planningList = new ArrayList<Planning>();
			int count = 0;

			while (rs.next())
			{
				count++;
				Planning planning = new Planning();

				planning.setUserId(rs.getString("userId"));
				planning.setRequestDate(rs.getDate("requestDate"));
				planning.setMondayFirstWeek(rs.getDate("day1"));
				planning.setTuesdayFirstWeek(rs.getDate("day2"));
				planning.setWednesdayFirstWeek(rs.getDate("day3"));
				planning.setThursdayFirstWeek(rs.getDate("day4"));
				planning.setFridayFirstWeek(rs.getDate("day5"));
				planning.setMondaySecondWeek(rs.getDate("day6"));
				planning.setTuesdaySecondWeek(rs.getDate("day7"));
				planning.setWednesdaySecondWeek(rs.getDate("day8"));
				planning.setThursdaySecondWeek(rs.getDate("day9"));
				planning.setFridaySecondWeek(rs.getDate("day10"));
				planning.setStatus(rs.getString("status"));
				planning.setNotesMondayFirstWeek(rs.getString("notesday1"));
				planning.setNotesTuesdayFirstWeek(rs.getString("notesday2"));
				planning.setNotesWednesdayFirstWeek(rs.getString("notesday3"));
				planning.setNotesThursdayFirstWeek(rs.getString("notesday4"));
				planning.setNotesFridayFirstWeek(rs.getString("notesday5"));
				planning.setNotesMondaySecondWeek(rs.getString("notesday6"));
				planning.setNotesTuesdaySecondWeek(rs.getString("notesday7"));
				planning.setNotesWednesdaySecondWeek(rs.getString("notesday8"));
				planning.setNotesThursdaySecondWeek(rs.getString("notesday9"));
				planning.setNotesFridaySecondWeek(rs.getString("notesday10"));
				planning.setPlanningWeek(rs.getInt("planningWeek"));
				planning.setFirstWeek(rs.getInt("firstWeek"));
				planning.setSecondWeek(rs.getInt("secondWeek"));
				planning.setManaged(rs.getString("managed"));

				planningList.add(planning);

			}
			System.out.println(
					"Total number of rows with counter inside result set loop within query are: "
							+ count);
			return planningList;
		} catch (SQLException | InstantiationException | IllegalAccessException
				| ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * This method allows to retrieve a list of all the planning items in the database.
	 * 
	 * @param thisWeek
	 *            the current week
	 * @param weekOne
	 *            the first week
	 * @param weekTwo
	 *            the second week
	 * @return a List of all the planning items
	 */
	public ArrayList<Planning> getAllPlanning(int thisWeek, int weekOne, int weekTwo)
	{
		try
		{
			Connection conn = LoginDao.getConnection();
			String strRead = "SELECT userId, requestDate, day1, day2, day3, day4, day5, "
					+ "day6, day7, day8, day9, day10, status, "
					+ "notesday1, notesday2, notesday3, notesday4, notesday5, "
					+ "notesday6, notesday7, notesday8, notesday9, notesday10, "
					+ "planningWeek, firstWeek, secondWeek, managed FROM users_planning"
					+ " WHERE planningWeek = ? AND firstWeek = ? AND secondWeek = ?";

			PreparedStatement pst = conn.prepareStatement(strRead);

			pst.setInt(1, thisWeek);
			pst.setInt(2, weekOne);
			pst.setInt(3, weekTwo);

			System.out.println("Same parameters inside query are: " + thisWeek + "-" + weekOne + "-"
					+ weekTwo);

			ResultSet rs = pst.executeQuery();

			ArrayList<Planning> planningList = new ArrayList<Planning>();
			int count = 0;
			while (rs.next())
			{
				count++;
				Planning planning = new Planning();

				planning.setUserId(rs.getString("userId"));
				planning.setRequestDate(rs.getDate("requestDate"));
				planning.setMondayFirstWeek(rs.getDate("day1"));
				planning.setTuesdayFirstWeek(rs.getDate("day2"));
				planning.setWednesdayFirstWeek(rs.getDate("day3"));
				planning.setThursdayFirstWeek(rs.getDate("day4"));
				planning.setFridayFirstWeek(rs.getDate("day5"));
				planning.setMondaySecondWeek(rs.getDate("day6"));
				planning.setTuesdaySecondWeek(rs.getDate("day7"));
				planning.setWednesdaySecondWeek(rs.getDate("day8"));
				planning.setThursdaySecondWeek(rs.getDate("day9"));
				planning.setFridaySecondWeek(rs.getDate("day10"));
				planning.setStatus(rs.getString("status"));
				planning.setNotesMondayFirstWeek(rs.getString("notesday1"));
				planning.setNotesTuesdayFirstWeek(rs.getString("notesday2"));
				planning.setNotesWednesdayFirstWeek(rs.getString("notesday3"));
				planning.setNotesThursdayFirstWeek(rs.getString("notesday4"));
				planning.setNotesFridayFirstWeek(rs.getString("notesday5"));
				planning.setNotesMondaySecondWeek(rs.getString("notesday6"));
				planning.setNotesTuesdaySecondWeek(rs.getString("notesday7"));
				planning.setNotesWednesdaySecondWeek(rs.getString("notesday8"));
				planning.setNotesThursdaySecondWeek(rs.getString("notesday9"));
				planning.setNotesFridaySecondWeek(rs.getString("notesday10"));
				planning.setPlanningWeek(rs.getInt("planningWeek"));
				planning.setFirstWeek(rs.getInt("firstWeek"));
				planning.setSecondWeek(rs.getInt("secondWeek"));
				planning.setManaged(rs.getString("managed"));

				planningList.add(planning);

				// debug planning List content..
				// for (Planning plan : planningList)
				// {
				// System.out.println("How many userId we got INSIDE query?...: " +
				// plan.getUserId());
				// }

			}
			System.out.println(
					"Total number of rows with counter inside result set loop within query are: "
							+ count);
			return planningList;

		} catch (SQLException | InstantiationException | IllegalAccessException
				| ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
