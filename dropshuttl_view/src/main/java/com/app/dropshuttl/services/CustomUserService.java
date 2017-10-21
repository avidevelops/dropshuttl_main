
package com.app.dropshuttl.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.constants.CommonConstants;
import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.security.PasswordSecurity;
import com.app.dropshuttl.security.UserUtils;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = null;
		Properties prop=UserUtils.readproperties(CommonConstants.USER_PROPERTIES);
		if (username.contains("@"))
			user = userService.findByEmail(username);
		else
			user = userService.findByMobile(username);
		return new User(username, PasswordSecurity.decrypt(user.getPass(), prop.getProperty(CommonConstants.EncryptionKey)),
				user.getAuthorities());
	}
}
