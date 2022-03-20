package com.ttl;



import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
* Servlet implementation class EditServlet
*/
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

/**
* @see HttpServlet#HttpServlet()
*/
public EditServlet() {
super();
// TODO Auto-generated constructor stub
}



/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
PrintWriter pw=response.getWriter();

String name=request.getParameter("name");

Employee emp=EmployeeDAO.getEmployeeByName(name);
System.out.println("EDIT-SERVLET "+emp);

pw.println("<form action='Edit2Servlet' method='post'>");
pw.print("Name:<input type='text' value='"+emp.getName()+"' name='empName'/> </BR></BR>");
pw.print("Role:<input type='text' value='"+emp.getRole()+"' name='role'/></BR></BR>");
pw.print("Salary:<input type='text' value='"+emp.getSalary()+"' name='empSalary'/></BR></BR>");
pw.print("<input type='submit' value='update'></br></br>");
pw.print("</form>");



}



/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}



}