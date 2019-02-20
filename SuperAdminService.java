package com.sagarsoft.service;
import java.awt.List;
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sagarsoft.common.*;
import com.sagarsoft.entity.User;
import java.util.*;
import java.sql.*;

	public class SuperAdminService implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Connection connection = DBConnection.getCon();
		
		
		
		public ArrayList<User> fetchUsers() throws SQLException, ClassNotFoundException {
			
			String sql = "select * from user_details";

			java.sql.Statement statement = connection.createStatement();
			
			 ArrayList<User> users = new ArrayList<User>();
			 ResultSet resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				System.out.println(resultSet.getString(1));
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setLastName(resultSet.getString("lastname"));
				user.setEmailId(resultSet.getString("emailid"));
				user.setCreatedDate(resultSet.getString("created_date"));
				user.setModifiedDate(resultSet.getString("modified_date"));
				user.setCreatedBy(resultSet.getString("created_by"));
				user.setModifiedBy(resultSet.getString("modified_by"));
				user.setRoleId(resultSet.getInt("role_id"));
				users.add(user);
			}
			
			return users;
			
		}


		
		public boolean deleteUser(User user) throws SQLException, ClassNotFoundException {
			System.out.println("i am in super Admin Service deleteUser()");
	        String sql = "DELETE FROM user_details where user_id = ?";

	        Connection connection = DBConnection.getCon();

	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setInt(1, user.getUserId());
	        System.out.println("ID="+user.getUserId());
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        connection.close();
	        return rowDeleted;
	}

	}
/*public class SuperAdminService {
	public Connection connection;
	public void init() throws ServletException{
		connection=DBConnection.getCon();
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user_details");
			 ArrayList<User> users = new ArrayList<User>();
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setFirstName(resultSet.getString("firstname"));
				user.setEmailId(resultSet.getString("emailid"));
				user.setPassword(resultSet.getString("password"));
				users.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}*/