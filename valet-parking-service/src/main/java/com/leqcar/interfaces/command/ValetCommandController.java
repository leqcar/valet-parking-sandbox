package com.leqcar.interfaces.command;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.apache.commons.lang.Validate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.leqcar.common.DriverInfo;
import com.leqcar.common.ValetResponse;
import com.leqcar.common.VehicleInfo;
import com.leqcar.domain.model.Driver;
import com.leqcar.domain.model.ValetAttendant;
import com.leqcar.domain.model.ValetRepository;
import com.leqcar.domain.model.Vehicle;

@RestController
@RequestMapping("/valets")
public class ValetCommandController {

	private static final Logger LOG = Logger.getLogger(ValetCommandController.class.getName());
	
	private IValetCommandService valetCommandService;
	
	public ValetCommandController(IValetCommandService valetCommandService, ValetRepository valetRepository) {
		this.valetCommandService = valetCommandService;;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ValetResponse> requestValet(@RequestBody VehicleInfo vehicleInfo) {
		LOG.log(Level.INFO, "-- requesting valet service ---");
		
		Validate.notNull(vehicleInfo, "Vehicle should not be null");
		Validate.notNull(vehicleInfo.getDriverInfo(), "Vehicle should have a Driver");
		
		ValetResponse response = valetCommandService.requestValet(new Vehicle(vehicleInfo.getPlateNumber(), toDriverModel(vehicleInfo.getDriverInfo())));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(response.getValetId()).toUri();	
		
		response.add(linkTo(ValetCommandController.class)
				.slash(response.getValetId())
				.withSelfRel());
		response.add(linkTo(methodOn(ValetCommandController.class).cancelValetRequest(response.getValetId())).withRel("cancel"));
		response.add(linkTo(methodOn(ValetCommandController.class).acceptValetRequest(response.getValetId(), new ValetAttendantInfo())).withRel("accept"));
		
		return ResponseEntity.created(location).body(response);
		
	}
	
	private Driver toDriverModel(DriverInfo driver) {
		return new Driver(driver.getCustomerNumber()
				, driver.getLicenseNumber()
				, driver.getFirstName()
				, driver.getLastName()
				, driver.getMobileNumber());
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{valetId}/cancel")
	public ResponseEntity<ValetResponse> cancelValetRequest(@PathVariable("valetId") String valetId) {
		LOG.log(Level.INFO, "-- cancelling request ---");
		
		valetCommandService.cancelRequest(valetId);
		
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/{valetId}/accept")
	public ResponseEntity<ValetResponse> acceptValetRequest(@PathVariable("valetId") String valetId
			, @RequestBody @Valid ValetAttendantInfo valetAttendantInfo) {
		
		LOG.log(Level.INFO, "--- accepting request ---");
		Validate.notNull(valetAttendantInfo);
		
		ValetResponse response = valetCommandService.acceptRequest(valetId, createValetAttendant(valetAttendantInfo));
		
		response.add(linkTo(ValetCommandController.class)
				.slash(response.getValetId())
				.withRel("valet"));
		
		return ResponseEntity.ok(response);
	}

	private ValetAttendant createValetAttendant(ValetAttendantInfo input) {
		return new ValetAttendant(input.getEmployeeNumber()
				, input.getFirstName()
				, input.getLastName()
				, input.getMobileNumber());
	}

}
