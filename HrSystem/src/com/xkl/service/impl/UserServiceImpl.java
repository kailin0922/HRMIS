package com.xkl.service.impl;

import com.xkl.dao.UserMapper;
import com.xkl.model.*;
import com.xkl.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public boolean addResume(Resume resume) {
        return userMapper.addResume(resume);
    }

    @Override
    public boolean updateResume(Resume resume) {
        return userMapper.updateResume(resume);
    }

    @Override
    public boolean addApplyrecruitment(ApplyRecruitment applyRecruitment) {
        ApplyRecruitment applyRecruitment1=userMapper.checkApplyRecruitment(applyRecruitment);
        if (applyRecruitment1!=null){
            return false;
        }
        return userMapper.addApplyrecruitment(applyRecruitment);
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

    @Override
    public Employee searchEmployeeByResumeId(Employee employee) {
        return userMapper.searchEmployeeByResumeId(employee);
    }

    @Override
    public Recruitment getRecrument(Recruitment recruitment) {
        return userMapper.getRecrument(recruitment);
    }

    @Override
    public List<ApplyRecruitment> allApplyRecords(User user) {
        return userMapper.allApplyRecords(user);
    }

    @Override
    public ApplyRecruitment searchApplyRecruitmentById(ApplyRecruitment applyRecruitment) {
        return userMapper.searchApplyRecruitmentById(applyRecruitment);
    }

    @Override
    public Recruitment searchRecruitmentById(Recruitment recruitment) {
        return userMapper.searchRecruitmentById(recruitment);
    }
}
