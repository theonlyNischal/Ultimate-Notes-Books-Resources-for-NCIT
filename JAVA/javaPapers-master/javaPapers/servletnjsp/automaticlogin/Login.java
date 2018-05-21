import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Login extends HttpServlet
{
   public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
{
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    String username="";
    String password="";

    Cookie cookies[]=request.getCookies();
    if(cookies!=null){
        for(int i=0;i<cookies.length;i++){
            Cookie thisCookie=cookies[i];
                 if(thisCookie.getName().equals("validuser"))
	    username=thisCookie.getValue();
	
	    else if(thisCookie.getName().equals("validpassword"))
	         password=thisCookie.getValue();
	
	if(!username.equals("") && !password.equals(""))
	{
	    RequestDispatcher rd=request.getRequestDispatcher                                           ("/Welcome");
	    rd.forward(request,response); 
	} 
	
	 }
      }
    
      out.println("<html><body>");
      out.println("<form name ='frmlogin' action='SetMe' method='POST'>");
      out.println("Username: <input type='text' name='username' value="+username+">");
      out.println("<br>");
      out.println("Password: <input type='password' name='password' value="+password+">");
      out.println("<br>");
      out.println("<input type='checkbox' name='chkrem' value='remember' >REMEMBER ME");
       out.println("<br>");
      out.println("<input type='submit' value='submit'>");
      out.println("</form></body></html>");
      out.close();
    }
}



	    
	
	
