/**
 * 
 */
package com.app.dropshuttl.customer.dao;

import java.util.List;

import com.app.dropshuttl.dto.OrderMast;
import com.app.dropshuttl.dto.UserMast;

/**
 * @author Vishal
 *
 */
public interface UserDAO {
	public void addUser(UserMast user);

	boolean getUserByNumber(String umob);
	
	public List<OrderMast> getOrdersByUser(long uid);


}
