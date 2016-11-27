package com.leqcar.infrastructure.command;

import com.leqcar.domain.model.*;
import com.leqcar.interfaces.command.CoordinatesInfo;
import org.springframework.stereotype.Service;

import com.leqcar.common.ValetResponse;
import com.leqcar.interfaces.command.IValetCommandService;

import java.math.BigDecimal;

@Service
public class DefaultValetCommandService implements IValetCommandService {

	private ValetRepository valetRepository;

	@Override
	public ValetResponse requestValet(Vehicle vehicle) {
		Valet valet = new Valet(vehicle);
		if (valet.hasVehicle()) {
			valetRepository.save(valet);
		}
		return buildValetResponse(valet);
	}
	
	public DefaultValetCommandService(ValetRepository valetRepository) {
		this.valetRepository = valetRepository;
	}

	@Override
	public ValetResponse cancelRequest(String valetId) {
		Valet valet = valetRepository.getOne(Long.parseLong(valetId));
		if (valet.isCancelAllowed()) {
			valetRepository.save(valet);
		}
		return new ValetResponse(valet.getId().toString(), valet.getValetStatus().toString());
	}

	@Override
	public ValetResponse acceptRequest(String valetId, ValetAttendant valetAttendant) {
		
		Valet valet = valetRepository.findOne(Long.parseLong(valetId));
		
		if (valet.isAccepted()) {
			valet.assignValetAttendant(valetAttendant);
			valetRepository.save(valet);
		}	
	 
		return buildValetResponse(valet);
	}

	@Override
	public ValetResponse confirm(String valetId, CoordinatesInfo coordinatesInfo) {

		Valet valet = valetRepository.findOne(Long.parseLong(valetId));

		Double longitude = coordinatesInfo.getLongitude();
		Double latitude = coordinatesInfo.getLatitude();
		if (valet.isConfirmed(longitude, latitude)) {
			valetRepository.save(valet);
		}
		return buildValetResponse(valet);
	}

	private ValetResponse buildValetResponse(Valet valet) {
		ValetResponse response = new ValetResponse(valet.getId().toString()
				, valet.getValetStatus().toString());

		if (valet.getClaimTicket() != null) {
			response.setTicketNumber(valet.getClaimTicket().getTicketNumber());
		}
		return response;
	}


}
