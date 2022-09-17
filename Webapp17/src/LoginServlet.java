import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{ resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  
	 
	  String user=req.getParameter("username");//<input type="text" name="username"><br>
	  String pass=req.getParameter("password");
	 try {
  ServletContext ctx=getServletContext();
  Connection con=(Connection)ctx.getAttribute("dbcon");
  
  PreparedStatement ps=con.prepareStatement("select * from register where name=? and password=?");
  ps.setString(1, user);
  ps.setString(2, pass);
  ResultSet rs=ps.executeQuery();
  			if(rs.next()==true)
  			{
  				out.print("sucessfully login  "+user);
  				
  			}
  			else
  			{
  				out.print("invalid user name or passwor!!!");
  				RequestDispatcher rd=req.getRequestDispatcher("index.html");
  				//RequestDispatcher rd=req.getRequestDispatcher("http://www.facebook.com");
  				//RequestDispatcher rd=req.getRequestDispatcher("http://www.gmail.com");
  				rd.include(req, resp);
  			}
  
  //con.close();
  out.close();
  
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  
	  
	}
}
