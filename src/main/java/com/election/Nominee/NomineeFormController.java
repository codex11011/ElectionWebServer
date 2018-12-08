package com.election.Nominee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.election.Nominee.dao.NomineeDao;
import com.election.Nominee.model.Nominee;
public class NomineeFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NomineeDao dao = new NomineeDao();
		Nominee n1 = new Nominee();
		n1.setFirstName(request.getParameter("firstName"));
		n1.setFamilyName(request.getParameter("familyName"));
		n1.setEmailId(request.getParameter("email"));
		n1.setPhoneNumber(request.getParameter("PhoneNumber"));//long
		n1.setHostel(request.getParameter("hostel"));
		n1.setRoomNumber(request.getParameter("roomNumber"));
		n1.setBatch(request.getParameter("batch"));
		n1.setBranch(request.getParameter("branch"));
		n1.setCgpa(request.getParameter("cgpa"));
		n1.setPosition(request.getParameter("position"));
		try {
			dao.saveNomineeDetails(n1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----------------");
		//dao.saveNomineeDetails();
		response.sendRedirect("index.jsp");
	}

}
