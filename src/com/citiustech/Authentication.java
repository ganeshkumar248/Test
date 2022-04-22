package com.citiustech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.citiustech.service.CustomerMenu;

public class Authentication { 
	
	public void isValidUser(String username, String password) throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");
			int login = 0;
			while (rs.next()) {
				if (username.equals(rs.getString("user_name")) && password.equals(rs.getString("user_password"))
						&& rs.getString("user_role").equalsIgnoreCase("admin")) {
					login++;
					Admin admin = new Admin();
					break;
				} else if(username.equals(rs.getString("user_name")) && password.equals(rs.getString("user_password"))
						&& rs.getString("user_role").equalsIgnoreCase("customer")) {
					login++;
					CustomerMenu customer = new CustomerMenu();
					break;
				}  
			} 
			if(login == 0) {
				System.out.println("---Please check Login Credentials---");
			}
 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
