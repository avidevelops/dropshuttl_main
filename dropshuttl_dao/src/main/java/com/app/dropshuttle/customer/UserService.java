package com.app.dropshuttle.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDao> getAllUSer()
	{
		List<UserDao> users=new ArrayList<UserDao>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	
	public void addUser(UserDao user)
	{
		userRepository.save(user);
	}
	
}
