package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String make;

    private String model;

    private int year;

    private String type;

    private String color;

    private int mileage;

    public Vehicle(Long id, String make, String model, int year, String type, String color, int mileage) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.color = color;
        this.mileage = mileage;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getMileage() {
        return mileage;
    }
}
