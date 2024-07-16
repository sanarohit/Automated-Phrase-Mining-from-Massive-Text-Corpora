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

public class Autophraseminingservlet extends HttpServlet {

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
		
		
		Searchforcandidatedao sfcd=new Searchforcandidatedao();
		
		try{
		ArrayList<Profilebean> list=sfcd.getphraseminingdetails();
		HttpSession session=request.getSession();
		session.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("Autophrasemining.jsp");
		rd.include(request, response);
	}
	catch (Exception e) {
		RequestDispatcher rd=request.getRequestDispatcher("phrasemining.jsp");
		rd.include(request, response);
	}
	}

}
