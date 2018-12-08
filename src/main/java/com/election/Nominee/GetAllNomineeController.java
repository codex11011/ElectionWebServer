package com.election.Nominee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.Nominee.dao.NomineeDao;
import com.election.Nominee.model.Nominee;


public class GetAllNomineeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NomineeDao dao = new NomineeDao();
		ArrayList<Nominee> list_nominee =  dao.getAllNomineeDetails();
		//System.out.println(list_nominee);
		HttpSession session = request.getSession();
		session.setAttribute("nominees", list_nominee);
		response.sendRedirect("jsp/allNominee.jsp");
//	
//		request.setAttribute("list_nominees", list_nominee);
//		RequestDispatcher rd = request.getRequestDispatcher("jsp/allNominee.jsp");
//		rd.forward(request, response);
	}

}
