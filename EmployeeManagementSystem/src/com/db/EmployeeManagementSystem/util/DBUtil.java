package com.db.EmployeeManagementSystem.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public final static String USER_NAME = "root";
	public final static String PASSWORD = "root";
	public final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public final static String URI = "jdbc:mysql://localhost:3306/sample";	// Used to connect to our database
									  // protocol::sub-protocol:localhost
	
	// Steps to get connection to the database
	// 1. Load the driver class
	// 2. Get the connection from getConnection() of driver manager class
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(URI, USER_NAME, PASSWORD);
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
