package com.app.dropshuttl.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.app.dropshuttl.dto.UserMast;

public interface IUserJpaDao extends JpaRepository<UserMast, Long>, JpaSpecificationExecutor<UserMast> {
	 UserMast findByName(final String name);
}
