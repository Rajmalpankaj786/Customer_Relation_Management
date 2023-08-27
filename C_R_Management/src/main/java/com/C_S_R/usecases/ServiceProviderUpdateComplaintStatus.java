package com.C_S_R.usecases;

import java.util.Scanner;

import com.C_S_R.DAO.ServiceProviderDao;
import com.C_S_R.DAO.ServiceProviderDaoImpl;
import com.C_S_R.exceptions.ComplaintException;


public class ServiceProviderUpdateComplaintStatus {
	
	public void engUpdateComplaintStatus() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter complaint id to update status.");
		int complaintId = sc.nextInt();
		System.out.println("Enter 1 to set status as In Progress.");
		System.out.println("Enter 2 to set status as Resolved.");
		String newStatus = "";
		int status = sc.nextInt();
		if(status==1) {
			newStatus = "In Progress";
			
			ServiceProviderDao dao = new ServiceProviderDaoImpl();
			
			try {
				String res = dao.updateComplaintStatus(complaintId, newStatus);
				System.out.println(res);
			} catch (ComplaintException e) {
				System.out.println(e.getMessage());
			}
		}else if(status==2) {
			newStatus = "Resolved";
			
			ServiceProviderDao dao = new ServiceProviderDaoImpl();
			
			try {
				String res = dao.updateComplaintStatus(complaintId, newStatus);
				System.out.println(res);
			} catch (ComplaintException e) {
				System.out.println(e.getMessage());
			}
		}else {
			System.out.println("Invalid choice. Please try again.");
		}
	}
}