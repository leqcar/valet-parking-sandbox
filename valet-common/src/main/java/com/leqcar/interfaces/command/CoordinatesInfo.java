package com.leqcar.interfaces.command;

import javax.validation.constraints.NotNull;

/**
 * Created by jongtenerife on 26/11/2016.
 */
public class CoordinatesInfo {

    @NotNull
    private double longitude;

    @NotNull
    private double latitude;

    public CoordinatesInfo() {
    }

    public CoordinatesInfo(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
