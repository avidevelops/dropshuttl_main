package com.app.dropshuttl.customer.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.dropshuttl.customer.dao.OrderDao;
import com.app.dropshuttl.dto.OrderMast;

@Repository
public class OrderDaoImpl implements OrderDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public OrderMast createOrder(OrderMast order) {
		this.entityManager.persist(order);
		return order;
	}
	@Transactional
	public OrderMast completePayment(OrderMast order) {
		//this.entityManager.persist(order);
		order.setPaymentStatus("true");
		return order;
	}

	

	


	/*
    public void addUser(UserMast user) {
        this.entityManager.persist(user);
    }*/
	
}
