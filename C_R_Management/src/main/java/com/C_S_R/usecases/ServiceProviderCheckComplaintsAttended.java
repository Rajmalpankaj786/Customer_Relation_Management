package com.C_S_R.usecases;

import java.util.List;

import com.C_S_R.DAO.ServiceProviderDao;
import com.C_S_R.DAO.ServiceProviderDaoImpl;
import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.model.Complaints;



public class ServiceProviderCheckComplaintsAttended {

	public void checkComplaintsAttended(int engId) {
		
		ServiceProviderDao dao = new ServiceProviderDaoImpl();
		
		try {
			List<Complaints> comps = dao.checkComplaintsAttended(engId);
			if(comps.isEmpty()) {
				System.out.println("No complaints attended.");
			}else {
				comps.forEach(comp -> System.out.println(comp));
			}
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}