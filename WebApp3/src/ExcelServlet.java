import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("application/vnd.ms-excel");
		PrintWriter pw=resp.getWriter();
		pw.println("id \t name \t job \t salary");
		pw.println("1  \t amit  \t developer \t  10000");
		pw.println("2  \t sumit \t ceo  \t  50000");
		pw.println("3  \t mohit \t cfo \t  60000");
	}
}
