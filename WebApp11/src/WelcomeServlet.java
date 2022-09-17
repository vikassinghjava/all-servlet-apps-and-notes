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
	  
	  //create the cookie
	  Cookie ck=new Cookie("user", user);
	  //to make persistent cookie for 1 yr
	  ck.setMaxAge(365*24*60*60);//seconds 
	  
	  response.addCookie(ck);
	   pw.print("<br> <a href='TourServlet'> Take a Tour</a>");
	}
}




