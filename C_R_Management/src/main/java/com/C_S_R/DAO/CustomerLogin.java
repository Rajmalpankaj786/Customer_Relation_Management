package com.C_S_R.DAO;

import java.util.Scanner;

import com.C_S_R.exceptions.CustomerException;
import com.C_S_R.model.Customer;


public class CustomerLogin {

	public int loginCustomer() {
		int empId = 0;
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = sc.next();
		System.out.println("Enter Password");
		String password = sc.next();
		System.out.println("==================================");
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			Customer emp = dao.loginCustomer(username, password);
			System.out.println("Welcome "+ emp.getName());
			System.out.println("======================================");
			empId = emp.getCusId();
			
		} catch (CustomerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("===========================================");
			loginCustomer();
		}
		
		return empId;
	}
}