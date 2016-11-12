package com.leqcar.interfaces;

import com.leqcar.domain.model.Vehicle;
import com.leqcar.domain.model.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jongtenerife on 12/11/2016.
 */
//@RestController
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    //@Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    //@RequestMapping(method = RequestMethod.POST)
    public Vehicle save(@RequestBody Vehicle vehicle) {

        return this.vehicleRepository.save(vehicle);

    }

    //@RequestMapping(method =  RequestMethod.GET)
    public Vehicle showVehicle(@PathVariable String plateNumber) {
        return this.vehicleRepository.findByPlateNumber(plateNumber);
    }
}
