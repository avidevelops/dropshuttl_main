package com.app.dropshuttl.services;

import java.util.List;

import com.app.dropshuttl.dto.OrderMast;
import com.app.dropshuttl.model.UserModel;

public interface IUserService {

   // public UserModel findByName(final String uname);
    public UserModel findByEmail(final String uname);

    public UserModel findByMobile(final String mob);

    // write

    public UserModel create(final UserModel entity);

    public UserModel update(final UserModel entity);
    public List<OrderMast> getOrders(final long uid);
}
