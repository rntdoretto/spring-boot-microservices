package com.renatodoretto.examples.microservices.limits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class LimitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsApplication.class, args);
	}

}
