package com.leqcar.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@Entity
public class Valet {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dateTimeIn;

    private LocalDateTime dateTimeOut;

    private String parkingLot;

    private int parkingSpot;

    private String note;
    
    private String vehicleId;

    
	public Valet() {
		//noop
	}

	public Valet(LocalDateTime dateTimeIn, LocalDateTime dateTimeOut, String parkingLot, int parkingSpot,
			String note, String vehicleId) {
		super();
		this.dateTimeIn = dateTimeIn;
		this.dateTimeOut = dateTimeOut;
		this.parkingLot = parkingLot;
		this.parkingSpot = parkingSpot;
		this.note = note;
		this.vehicleId = vehicleId;
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

	@Override
	public String toString() {
		return "Valet [id=" + id + ", dateTimeIn=" + dateTimeIn + ", dateTimeOut=" + dateTimeOut + ", parkingLot="
				+ parkingLot + ", parkingSpot=" + parkingSpot + ", note=" + note + ", vehicleId=" + vehicleId + "]";
	}
       
}
