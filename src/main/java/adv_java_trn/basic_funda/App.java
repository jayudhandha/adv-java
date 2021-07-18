package adv_java_trn.basic_funda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import adv_java_trn.basic_funda.utils.DBUtils;

public class App {
	
	public static void main(String[] args) throws SQLException  {
		Connection connection = null;
		try {
			
			connection = DBUtils.getConnection();
			
			if (connection != null) {
				
				Map<String, Object> hmStd = new LinkedHashMap<>();
				
				hmStd.put("name", "Jayesh");
				hmStd.put("email", "test@gmail.com");
				hmStd.put("rollNo", 8);
				
				
				int updatedRows = DBUtils.createOrUpdateEntry(connection, DBUtils.CREATE_QUERY, hmStd);
				
				if (updatedRows > 0) {
					System.out.println("Insertion successfull");
				}
				
				ResultSet readEntries = DBUtils.readEntries(connection, DBUtils.READ_QUERY);
				
				while (readEntries.next()) { 
					System.out.println("Name: "+readEntries.getString("name"));
					System.out.println("Email: "+readEntries.getString("email"));
					System.out.println("RollNo: "+readEntries.getInt("rollNo"));
					System.out.println("--------------");
				}
				
			} else {
				System.out.println("Please check database credentials and try again");
			}
			
		} catch (Exception e) {
			System.err.println("Error while connecting db!!");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		

	}
	
	

}


// Code reusable

// Common methods for all db operations



