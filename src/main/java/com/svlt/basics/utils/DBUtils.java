package com.svlt.basics.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class DBUtils {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/mu_students";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "KodFactory@123";

	public static final String CREATE_QUERY = "insert into students (name, email, rollNo) values (?, ?, ?)";
	public static final String READ_QUERY = "select * from students";
	public static final String READ_SPECIFIC_STD_QUERY = "select * from students where rollNo = ?";
	
	// get connection
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			return connection;
		
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error while getting db connection : " + e);
		}

		return null;

	}

	// create entry
	public static int createOrUpdateEntry(Connection connection, final String sql, Map<String, Object> params) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		int index = 1;
		for(String key: params.keySet()) {
			Object value = params.get(key);
			
			if (value instanceof String) {
				prepareStatement.setString(index, (String) value);
			} else if (value instanceof Integer) {
				prepareStatement.setInt(index, (int) value);
			}
			index++;
		}

		return prepareStatement.executeUpdate();
					
	}
	

	// read entry
	public static ResultSet readEntries(Connection connection, final String sql, Map<String, Object> params) throws SQLException {
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		int index = 1;
		for(String key: params.keySet()) {
			Object value = params.get(key);
			
			if (value instanceof String) {
				prepareStatement.setString(index, (String) value);
			} else if (value instanceof Integer) {
				prepareStatement.setInt(index, (int) value);
			}
			index++;
		}
		
		return prepareStatement.executeQuery();
	}

	// update entry

	// delete entry
}
