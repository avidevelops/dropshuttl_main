package com.app.dropshuttl.customer.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dropshuttl.customer.dao.UserDAO;
import com.app.dropshuttl.dto.UserMast;

@Repository
public class UserDaoImpl implements UserDAO {

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;


	@Transactional
    public void addUser(UserMast user) {
        this.entityManager.persist(user);
    }
	
	
	public boolean getUserByNumber(String umob) {
		int hasUser=entityManager.createQuery("FROM UserMast u where u.umob = :mobnum")
				.setParameter("mobnum", umob).getResultList().size();
        if(hasUser!=0)
        	return true;
        else 
        	return false;
	
	}




}
