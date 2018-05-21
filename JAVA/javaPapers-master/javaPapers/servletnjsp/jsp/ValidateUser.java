import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidateUser extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
{
    response.setContentType("text/html");
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    
    if(username.equals("12345") && password.equals("12345"))
    {
	HttpSession session=request.getSession();
                 session.setAttribute("userID","12345");
                 session.setMaxInactiveInterval(2*60);
	RequestDispatcher rd=request.getRequestDispatcher("/proj/TrackSession.jsp");
	rd.forward(request,response);
	
     }
     else
     {
	RequestDispatcher rd=request.getRequestDispatcher("/proj/CreateSession.jsp");
	rd.forward(request,response);
     }
  }
}