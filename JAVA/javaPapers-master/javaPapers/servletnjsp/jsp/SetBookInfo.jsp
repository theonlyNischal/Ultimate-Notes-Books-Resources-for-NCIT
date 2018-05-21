<html>
<body>
<%
String bookname=request.getParameter("bookname");
String author=request.getParameter("author");

%>

Book name:<%=bookname %> <br>
Author: <%= author %>

</body>
</html>