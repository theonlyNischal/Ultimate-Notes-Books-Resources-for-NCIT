//www.techinterviews.com/master-list-of-java-interview-questions
//www.gointerviews.com/top-100-core-java-interview-questions
//creating cookie
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class CreateCookie extends HttpServlet
{protected void doGet(HttpServletRequest request,HttpServletResponse response)throws Exception
    {
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	Cookie cookie1=new Cookie("FirstName","abc");
	Cookie cookie2=new Cookie("LastName","bcd");
	cookie1.setMaxAge(24*60*60);
	cookie2.setMaxAge(24*60*60);
	response.addCookie(cookie1);
	response.addCookie(cookie2);
	pw.println("Hello user cookie has been set to your 	computer");
	pw.close();	
    }
}
		

		