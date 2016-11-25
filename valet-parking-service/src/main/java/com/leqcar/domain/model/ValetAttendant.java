package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ValetAttendant {

	@Id
	@GeneratedValue
	private Long id;
	
	private String employeeNumber;
	
	private String firstName;
	
	private String lastName;
	
	private String mobileNumber;

	
	public ValetAttendant() {
	}


	public ValetAttendant(String employeeNumber, String firstName, String lastName, String mobileNumber) {
		super();
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
	}


	@Override
	public String toString() {
		return "ValetAttendant [id=" + id + ", employeeNumber=" + employeeNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + "]";
	}


	public Long getId() {
		return id;
	}


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
