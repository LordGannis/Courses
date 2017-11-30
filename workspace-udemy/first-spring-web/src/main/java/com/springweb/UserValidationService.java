package com.springweb;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	
	public boolean isUserValie(String name, String password) {
		if ((name != null && !name.equals("")) && (password != null && !password.equals(""))) {
			return true;
		} else {
			return false;
		}
	}
	
}
