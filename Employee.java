

package com.ttl;



public class Employee {
String name, role;
double salary;



@Override
public String toString() {
return "Employee [name=" + name + ", role=" + role + ", salary=" + salary + "]";
}



public Employee(String name, String role, double salary) {
super();
this.name = name;
this.role = role;
this.salary = salary;
}



public Employee() {
// TODO Auto-generated constructor stub
}



public String getName() {
return name;
}



public void setName(String name) {
this.name = name;
}



public String getRole() {
return role;
}



public void setRole(String role) {
this.role = role;
}



public double getSalary() {
return salary;
}



public void setSalary(double salary) {
this.salary = salary;
}



}