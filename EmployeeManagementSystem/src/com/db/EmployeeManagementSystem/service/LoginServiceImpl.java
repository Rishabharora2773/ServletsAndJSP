package com.db.EmployeeManagementSystem.service;
import com.db.EmployeeManagementSystem.bean.LoginBean;
import com.db.EmployeeManagementSystem.dao.LoginDAO;
import com.db.EmployeeManagementSystem.dao.LoginDAOImpl;

public class LoginServiceImpl implements LoginService {
	
	LoginDAO loginDAO = new LoginDAOImpl();
	
	public boolean authenticate(LoginBean login) {
		// TODO Auto-generated method stub
		return loginDAO.authenticate(login);
	}

}
