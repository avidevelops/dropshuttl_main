package com.app.dropshuttl.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderId;
	private long uid;
	private String fromAddress;
	private String toAddress;
	private Date deliveryTime;
	private String orderType;
	private String orderPrice;
	private String toLoaction;
	private String fromLocation;
	private String paymentStatus;
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
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
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAdderss(String fromAddress) {
		this.fromAddress = fromAddress;
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
