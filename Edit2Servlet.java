
package com.ttl;



import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
* Servlet implementation class Edit2Servlet
*/
@WebServlet("/Edit2Servlet")
public class Edit2Servlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public Edit2Servlet() {
super();
// TODO Auto-generated constructor stub
}



/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

PrintWriter pw=response.getWriter();

String name = request.getParameter("empName");



String designation = request.getParameter("role");



double salary = Double.parseDouble(request.getParameter("empSalary"));

Employee e=new Employee();



e.setName(name);
e.setRole(designation);
e.setSalary(salary);

int status=EmployeeDAO.update(e);

if(status>0)
response.sendRedirect("EmployeeListServlet");
else
pw.print("<h1> Sorry could not update record");


}



/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}



}