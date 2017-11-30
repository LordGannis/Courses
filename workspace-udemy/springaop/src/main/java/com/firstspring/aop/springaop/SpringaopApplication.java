package com.firstspring.aop.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.firstspring.aop.springaop.business.Business;
import com.firstspring.aop.springaop.business.OtherBusiness;

@SpringBootApplication
public class SpringaopApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringaopApplication.class);

	@Autowired
	Business business;

	@Autowired
	OtherBusiness otherBusiness;

	public static void main(String[] args) {
		SpringApplication.run(SpringaopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(business.calculateSomething());
		logger.info(otherBusiness.calculateSomething());
	}
}
