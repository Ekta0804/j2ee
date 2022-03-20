
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.ttl.Employee,com.ttl.EmployeeDAO,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Employees</title>
</head>
<body>
<table border='1'>
<tr><th>Employee Name</th><th>Designation</th><th>Salary</th><th>EDIT</th><th>DELETE</th></tr>
<%
List<Employee> empList=EmployeeDAO.getAllEmployees();
request.setAttribute("list", empList);

%>
<%%>
<!-- jstl ==> java server pages tag library -->
<tr>
<c:forEach items="${list}" var="emp">
<td>${emp.getName()}</td><td>${emp.getRole()}</td><td>${emp.getSalary()}</td>
<td><a href='EditServlet?name=${ emp.getName()}'>EDIT</a></td>
<td><a href='DeleteServlet?name=${ emp.getName()}'>Delete</a></td>
</tr>
</c:forEach>
</tr>
</table>
</body>
</html>