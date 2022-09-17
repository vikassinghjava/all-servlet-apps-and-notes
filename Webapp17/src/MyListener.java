import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent cte)
	{ 	try 
		  {
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb","root","javahub");
	   
	   ServletContext ctx=cte.getServletContext();
		ctx.setAttribute("dbcon", con);
		  }catch(Exception ex) {ex.printStackTrace();}
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		
		
	}
}
