import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{ resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();	  
	  try 
	  {
		//Create the object of ServletContext
		  ServletContext ctx=getServletContext();
		  
		  //get the value from xml
		  String driver=ctx.getInitParameter("driver");
		  String url=ctx.getInitParameter("url");
		  String user1=ctx.getInitParameter("user");
		  String password1=ctx.getInitParameter("password");
		  
  Class.forName(driver);
  Connection con=DriverManager.getConnection(url,user1,password1);
  PreparedStatement ps=con.prepareStatement("select * from register");
  
  ResultSet rs=ps.executeQuery();
  out.println("<table align='center' border=2>");
  out.print("<tr> <th>name</th>  <th>password</th> ");
  out.print("<th>Update</th>  <th>Delete</th> </tr>");
  while(rs.next()==true)
  {
	  out.println("<tr>");
	  out.print("<td>"+rs.getString("name")+"</td>  <td>"+rs.getString("password")+"</td>");
	  out.print("<td>  <a href='UpdateServlet'>Update</a> </td>");
	  out.print("<td>  <a href='DeleteServlet'>Delete</a> </td>");
	  out.println("</tr>");
	  
  }
  out.println("</table>");
  con.close();
  out.close();
  
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  
	  
	}
}
