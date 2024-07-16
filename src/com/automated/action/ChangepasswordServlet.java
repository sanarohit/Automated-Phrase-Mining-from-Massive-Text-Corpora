package com.automated.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automated.dao.ChangepasswordDao;
import com.automated.dto.Profilebean;


public class ChangepasswordServlet extends HttpServlet {

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
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userid=request.getParameter("userid");
		String password=request.getParameter("pass");
		String newPassword=request.getParameter("newpass");
		System.out.println("userid************"+userid);
		System.out.println("Password************"+password);
		System.out.println("newPassword************"+newPassword);
		Profilebean dto=new Profilebean();
		
		dto.setLoginid(userid);
		dto.setPassword(password);
		dto.setNewpassword(newPassword);
		ChangepasswordDao cpd=new ChangepasswordDao();
		try {
			int i=cpd.changepassword(dto);
			if(i!=0){
			RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp?status=Password changed Successfully");
			rd.include(request, response);
			}
			else{
				RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp?status=Invalid Password ");
				rd.include(request, response);
				}
			
		} catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("changepassword.jsp?status=Password NotChanged ");
			rd.include(request, response);
			
			
		}
	}

}
