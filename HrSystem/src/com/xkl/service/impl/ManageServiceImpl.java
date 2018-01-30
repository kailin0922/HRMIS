package com.xkl.service.impl;

import com.xkl.dao.DepartmentMapper;
import com.xkl.dao.ManageMapper;
import com.xkl.model.*;
import com.xkl.service.ManageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xkl on 2018/1/27.
 */
@Service("manageService")
public class ManageServiceImpl implements ManageService{
    @Resource
    private ManageMapper manageMapper;
    @Resource
    private DepartmentMapper departmentMapper;
    @Override
    public List<Recruitment> allRecruitmentInfo() {
        return manageMapper.allRecruitmentInfo();
    }
    @Override
    public List<Department> allDepartmentInfo() {
        return departmentMapper.allDepartmentInfo();
    }

    @Override
    public List<ApplyRecruitment> allApplyRecords() {
        return manageMapper.allApplyRecords();
    }

    @Override
    public List<User> allUsers() {
       return manageMapper.allUsers();
    }

    @Override
    public Position searchPosition(Position position) {
        return manageMapper.searchPosition(position);
    }

    @Override
    public Resume searchResumeByUid(Resume resume) {
        return manageMapper.searchResumeByUid(resume);
    }

    @Override
    public Employee getEmployee(Employee employee) {
        return manageMapper.getEmployee(employee);
    }

    @Override
    public Employee searchEmployeeByResumeId(Employee employee) {
        return manageMapper.searchEmployeeByResumeId(employee);
    }

    @Override
    public boolean addPosition(Position position) {
        return manageMapper.addPosition(position);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return manageMapper.addEmployee(employee);
    }

    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        return manageMapper.addRecruitment(recruitment);
    }

    @Override
    public boolean deleteRecruitment(Recruitment recruitment) {
        return manageMapper.deleteRecruitment(recruitment);
    }

    @Override
    public boolean updateApplyRecruuitment(ApplyRecruitment applyRecruitment) {
        return manageMapper.updateApplyRecruuitment(applyRecruitment);
    }
}
