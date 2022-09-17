import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TourServlet")
public class TourServlet extends HttpServlet 
{	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.setContentType("text/html");
	  PrintWriter pw=response.getWriter();
	  
	  //get the old session of WelcomeServlet
	  HttpSession session=request.getSession(false);
	  
	  //get the value from session
	  String name=(String)session.getAttribute("username");
	  
	   
	   pw.println("Thanks for visit: "+name);
	   pw.println("ID: "+session.getId());
	   pw.println(" "+session.getCreationTime());
	   pw.println(" "+session.getLastAccessedTime());
	   pw.println(" "+session.getMaxInactiveInterval());
	   pw.println(" "+session.isNew());
	   
	   
	 
	 
	}
}




