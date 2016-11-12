package com.leqcar;

import com.leqcar.domain.model.Valet;
import com.leqcar.domain.model.ValetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ValetParkingServiceApplication {

	@Autowired
	private ValetRepository valetRepository;

	public static void main(String[] args) {
		SpringApplication.run(ValetParkingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner DummyValetCLR() {
		return arg -> {
			Valet toyotaValetOne = new Valet("Basement 1", 25,
			null, "XYZ123");

			valetRepository.save(toyotaValetOne);
			valetRepository.findAll().forEach(System.out::println);

		};
	}
}
