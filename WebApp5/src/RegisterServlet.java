import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{ resp.setContentType("text/html");
	  PrintWriter out=resp.getWriter();
	  
	  String user=req.getParameter("username");//<input type="text" name="username"><br>
	  String pass=req.getParameter("password");
	  try 
	  {
  Class.forName("com.mysql.jdbc.Driver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","javahub");
  PreparedStatement ps=con.prepareStatement("insert into register values(?,?)");
  ps.setString(1, user);
  ps.setString(2, pass);
  int i=ps.executeUpdate();
  			if(i>0)
  			{
  				out.print("sucessfully registerd  "+user);
  			}
  			else
  			{
  				out.print("Connection Failure and contact to admin!!!");
  			}
  out.println("<a href='UserServlet'>All Registered Users</a><br>");
  con.close();
  out.close();
  
	  }catch(Exception ex) 
	  {
		  ex.printStackTrace();
	  }
	  
	  
	}
}
