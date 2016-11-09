package com.leqcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ValetParkingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValetParkingServiceApplication.class, args);
	}
}
