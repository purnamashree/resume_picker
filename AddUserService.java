package com.sagarsoft.service;
import com.sagarsoft.common.DBConnection;
import com.sagarsoft.entity.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddUserService extends HttpServlet{
	public Connection connection;private SuperAdminService superAdminService;
	public void init() throws ServletException{
		connection=DBConnection.getCon();superAdminService=new SuperAdminService();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("1");
		String user_id = null;
		String firstName = req.getParameter("firstname");
		String lastName = req.getParameter("lastname");
		String emailId = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("2");
		//String createdDate = dtf.format(now);
		//String modifiedDate = dtf.format(now);
		//String createdDate = req.getParameter("created_date");
		//String modifiedDate = req.getParameter("modified_date");
		String createdBy = req.getParameter("created_by");
		String modifiedBy ="";
		String role = req.getParameter("role");
		
		System.out.println("3");
		//System.out.println(role);
		//System.out.println(createdDate);
		//System.out.println(modifiedDate);
		try {
			PreparedStatement preparedStatement2 = connection.prepareStatement("select seq_user.nextval from dual");
			ResultSet resultSet2=preparedStatement2.executeQuery();
			while(resultSet2.next()) {
				user_id=resultSet2.getString(1);
			}
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user_details(user_id,firstname,lastname,emailid,password,created_by,role_id,modified_by) values(?,?,?,?,?,?,?,?)");
			
			preparedStatement.setInt(1,Integer.parseInt(user_id));
			  preparedStatement.setString(2,firstName);
			  preparedStatement.setString(3,lastName);
			  preparedStatement.setString(4,emailId);
			  preparedStatement.setString(5,password);
			  //preparedStatement.setString(6,createdDate);
			  //preparedStatement.setString(7,modifiedDate);
			  System.out.println("4");
			  preparedStatement.setString(6,createdBy);
			  
			  PreparedStatement preparedStatement3 = connection.prepareStatement("select role_id from user_roles where role=?");
			  preparedStatement3.setString(1,role);
			  ResultSet resultSet=preparedStatement3.executeQuery();
			  while(resultSet.next()) {
				  preparedStatement.setInt(7,Integer.parseInt(resultSet.getString(1)));
			  }
			  preparedStatement.setString(8,modifiedBy);
			 /* if(role.equals("Admin")){
				  preparedStatement.setInt(7,2);
			  }
			  else if(role.equals("HR")) {
				  preparedStatement.setInt(7,3); 
			  }
			  else{
				  pw.println("select any user");
			  }
				  */
			  
			  int k=preparedStatement.executeUpdate();
			 
				if(k>=0) {
					ArrayList<User> listUser = superAdminService.fetchUsers();
					req.setAttribute("listUser", listUser);
					RequestDispatcher dispatcher = req.getRequestDispatcher("superAdminPage.jsp");
			        dispatcher.forward(req, res);
				}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
