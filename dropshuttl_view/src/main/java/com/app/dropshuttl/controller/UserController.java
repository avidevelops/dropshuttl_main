package com.app.dropshuttl.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.services.IUserService;
import com.app.dropshuttle.googleapis.UserGoogleProfileInfo;

@Controller
@RequestMapping("/")
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody UserModel insertUser(@RequestBody UserModel user, HttpSession session) {
		UserModel resp = null;
		if (userService.findByEmail(user.getUmailId()) != null)
			resp = userService.create(user);
		else {
			logger.debug("User Aready Exists with this emailID ");
			resp = userService.update(user);
		}
		logger.debug("Inside insertUser " + resp.getUname());

		session.setAttribute("loginuser", resp.getUname());
		return user;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody UserModel getUserInfo(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		request.getSession().setAttribute("username", username);
		UserModel usermodel = new UserModel();
		usermodel.setUname(username);
		return usermodel;
	}

	@RequestMapping(value = "/tokensignin", method = RequestMethod.POST)
	public @ResponseBody UserModel getUserInfo(@RequestParam String idtoken, HttpServletRequest request,
			HttpServletResponse response) {

		UserModel socialUser = null;
		UserModel user = null;
		UserGoogleProfileInfo profile = new UserGoogleProfileInfo();
		try {
			socialUser = profile.getUserGoogleProfileDetails(idtoken);


			request.getSession().setAttribute("username", user.getUname());
		} catch (GeneralSecurityException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		logger.debug("user_id ");
		return user;

	}
	
	@RequestMapping(value = "/fbSignin", method = RequestMethod.POST,produces = { "application/json;charset=UTF-8" })
	public @ResponseBody UserModel getFbUserInfo(@RequestBody UserModel data, HttpServletRequest request,
			HttpServletResponse response) {
		UserModel user=null;
		if (userService.findByEmail(data.getUmailId()) ==null) {
			
			user = userService.create(data);
		} else

		{
			logger.debug("User already exists with this mail ID");
			user = userService.update(data);
		}		
		return null;
		
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logoutPage(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	   //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
