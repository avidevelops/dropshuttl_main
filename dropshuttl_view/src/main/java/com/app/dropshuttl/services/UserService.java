package com.app.dropshuttl.services;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.customer.dao.UserDAO;
import com.app.dropshuttl.dto.UserMast;


@Service
public class UserService {

	@Autowired
	UserDAO userDaoImpl;
	
	final static Logger logger = Logger.getLogger(UserService.class);
	@Transactional
	public void addUser(UserMast user)
	{
		userDaoImpl.addUser(user);
		//userRepository.save(user);
	}
	
}
