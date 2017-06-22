package com.app.dropshuttle.customer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="ds_user")
public class UserDao implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;  
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
    private int uid;
	@Column(name="uname")	
	private String uname;
	@Column(name="umailid")
	private String umailId;
	@Column(name="umob")
	private int umob;
	@Column(name="usocialfb")
	private String usocialFB;
	@Column(name="usocialGID")
	private String usocialGID;
	@Column(name="isactive")
	private String isActive;
	@Column(name="isLoggedIn")
	private String isLoggedIn;
	@Column(name="isloggedinsocial")
	private String isloggedinsocial;
	@Column(name="password")
	private String pass;
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUmailId() {
		return umailId;
	}
	public void setUmailId(String umailId) {
		this.umailId = umailId;
	}
	public int getUmob() {
		return umob;
	}
	public void setUmob(int umob) {
		this.umob = umob;
	}
	public String getUsocialFB() {
		return usocialFB;
	}
	public void setUsocialFB(String usocialFB) {
		this.usocialFB = usocialFB;
	}
	public String getUsocialGID() {
		return usocialGID;
	}
	public void setUsocialGID(String usocialGID) {
		this.usocialGID = usocialGID;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getIsLoggedIn() {
		return isLoggedIn;
	}
	public void setIsLoggedIn(String isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getIsloggedinsocial() {
		return isloggedinsocial;
	}
	public void setIsloggedinsocial(String isloggedinsocial) {
		this.isloggedinsocial = isloggedinsocial;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}  