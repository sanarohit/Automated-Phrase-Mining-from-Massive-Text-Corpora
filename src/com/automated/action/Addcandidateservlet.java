package com.automated.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.automated.dao.Addcandidatedao;
import com.automated.dto.Profilebean;

public class Addcandidateservlet extends HttpServlet {

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
		
		String candidatename=request.getParameter("candname");
		String desc=request.getParameter("desc");
		String topicname=request.getParameter("tname");
		
		
		Profilebean pb=new Profilebean();
		
		pb.setCandidatename(candidatename);
		pb.setDesc(desc);
		pb.setTopicname(topicname);
		Addcandidatedao acd=new Addcandidatedao();
		
		try{
		int i=acd.addcandidates(pb);
		if(i!=0){
			RequestDispatcher rd=request.getRequestDispatcher("Addcandidate.jsp?status=Details Added Successfully");
			rd.include(request,response);
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("Addcandidate.jsp?status=Details Not Added");
			rd.include(request,response);
		}
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("Addcandidate.jsp?status=Some Internal Problem Occured");
			rd.include(request,response);
		}
		
		
	}

}
