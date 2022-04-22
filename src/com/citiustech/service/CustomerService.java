package com.citiustech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerService {
	 
	Scanner input = new Scanner(System.in);
	
	public void addCustomer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("insert into users values(?, ?, ?, ?)");
			System.out.println("Enter Customer ID"); 
			int custId = input.nextInt();
			System.out.println("Enter the Customer Name");
			String custName = input.next();
			System.out.println("Enter the Customer Password");
			String custpassword = input.next();
			System.out.println("Enter the Customer Role");
			String custRole = input.next();

			pstmt.setInt(1, custId);
			pstmt.setString(2, custName);
			pstmt.setString(3, custpassword);
			pstmt.setString(4, custRole);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Customer added successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateCustomer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("update users set user_name=? where user_id=? and user_role='customer'");
			System.out.println("Enter the Customer Name");
			String custName = input.next();

			System.out.println("Enter Customer ID");
			int custId = input.nextInt();

			pstmt.setString(1, custName);
			pstmt.setInt(2, custId);
			
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Customer updated successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteCustomer() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("delete from users where user_id=?");

			System.out.println("Enter Customer ID");
			int custId = input.nextInt();

			pstmt.setInt(1, custId);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Customer deleted successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void getCustomerById() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("select * from users where user_id=?");

			System.out.println("Enter Customer ID");
			int custId = input.nextInt();

			pstmt.setInt(1, custId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("user_role").equalsIgnoreCase("customer")) {
					System.out.println(rs.getString("user_name"));
				}

			}

			pstmt.close(); 
			con.close(); 

			System.out.println("Customer fetched successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void getAllCustomers() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("select * from users");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("user_role").equalsIgnoreCase("customer")) { 
					System.out.println(rs.getString("user_name"));
				}
			}

			pstmt.close();
			con.close();
 
			System.out.println("Customers fetched successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}


}
