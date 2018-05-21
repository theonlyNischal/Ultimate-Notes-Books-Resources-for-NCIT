import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ParameterServlet extends HttpServlet
{
    public void doGet(HttpServletRequest request,      HttpServletResponse response)throws IOException,ServletException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("ename");
		String phone=request.getParameter("ephone");
		pw.println("<html>");
		pw.println("<body>");
		pw.println("Employee Name: "+name);
		pw.println("<br>");
		pw.println("Phone Number: "+phone);
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}
		