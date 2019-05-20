package com.renatodoretto.examples.microservices.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@EntityScan(basePackages = {"com.renatodoretto.examples.microservices.currencyexchange.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.examples.microservices.currencyexchange.repository"})
@SpringBootApplication(scanBasePackages = {"com.renatodoretto.examples.microservices.currencyexchange"})
public class CurrencyExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
