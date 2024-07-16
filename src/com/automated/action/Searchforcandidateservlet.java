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

import com.automated.dao.Searchforcandidatedao;
import com.automated.dto.Profilebean;

public class Searchforcandidateservlet extends HttpServlet {

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
		
		int cid=0;
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("uname");
		String candidatename=request.getParameter("candidatename");
		Searchforcandidatedao sfcd=new Searchforcandidatedao();
		try{
		ArrayList<Profilebean> list=sfcd.searchcondidates(candidatename);	
		for(Profilebean p:list){
			 cid=p.getCid();
			
			 	System.out.println("cid====>"+cid);	 
			 				 				 
		}
		
		session.setAttribute("list", list);
		
		//sfcd.storehistory(cid,userid);
		
		RequestDispatcher rd=request.getRequestDispatcher("Candidatedetails.jsp");
		rd.include(request, response);
		}
		catch (Exception e) {
			RequestDispatcher rd=request.getRequestDispatcher("Candidatedetails.jsp");
			rd.include(request, response);
		}
		
		
		
	}

}
