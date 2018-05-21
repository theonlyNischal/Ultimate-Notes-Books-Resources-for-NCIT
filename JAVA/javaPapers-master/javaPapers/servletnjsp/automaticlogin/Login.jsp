<@ page import ="javax.servlet.http.*" %>
<%
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
	    RequestDispatcher rd=request.getRequestDispatcher("/Welcome");
	    rd.forward(request,response); 
	} 
	
	 }
      }
%>    
<html>
<body>
 <form name ="frmlogin" action="SetMe" method="POST">
  Username: <input type="text" name="username" value="<%= username %>">
      <br>
 Password: <input type="password" name="password" value="<%= password %>">
  <br>
  <input type="checkbox" name="chkrem" value="remember">REMEMBER ME
    <br>
    <input type="submit" value="submit">
      </form>
</body>
</html>
    }
}



	    
	
	
