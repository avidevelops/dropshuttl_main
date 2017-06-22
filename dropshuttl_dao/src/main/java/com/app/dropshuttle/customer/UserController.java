package com.app.dropshuttle.customer;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView insertUser(@ModelAttribute("user") UserDao user,ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		
		         userService.addUser(user);
				return new ModelAndView("success", modelMap);
	}
	
}
