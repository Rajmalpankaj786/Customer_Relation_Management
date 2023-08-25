package com.C_S_R.model;

import java.sql.Date;

public class Complaints {

	private int complaintId;
	private int cusId;
	private String complaintType;
	private int serpId;
	private String status;
	private Date dateRaised;
	private Date dateResolved;
	
	public Complaints() {}

	public Complaints(int complaintId, int empId, String complaintType, int engId, String status, Date dateRaised,
			Date dateResolved) {
		super();
		this.complaintId = complaintId;
		this.cusId = empId;
		this.complaintType = complaintType;
		this.serpId = engId;
		this.status = status;
		this.dateRaised = dateRaised;
		this.dateResolved = dateResolved;
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

	public void setDateRaised(Date date) {
		this.dateRaised = date;
	}

	public Date getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(Date date) {
		this.dateResolved = date;
	}

	@Override
	public String toString() {
		return "Complaints [complaintId=" + complaintId + ", cusId=" + cusId + ", complaintType=" + complaintType
				+ ", serpId=" + serpId + ", status=" + status + ", dateRaised=" + dateRaised + ", dateResolved="
				+ dateResolved + "]";
	}

	
	
	
}