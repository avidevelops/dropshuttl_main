package com.app.dropshuttl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dropshuttl.metro.exception.StationNotFound;
import com.app.dropshuttl.model.Order;
import com.app.dropshuttl.model.PriceModel;
import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.services.OrderService;
import com.app.dropshuttle.googleapis.AddressLatitudeLongitude;

@Controller
@RequestMapping("/")
public class OrderBookingController {
	
	@Autowired
	OrderService orderservice;
	
	final static Logger logger = Logger.getLogger(UserController.class);
	@RequestMapping(value = "/checkAvailablePrice", method = RequestMethod.POST,consumes = {"application/json;charset=UTF-8"}, produces={"application/json;charset=UTF-8"})
	public @ResponseBody  int  getPriceForOrder(@RequestBody Order order,HttpServletRequest request, HttpServletResponse response) throws StationNotFound
	{
		 PriceModel price=new PriceModel();
		 AddressLatitudeLongitude lnl=new AddressLatitudeLongitude();
//		 double fromLatitude=0;
//		 double fromLongitude=0;
//		 double toLatitude=0;
//		 double toLongitude=0;
		 int cost=0;
	try{
//			String addr=lnl.getLatAndLong(order.getFromAddress()+order.getFromLocation());
//		    String[] ss=addr.split(",");
//		    fromLatitude=Double.parseDouble(ss[0]);
//		    fromLongitude=Double.parseDouble(ss[1]);
//		    addr=lnl.getLatAndLong(order.getToAddress()+order.getToLoaction());
//		    ss=addr.split(",");
//		    toLatitude=Double.parseDouble(ss[0]);
//		    toLongitude=Double.parseDouble(ss[1]);
//		    logger.debug("address "+fromLatitude+" "+fromLongitude+" "+toLatitude+" "+toLongitude);
//		    cost= price.getMetroFair(fromLatitude, fromLongitude, toLatitude, toLongitude);
		cost=50;
		    logger.debug("cost "+cost);
		    
	} catch (Exception e) {
		    e.printStackTrace();
		    
		}
		    logger.debug("Order Details"+ order);
		    return cost;
    }
	/*
	 * 
	 */
	@RequestMapping(value = "/receiveOrderPayment", method = RequestMethod.POST, consumes = {
			"application/json;charset=UTF-8" }, produces = { "application/json;charset=UTF-8" })
	public @ResponseBody Order receiveOrderPayment(@RequestBody Order order,HttpServletRequest request, HttpServletResponse response) {
		Order newOrder = orderservice.confirmPayment(order);
		if (newOrder.getPaymentStatus().equals("true")) {
             UserModel user=(UserModel) request.getSession().getAttribute("user");
             if(user!=null && user.getUid()!=0) {
            	 order.setUid(user.getUid());
             }
			order=orderservice.createNewOrder(order);
		} else {
			logger.debug("Error in Payment");
		}

		return order;
	}
	
}
