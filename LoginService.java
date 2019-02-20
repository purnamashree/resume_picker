package com.sagarsoft.service;
import com.sagarsoft.common.DBConnection;

import com.sagarsoft.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginService extends HttpServlet{
	
	public Connection connection;
	SuperAdminService superAdminService;
	public void init() throws ServletException{
		connection=DBConnection.getCon();
		superAdminService = new SuperAdminService();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		pw.print("Couldn't connect to the webpage");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String emailId = req.getParameter("username");
		String password = req.getParameter("password");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_details where emailid=? and password=?");
			 preparedStatement.setString(1,emailId);
			 preparedStatement.setString(2,password);
			 
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				if(resultSet.getInt("role_id") == 1) {
					ArrayList<User> listUser = superAdminService.fetchUsers();
					req.setAttribute("listUser", listUser);
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("superAdminPage.jsp");
					requestDispatcher.forward(req, res);
				}
				else if(resultSet.getInt("role_id") == 2) {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminPage.jsp");
					requestDispatcher.forward(req, res);
				}
				else if(resultSet.getInt("role_id") == 3) {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("hrPage.jsp");
					requestDispatcher.forward(req, res);
				}
				else {
					pw.println("No such user is present in the system.");
				}
			}
			else {

				pw.print("Invalid Username/Password");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, res);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
			
	/*public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fName = req.getParameter("fname");
		String lName = req.getParameter("lname");
		String emailId = req.getParameter("email");
		String password = req.getParameter("pword");
		String createdDate = req.getParameter("cdate");
		String modifiedDate = req.getParameter("mdate");
		String createdBy = req.getParameter("cby");
		String roleId = req.getParameter("roleid");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user_details values(?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,1);
			  preparedStatement.setString(2,fName);
			  preparedStatement.setString(3,lName);
			  preparedStatement.setString(4,emailId);
			  preparedStatement.setString(5,password);
			  preparedStatement.setString(6,createdDate);
			  preparedStatement.setString(7,modifiedDate);
			  preparedStatement.setString(8,createdBy);
			  preparedStatement.setInt(9,Integer.parseInt(roleId));
			  int k=preparedStatement.executeUpdate();
				if(k>=0) {
					pw.println("inserted");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}*/
}
