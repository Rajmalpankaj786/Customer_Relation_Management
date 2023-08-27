package com.C_S_R.usecases;

import java.util.Scanner;

import com.C_S_R.DAO.CustomerDao;
import com.C_S_R.DAO.CustomerDaoImpl;
import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.model.ServiceProviderComplaintsDTO;



public class CustomerCheckComplaintStatus {
	
	public void checkCompStatus() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your complaint id to check status");
		int compId = sc.nextInt();
		System.out.println("=======================================");
		System.out.println("Complaint status:- ");
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			ServiceProviderComplaintsDTO dto =  dao.checkComplaintStatus(compId);
			System.out.println("ComplaintId: " + dto.getComplaintId());
			System.out.println("Complaint Type: " + dto.getComplaintType());
			System.out.println("ServiceProvider id: " + dto.getSerPId());
			System.out.println("Engineer name: " + dto.getName());
			System.out.println("Status: " + dto.getStatus());
			System.out.println("Date raised: " + dto.getDateRaised());
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
