package com.app.dropshuttl.services;

import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dropshuttl.customer.dao.impl.UserDaoImpl;
import com.app.dropshuttl.dto.UserMast;
import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.security.PasswordSecurity;

@Transactional
@Service
public class UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	final static Logger logger = Logger.getLogger(UserService.class);
	boolean isUserAreadyPresent;

	public void addUser(UserModel user)
	{

		if(user !=null)
			isUserAreadyPresent=userDaoImpl.getUserByNumber(user.getUmob());
		if(!isUserAreadyPresent){
			ModelMapper mapper = new ModelMapper();
			mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

			UserMast userMast = mapper.map(user, UserMast.class);
			userMast.setPass(PasswordSecurity.encrypt(user.getPass(), user.getUname()));
			userDaoImpl.addUser(userMast);
		}else
		{
			logger.error("USer Is already present !!");
		}
	}

}
