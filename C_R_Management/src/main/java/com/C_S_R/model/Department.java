package com.C_S_R.model;

public class Department {
	 
	private int productId;
	private String dName;
	private String location;
	
	public Department() {}

	public Department(int deptid, String dName, String location) {
		super();
		this.productId = deptid;
		this.dName = dName;
		this.location = location;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int deptid) {
		this.productId = deptid;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [productId=" + productId + ", dName=" + dName + ", location=" + location + "]";
	}

	
}