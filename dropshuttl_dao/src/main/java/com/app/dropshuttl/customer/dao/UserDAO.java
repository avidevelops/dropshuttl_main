/**
 * 
 */
package com.app.dropshuttl.customer.dao;

import com.app.dropshuttl.dto.UserMast;

/**
 * @author Vishal
 *
 */
public interface UserDAO {
	public void addUser(UserMast user);

	boolean getUserByNumber(String umob);



}
