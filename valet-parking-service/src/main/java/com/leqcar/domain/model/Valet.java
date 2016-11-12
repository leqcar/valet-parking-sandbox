package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@Entity
public class Valet {

    @Id
    @GeneratedValue
    private Long id;

	private String ticketNumber;

    private LocalDateTime dateTimeIn;

    private LocalDateTime dateTimeOut;

    private String parkingLot;

    private int parkingSpot;

    private String note;
    
    private String vehicleId;

    
	public Valet() {
		//noop
	}

	public Valet(String parkingLot, int parkingSpot,
			String note, String vehicleId) {
		super();
		this.dateTimeIn = LocalDateTime.now();
		this.parkingLot = parkingLot;
		this.parkingSpot = parkingSpot;
		this.note = note;
		this.vehicleId = vehicleId;
		this.ticketNumber = generateTicketNumber();
	}

	private String generateTicketNumber() {
		return "REF-" + UUID.randomUUID().toString();
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

	public String getVehicleId() {
		return vehicleId;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	private void setDateTimeOut(LocalDateTime dateTimeOut) {
		this.dateTimeOut = dateTimeOut;
	}

	public void checkOut() {
		setDateTimeOut(LocalDateTime.now());
	}

	@Override
	public String toString() {
		return "Valet{" +
				"id=" + id +
				", ticketNumber='" + ticketNumber + '\'' +
				", dateTimeIn=" + dateTimeIn +
				", dateTimeOut=" + dateTimeOut +
				", parkingLot='" + parkingLot + '\'' +
				", parkingSpot=" + parkingSpot +
				", note='" + note + '\'' +
				", vehicleId='" + vehicleId + '\'' +
				'}';
	}
}
