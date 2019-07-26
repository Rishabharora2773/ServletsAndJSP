package com.db.EmployeeManagementSystem.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.EmployeeManagementSystem.bean.LoginBean;
import com.db.EmployeeManagementSystem.service.LoginService;
import com.db.EmployeeManagementSystem.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		System.out.println(userName);
		System.out.println(passWord);
		
		// 2 methods to forward requests
		// request: dispatchers forward -- doesn't changes the address bar after 
		// response: send redirect  --  changes the address bar 
		RequestDispatcher dispatcher = null;
		LoginService loginService = new LoginServiceImpl();
		LoginBean login = new LoginBean(userName,passWord);
		
		if(loginService.authenticate(login)){
			// He is an admin
			dispatcher = request.getRequestDispatcher("adminHomePage.html");
			dispatcher.forward(request, response);
			//response.sendRedirect("adminHomePage.html");
		}
		else{
			response.sendRedirect("login.html");
		}
	}

}
