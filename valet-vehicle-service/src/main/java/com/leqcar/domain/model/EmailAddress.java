package com.leqcar.domain.model;

public class EmailAddress {

	private String address;

	public EmailAddress(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "EmailAddress [address=" + address + "]";
	}
				
}
