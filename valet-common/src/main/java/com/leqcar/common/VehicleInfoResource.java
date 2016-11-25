package com.leqcar.common;

public class VehicleInfoResource {

	private String plateNumber;
	
	private DriverInfoResource driverInfo;
	
	public VehicleInfoResource() {

	}

	public VehicleInfoResource(String plateNumber, DriverInfoResource driverInfo) {
		this.plateNumber = plateNumber;
		this.driverInfo = driverInfo;
	}

	public String getPlateNumber() {
		return plateNumber;
	}


	public DriverInfoResource getDriverInfo() {
		return driverInfo;
	}


	@Override
	public String toString() {
		return "VehicleInfoResource [plateNumber=" + plateNumber + ", driver=" + driverInfo + "]";
	}
}
