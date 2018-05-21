<html>
<body>
<form name="frm1" action="TrackSession.jsp" method="POST">
<% session.setAttribute("userID","12345"); 
session.setMaxInactiveInterval(2*60);
%>

Username: <input type="text" name="username">
<br>
Password: <input type="password" name="password">
<br>
<input type="submit" value="submit">
</form>
</body>
</html>
