package com.app.dropshuttl.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.dropshuttl.model.Order;


@Transactional
@Service
public interface OrderService {

	public Order createNewOrder(Order order);
    public Order confirmPayment(Order order);
	

}
