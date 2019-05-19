package com.renatodoretto.examples.microservices.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EntityScan(basePackages = {"com.renatodoretto.examples.microservices.currencyconversion.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.examples.microservices.currencyconversion.repository"})
@EnableFeignClients(basePackages = {"com.renatodoretto.examples.microservices.currencyconversion.proxy"})
@SpringBootApplication(scanBasePackages = {"com.renatodoretto.examples.microservices.currencyconversion"})
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}

}
