package com.app.dropshuttl.customer.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.dropshuttl.customer.dao.UserDAO;

@Repository
public class UserDaoImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
/*
	public void save(User p) {
		// TODO Auto-generated method stub
		
	}*/

	/*public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
/*	@Autowired
	private CommonDao commonDaoImpl;*/
	
	/**
	 * Fetch Role for user and put into User DTO.
	 * @param userDto
	 * @param roleId
	 * 
	 */
	/*@Transactional
	public void submitUser(Users userDto, String roleId) {
		Query q=entityManager.createQuery(SqlStatements.SELECT_FROM_ROLE);
	    q.setParameter(CommonConstants.KEYWORD, roleId);
	    Role role=(Role)q.getResultList().get(0);
	    userDto.setRole(role);
	    commonDaoImpl.merge(userDto);
	}*/
	
	/**
	 * Fetch details of User from DB.
	 * @param userId
	 */
	/*@Override
	public Users getUser(String userId) {
		Users user = entityManager.find(Users.class, userId);
		return user;
	}*/
	
	/**
	 * Get list of Users from DB by like query on userId.
	 * @param userId
	 */
/*	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsersByLike(String userId) {
		Query q=entityManager.createQuery(SqlStatements.SELECT_FROM_USERS_LIKE);
	    q.setParameter(CommonConstants.KEYWORD, CommonConstants.PERCENTAGE+userId+CommonConstants.PERCENTAGE);
	    List<Users> users = (List<Users>) q.getResultList();
		return users;
	}
	*/
	
	/**
	 * Get list of Users from DB by like query on userId.
	 * @param userId
	 */
/*	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getActiveUsers() {
		Query q=entityManager.createQuery(SqlStatements.SELECT_ACTIVE_USERS);
	    q.setParameter(CommonConstants.KEYWORD, CommonConstants.STATUS_Y);
	    List<Users> users = (List<Users>) q.getResultList();
		return users;
	}*/
	
	
	/*@Transactional
	public void submitUser(Users userDto) {
		 commonDaoImpl.merge(userDto);
	}
	*/
	
	
}
