package com.app.dropshuttl.model;

import java.util.Date;

public class Order {

	private String orderId;
	private String uid;
	private String fromAdderss;
	private String toAddress;
	private Date deliveryTime;
	private String orderType;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getFromAdderss() {
		return fromAdderss;
	}
	public void setFromAdderss(String fromAdderss) {
		this.fromAdderss = fromAdderss;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
	
}
