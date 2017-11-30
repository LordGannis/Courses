package com.springweb.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springweb.UserValidationService;

@Controller
public class LoginController {

	@Autowired
	UserValidationService userValidationService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String name, @RequestParam String password, ModelMap map) {
		if (userValidationService.isUserValie(name, password)) {
			map.put("name", name);
			return "loginOk";
		} else {
			map.put("errorMessage", "Name or Password wrong! Please try again.");
			return "login";
		}
	}

}
