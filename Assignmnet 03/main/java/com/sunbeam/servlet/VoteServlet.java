package com.sunbeam.servlet;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.CandidateDao;
import com.sunbeam.dao.CandidateDaoImpl;
import com.sunbeam.dao.UserDao;
import com.sunbeam.dao.UserDaoImpl;
import com.sunbeam.entities.User;



@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get selected candidate id from previous page
		String candId = req.getParameter("candidate"); // "candidate" is name of radio button in prev page
		int id = Integer.parseInt(candId);
		
		
		//to add color
		ServletContext appc = this.getServletContext();
		String appcolor = appc.getInitParameter("app.color");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>",appcolor);
		
		//display msg by conrext
		
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>", appTitle);
		
				
		
		
		
		//add cookie
		Cookie[] arr=req.getCookies();
		String userName="",role="";
		if(arr !=null) {
			for(Cookie c:arr) {
				if(c.getName().equals("uname"))
					userName=c.getValue();
				if(c.getName().equals("role"))
					role=c.getValue();
			}
		}
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		
		out.println("<h2>Voting Status</h2>");

		
		

		//use session to add status
	
	
	
	
		HttpSession session = req.getSession();
		
		
		//retrive session 
		//HttpSession session = req.getSession(false); 
//				if(session==null)
//				{
//					//resp.sendRedirect("index.html");
//					resp.sendError(440);
//					return;
//					
//				}  write this if you want to add the session for that process like bank transaction
		
		
				
				//to add status--------------
		
			User user = (User) session.getAttribute("curUser");
			// let user vote, if not already voted
	if(user.getStatus() == 0)
	
	{
		try(CandidateDao cando=new CandidateDaoImpl()) {
			
			int count=cando.incrVote(id);
			if(count==1)
			{
				out.println("<h4>You have successfully casted your vote.</h4>");
                user.setStatus(1);
               try (UserDao userDao=new UserDaoImpl()){
                	count=userDao.update(user);
                	if(count==1)
                		out.println("<h4>You have  marked as voted.</h4>");
               }
                }
                else {
                	out.println("<h4>You voting vote.</h4>");

                }
		}
                
      catch (Exception e)
          {
			
			e.printStackTrace();
		}
			}
	
	
      else {
    	  		out.println("<h4>You have already voted.</h4>");
    	   		}
	
		
		
		
		out.println("<p><a href='logout'>Sign Out</a></p>");
		out.println("</body>");
		out.println("</html>");
	}
}
