package com.firstspring.aop.springaop.data;

import org.springframework.stereotype.Repository;

@Repository
public class OtherDAO {

	public String getSomething() {
		return "OtherDAO call";
	}

}
