package com.jayklef.bhis.service;

import com.jayklef.bhis.model.User;


public interface UserService {

    User saveUser(User user);

    User getUser();
}
