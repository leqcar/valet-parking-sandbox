package com.leqcar;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.leqcar.domain.model.Vehicle;
import com.leqcar.domain.model.VehicleRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class VehicleServiceApplication {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(VehicleServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner DummyVehicleCLR() {
		return r -> {
			Vehicle toyotaVios = new Vehicle("Toyota", "Vios", 2016, "Automatic", "Gray", 0, "ABC123");
			Vehicle toyotaAltis = new Vehicle("Toyota", "Corolla Altis", 2016, "Automatic", "Black", 0, "DEF123");
			
			List<Vehicle> vehicles = Arrays.asList(toyotaAltis, toyotaVios);
			vehicles.stream().forEach(v -> vehicleRepository.save(v));
			
			vehicleRepository.findAll().forEach(System.out::println);
		};
	}
}
