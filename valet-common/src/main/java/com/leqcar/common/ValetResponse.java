package com.leqcar.common;

import org.springframework.hateoas.ResourceSupport;

public class ValetResponse extends ResourceSupport{

	private String valetId;
	
	private String valetStatus;
	
	public ValetResponse() {

	}
	
	public ValetResponse(String valetId, String valetStatus) {
		this.valetId = valetId;
		this.valetStatus = valetStatus;
	}

	public String getValetId() {
		return valetId;
	}

	public String getValetStatus() {
		return valetStatus;
	}
	
	
}
