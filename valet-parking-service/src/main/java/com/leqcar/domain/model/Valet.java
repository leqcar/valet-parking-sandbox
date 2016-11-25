package com.leqcar.domain.model;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private ClaimTicket claimTicket;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	private ValetAttendant valetAttendant;

	@Enumerated(EnumType.STRING)
	private ValetStatus valetStatus = ValetStatus.REQUESTED;
	
	private LocalDateTime dateTimeOccured = LocalDateTime.now();
	
    private LocalDateTime dateTimeIn;

    private LocalDateTime dateTimeOut;

    private String parkingLot;

    private int parkingSpot;

    private String note;
    
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
    private Vehicle vehicle;
    
	public Valet() {
		//noop
	}

	public Valet(ClaimTicket claimTicket
			, LocalDateTime dateTimeIn
			, LocalDateTime dateTimeOut
			, String parkingLot
			, int parkingSpot
			, String note
			, Vehicle vehicle
			, ValetStatus valetStatus
			, LocalDateTime dateTimeOccured) {
		this.claimTicket = claimTicket;
		this.dateTimeIn = dateTimeIn;
		this.dateTimeOut = dateTimeOut;
		this.parkingLot = parkingLot;
		this.parkingSpot = parkingSpot;
		this.note = note;
		this.vehicle = vehicle;
		this.valetStatus = valetStatus;
		this.dateTimeOccured = dateTimeOccured;
	}
	
	public Valet(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.valetStatus =  ValetStatus.REQUESTED;
		this.dateTimeOccured = LocalDateTime.now();
	}

	@Transient
	public boolean isAccepted() {
		if (this.valetStatus.equals(ValetStatus.REQUESTED)) {
			if (isWithinGracePeriod()) {
				generateTicketNumber();
				setValetStatus(ValetStatus.ACCEPTED);
				return true;
			}
		}
		return false;
	}

	private void generateTicketNumber() {
		this.claimTicket =  new ClaimTicket(UUID.randomUUID().toString());
	}
	
	@Transient
	public boolean isCancelAllowed() {
		if (this.valetStatus.equals(ValetStatus.REQUESTED)) {
			if (isWithinGracePeriod()) {
				setValetStatus(ValetStatus.CANCELLED);
				return true;
			}
		}
		return false;
	}
	
	@Transient
	private boolean isWithinGracePeriod() {
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

	public boolean hasVehicle() {
		if (this.vehicle == null || this.vehicle.getDriver() == null) {
			return false;
		}
		return true;
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
				", valetStatus='" + valetStatus + '\'' +				
				'}';
	}

	private void setValetStatus(ValetStatus status) {
		this.valetStatus = status;
	}

	public void assignValetAttendant(ValetAttendant assignedValetAttendant) {
		this.valetAttendant = assignedValetAttendant;
	}
}
