package com.app.dropshuttl.model;

import java.util.Date;

public class Order {

	private String orderId;
	private String uid;
	private String fromAdderss;
	private String toAddress;
	private Date deliveryTime;
	private String orderType;
	private String orderPrice;
	private String toLoaction;
	private String fromLocation;
	
	public String getToLoaction() {
		return toLoaction;
	}
	public void setToLoaction(String toLoaction) {
		this.toLoaction = toLoaction;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
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
	/**
	 * @return the orderPrice
	 */
	public String getOrderPrice() {
		return orderPrice;
	}
	/**
	 * @param orderPrice the orderPrice to set
	 */
	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	
	
}
