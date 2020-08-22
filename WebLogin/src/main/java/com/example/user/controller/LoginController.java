package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.user.service.LoginService;

@Controller
@SessionAttributes("name")


public class LoginController {
	
	@Autowired
	LoginService log;
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		
		return "login";
	}

	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showHello(ModelMap model, @RequestParam String username, @RequestParam String password ) {
		
		boolean isValidUser = log.validateUser(username, password);
		if(!isValidUser) {
			model.put("errormessage", "invalid");
			return "login";
			
			
		}
		model.put("name", username);
		model.put("password", password);
		return "hello";
	}
}
