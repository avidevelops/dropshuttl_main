package com.app.dropshuttl.services;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.customer.dao.IUserJpaDao;
import com.app.dropshuttl.dto.UserMast;
import com.app.dropshuttl.model.UserModel;

@Transactional
@Service
public class UserLoginService implements IUserService {
	
	@Autowired
	IUserJpaDao dao;

	@Override
	public UserModel findByName(String uname) {
		// TODO Auto-generated method stub
		UserMast user = dao.findByName(uname);
		ModelMapper map = new ModelMapper();
		map.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserModel userModel = map.map(user, UserModel.class);
		return userModel;
	}

//	@Override
//	public UserModel findById(long id) {
//		// TODO Auto-generated method stub
//		return dao.findOne(id);
//	}
//
//	@Override
//	public UserModel create(UserModel entity) {
//		// TODO Auto-generated method stub
//		return dao.save(entity);
//	}
//
//	@Override
//	public void update(UserModel entity) {
//		dao.save(entity);
//		
//	}

}
