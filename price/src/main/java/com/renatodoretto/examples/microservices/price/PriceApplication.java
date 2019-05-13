package com.renatodoretto.examples.microservices.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.renatodoretto.examples.microservices.core.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.examples.microservices.core.repository"})
@SpringBootApplication(scanBasePackages = {"com.renatodoretto.examples.microservices"})
public class PriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApplication.class, args);
	}

}
