package com.app.dropshuttl.services;

import com.app.dropshuttl.model.UserModel;

public interface IUserService {

   // public UserModel findByName(final String uname);
    public UserModel findByEmail(final String uname);

    public UserModel findByMobile(final String mob);

    // write

    public UserModel create(final UserModel entity);

    public void update(final UserModel entity);
}
