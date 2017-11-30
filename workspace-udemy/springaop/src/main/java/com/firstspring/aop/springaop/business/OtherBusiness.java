package com.firstspring.aop.springaop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.aop.springaop.data.OtherDAO;

@Service
public class OtherBusiness {

	@Autowired
	private OtherDAO otherDAO;

	public String calculateSomething() {
		return otherDAO.getSomething();
	}

}
