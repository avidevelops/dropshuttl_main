package com.app.dropshuttl.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ds_order")
public class OrderMast implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ORDER_ID")
	private String orderId;
	@Column(name="user_id")
	private long uid;
	@Column(name="F_LOCATION")
	private String fromAddress;
	@Column(name="T_LOCATION")
	private String toAddress;
	@Column(name="U_EXPECTED_TIME")
	private Date deliveryTime;
	@Column(name="ESTIMATED_TIME_ORIGINAL")
	private Date systemGeneratedTimeEstimate;
	@Column(name="LOCATION_STATION")
	private String nearestMetro;
	@Column(name="ORDER_STATUS")
	private String orderStatus;
	@Column(name="ORDER_COST")
	private double orderCost;
	@Column(name="PAYMENT_STATUS")
	private String paymentStatus;
	@Column(name="ORDER_TYPE_ID")
	private String orderType;
	@Column(name="ORDER_WEIGHT")
	private double orderWeight;
	@Column(name="IS_INSURANCE")
	private boolean isInsurance; 
	@Column(name="ORDER_TRACK_ID")
	private String orderTrackID;
	@Column(name="ASSIGNED_AGENT_ID")
	private String agentId;
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
	public void setFromAddress(String fromAddress) {
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
	public Date getSystemGeneratedTimeEstimate() {
		return systemGeneratedTimeEstimate;
	}
	public void setSystemGeneratedTimeEstimate(Date systemGeneratedTimeEstimate) {
		this.systemGeneratedTimeEstimate = systemGeneratedTimeEstimate;
	}
	public String getNearestMetro() {
		return nearestMetro;
	}
	public void setNearestMetro(String nearestMetro) {
		this.nearestMetro = nearestMetro;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public double getOrderWeight() {
		return orderWeight;
	}
	public void setOrderWeight(double orderWeight) {
		this.orderWeight = orderWeight;
	}
	public boolean isInsurance() {
		return isInsurance;
	}
	public void setInsurance(boolean isInsurance) {
		this.isInsurance = isInsurance;
	}
	public String getOrderTrackID() {
		return orderTrackID;
	}
	public void setOrderTrackID(String orderTrackID) {
		this.orderTrackID = orderTrackID;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	
	
	
	
}
