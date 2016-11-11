package com.leqcar.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by jongtenerife on 09/11/2016.
 */
@RepositoryRestResource
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
