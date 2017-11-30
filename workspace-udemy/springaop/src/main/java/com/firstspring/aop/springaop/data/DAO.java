package com.firstspring.aop.springaop.data;

import org.springframework.stereotype.Repository;

import com.firstspring.aop.springaop.aspect.annotation.TrackTime;

@Repository
public class DAO {

	@TrackTime
	public String getSomething() {
		return "DAO call";
	}

}
