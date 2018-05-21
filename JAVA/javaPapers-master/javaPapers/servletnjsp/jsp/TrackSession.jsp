<html>
<body>
<% String check=session.getAttribute("userID");
if(!check.equals("12345"))
 response.sendRedirect("CreateSession.jsp");
else
  out.println("Welcome user");
%>
</body>
</html>
  