package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/announce")
public class AnnouncementServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//setcontext is used when we want to display something all over
		String announcement=req.getParameter("ann");
		ServletContext ctx = this.getServletContext();
		ctx.setAttribute("announcement", announcement);
		// go to result
		resp.sendRedirect("result");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}
	

}