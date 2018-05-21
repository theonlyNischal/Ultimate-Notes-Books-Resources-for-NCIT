errorpage.jsp
--------------------
<%@ page isErrorPage="true" %>
<html>
<body>
Oops this error has occured:
<%= exception.getMessage( ) %>
</body>
</html>