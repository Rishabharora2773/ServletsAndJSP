package com.db.EmployeeManagementSystem.dao;
import com.db.EmployeeManagementSystem.bean.LoginBean;

// Main use of interface is setting up the contracts and then we implement those contracts
// using interface

public interface LoginDAO {
	public boolean authenticate(LoginBean login);
}