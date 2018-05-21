//creating session
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class SessionTrack extends HttpServlet
{
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
     {
           response.setContentType("text/html");    
           PrintWriter pw=response.getWriter();
          //creating a session 
           HttpSession session=request.getSession();
	  //printing session ID
	   pw.println(session.getId());
           //setting time interval for the session
           session.setMaxInactiveInterval(2*60);
         //checking for the session if it is new
           if(session.isNew()){
		pw.println("Welcome User");
           }
         else{
		pw.println("Welcome Back");
           }
	}
}
		

		