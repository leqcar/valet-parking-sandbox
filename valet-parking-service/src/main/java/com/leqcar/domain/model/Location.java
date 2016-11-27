package com.leqcar.domain.model;

import javax.persistence.*;

/**
 * Created by jongtenerife on 26/11/2016.
 */
@Entity
public class Location {

    @Id @GeneratedValue
    private Long id;

    private String address;

    private String landmark;

    @Embedded
    private Coordinates coordinates;

    public Location() {
    }

    public Location(String address, String landmark, Coordinates coordinates) {
        this.address = address;
        this.landmark = landmark;
        this.coordinates = coordinates;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getLandmark() {
        return landmark;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
