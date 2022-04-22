package com.citiustech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductService {
	Scanner input = new Scanner(System.in);

	public ProductService() {

	}

	public void addProduct() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("insert into ProductDetails values(?, ?, ?, ?)");
			System.out.println("Enter Product ID");
			int prodId = input.nextInt();
			System.out.println("Enter the Product Name");
			String prodName = input.next();
			System.out.println("Enter the Product Price");
			float prodPrice = input.nextFloat();
			System.out.println("Enter the Product Category");
			String prodCategory = input.next();

			pstmt.setInt(1, prodId);
			pstmt.setString(2, prodName);
			pstmt.setFloat(3, prodPrice);
			pstmt.setString(4, prodCategory);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Product added successfully"); 
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateProduct() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("update ProductDetails set prod_price=? where prod_id=?");
			System.out.println("Enter the Product Price");
			float prodPrice = input.nextFloat();

			System.out.println("Enter Product ID");
			int prodId = input.nextInt();

			pstmt.setFloat(1, prodPrice);
			pstmt.setInt(2, prodId); 
			
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Product updated successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteProduct() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("delete from ProductDetails where prod_id=?");

			System.out.println("Enter Product ID");
			int prodId = input.nextInt();

			pstmt.setInt(1, prodId);

			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			System.out.println("Product deleted successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getProductById() throws ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("select * from ProductDetails where prod_id=?");

			System.out.println("Enter Product ID");
			int prodId = input.nextInt();

			pstmt.setInt(1, prodId);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) { 
				System.out.println(rs.getString("prod_name") + "--" + rs.getFloat("prod_price"));
			}

			pstmt.close();
			con.close();

			System.out.println("Product fetched successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
 
	public void getAllProducts() throws ClassNotFoundException {

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			PreparedStatement pstmt = con.prepareStatement("select * from ProductDetails");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("prod_name") + "--" + rs.getFloat("prod_price"));
			}

			pstmt.close();
			con.close();

			System.out.println("Products fetched successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
