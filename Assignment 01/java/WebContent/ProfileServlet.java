package WebContent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/p")
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException
				{
					resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Home</title>");
				
					
					out.println("</head>");
					out.println("<body style=\"background-color:pink;\">");
					out.println("<h1>welcome to profileservlet</h1>");
	                out.println("First_Name:Ashutosh<br>");	
	                out.println("Last_Name:Pardhi<br>");
	                out.println("qualification:MBBS<br>");
	                out.println("College Name:PDMC<br>");
	                out.println("DOB:25/10/2002<br>");
	                
					out.println("</body>");
					out.println("</html>");
				}

}
