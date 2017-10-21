package com.app.dropshuttl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.customer.dao.OrderDao;
import com.app.dropshuttl.dto.OrderMast;
import com.app.dropshuttl.model.Order;
import com.app.dropshuttl.modelmapper.DtoMapper;

@Service
public class OrderManagementService implements OrderService{

	@Autowired
	OrderDao orderdao;
	@Override
	public Order createNewOrder(Order order) {
		OrderMast orderentity = DtoMapper.map(order, OrderMast.class);
		orderentity.setOrderId(order.getUid()+"_"+Math.random());
		orderdao.createOrder(orderentity);
		order=DtoMapper.map(orderentity, Order.class);
		return order;
	}
	/**
	 * confirm payment by hitting payment gateway service and return the order with payment status
	 */
	@Override
	public Order confirmPayment(Order order) {
		OrderMast orderentity = DtoMapper.map(order, OrderMast.class);
		orderdao.completePayment(orderentity);
		order=DtoMapper.map(orderentity, Order.class);
		return order;
	}

	

}
