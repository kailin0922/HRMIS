package com.xkl.service.impl;

import com.xkl.dao.UserMapper;
import com.xkl.model.Resume;
import com.xkl.model.User;
import com.xkl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xkl on 2018/1/25.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User checkName(User user) {
        return userMapper.checkName(user);
    }

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public Resume getResume(User user) {
        return userMapper.getResume(user);
    }
}
