package com.sagarsoft.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sagarsoft.common.DBConnection;

public class ChangePasswordService extends HttpServlet{
	public Connection connection;
	//SuperAdminService superAdminService;
	public void init() throws ServletException{
		connection=DBConnection.getCon();
		//superAdminService = new SuperAdminService();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String emailId = req.getParameter("username");
		String newPassword = req.getParameter("newPassword");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("update user_details set password=? where emailId=?");
			 preparedStatement.setString(1,newPassword);
			 preparedStatement.setString(2,emailId);
			 int k = preparedStatement.executeUpdate();
				if(k>=0) {
					pw.print("Password updated");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
					requestDispatcher.forward(req, res);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
