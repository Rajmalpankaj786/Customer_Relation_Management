package com.C_S_R.DAO;

import java.util.List;

import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.exceptions.CustomerException;
import com.C_S_R.model.Complaints;
import com.C_S_R.model.Customer;
import com.C_S_R.model.ServiceProviderComplaintsDTO;


public interface CustomerDao {

	public String registerCustomer(int deptid, String name, String username, String password) throws CustomerException;
	
	public Customer loginCustomer(String username, String password) throws CustomerException;
	
	public int raiseComplaint(int empId, String compType) throws ComplaintException;
	
	public ServiceProviderComplaintsDTO checkComplaintStatus(int complaintId) throws ComplaintException;
	
	public List<Complaints> checkComplaintHistory(int empId) throws ComplaintException;
	
	public String changeCustomerPassword(String username, String oldPassword, String newPassword) throws CustomerException;
	
}
