<%@ page import ="java.io.*" %>
<html>
<body>
<% int num1=10, num2=0;
try
{
out.println("dividing");
int num3=num1/num2;
out.println(num3);
}
catch(ArithmeticException e)
{
	out.println("error");
}
%>
</body>
</html>


