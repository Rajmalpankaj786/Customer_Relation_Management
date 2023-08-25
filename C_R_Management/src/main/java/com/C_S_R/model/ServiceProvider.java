package com.C_S_R.model;

public class ServiceProvider {
	
	private int serpId;
	private String name;
	private String userName;
	private String password;
	private String type;
	private String location;
	
	public ServiceProvider() {}

	public ServiceProvider(int spId, String name, String userName, String password, String type, String location) {
		this.serpId = spId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.location = location;
	}

	public int getSerpId() {
		return serpId;
	}

	public void setSerpId(int engId) {
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

	@Override
	public String toString() {
		return "Engineer [engId=" + serpId + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", type=" + type + ", location=" + location + "]";
	}
	
	
}