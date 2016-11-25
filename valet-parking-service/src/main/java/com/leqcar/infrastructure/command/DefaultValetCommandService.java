package com.leqcar.infrastructure.command;

import org.springframework.stereotype.Service;

import com.leqcar.common.ValetResponse;
import com.leqcar.domain.model.Valet;
import com.leqcar.domain.model.ValetAttendant;
import com.leqcar.domain.model.ValetRepository;
import com.leqcar.domain.model.ValetStatus;
import com.leqcar.domain.model.Vehicle;
import com.leqcar.interfaces.command.IValetCommandService;

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
	public void cancelRequest(String valetId) {
		Valet valet = valetRepository.getOne(Long.parseLong(valetId));
		
		if (valet.getValetStatus().equals(ValetStatus.REQUESTED) & valet.isCancelAllowed()) {
			valetRepository.save(valet);
		}
	}

	@Override
	public ValetResponse acceptRequest(String valetId, ValetAttendant valetAttendant) {
		
		Valet valet = valetRepository.getOne(Long.parseLong(valetId));
		valet.assignValetAttendant(valetAttendant);
		
		if (valet.isAccepted()) {
			valetRepository.save(valet);
		}	
	 
		return buildValetResponse(valet);
	}
	
	private ValetResponse buildValetResponse(Valet valet) {
		ValetResponse response = new ValetResponse(valet.getId().toString()
				, valet.getValetStatus().toString());
		return response;
	}
}
