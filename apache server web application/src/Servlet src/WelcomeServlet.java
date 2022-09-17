import javax.servlet.Servlet;
import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Welcome")
public class  WelcomeServlet implements Servlet
{
    public void init(ServletConfig cfg){}
    public void service(ServletRequest req,  ServletResponse  res)
	throws ServletException,IOException
	{
	     res.setContentType("text/html"); //browser o/p
                      PrintWriter pw=res.getWriter();//dy. page genarate// response to the client

                     String name=req.getParameter("username"); 
                     pw.println("<html><body bgcolor=cyan>");
	    pw.println("Welcome :    "+name);
                     pw.println("</body></html>");   
	   pw.close();
	}
public void destroy(){}

public String getServletInfo(){ return null;}

public ServletConfig getServletConfig(){return null;}
}