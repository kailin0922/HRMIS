package com.xkl.dao;

import com.xkl.model.Resume;
import com.xkl.model.User;

/**
 * Created by xkl on 2018/1/25.
 */
public interface UserMapper {
    boolean addUser(User user);
    User checkName(User user);
    User getUser(User user);
    Resume getResume(User user);
}
