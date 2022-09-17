import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.swing.JOptionPane;


@WebListener //Registration from server to Listener
public class Mylistener implements ServletContextListener
{
	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{//JOptionPane.showMessageDialog(null, "ServletContext object is created!!");		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
		JOptionPane.showMessageDialog(null, "ServletContext object is destroyed!!");	
	}
}
