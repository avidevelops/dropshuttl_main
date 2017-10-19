package com.app.dropshuttl.services;

import org.springframework.stereotype.Service;

import com.app.dropshuttl.model.Order;



@Service
public interface OrderService {

	public void createNewOrder(Order order);
    public Order confirmPayment(Order order);
	

}
