package com.app.dropshuttl.services;

import java.util.Properties;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.constants.CommonConstants;
import com.app.dropshuttl.customer.dao.IUserDao;
import com.app.dropshuttl.dto.UserMast;
import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.modelmapper.DtoMapper;
import com.app.dropshuttl.security.PasswordSecurity;
import com.app.dropshuttl.security.UserUtils;

@Transactional
@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDao dao;
/**
 *  find user by Email ID
 */
	@Override
	public UserModel findByEmail(String uname) {
		UserModel userModel=null;
		UserMast user = dao.findByUmailId(uname);
		if(user !=null)
	     userModel = DtoMapper.map(user, UserModel.class);
		return userModel;
	}
/**
 * Find User by Mobile number
 */
  @Override
	public UserModel findByMobile(String mob) {
	UserMast user = dao.findByUmob(mob);	
	UserModel userModel =DtoMapper.map(user, UserModel.class);
	return userModel;
	}
/**
 * create user account for dropshuttl
 */
	@Override
	public UserModel create(UserModel entity) {
		UserMast userEntity = DtoMapper.map(entity, UserMast.class);
		Properties prop = UserUtils.readproperties(CommonConstants.USER_PROPERTIES);
		if (entity.getUmailId() != null)
			userEntity.setPass(PasswordSecurity.encrypt(entity.getPass(), prop.getProperty(CommonConstants.EncryptionKey)));
		else
			userEntity.setPass(PasswordSecurity.encrypt(entity.getPass(), prop.getProperty(CommonConstants.EncryptionKey)));
		userEntity.setIsActive(CommonConstants.IS_ACTIVE_USER);
		userEntity.setIsLoggedIn(CommonConstants.USER_LOGGEDIN);
		userEntity = dao.save(userEntity);
		UserModel userModel = DtoMapper.map(userEntity, UserModel.class);
		return userModel;
	}

	@Override
	public UserModel update(UserModel entity) {
		UserMast userEntity = DtoMapper.map(entity, UserMast.class);
		dao.save(userEntity);
		UserModel userModel = DtoMapper.map(entity, UserModel.class);
		return userModel;
		
	}

	

}
