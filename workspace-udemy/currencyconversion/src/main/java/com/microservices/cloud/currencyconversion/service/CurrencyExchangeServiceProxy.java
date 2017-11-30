package com.microservices.cloud.currencyconversion.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.cloud.currencyconversion.model.CurrencyConversion;

//@FeignClient(name="currencyexchange", url="localhost:8000")
//@FeignClient(name="currencyexchange")
@FeignClient(name="zuulgateway")
@RibbonClient(name="currencyexchange")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currencyexchange/currencyexchange/from/{from}/to/{to}")
	public CurrencyConversion getCurrencyExchange(@PathVariable("from") String from, @PathVariable("to") String to);

}
