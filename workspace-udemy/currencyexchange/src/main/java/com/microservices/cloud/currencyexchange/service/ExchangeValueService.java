package com.microservices.cloud.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.cloud.currencyexchange.dao.ExchangeValueDAO;
import com.microservices.cloud.currencyexchange.model.ExchangeValue;

@Service
public class ExchangeValueService {

	@Autowired
	private ExchangeValueDAO dao;

	public ExchangeValue getExchangeValue(String from, String to) {
		return dao.findByFromAndTo(from, to);
	}

}
