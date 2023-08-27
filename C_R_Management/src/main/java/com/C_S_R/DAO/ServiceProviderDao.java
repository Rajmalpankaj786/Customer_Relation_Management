package com.C_S_R.DAO;

import java.util.List;

import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.exceptions.ServiceProviderException;
import com.C_S_R.model.Complaints;
import com.C_S_R.model.ServiceProvider;


public interface ServiceProviderDao {
	
	public ServiceProvider loginServiceProvider(String username, String password) throws ServiceProviderException;
	
	public List<Complaints> checkAssignedComplaints(int engId) throws ComplaintException;
	
	public String updateComplaintStatus(int complaintId, String newStatus) throws ComplaintException;
	
	public List<Complaints> checkComplaintsAttended(int engId) throws ComplaintException;
	
	public String changeServiceProviderPassword(String username, String oldPassword, String newPassword) throws ServiceProviderException;
}