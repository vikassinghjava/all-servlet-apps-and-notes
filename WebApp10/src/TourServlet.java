import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TourServlet")
public class TourServlet extends HttpServlet 
{	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.setContentType("text/html");
	  PrintWriter pw=response.getWriter();
	 
	  Cookie ck[]=request.getCookies();
	  pw.println("Thanks for visit: "+ck[0].getValue()+"<br>");
	  pw.println("Value: "+ck[0].getValue()+"<br>");
	  pw.println("MaxAge: "+ck[0].getMaxAge()+"<br>");
	  pw.println("Name: "+ck[0].getName()+"<br>");
	  pw.println("Path: "+ck[0].getPath()+"<br>");
	  pw.println("Domian: "+ck[0].getDomain()+"<br>");
	  pw.println("Comment: "+ck[0].getComment()+"<br>");
	}
}




