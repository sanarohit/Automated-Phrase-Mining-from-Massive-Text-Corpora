package com.automated.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.automated.dao.Logindao;
import com.automated.dto.Profilebean;

public class LoginServlet extends HttpServlet {

	int count=0;
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String uname=request.getParameter("uid");
		String password=request.getParameter("pass");
		String role=null;
		String username=null;
		String status=null;
				
		Profilebean pb=new Profilebean();
		pb.setLoginid(uname);
		pb.setPassword(password);
		
		Logindao ld=new Logindao();
		try{
		
			ArrayList<Profilebean> list=ld.datauserlogin(pb);
		
			for(Profilebean p:list){
			 role=p.getRole();
			 username=p.getUsername();
			 status=p.getStatus();
			 	System.out.println("role====>"+role);	 
			 	System.out.println("name====>"+username);	 
			 	System.out.println("status====>"+status);
			 	
			 
		}
		if("Admin".equals(role)){
			
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("username", username);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.jsp");
			rd.include(request, response);
			
		}
		
		
		
		else if("User".equals(role)&& status.equals("Active")){
		/*else if("User".equals(role)){*/
			
			HttpSession session=request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("username", username);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("UserHome.jsp");
			rd.include(request, response);
			
		}
		else if("User".equals(role)&& status.equals("Pending")){
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?status=Your Request is in Pending");
			rd.include(request, response);
			
		}       
		
		else {
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?status=Invalid Userid And Password");
			rd.include(request, response);
			}
			
		}
		
		catch (Exception e) {
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp?status=Some Internal Problem");
			rd.include(request, response);
			
		}
		}
		
}
