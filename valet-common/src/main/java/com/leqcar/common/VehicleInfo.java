package com.leqcar.common;

public class VehicleInfo {

	private String plateNumber;
	
	private DriverInfo driverInfo;
	
	public VehicleInfo() {

	}

	public VehicleInfo(String plateNumber, DriverInfo driverInfo) {
		this.plateNumber = plateNumber;
		this.driverInfo = driverInfo;
	}

	public String getPlateNumber() {
		return plateNumber;
	}


	public DriverInfo getDriverInfo() {
		return driverInfo;
	}


	@Override
	public String toString() {
		return "VehicleInfo [plateNumber=" + plateNumber + ", driver=" + driverInfo + "]";
	}
}
