package com.leqcar.domain.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@Entity
public class Valet {

	//TODO: move to property file
    private static final int GRACE_PERIOD_30MINS = 30;

	@Id
    @GeneratedValue
    private Long id;

	private ClaimTicket claimTicket;
	
	private ValetAttendant valetAttendant;

	private ValetStatus valetStatus;
	
	private ValetEvent valetEvent;
	
	private LocalDateTime dateTimeOccured;
	
    private LocalDateTime dateTimeIn;

    private LocalDateTime dateTimeOut;

    private String parkingLot;

    private int parkingSpot;

    private String note;
    
    private Vehicle vehicle;
    
	public Valet() {
		//noop
	}


	public Valet(ClaimTicket claimTicket, LocalDateTime dateTimeIn, LocalDateTime dateTimeOut, String parkingLot,
			int parkingSpot, String note, Vehicle vehicle) {
		super();
		this.claimTicket = claimTicket;
		this.dateTimeIn = dateTimeIn;
		this.dateTimeOut = dateTimeOut;
		this.parkingLot = parkingLot;
		this.parkingSpot = parkingSpot;
		this.note = note;
		this.vehicle = vehicle;
	}

	public Valet(Vehicle vehicle, ValetEvent valetEvent, ValetStatus valetStatus) {
		this.vehicle = vehicle;
		this.valetEvent = valetEvent;
		this.valetStatus = valetStatus;
	}

	public Valet requestValet(Vehicle vehicle, ValetEvent valetEvent) {
		return new Valet(vehicle, valetEvent, ValetStatus.REQUESTED);
	}
	
	public Valet cancelValet(Vehicle vehicle, ValetEvent valetEvent) {
		return new Valet(vehicle, valetEvent, ValetStatus.CANCELLED);
	}
	
	public boolean isWithinGracePeriod() {
		Long result=this.dateTimeOccured.until(LocalDateTime.now(), ChronoUnit.MINUTES);
		return result > GRACE_PERIOD_30MINS ? false : true;
	}
	
	public Long getId() {
		return id;
	}

	public LocalDateTime getDateTimeIn() {
		return dateTimeIn;
	}

	public LocalDateTime getDateTimeOut() {
		return dateTimeOut;
	}

	public String getParkingLot() {
		return parkingLot;
	}

	public int getParkingSpot() {
		return parkingSpot;
	}
 
	public String getNote() {
		return note;
	}

	public ClaimTicket getClaimTicket() {
		return claimTicket;
	}


	public ValetAttendant getValetAttendant() {
		return valetAttendant;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	private void setDateTimeOut(LocalDateTime dateTimeOut) {
		this.dateTimeOut = dateTimeOut;
	}

	public void checkOut() {
		setDateTimeOut(LocalDateTime.now());
	}
		
	public LocalDateTime getDateTimeRequested() {
		return dateTimeOccured;
	}

	public ValetStatus getValetStatus() {
		return valetStatus;
	}

	@Override
	public String toString() {
		return "Valet{" +
				"id=" + id +
				", ClaimTicket='" + claimTicket + '\'' +
				", dateTimeIn=" + dateTimeIn +
				", dateTimeOut=" + dateTimeOut +
				", parkingLot='" + parkingLot + '\'' +
				", parkingSpot=" + parkingSpot +
				", note='" + note + '\'' +
				", vehicle='" + vehicle + '\'' +
				'}';
	}
}
