package com.leqcar.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@RepositoryRestResource(path = "vehicles")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @RestResource(path = "by-plateNumber")
    Vehicle findByPlateNumber(@Param("plateNumber") String plateNumber);
}
