package com.firstspring.aop.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.aop.springaop.data.DAO;

@Service
public class Business {

	@Autowired
	private DAO dao;

	public String calculateSomething() {
		return dao.getSomething();
	}

}
