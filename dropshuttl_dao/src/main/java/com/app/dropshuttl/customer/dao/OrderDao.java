package com.app.dropshuttl.customer.dao;

import com.app.dropshuttl.dto.OrderMast;

public interface OrderDao {

	public void createOrder(OrderMast order);
    public OrderMast completePayment(OrderMast order); 
	
}
