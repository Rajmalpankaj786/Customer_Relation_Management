package com.C_S_R.usecases;

import java.util.Scanner;

import com.C_S_R.DAO.ServiceProviderDao;
import com.C_S_R.DAO.ServiceProviderDaoImpl;
import com.C_S_R.exceptions.ServiceProviderException;
import com.C_S_R.model.ServiceProvider;



public class ServiceProviderLogin {

	public int ServiceProviderLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.next();
		System.out.println("Enter password");
		String password = sc.next();
		System.out.println("===================================");
		
		ServiceProviderDao dao = new ServiceProviderDaoImpl();
		int serpId = 0;
		
		try {
			ServiceProvider eng = dao.loginServiceProvider(username, password);
			System.out.println("Welcome " + eng.getName());
			serpId=eng.getSerpId();
		} catch (ServiceProviderException e) {
			System.out.println(e.getMessage());
			ServiceProviderLogin();
		}
		return serpId;
	}
}