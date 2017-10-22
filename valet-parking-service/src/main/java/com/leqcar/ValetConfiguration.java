package com.leqcar;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("!local")
@Configuration
@EnableEurekaClient
public class ValetConfiguration {

}
