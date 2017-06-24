package com.app.dropshuttl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttle.customer.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		model.addAttribute("message", "Spring 3 MVC Hello World");
		return "login";

	}

	@RequestMapping(value = "/dropshuttl_view/addUser", method = RequestMethod.POST)
	public ResponseEntity<Void> insertUser(@ModelAttribute("user") UserModel user)
			 {
		System.out.println("User "+user);
		   
		return new ResponseEntity<Void>(HttpStatus.OK);
				
	}
	
}
