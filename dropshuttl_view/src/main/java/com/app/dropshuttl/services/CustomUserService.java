
package com.app.dropshuttl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dropshuttl.model.UserModel;
import com.app.dropshuttl.security.PasswordSecurity;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	IUserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = null;
		if (username.contains("@"))
			user = userService.findByEmail(username);
		else
			user = userService.findByMobile(username);

		return new User(user.getUname(), PasswordSecurity.decrypt(user.getPass(), user.getUname()),
				user.getAuthorities());
	}
}
