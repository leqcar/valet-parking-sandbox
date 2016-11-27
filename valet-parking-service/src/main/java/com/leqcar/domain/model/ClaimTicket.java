package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class ClaimTicket {

	@Id
	@GeneratedValue
	private Long id;
	
	private String ticketNumber;
	
	public ClaimTicket() {

	}

	public ClaimTicket(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}
	
}
