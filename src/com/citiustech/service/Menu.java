package com.citiustech.service;

import java.util.Scanner;

import com.citiustech.Authentication;

public class Menu {
	Scanner input = new Scanner(System.in);

	public Menu() throws ClassNotFoundException {
		System.out.println("---Menu---\n1.Admin \n2.Customer \n0.Exit");
		System.out.println("Enter your choice");
		int choice = input.nextInt();
		if (choice == 1 || choice == 2) {
			System.out.println("Enter your username:");
			String username = input.next();
			System.out.println("Enter your password:");
			String password = input.next();
			Authentication auth = new Authentication();
			auth.isValidUser(username, password);	

		} else {
			System.out.println("---Thank You---");
		}  
	}

}
 