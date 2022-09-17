import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet 
{	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  response.setContentType("text/html");
	  PrintWriter pw=response.getWriter();
	  
	  String user=request.getParameter("username");
	  pw.print("Welcome: "+user);
	  
	  //create the object of HttpSession
	  HttpSession session=request.getSession();
	  //save the user sate
	  session.setAttribute("username", user);
	  
	 pw.println("<a href='TourServlet?user1="+user+"'>Take Tour Servlet </a>");
	 pw.println("<a href='Logoutservlet'>Logout</a>");
	  
	 
	}
}




