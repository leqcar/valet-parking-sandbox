package com.leqcar.domain.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id @GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private EmailAddress emailAddress;
	
	@OneToMany
	private Set<Vehicle> vehicles;

	public Customer(String firstName, String lastName, EmailAddress emailAddress, Set<Vehicle> vehicles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.vehicles = vehicles;
	}

	
	public Long getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public EmailAddress getEmailAddress() {
		return emailAddress;
	}


	public Set<Vehicle> getVehicles() {
		return vehicles;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + ", vehicles=" + vehicles + "]";
	}
	
	
	
}
