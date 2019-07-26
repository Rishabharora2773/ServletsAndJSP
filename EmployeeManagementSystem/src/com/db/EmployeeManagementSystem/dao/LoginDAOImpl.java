package com.db.EmployeeManagementSystem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.db.EmployeeManagementSystem.bean.LoginBean;
import com.db.EmployeeManagementSystem.util.DBUtil;

public class LoginDAOImpl implements LoginDAO{

	public boolean authenticate(LoginBean login) {
		String query = "Select * from login_table where username=? and password=?";
		// Now we need to take statement or prepared statement or callable
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DBUtil.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			// preparedStatement.setXXX(index of ? >=1, value), where XXX is the data type of '?' in query string
			preparedStatement.setString(1, login.getUserName());
			preparedStatement.setString(2, login.getPassWord());
			
			// Now 3 methods to execute the above SQL query
			// 1. executeQuery()    		-- USED in DQL(DATA QUERY LANGUAGE)
			// 2. executeUpdate()			-- USED in DML(DATA MANIPULATION LANGUAGE)
			// 3. execute()					-- USED in DDL(DATA DEFINITION LANGUAGE)
			
			resultSet = preparedStatement.executeQuery();
			
			// resultSet will have either 0 rows or max 1 rows as the username is unique
			
			if(resultSet.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			DBUtil.closeConnection(connection);
		}
		return false;
	}
}
