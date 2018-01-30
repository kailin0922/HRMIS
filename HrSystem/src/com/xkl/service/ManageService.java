package com.xkl.service;

import com.xkl.model.*;

import java.awt.*;
import java.util.List;

/**
 * Created by xkl on 2018/1/27.
 */
public interface ManageService {
    List<Recruitment> allRecruitmentInfo();
    List<Department> allDepartmentInfo();
    List<ApplyRecruitment> allApplyRecords();
    List<User> allUsers();
    Position searchPosition(Position position);
    Resume searchResumeByUid(Resume resume);
    Employee getEmployee(Employee employee);
    Employee searchEmployeeByResumeId(Employee employee);
    boolean addPosition(Position position);
    boolean addEmployee(Employee employee);
    boolean addRecruitment(Recruitment recruitment);
    boolean deleteRecruitment(Recruitment recruitment);
    boolean updateApplyRecruuitment(ApplyRecruitment applyRecruitment);
}
