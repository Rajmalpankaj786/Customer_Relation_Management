package com.C_S_R.model;

import java.sql.Date;
//import java.util.Date;

public class ServiceProviderComplaintsDTO {
	
	private int serpId;
	private String name;
	private String userName;
	private String password;
	private String type;
	private String location;
	private int complaintId;
	private int cusId;
	private String complaintType;
	private String status;
	private Date dateRaised;
	private String dateResolved;

	public ServiceProviderComplaintsDTO() {}

	public ServiceProviderComplaintsDTO(int engId, String name, String userName, String password, String type, String location,
			int complaintId, int empId, String complaintType, String status, Date dateRaised, String dateResolved) {
		super();
		this.serpId = engId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.location = location;
		this.complaintId = complaintId;
		this.cusId = empId;
		this.complaintType = complaintType;
		this.status = status;
		this.dateRaised = dateRaised;
		this.dateResolved = dateResolved;
	}

	public int getSerPId() {
		return serpId;
	}

	public void setSerPId(int engId) {
		this.serpId = engId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int empId) {
		this.cusId = empId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateRaised() {
		return dateRaised;
	}

	public void setDateRaised(Date date) {
		this.dateRaised = date;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

	@Override
	public String toString() {
		return "ServiceProviderComplaintsDTO [serpId=" + serpId + ", name=" + name + ", userName=" + userName
				+ ", password=" + password + ", type=" + type + ", location=" + location + ", complaintId="
				+ complaintId + ", cusId=" + cusId + ", complaintType=" + complaintType + ", status=" + status
				+ ", dateRaised=" + dateRaised + ", dateResolved=" + dateResolved + "]";
	}


	
}
