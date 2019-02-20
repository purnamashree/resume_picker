package com.sagarsoft.controller;

import java.awt.List;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sagarsoft.entity.User;
import com.sagarsoft.service.SuperAdminService;

public class SuperAdminController extends HttpServlet {
	private SuperAdminService superAdminService;

	public void init() {
		superAdminService = new SuperAdminService();

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		System.out.println(action);

		try {
			if (action.contains("/super_admin_page")) {
				listUsers(request, response);
			}
			else if (action.contains("/delete_user")) {
				deleteUser(request, response);
			}
			
			else {
				System.out.println("cannot go to the page");
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException, ClassNotFoundException {
		System.out.println("i am in superadminController listUsers()");
		ArrayList<User> listUser = superAdminService.fetchUsers();
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("superAdminPage.jsp");
		/*
		 * ArrayList<User> listUser = superAdminService.fetchUsers();
		 * System.out.println("I am in SuperAdminController: ");
		 * request.setAttribute("listUser", listUser);
		 * System.out.println("I am in SuperAdminController: " + listUser.size());
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("superAdminPage.jsp");
		 * dispatcher.forward(request, response);
		 */
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ClassNotFoundException {

        int id = Integer.parseInt(request.getParameter("user_id"));

        User user = new User(id);
        superAdminService.deleteUser(user);
        ArrayList<User> listUser = superAdminService.fetchUsers();
		request.setAttribute("listUser", listUser);
		request.getRequestDispatcher("superAdminPage.jsp");
       // response.sendRedirect("superAdminPage.jsp");

	}

}
