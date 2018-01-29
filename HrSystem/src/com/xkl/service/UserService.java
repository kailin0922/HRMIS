package com.xkl.service;

import com.xkl.model.User;

/**
 * Created by xkl on 2018/1/25.
 */
public interface UserService {
    boolean addUser(User user);
    User checkName(User user);
    User getUser(User user);
}
