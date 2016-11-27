package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmailAddress {

	@Id
	@GeneratedValue
	private Long id;

	private String address;

	public EmailAddress() {
	}

	public EmailAddress(String address) {
		super();
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "EmailAddress [address=" + address + "]";
	}
				
}
