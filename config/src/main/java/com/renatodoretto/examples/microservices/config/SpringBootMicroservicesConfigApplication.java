package com.renatodoretto.examples.microservices.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringBootMicroservicesConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMicroservicesConfigApplication.class, args);
	}

}
