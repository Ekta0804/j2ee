
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" info="This is success page" isThreadSafe="true"%>
<%@ page errorPage="myErrorPage.jsp" import="java.util.Date" %> <!-- Directives in JSP used translation phase(jsp==>_jsp.java) -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%!int age=2; %> <!-- declaration tag -->
<%=age%> <!-- expression tag -->
<!--Scriptlets -->
<%if(age>=18)
out.print("Age is valid");
else
out.print("Age is invalid");
%>
</BR></BR>
<%=getServletInfo() %>
<%=new Date() %>
<%=2*5%>
<%=10/0%>



</body>
</html>