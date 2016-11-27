package com.leqcar.domain.model;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import javax.persistence.*;

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
	@JoinColumn
	private ClaimTicket claimTicket;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private ValetAttendant valetAttendant;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Location location;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn
	private Vehicle vehicle;

	@Enumerated(EnumType.STRING)
	private ValetStatus valetStatus = ValetStatus.REQUESTED;
	
	private LocalDateTime dateTimeOccurred = LocalDateTime.now();
	
    private LocalDateTime dateTimeIn;

    private LocalDateTime dateTimeOut;

    private String parkingLot;

    private int parkingSpot;

    private String note;

    
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
			, LocalDateTime dateTimeOccurred) {
		this.claimTicket = claimTicket;
		this.dateTimeIn = dateTimeIn;
		this.dateTimeOut = dateTimeOut;
		this.parkingLot = parkingLot;
		this.parkingSpot = parkingSpot;
		this.note = note;
		this.vehicle = vehicle;
		this.valetStatus = valetStatus;
		this.dateTimeOccurred = dateTimeOccurred;
	}
	
	public Valet(Vehicle vehicle) {
		this.vehicle = vehicle;
		this.valetStatus =  ValetStatus.REQUESTED;
		this.dateTimeOccurred = LocalDateTime.now();
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
		if (this.valetStatus.equals(ValetStatus.REQUESTED) ||
				this.valetStatus.equals(ValetStatus.ACCEPTED)) {
			if (isWithinGracePeriod()) {
				setValetStatus(ValetStatus.CANCELLED);
				return true;
			}
		}
		return false;
	}
	
	@Transient
	private boolean isWithinGracePeriod() {
		Long result=this.dateTimeOccurred.until(LocalDateTime.now(), ChronoUnit.MINUTES);
		return result > GRACE_PERIOD_30MINS ? false : true;
	}

	@Transient
	public boolean isConfirmed(Double longitude, Double latitude) {
		if (this.valetStatus.equals(ValetStatus.ACCEPTED)) {
			if (isWithinGracePeriod()) {
				toCoordinates(longitude, latitude);
				setValetStatus(ValetStatus.CONFIRMED);
				return true;
			}
		}
		return false;
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
		
	public LocalDateTime getDateTimeOccured() {
		return dateTimeOccurred;
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

	public void toCoordinates(Double longitude, Double latitude) {
		if (location == null) {
			location = new Location(null
					, null
					, new Coordinates(longitude, latitude));
		} else {
			location.setCoordinates(new Coordinates(longitude, latitude));
		}
	}

	public Location getLocation() {
		return location;
	}
}
