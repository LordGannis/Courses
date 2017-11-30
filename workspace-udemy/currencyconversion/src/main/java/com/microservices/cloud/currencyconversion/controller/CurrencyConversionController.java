package com.microservices.cloud.currencyconversion.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.cloud.currencyconversion.model.CurrencyConversion;
import com.microservices.cloud.currencyconversion.service.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {

	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	private CurrencyExchangeServiceProxy proxy;

	@GetMapping("/currencyconversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyExchange(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		// Feign - Problem 1 - REST Service client
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currencyexchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = responseEntity.getBody();
		currencyConversion.setQuantity(quantity);
		currencyConversion
				.setTotalAmount(currencyConversion.getQuantity().multiply(currencyConversion.getConversionMultiple()));

		logger.info("{}", currencyConversion);

		return currencyConversion;
	}

	@GetMapping("/currencyconversion/feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion getCurrencyExchangeFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion currencyConversion = proxy.getCurrencyExchange(from, to);
		currencyConversion.setQuantity(quantity);
		currencyConversion
				.setTotalAmount(currencyConversion.getQuantity().multiply(currencyConversion.getConversionMultiple()));

		logger.info("{}", currencyConversion);

		return currencyConversion;
	}

}
