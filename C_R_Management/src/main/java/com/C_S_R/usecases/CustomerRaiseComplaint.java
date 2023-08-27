package com.C_S_R.usecases;

import java.util.Scanner;

import com.C_S_R.DAO.CustomerDao;
import com.C_S_R.DAO.CustomerDaoImpl;
import com.C_S_R.exceptions.ComplaintException;



public class CustomerRaiseComplaint {

	public void raiseComplaint(int cusId) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Press 1 if Product Packing Mistake, Complaint.");
		System.out.println("Press 2 if Product is not good, Complaint.");
		int compChoice = sc.nextInt();
		String compType="Not mentioned";
		if(compChoice==1) compType="product Packing Mistake";
		
		else if(compChoice==2) compType ="Bad Product";
		
		else {
			System.out.println("Invalid Choice. Please try again.");
			System.out.println("==================================");
			raiseComplaint(cusId);
		}
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			int compId = dao.raiseComplaint(cusId, compType);
			System.out.println("Complaint Id: "+ compId +" Please keep this handy to check complaint status.");
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}