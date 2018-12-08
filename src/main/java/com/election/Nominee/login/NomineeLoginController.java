package com.election.Nominee.login;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.election.Nominee.login.model.NomineeGoogleLogin;
import com.google.gson.Gson;

public class NomineeLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//    public NomineeLoginController() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		String requestData = request.getReader().lines().collect(Collectors.joining());
//		System.out.println(requestData);
		Gson gson = new Gson();
		NomineeGoogleLogin x = gson.fromJson(requestData, NomineeGoogleLogin.class);
		String username = (String)x.getName().getGivenName();
		String familyname = (String)x.getName().getFamilyName();
		String emailId = (String)x.getEmails()[0].getValue();
		String domain = (String) x.getDomain();
//		System.out.println(emailId);
//		System.out.println(x);
//		System.out.println(("lnmiit.ac.in").equals(domain));
//		System.out.println(domain);
		
		if(domain==null) {
			response.sendRedirect("jsp/signOutRedirect.jsp");
		}
		else if(domain!=null){			
			if(("lnmiit.ac.in").equals(domain)) {			
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("familyname", familyname);
				session.setAttribute("email", emailId);
				session.setAttribute("domain", domain);
				response.sendRedirect("jsp/NomineeForm.jsp");
			}else {
				response.sendRedirect("jsp/signOutRedirect.jsp");
			}
		}
		
	}
}


