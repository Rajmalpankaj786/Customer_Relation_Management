package com.C_S_R.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.C_S_R.exceptions.CustomerException;
import com.C_S_R.model.Complaints;
import com.C_S_R.model.Customer;
import com.C_S_R.model.ServiceProviderComplaintsDTO;
import com.C_S_R.util.DBUtil;
import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.exceptions.CustomerException;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public String registerCustomer(int productId, String name, String username, String password) throws CustomerException {
		String res = "Failed. Some details entered are incorrect. Please try again!";
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into Customer (prouctId,name,username,password)"
					+ "values(?,?,?,?)");
			ps.setInt(1, productId);
			ps.setString(2, name);
			ps.setString(3, username);
			ps.setString(4, password);
			
			int x = ps.executeUpdate();
			if(x>0) {
				res = "Registration Successfull.";
			}else {
				throw new CustomerException("Registration failed. Some entries maybe wrong.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public Customer loginCustomer(String username, String password) throws CustomerException {
		Customer emp = new Customer();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from Customer where username=?"
					+ "AND password = ?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				emp.setCusId(rs.getInt("cusId"));
				emp.setProductId(rs.getInt("productId"));
				emp.setName(rs.getString("name"));
				emp.setUserName(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
			}else {
				throw new CustomerException("Invalid username or password");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		
		return emp;
	}

	@Override
	public int raiseComplaint(int cusId, String compType) throws ComplaintException {
		int complaintId = 0;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("insert into complaints (complaintId,"
					+ "cusId, complaintType,status, dateRaised) values(?,?,?,?,?)");
			
			complaintId = (int) (Math.random()*10000);
			LocalDate dateRaised = LocalDate.now();
			
			ps.setInt(1, complaintId);
			ps.setInt(2, cusId);
			ps.setString(3, compType);
			ps.setString(4, "Raised");
			ps.setDate(5, java.sql.Date.valueOf(dateRaised));
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Complaint raised successfully");
			}else {
				throw new ComplaintException("Complaint could not be raised. Please try again.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return complaintId;
	}

	@Override
	public ServiceProviderComplaintsDTO checkComplaintStatus(int complaintId) throws ComplaintException {
		
		ServiceProviderComplaintsDTO dto = new ServiceProviderComplaintsDTO();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select c.complaintId, c.cusId, e.name,c.complaintType, c.status, c.dateRaised from complaints c INNER JOIN Customer e ON c.cusId=e.cusId where complaintId=?");
			
			ps.setInt(1, complaintId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto.setComplaintId(rs.getInt("complaintId"));
				dto.setComplaintType(rs.getString("complaintType"));
				
				dto.setCusId(rs.getInt("cusId"));
				dto.setName(rs.getString("name"));
				dto.setStatus(rs.getString("status"));
				dto.setDateRaised(rs.getDate("dateRaised"));
			}else {
				throw new ComplaintException("Complaint not assigned yet. Please check back later.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return dto;
	}

	@Override
	public List<Complaints> checkComplaintHistory(int cusId) throws ComplaintException {
		List<Complaints> complaints = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where cusId=?");
			
			ps.setInt(1, cusId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Complaints comp = new Complaints();
				comp.setComplaintId(rs.getInt("complaintId"));
				comp.setCusId(rs.getInt("cusId"));
				comp.setComplaintType(rs.getString("complaintType"));
				comp.setSerPId(rs.getInt("serpId"));
				comp.setStatus(rs.getString("status"));
				comp.setDateRaised(rs.getDate("dateRaised"));
				comp.setDateResolved(rs.getDate("dateResolved"));
				
				complaints.add(comp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return complaints;
	}

	@Override
	public String changeCustomerPassword(String username, String oldPassword, String newPassword) throws CustomerException {
		String res = "Password could not be changed. Please try again.";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update Customer set password=? where username=? and password=?");
			
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, oldPassword);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				res = "Password changed successfully.";
			}else {
				throw new CustomerException("Wrong username or password entered. Please try again.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CustomerException(e.getMessage());
		}
		
		return res;
	}

}
