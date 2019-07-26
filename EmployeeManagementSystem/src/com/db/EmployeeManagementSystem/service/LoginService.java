package com.db.EmployeeManagementSystem.service;
import com.db.EmployeeManagementSystem.bean.LoginBean;

public interface LoginService {
	// validate the data with the database
	public boolean authenticate(LoginBean login);
}
