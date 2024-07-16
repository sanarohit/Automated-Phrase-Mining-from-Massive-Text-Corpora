package com.automated.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automated.dao.Requestacceptdao;
import com.automated.dto.Profilebean;

public class Requestacceptservlet extends HttpServlet {

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
		
		String loginid=request.getParameter("uid");
		String status=request.getParameter("status");
		Profilebean pb=new Profilebean();
		pb.setLoginid(loginid);
		pb.setStatus(status);
		
		Requestacceptdao rad=new Requestacceptdao();
		try{
		int i=rad.requestaccept(pb);
		 if(i!=0){
			 RequestDispatcher rd=request.getRequestDispatcher("Viewuserrequestservlet?status=Request Accepted Successfully");
			 rd.include(request, response);
		 }
		 else {
			 RequestDispatcher rd=request.getRequestDispatcher("Viewuserrequestservlet?status=Request Not Accepted");
			 rd.include(request, response);
		}
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("Viewuserrequestservlet?status=Some Internal Problem Occured");
			 rd.include(request, response);
		}
		
	}

}
