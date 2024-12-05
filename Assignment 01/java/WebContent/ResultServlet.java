package WebContent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/r")
public class ResultServlet extends HttpServlet {
	
	ArrayList<Marks> result;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		super.init(config);
		result=new ArrayList<>();
		result.add(new Marks("java",75));
		result.add(new Marks("java programming",85));
		result.add(new Marks("WPT",95));
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse resp)
			throws ServletException,IOException
				{
		
		
		
		
					resp.setContentType("text/html");
					PrintWriter out=resp.getWriter();
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Home</title>");
					
					out.println("</head>");
					out.println("<body>");
					for(Marks m:result) {
						 out.println("<tr>"); 
						    out.printf("<td>%s<td>\r\n", m.getSubject()); 
						  
						    out.printf("<td>%.2f<td>\r\n", m.getMarks()); 
						    out.println("</tr>"); 
					}
				
					out.println("</body>");
					out.println("</html>");
				}

}
