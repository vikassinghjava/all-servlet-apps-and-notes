import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet 
{	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.setContentType("text/html");
	  PrintWriter pw=response.getWriter();
	  
	  String user=request.getParameter("username");
	  pw.print("Welcome: "+user);
	  
	  pw.println("<form action='TourServlet'>");
	  pw.println("<input type=hidden name=username value='"+user+"'>");
	  pw.println("<input type=submit value=Take_A_Tour>");
	  
	 
	}
}




