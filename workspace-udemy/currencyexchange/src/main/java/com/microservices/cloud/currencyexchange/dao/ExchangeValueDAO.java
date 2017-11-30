package com.microservices.cloud.currencyexchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.cloud.currencyexchange.model.ExchangeValue;

@Repository
public interface ExchangeValueDAO extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);
	
}
