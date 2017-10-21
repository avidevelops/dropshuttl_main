package com.app.dropshuttl.customer.dao;

import com.app.dropshuttl.dto.OrderMast;

public interface OrderDao {

	public OrderMast createOrder(OrderMast order);
    public OrderMast completePayment(OrderMast order); 
	
}
