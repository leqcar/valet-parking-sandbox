package com.leqcar.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private Long id;
	
	private String plateNumber;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private Driver driver;
	
	public Vehicle() {

	}

	public Vehicle(String plateNumber, Driver driver) {
		this.plateNumber = plateNumber;
		this.driver = driver;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public Driver getDriver() {
		return driver;
	}

	@Override
	public String toString() {
		return "Vehicle [plateNumber=" + plateNumber + ", driver=" + driver + "]";
	}
		
}
