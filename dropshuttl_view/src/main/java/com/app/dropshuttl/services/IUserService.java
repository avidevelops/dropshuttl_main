package com.app.dropshuttl.services;

import com.app.dropshuttl.model.UserModel;

public interface IUserService {

    public UserModel findByName(final String uname);

    public UserModel findById(final long id);

    // write

    public UserModel create(final UserModel entity);

    public void update(final UserModel entity);
}
