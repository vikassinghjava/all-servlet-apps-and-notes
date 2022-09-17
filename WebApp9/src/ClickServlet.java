import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ClickServlet")
public class ClickServlet extends HttpServlet
{	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
    {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		ServletContext ctx=getServletContext();
		Integer hit=(Integer)ctx.getAttribute("count");
		if(hit==null)
		{
			hit=new Integer(0);
		}
	ctx.setAttribute("count", hit.intValue()+1);
	hit=(Integer)ctx.getAttribute("count");
    pw.print("No of clicks: "+hit);	
	}
}
