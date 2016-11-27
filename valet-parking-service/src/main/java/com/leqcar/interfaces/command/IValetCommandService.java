package com.leqcar.interfaces.command;

import org.springframework.stereotype.Service;

import com.leqcar.common.ValetResponse;
import com.leqcar.domain.model.ValetAttendant;
import com.leqcar.domain.model.Vehicle;

@Service
public interface IValetCommandService {

	ValetResponse requestValet(Vehicle vehicle);
	
	ValetResponse cancelRequest(String valetId);

	ValetResponse acceptRequest(String valetId, ValetAttendant valetAttendant);

	ValetResponse confirm(String valetId, CoordinatesInfo coordinatesInfo);
}
