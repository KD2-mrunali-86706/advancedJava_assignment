package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;

@WebServlet("/candidate")
public class CandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) {

		String canName=req.getParameter("name");
		String partyName=req.getParameter("party");
		
		
		try {
			
			Candidate c=new Candidate();
			c.setName(canName);
			c.setParty(partyName);
			CandidateDaoImpl candidateSave=new CandidateDaoImpl();
			candidateSave.save(c);
	        resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login</title>");
			out.println("</head>");
			out.println("<body>");
			
			resp.sendRedirect("result");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
