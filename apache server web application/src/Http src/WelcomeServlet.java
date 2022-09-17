import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;  //Servlet/GenericServlet/ServletException
import java.io.*;     //IOException/PrintWriter

import javax.servlet.annotation.WebServlet;


@WebServlet("/Welcome")
public class  WelcomeServlet extends  HttpServlet
{   
    public void service(HttpServletRequest req,  HttpServletResponse  res)
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

}