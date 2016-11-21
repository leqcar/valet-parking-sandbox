package com.leqcar.domain.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by jongtenerife on 12/11/2016.
 */
@RepositoryRestResource(path = "valets")
public interface ValetRepository extends JpaRepository<Valet, Long> {

    @RestResource(path = "by-ticketNumber")
    Valet findByClaimTicketTicketNumber(@Param("ticketNumber") String ticketNumber);
}
