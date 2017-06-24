package com.app.dropshuttle.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.dropshuttl.dto.UserMast;


@Service
public class UserService {

	
	
	public List<UserDao> getAllUSer()
	{
		List<UserDao> users=new ArrayList<UserDao>();
		//userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void addUser(UserMast user)
	{
		//userRepository.save(user);
	}
	
}
