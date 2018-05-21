//reading cookies
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
public class ShowCookie extends HttpServlet
{	public void doGet(HttpServletRequest request,HttpServletResponse response)throws  IOException
    {	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	Cookie cookies[]=request.getCookies();
	if(cookies!=null)
	{
            for(int i=0;i<cookies.length;i++)
	    {
     	        String name=cookies[i].getName();
	        String value=cookies[i].getValue();
	        pw.println("Cookie Name " +name);
	        pw.println("Cookie Value "+value);
	}
          }
          pw.close();			
     }
}
		

		