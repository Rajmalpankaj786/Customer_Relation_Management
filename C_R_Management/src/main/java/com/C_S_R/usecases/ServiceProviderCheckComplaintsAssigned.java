package com.C_S_R.usecases;

import java.util.List;

import com.C_S_R.DAO.ServiceProviderDao;
import com.C_S_R.DAO.ServiceProviderDaoImpl;
import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.model.Complaints;



public class ServiceProviderCheckComplaintsAssigned {

	public void checkComplaintsAssigned(int engId) throws ComplaintException {
		
		
		ServiceProviderDao dao = new ServiceProviderDaoImpl();
		try {
			List<Complaints> complaintsAssigned = dao.checkAssignedComplaints(engId);
			if(complaintsAssigned.isEmpty()) {
				System.out.println("No new complaints assigned.");
			}else
			complaintsAssigned.forEach(comps -> System.out.println(comps));
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			throw new ComplaintException("No complaints assigned.");
		}
		
	}
}