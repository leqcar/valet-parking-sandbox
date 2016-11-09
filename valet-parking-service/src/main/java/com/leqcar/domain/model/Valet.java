package com.leqcar.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@Entity
public class Valet {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate dateTimeIn;

    private LocalDate dateTimeOut;

    private String parkingLot;

    private int parkingSpot;

    private String note;

}
