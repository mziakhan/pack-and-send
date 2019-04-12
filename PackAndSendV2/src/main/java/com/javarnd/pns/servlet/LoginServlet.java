package com.javarnd.pns.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javarnd.pns.enums.ResourceEnum;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestUrl = request.getServletPath();
		switch (requestUrl) {
		case "/signup":
			showRegistrationPage(request, response);
			break;
		case "/LoginServlet":
			processUserRequest(request, response);
		}
	}

	private void processUserRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			boolean user = authenticateUser(username, password);
			if (user!=false) {
				session.setAttribute("admin", true);
				request.getRequestDispatcher(ResourceEnum.RESOURCE_PATH.getName() + "admin/add_company_info.jsp")
						.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("user not found");
		}

	}

	private void showRegistrationPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(ResourceEnum.RESOURCE_PATH.getName() + "common/registration.jsp")
					.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private boolean authenticateUser(String username, String password) throws Exception {
		String uName="admin";
		String passwd="admin@1234";
		
			try {
				if ( username.equals(uName) && password.equals(passwd)) {
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
	}
}
