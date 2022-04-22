package com.citiustech;

import java.util.Scanner;

import com.citiustech.service.CustomerService;
import com.citiustech.service.Menu;
import com.citiustech.service.ProductService;

public class Admin {
	Scanner input = new Scanner(System.in);
	public Admin() throws ClassNotFoundException {
		System.out.println("---Hello Admin---");
		System.out.println("1.Add Product "
						+ "\n2.Update Product " 
						+ "\n3.Delete Product "
						+ "\n4.Get Product By ID "
						+ "\n5.Get All Products "
						+ "\n6.Add customer "
						+ "\n7.Update Customer "  
						+ "\n8.Delete Custome "
						+ "\n9.Get Customer by ID "
						+ "\n10.Get All Customer "
						+ "\n0.Exit"); 
		System.out.println("Enter your choice"); 
		int choice = input.nextInt();
		selectOperation(choice);
		
	} 
	public void selectOperation(int choice) throws ClassNotFoundException {
		
		ProductService prodService = new ProductService();
		CustomerService custService = new CustomerService();
		if(choice == 1) {
			prodService.addProduct();
			stayLogin();
			
		} else if(choice == 2 ) {
			prodService.updateProduct();
			stayLogin();
			
		} else if(choice == 3) {
			prodService.deleteProduct();
			stayLogin();
			
		} else if(choice == 4) {
			prodService.getProductById();
			stayLogin();
			
		} else if(choice == 5) {
			prodService.getAllProducts();
			stayLogin();
			
		} else if(choice == 6) { 
			custService.addCustomer();
			stayLogin();
			
		} else if(choice == 7) {
			custService.updateCustomer();
			stayLogin();
			
		} else if(choice == 8) {
			custService.deleteCustomer();
			stayLogin();
			
		} else if(choice == 9) {
			custService.getCustomerById();
			stayLogin();
			
		} else if(choice == 10) {
			custService.getAllCustomers();
			stayLogin();
			
		} else {
			System.out.println("---Thank You---");
		}
		
	}
	public void stayLogin() throws ClassNotFoundException {
		System.out.println("Do you wat to continue? please select Y or N");
		String choose = input.next();
		if(choose.equalsIgnoreCase("Y")) {
			Admin admin = new Admin();
		} else {
			Menu menu = new Menu();
		}
		
	} 

}












