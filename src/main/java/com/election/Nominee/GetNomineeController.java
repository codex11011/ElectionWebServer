package com.election.Nominee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.Nominee.dao.NomineeDao;
import com.election.Nominee.model.Nominee;

public class GetNomineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//NomineeDao dao = new NomineeDao();
		//Nominee n1 = dao.getNominee(id);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("nominee", n1);
//		response.sendRedirect("jsp/Nominee.jsp");
	}
	
}
