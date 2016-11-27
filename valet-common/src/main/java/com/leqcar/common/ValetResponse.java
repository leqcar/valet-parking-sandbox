package com.leqcar.common;

import com.leqcar.interfaces.command.CoordinatesInfo;
import org.springframework.hateoas.ResourceSupport;

public class ValetResponse extends ResourceSupport{

	private String valetId;
	
	private String valetStatus;

	private String ticketNumber;

	private CoordinatesInfo coordinatesInfo;

	public ValetResponse() {

	}
	
	public ValetResponse(String valetId, String valetStatus) {
		this.valetId = valetId;
		this.valetStatus = valetStatus;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public CoordinatesInfo getCoordinatesInfo() {
		return coordinatesInfo;
	}

	public void setCoordinatesInfo(CoordinatesInfo coordinatesInfo) {
		this.coordinatesInfo = coordinatesInfo;
	}

	public String getValetId() {
		return valetId;
	}

	public String getValetStatus() {
		return valetStatus;
	}
	
	
}
