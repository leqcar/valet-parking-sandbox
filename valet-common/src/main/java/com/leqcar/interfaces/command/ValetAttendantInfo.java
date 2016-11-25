package com.leqcar.interfaces.command;

import javax.validation.constraints.NotNull;

public class ValetAttendantInfo {

	@NotNull
	private String employeeNumber;
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String mobileNumber;

	public String getEmployeeNumber() {
		return employeeNumber;
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
	
	
}
