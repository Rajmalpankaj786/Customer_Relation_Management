package com.C_S_R.model;

import java.util.Date;

public class CustomerComplaintsDTO {
	
	private int cusId;
	private int productId;
	private String name;
	private String userName;
	private String password;
	private int complaintId;
	private String complaintType;
	private int serpId;
	private String status;
	private Date dateRaised;
	private String dateResolved;
	
	public CustomerComplaintsDTO() {}

	public CustomerComplaintsDTO(int empId, int deptid, String name, String userName, String password, int complaintId,
			String complaintType, int engId, String status, Date dateRaised, String dateResolved) {
		this.cusId = empId;
		this.productId = deptid;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.complaintId = complaintId;
		this.complaintType = complaintType;
		this.serpId = engId;
		this.status = status;
		this.dateRaised = dateRaised;
		this.dateResolved = dateResolved;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int empId) {
		this.cusId = empId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int deptid) {
		this.productId = deptid;
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

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public int getSerPId() {
		return serpId;
	}

	public void setSerPId(int engId) {
		this.serpId = engId;
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

	public void setDateRaised(Date dateRaised) {
		this.dateRaised = dateRaised;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

	@Override
	public String toString() {
		return "CustomerComplaintsDTO [cusId=" + cusId + ", productId=" + productId + ", name=" + name + ", userName="
				+ userName + ", password=" + password + ", complaintId=" + complaintId + ", complaintType="
				+ complaintType + ", serpId=" + serpId + ", status=" + status + ", dateRaised=" + dateRaised
				+ ", dateResolved=" + dateResolved + "]";
	}

	
	
	
	
}