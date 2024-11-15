package com.example.CentralService_ApplianceStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CentralServiceApplianceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CentralServiceApplianceStoreApplication.class, args);
	}

}
