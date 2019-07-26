package com.db.EmployeeManagementSystem.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.db.EmployeeManagementSystem.bean.LoginBean;

class LoginServiceImplTest {
	
	private static LoginServiceImpl loginServiceImpl = null;
	private static LoginBean login = null;
	
	@BeforeAll
	public static void init() {
		loginServiceImpl = new LoginServiceImpl();
		login = new LoginBean("admin","root");
	}
	
	@Test
	void testAuthenticate() {
		Assertions.assertEquals(true, loginServiceImpl.authenticate(login), "Expected should be true");
	}

}
