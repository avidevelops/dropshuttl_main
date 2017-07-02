package com.app.dropshuttl.services;

import com.app.dropshuttl.model.UserModel;

public interface IUserService {

    public UserModel findByName(final String uname);

//    public UserMast findById(final long id);
//
//    // write
//
//    public UserMast create(final UserMast entity);
//
//    public void update(final UserMast entity);
}
