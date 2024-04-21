package com.andersontiban.petsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PetsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetsServiceApplication.class, args);
	}

}
