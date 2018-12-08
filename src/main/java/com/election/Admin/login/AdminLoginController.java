package com.election.Admin.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.Admin.login.dao.LoginDao;
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getParameter("adminUsername");
		String email = (String) request.getParameter("adminEmail");
		String password = (String) request.getParameter("adminPassword");
		LoginDao dao = new LoginDao();
		
		if(dao.check(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("adminEmail", email);
			session.setAttribute("adminPassword", password);
			session.setAttribute("adminUsername", username);
			response.sendRedirect("getAllNominee");
		}else {
			response.sendRedirect("jsp/login.jsp");
		}
	}

	
}
