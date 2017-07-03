package com.app.dropshuttl.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.customer.dao.IUserDao;
import com.app.dropshuttl.dto.UserMast;
import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.modelmapper.DtoMapper;
import com.app.dropshuttl.security.PasswordSecurity;

@Transactional
@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDao dao;

	@Override
	public UserModel findByName(String uname) {
		// TODO Auto-generated method stub
		UserMast user = dao.findByUname(uname);	
		UserModel userModel = DtoMapper.map(user, UserModel.class);
		return userModel;
	}

//	@Override
//	public UserModel findById(long id) {
//		// TODO Auto-generated method stub
//		return dao.findOne(id);
//	}

	@Override
	public UserModel create(UserModel entity) {
		// TODO Auto-generated method stub		
		UserMast userEntity = DtoMapper.map(entity, UserMast.class);
		userEntity.setPass(PasswordSecurity.encrypt(entity.getPass(), entity.getUname()));
		userEntity = dao.save(userEntity);
		UserModel userModel = DtoMapper.map(userEntity, UserModel.class);
		return userModel;
	}

	@Override
	public void update(UserModel entity) {
		UserMast userEntity = DtoMapper.map(entity, UserMast.class);
		dao.save(userEntity);
		
	}

	@Override
	public UserModel findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
