package com.election.Nominee.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NomineeLogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.removeAttribute("familyname");
		session.removeAttribute("email");
		session.removeAttribute("domain");
		session.invalidate();
		response.sendRedirect("jsp/login.jsp");
	}
	
}
