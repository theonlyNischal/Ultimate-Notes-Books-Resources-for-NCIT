import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>hello servlet</title>");
		out.println("<body>");
		out.println("<h1>Welcome to Servlet</h1>");
		out.println("</body>");
		out.println("</html>");
	
	}
}