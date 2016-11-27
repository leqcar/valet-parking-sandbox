package com.leqcar.domain.model;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * Created by jongtenerife on 26/11/2016.
 */
@Embeddable
public class Coordinates {

    private Double longitude;

    private Double latitude;

    public Coordinates() {
    }

    public Coordinates(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }
}


