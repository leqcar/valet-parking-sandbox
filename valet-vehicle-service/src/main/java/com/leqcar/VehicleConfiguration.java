package com.leqcar;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jongtenerife on 27/11/2016.
 */
@Profile("!local")
@Configuration
@EnableDiscoveryClient
@EnableEurekaClient
public class VehicleConfiguration {
}
