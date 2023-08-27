package com.C_S_R.model;

public class Customer {

	private int cusId;
	private int productId;
	private String name;
	private String userName;
	private String password;
	
	public Customer() {}

	public Customer(int cusId, int deptid, String name, String userName, String password) {
		super();
		this.cusId = cusId;
		this.productId = deptid;
		this.name = name;
		this.userName = userName;
		this.password = password;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
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

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", deptid=" + productId + ", name=" + name + ", userName=" + userName
				+ ", password=" + password + "]";
	}

	
	
}