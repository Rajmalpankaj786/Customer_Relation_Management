package com.C_S_R.DAO;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.C_S_R.exceptions.CustomerException;


public class CustomerRegistration {
	
	public void registerCustomer() {
		System.out.println("Customer Registration");
		System.out.println("=============================");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter department id.");
		int productId = sc.nextInt();
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter your username.");
		String username = sc.next();
		System.out.println("Enter password. Password should have 8 to 20 characters without"
				+ "space and should include atleast 1 digit 1 uppercase 1 lowercase letter"
				+ "and a special character.");
		String password = sc.next();
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(password);
		
		if(m.matches()) {
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				String res = dao.registerCustomer(productId, name, username, password);
				System.out.println(res);
			} catch (CustomerException e) {
				System.out.println(e.getMessage());
			}
			
		}else {
			System.out.println("Password should have 8 to 20 characters without"
					+"space and should include atleast 1 digit 1 uppercase 1 lowercase letter"
					+"and a special character. Please try again.");
			
			registerCustomer();
		}
		
	}
}