package com.renatodoretto.examples.microservices.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.renatodoretto.examples.microservices.core.model"})
@EnableJpaRepositories(basePackages = {"com.renatodoretto.examples.microservices.core.repository"})
@SpringBootApplication(scanBasePackages = {"com.renatodoretto.examples.microservices"})
public class SpringBootCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourseApplication.class, args);
	}

}
