package com.microservices.cloud.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.cloud.currencyexchange.model.ExchangeValue;
import com.microservices.cloud.currencyexchange.service.ExchangeValueService;

@RestController
public class CurrencyExchangeController {

	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueService service;

	@GetMapping("/currencyexchange/from/{from}/to/{to}")
	public ExchangeValue getCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = service.getExchangeValue(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		logger.info("{}", exchangeValue);

		return exchangeValue;
	}

}
