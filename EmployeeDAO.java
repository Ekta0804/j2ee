
package com.ttl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

// JDBC API -JAVA DATABASE CONNECTIVITY API
// 1. download mysql-connector jar file
// 2. Load jdbc driver
// 3. establish conenction with db , dbname,username,password
// 4. execute query
// 5.retrieve result

	public static Connection establishConnection() {
		Connection con = null;

		try {
// 1. Load JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("JDBC Driver loaded");

// 2. Establish connection with mysql db using java
// jdbc:mysql:// hostname/ databaseName
// LEGACY AUTHENTICATION METHOD
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedJava", "root", "root");
			System.out.println("Connection made with Database");

		} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

	public static int save(Employee emp) {
		int status = 0;

		try {
			Connection con = EmployeeDAO.establishConnection();

			System.out.println("");
// insert record for real time form data ==> PreparedStatement

			String query = "INSERT INTO EMPLOYEE(name,designation,salary) VALUES(?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getRole());
			ps.setDouble(3, emp.getSalary());

// executing insert query on table
			status = ps.executeUpdate();
			//con.close();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public static int update(Employee emp) {
		int status = 0;

		try {
			Connection con = EmployeeDAO.establishConnection();

// insert record for real time form data ==> PreparedStatement

			String query = "UPDATE EMPLOYEE SET designation=?,salary=? where name=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, emp.getRole());
			ps.setDouble(2, emp.getSalary());
			ps.setString(3, emp.getName());

// executing insert query on table
			status = ps.executeUpdate();

			System.out.println("EMPLOYEE DAO update performed");

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public static int delete(String name) {
		int status = 0;

		System.out.println("Name " + name);

		try {
			Connection con = EmployeeDAO.establishConnection();

// insert record for real time form data ==> PreparedStatement

			String query = "DELETE FROM EMPLOYEE where name=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, name);

// executing insert query on table
			status = ps.executeUpdate();

			System.out.println("for " + name + ",records deleted successfully");
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();

		try {
			Connection con = EmployeeDAO.establishConnection();

// insert record for real time form data ==> PreparedStatement

			String query = "select * from employee";

			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Employee e = new Employee();

// fetching record from each row and setting values for new employee object
				e.setName(rs.getString(2));
				e.setRole(rs.getString(3));
				e.setSalary(rs.getDouble(4));
// add employee object to the list
				list.add(e);
			}

// con.close();

		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public static Employee getEmployeeByName(String name) {
		Employee e = new Employee();

		try {
			Connection con = EmployeeDAO.establishConnection();

// insert record for real time form data ==> PreparedStatement

			String query = "select * from employee where name=?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

// fetching record from each row and setting values for new employee object
				e.setName(rs.getString(2));
				e.setRole(rs.getString(3));
				e.setSalary(rs.getDouble(4));

			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return e;
	}

}