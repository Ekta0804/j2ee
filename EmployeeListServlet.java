package com.ttl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class EmployeeListServlet
*/
@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
PrintWriter pw=response.getWriter();

pw.print("<h1> Employee List displayed here </h1><table border='1'><tr><th>Emplyee Name</th><th>Designation</th><th>Salary</th>"
+ "<th>EDIT</th><th>DELETE</th></tr>");

//List<Employee> empList=(List<Employee>) request.getAttribute("ListEmployees");

List<Employee> empList=EmployeeDAO.getAllEmployees();

for(Employee emp:empList)
pw.print("<tr> <td>"+emp.getName()+"</td>"+"<td>"+emp.getRole()+"</td><td>"+emp.getSalary()+"</td>"
+ "<td><a href='EditServlet?name="+emp.getName()+"'>EDIT</a></td>"
+"<td><a href='DeleteServlet?name="+emp.getName()+"'>Delete</a></td> "
+ "</tr>");
//System.out.println(empList);

pw.print("</table></html>");
}



/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}



}