package com.app.dropshuttl.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserModel  implements Serializable,UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5388886317312799281L;
	
	@NotBlank(message = "Please enter your User Name.")
	private String uname;
	@NotBlank(message = "Please enter valid Email Id.")
	@Email
	private String umailId;
	@NotBlank(message = "Please enter mobile number.")
	private String umob;
	@NotBlank(message = "Please enter Password.")
	private String pass;
	private String role;
	private String usocialFB;
	private String usocialGID;
	private String isloggedinsocial;
	private int uid;
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
	public String getIsloggedinsocial() {
		return isloggedinsocial;
	}
	public void setIsloggedinsocial(String isloggedinsocial) {
		this.isloggedinsocial = isloggedinsocial;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getUmob() {
		return umob;
	}
	public void setUmob(String umob) {
		this.umob = umob;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	

}
