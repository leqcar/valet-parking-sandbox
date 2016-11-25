package com.leqcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leqcar.domain.model.Driver;
import com.leqcar.domain.model.Valet;
import com.leqcar.domain.model.ValetRepository;
import com.leqcar.domain.model.Vehicle;

@SpringBootApplication
public class ValetParkingServiceApplication {

	@Autowired
	private ValetRepository valetRepository;

	public static void main(String[] args) {
		SpringApplication.run(ValetParkingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner DummyValetRequestCLR() {
		return arg -> {
			Vehicle toyotaVehicle = new Vehicle("XYZ123"
					, new Driver("person1234"
							, "B-123XYZ"
							, "John"
							, "Doe"
							, "639178881818"));
			//Valet toyotaValetRequest = Valet.requestFor(toyotaVehicle);
			Valet toyotaValetRequest = new Valet(toyotaVehicle);
			valetRepository.save(toyotaValetRequest);
			valetRepository.findAll().forEach(System.out::println);
		};
	}
}
