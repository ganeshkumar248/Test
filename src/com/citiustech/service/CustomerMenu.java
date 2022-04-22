package com.citiustech.service;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.citiustech.model.Product;

public class CustomerMenu {
	Scanner input = new Scanner(System.in);

	List<Product> furniture = new ArrayList<Product>();
	List<Product> laptop = new ArrayList<Product>();
	List<Product> mobile = new ArrayList<Product>();

	ResultSet rsFurniture;
	ResultSet rsLaptop;
	ResultSet rsMobile;

	public CustomerMenu() throws ClassNotFoundException {
		System.out.println("---Select category---");
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select distinct prod_category from ProductDetails");
			int i = 1;
			while (rs.next()) {
				System.out.println(i + "." + rs.getString(1));
				i++;
			}
			System.out.println("0.Exit");
			System.out.println("---------------------");

			Statement stmt1 = con.createStatement();
			rsFurniture = stmt1.executeQuery("select * from ProductDetails where prod_category='Furniture'");

			while (rsFurniture.next()) {
				Product fProduct = new Product();
				fProduct.setProdId(rsFurniture.getInt("prod_id"));
				fProduct.setProdCategory(rsFurniture.getString("prod_category"));
				fProduct.setProdName(rsFurniture.getString("prod_name"));
				fProduct.setProdPrice(rsFurniture.getFloat("prod_price"));
				furniture.add(fProduct);
			}

			Statement stmt2 = con.createStatement();
			rsLaptop = stmt2.executeQuery("select * from ProductDetails where prod_category='Laptop'");

			while (rsLaptop.next()) {
				Product lProduct = new Product();
				lProduct.setProdId(rsLaptop.getInt("prod_id"));
				lProduct.setProdCategory(rsLaptop.getString("prod_category"));
				lProduct.setProdName(rsLaptop.getString("prod_name"));
				lProduct.setProdPrice(rsLaptop.getFloat("prod_price"));
				laptop.add(lProduct);
			}

			Statement stmt3 = con.createStatement();
			rsMobile = stmt3.executeQuery("select * from ProductDetails where prod_category='Mobile'");

			while (rsMobile.next()) {
				Product mProduct = new Product();
				mProduct.setProdId(rsMobile.getInt("prod_id"));
				mProduct.setProdCategory(rsMobile.getString("prod_category"));
				mProduct.setProdName(rsMobile.getString("prod_name"));
				mProduct.setProdPrice(rsMobile.getFloat("prod_price"));
				mobile.add(mProduct);
			}

			System.out.println("Enter your choice");
			int choice = input.nextInt();
			selectOperation(choice);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void selectOperation(int choice) throws SQLException, ClassNotFoundException {

		if (choice == 1) {

			int i = 1;
			for (Product product : furniture) {
				System.out.println(i++ + "." + product.getProdName() + "---" + product.getProdPrice());
			}
			System.out.println("0.Exit");
			System.out.println("Select Product");
			int product = input.nextInt();
			if (product == 0) {
				CustomerMenu custMneu = new CustomerMenu();
			} else {
				System.out.println("Enter Quantity");
				int quantity = input.nextInt();
				System.out.println("Name of the Product: " + furniture.get(product - 1).getProdName());
				System.out.println("Quantity: " + quantity);
				System.out.println("Your Bill: " + quantity * furniture.get(product - 1).getProdPrice());
				System.out.println("Thank you for Purchase");

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
					PreparedStatement pstmt = con.prepareStatement("insert into orderDetails values(?, ?, ?)");
					pstmt.setString(1, furniture.get(product - 1).getProdName());
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, quantity * furniture.get(product - 1).getProdPrice());

					pstmt.executeUpdate();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				isPurchaseDone(choice);
			}

		} else if (choice == 2) {
			int i = 1;
			for (Product product : laptop) {
				System.out.println(i++ + "." + product.getProdName() + "---" + product.getProdPrice());
			}
			System.out.println("0.Exit");
			System.out.println("Select Product");
			int product = input.nextInt();
			if (product == 0) {
				CustomerMenu custMneu = new CustomerMenu();
			} else {
				System.out.println("Enter Quantity");
				int quantity = input.nextInt();
				System.out.println("Name of the Product: " + laptop.get(product - 1).getProdName());
				System.out.println("Quantity: " + quantity);
				System.out.println("Your Bill: " + quantity * laptop.get(product - 1).getProdPrice());
				System.out.println("Thank you for Purchase");

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
					PreparedStatement pstmt = con.prepareStatement("insert into orderDetails values(?, ?, ?)");
					pstmt.setString(1, laptop.get(product - 1).getProdName());
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, quantity * laptop.get(product - 1).getProdPrice());

					pstmt.executeUpdate();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				isPurchaseDone(choice);
			}

		} else if (choice == 3) {
			int i = 1;
			for (Product product : mobile) {
				System.out.println(i++ + "." + product.getProdName() + "---" + product.getProdPrice());
			}
			System.out.println("0.Exit");
			System.out.println("Select Product");
			int product = input.nextInt();
			if (product == 0) {
				CustomerMenu custMneu = new CustomerMenu();
			} else {
				System.out.println("Enter Quantity");
				int quantity = input.nextInt();
				System.out.println("Name of the Product: " + mobile.get(product - 1).getProdName());
				System.out.println("Quantity: " + quantity);
				System.out.println("Your Bill: " + quantity * mobile.get(product - 1).getProdPrice());
				System.out.println("Thank you for Purchase");

				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:sqlserver://IMCBBCP59-BLL\\SQLEXPRESS;databaseName=MiniProject;user=sa;password=password_123");
					PreparedStatement pstmt = con.prepareStatement("insert into orderDetails values(?, ?, ?)");
					pstmt.setString(1, mobile.get(product - 1).getProdName());
					pstmt.setInt(2, quantity);
					pstmt.setFloat(3, quantity * mobile.get(product - 1).getProdPrice());

					pstmt.executeUpdate();

				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				isPurchaseDone(choice);
			}

		} else {
			Menu menu = new Menu();
		}

	}

	public void isPurchaseDone(int choice) throws SQLException, ClassNotFoundException {
		System.out.println("Do you wat to continue? please select Y or N");
		String choose = input.next();
		if (choose.equalsIgnoreCase("Y")) {
			selectOperation(choice);
		} else {
			CustomerMenu custMneu = new CustomerMenu();
		}

	}

}
