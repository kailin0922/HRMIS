package com.xkl.service;

import com.xkl.model.ApplyRecruitment;
import com.xkl.model.Department;
import com.xkl.model.Position;
import com.xkl.model.Recruitment;

import java.awt.*;
import java.util.List;

/**
 * Created by xkl on 2018/1/27.
 */
public interface ManageService {
    List<Recruitment> allRecruitmentInfo();
    List<Department> allDepartmentInfo();
    List<ApplyRecruitment> allApplyRecords();
    boolean addPosition(Position position);
    boolean addRecruitment(Recruitment recruitment);
    boolean deleteRecruitment(Recruitment recruitment);
}
