import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DivideServlet")
public class DivideServlet extends HttpServlet
{
	ServletConfig cfg;
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
	 cfg=config;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{ resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();	
	  
	  
	  
	  int n1=Integer.parseInt(req.getParameter("num1"));
	  int n2=Integer.parseInt(req.getParameter("num2"));
	  
	  try {
		  	int c=n1/n2;
		  	out.print("Result: "+(c));
		  	RequestDispatcher rd=req.getRequestDispatcher("index.html");
		  	rd.include(req, resp);
	     }
	     catch(Exception ex) 
	     {
		  resp.sendRedirect("http://www.google.com");
	     }
	  
	  
	}
}
