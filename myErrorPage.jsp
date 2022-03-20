<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%response.setStatus(200);%>
<% if(response.getStatus()==500) %>
<font color="red">
<h2>Sorry user, some error occured</h2>
The exception is <%=exception.getMessage()%>
</font>
</body>
</html>