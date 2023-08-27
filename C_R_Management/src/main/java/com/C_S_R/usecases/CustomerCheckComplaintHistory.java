package com.C_S_R.usecases;

import java.util.List;

import com.hardware_software_support.DAO.EmployeeDao;
import com.hardware_software_support.DAO.EmployeeDaoImpl;
import com.hardware_software_support.exceptions.ComplaintException;
import com.hardware_software_support.model.Complaints;

public class CustomerCheckComplaintHistory {

	public void checkComplaintHistory(int cusId) {
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			List<Complaints> complaints = dao.checkComplaintHistory(cusId);
			complaints.forEach(comp -> System.out.println(comp));
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}