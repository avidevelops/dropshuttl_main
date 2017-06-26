package com.app.dropshuttl.model;

import java.io.Serializable;

public class UserModel  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5388886317312799281L;
	private String uname;
	private String umailId;
	private int umob;
	private String pass;
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

}
