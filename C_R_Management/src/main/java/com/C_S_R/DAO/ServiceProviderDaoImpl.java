package com.C_S_R.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.C_S_R.exceptions.ComplaintException;
import com.C_S_R.exceptions.ServiceProviderException;
import com.C_S_R.model.Complaints;
import com.C_S_R.model.ServiceProvider;

//import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.C_S_R.util.DBUtil;

public class ServiceProviderDaoImpl implements ServiceProviderDao{

	@Override
	public ServiceProvider loginServiceProvider(String username, String password) throws ServiceProviderException {
		ServiceProvider eng = new ServiceProvider();
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select * from ServiceProvider where username=? AND password=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				eng.setSerpId(rs.getInt("serpId"));
				eng.setName(rs.getString("name"));
				eng.setUserName(rs.getString("username"));
				eng.setPassword(rs.getString("password"));
				eng.setType(rs.getString("type"));
				eng.setLocation(rs.getString("location"));
			}else {
				throw new ServiceProviderException("Invalid username or password. Please try again.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceProviderException(e.getMessage());
		}
		return eng;
	}

	@Override
	public List<Complaints> checkAssignedComplaints(int engId) throws ComplaintException {
		List<Complaints> complaintsAssigned = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where serpId=? AND status='Assigned'");
			
			ps.setInt(1, engId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Complaints comp = new Complaints();
				
				comp.setComplaintId(rs.getInt("complaintId"));
				comp.setCusId(rs.getInt("empId"));
				comp.setComplaintType(rs.getString("complaintType"));
				comp.setSerPId(rs.getInt("engId"));
				comp.setStatus(rs.getString("status"));
				comp.setDateRaised(rs.getDate("dateRaised"));
				comp.setDateResolved(rs.getDate("dateResolved"));
				
				complaintsAssigned.add(comp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return complaintsAssigned;
	}

	@Override
	public String updateComplaintStatus(int complaintId, String newStatus) throws ComplaintException {
		String res = "Could not find any complaints. Please check complaintId and try again.";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			int x = 0;
			
			if(newStatus.equals("Resolved")) {
				PreparedStatement ps = conn.prepareStatement("update complaints set status=?, dateResolved=? where complaintId=?");
				
				LocalDate dateResolved = LocalDate.now();
				
				ps.setString(1, newStatus);
				ps.setDate(2, java.sql.Date.valueOf(dateResolved));
				ps.setInt(3, complaintId);
				
				x = ps.executeUpdate();
				
			}else {
				PreparedStatement ps = conn.prepareStatement("update complaints set status=?,dateResolved=null where complaintId=?");
				
				ps.setString(1, newStatus);
				ps.setInt(2, complaintId);
				
				x = ps.executeUpdate();
			}
			
			if(x>0) {
				res = "Status set to "+ newStatus +" for complaintId "+ complaintId;
			}else {
				throw new ComplaintException("Could not find complaint with complaintid "+ complaintId +" Please try again.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		return res;
	}

	@Override
	public List<Complaints> checkComplaintsAttended(int engId) throws ComplaintException {
		List<Complaints> complaints = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from complaints where serpId=?");
			
			ps.setInt(1, engId);
			
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
			e.printStackTrace();
		}
		
		return complaints;
	}

	@Override
	public String changeServiceProviderPassword(String username, String oldPassword, String newPassword) throws ServiceProviderException {
String res = "Password could not be changed. Please try again.";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update ServiceProvider set password=? where username=? and password=?");
			
			ps.setString(1, newPassword);
			ps.setString(2, username);
			ps.setString(3, oldPassword);
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				res = "Password changed successfully.";
			}else {
				throw new ServiceProviderException("Wrong username or password entered. Please try again.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceProviderException(e.getMessage());
		}
		
		return res;
	}

}