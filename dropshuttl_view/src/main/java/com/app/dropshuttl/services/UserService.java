package com.app.dropshuttl.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dropshuttl.customer.dao.impl.UserDaoImpl;
import com.app.dropshuttl.dto.UserMast;

@Transactional
@Service
public class UserService {

	@Autowired
	UserDaoImpl userDaoImpl;
	
	final static Logger logger = Logger.getLogger(UserService.class);
	@Transactional
	public void addUser(UserMast user)
	{
		userDaoImpl.addUser(user);
		//userRepository.save(user);
	}
	
}
