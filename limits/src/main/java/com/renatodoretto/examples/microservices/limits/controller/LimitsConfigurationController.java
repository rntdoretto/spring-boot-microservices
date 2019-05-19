package com.renatodoretto.examples.microservices.limits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatodoretto.examples.microservices.limits.configuration.Configuration;
import com.renatodoretto.examples.microservices.limits.model.LimitConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
	}
}
