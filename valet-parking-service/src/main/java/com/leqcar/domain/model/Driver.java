package com.leqcar.domain.model;

public class Driver {

	private String customerNumber;
	
	private String licenseNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;

	public Driver() {
		//noop
	}

	public Driver(String customerNumber, String licenseNumber, String firstName, String lastName, String mobileNumber) {
		this.customerNumber = customerNumber;
		this.licenseNumber = licenseNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public String toString() {
		return "Driver [customerNumber=" + customerNumber + ", licenseNumber=" + licenseNumber + ", firstName="
				+ firstName + ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}		
		
}
