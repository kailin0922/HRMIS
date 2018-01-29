package com.xkl.service.impl;

import com.xkl.dao.DepartmentMapper;
import com.xkl.dao.ManageMapper;
import com.xkl.model.Department;
import com.xkl.model.Position;
import com.xkl.model.Recruitment;
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
    public boolean addPosition(Position position) {
        return manageMapper.addPosition(position);
    }

    @Override
    public boolean addRecruitment(Recruitment recruitment) {
        return manageMapper.addRecruitment(recruitment);
    }

    @Override
    public boolean deleteRecruitment(Recruitment recruitment) {
        return manageMapper.deleteRecruitment(recruitment);
    }
}
