/**
 * 
 */
package com.app.dropshuttl.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.security.core.userdetails.User;

/**
 * @author vishalsahu
 *
 */
public class UserUtils {
	
	/**
	 * Generate Order Numberß
	 * @return
	 */
	public static String generateOrderNumber(String order)
	{
		return null;
	}
	
	/**
	 * Read properties file 
	 * @param propertyName
	 * @return
	 */
	
	public static Properties readproperties(String propertyName) {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input=UserUtils.class.getClassLoader().getResourceAsStream(propertyName);
			// = new FileInputStream(propertyName);
			// load a properties file
			prop.load(input);
			return prop;

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;

	}
	
	public static boolean isMobile(User user)
	{
		if (user != null && user.getUsername()!=null && user.getUsername().contains("@"))
			return false;

	   return true;
		
	}
}
