package com.microservices.cloud.limitsService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.cloud.limitsService.model.LimitConfiguration;
import com.microservices.cloud.limitsService.util.Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration getLimitsFromConfiguration() {
		return new LimitConfiguration(configuration.getMaxmum(), configuration.getMinimum());
	}

	@GetMapping("/faulttolerance")
	@HystrixCommand(fallbackMethod = "fallbackGetConfiguration")
	public LimitConfiguration getConfiguration() {
		throw new RuntimeException("Not avaliable");
	}

	public LimitConfiguration fallbackGetConfiguration() {
		return new LimitConfiguration(9, 999);
	}

}
