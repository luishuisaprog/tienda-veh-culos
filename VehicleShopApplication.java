package com.example.VehicleShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class VehicleShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehicleShopApplication.class, args);
	}

}
