package com.app.dropshuttl.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.services.IUserService;

@Controller
@RequestMapping("/") 
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST,consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	public @ResponseBody  UserModel insertUser(@RequestBody UserModel user)
	{
		userService.create(user);
		logger.debug("Inside pintwelcom "+user.getUname());
		System.out.println("User "+user.getUname());
		return user;
	}



}
