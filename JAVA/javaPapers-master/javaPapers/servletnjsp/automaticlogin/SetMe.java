import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetMe extends HttpServlet
{
   public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
{
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    String username=request.getParameter("username");
    String password=request.getParameter("password");
   
    if(!username.equals("abc") || !password.equals("5678"))
          out.println("Invalid login. Please try again");
   else 
      {
             out.println("<br>Successful Login. Welcome to the world              of servlets");
             if(request.getParameter("chkrem")!=null)
              {
	
	Cookie loginuser=new Cookie("validuser",username);
	loginuser.setMaxAge(60);
	response.addCookie(loginuser);

	Cookie loginpassword=new Cookie                ("validpassword",password);
	loginpassword.setMaxAge(60);
	response.addCookie(loginpassword);
	
	}
	else
	{
	 Cookie loginuser=new Cookie("validuser","");
	loginuser.setMaxAge(0);
	response.addCookie(loginuser);

	Cookie loginpassword=new Cookie("validpassword","");
	loginpassword.setMaxAge(0);
	response.addCookie(loginpassword);
                 
	}
       }
       out.close();
  }
}

	

    