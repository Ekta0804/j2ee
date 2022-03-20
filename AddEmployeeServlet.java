package com.ttl;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
* Servlet implementation class AddEmployeeServlet
*/
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

List<Employee> empList=new ArrayList<Employee>();



/**
* @see HttpServlet#HttpServlet()
*/
public AddEmployeeServlet() {
super();



System.out.println("Constructor called");
}



/**
* @see Servlet#init(ServletConfig)
*/
public void init(ServletConfig config) throws ServletException {



System.out.println("Init method called");
}



/**
* @see Servlet#destroy()
*/
public void destroy() {
System.out.println("Destroy method called");
}



/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
* response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}



/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
* response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {



PrintWriter pw = response.getWriter(); // CharacterStreams



// pw.print("<HTML>");
// pw.print("<h1> Adding a new Employee </h1>");
// pw.print("</html>");



String name = request.getParameter("empName");



String designation = request.getParameter("role");



String salary = request.getParameter("empSalary");




double empSalary=0.0;
try {
empSalary= Double.parseDouble(salary);
} catch (NumberFormatException nfe) {
pw.print("<h1 style='color:red'> Error: pls enter salary in numbers </h1>");
}



//create model instance
Employee e=new Employee(name,designation,empSalary);



int status=EmployeeDAO.save(e);

/*if(status>0)
pw.print("<h1 style='color:green'>Employee added successfully </h1>");
else
pw.print("<h1 style='color:red'>Employee not added </h1>");*/

//empList.add(e);

System.out.println(e);
//pw.print("<h1 style='color:green'>Employee added successfully </h1>");

//contents from one servlet to another servlet are sent using request scope
//request.setAttribute("ListEmployees", empList);


/*RequestDispatcher rd=request.getRequestDispatcher("EmployeeListServlet");
rd.forward(request, response);*/



RequestDispatcher rd=request.getRequestDispatcher("EmployeeList.jsp");
rd.forward(request, response);



}



}