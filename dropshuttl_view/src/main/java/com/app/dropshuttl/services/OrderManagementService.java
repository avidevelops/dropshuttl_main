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
	public void createNewOrder(Order order) {
		OrderMast orderentity = DtoMapper.map(order, OrderMast.class);
		orderdao.createOrder(orderentity);
		
	}

	

}
