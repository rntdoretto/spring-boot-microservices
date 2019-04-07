package com.renatodoretto.examples.microservices.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.renatodoretto.examples.microservices.core.property.JwtConfiguration;

@SpringBootApplication
@EnableConfigurationProperties(value = JwtConfiguration.class)
@EntityScan(basePackages = {"com.renatodoretto.examples.microservices.core.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.examples.microservices.core.repository"})
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
