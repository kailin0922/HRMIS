package com.xkl.dao;

import com.xkl.model.*;

import java.util.List;

/**
 * Created by xkl on 2018/1/25.
 */
public interface UserMapper {
    boolean addUser(User user);
    User checkName(User user);
    User getUser(User user);
    Resume getResume(User user);
    Employee searchEmployeeByResumeId(Employee employee);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean addApplyrecruitment(ApplyRecruitment applyRecruitment);
    Recruitment getRecrument(Recruitment recruitment);
    List<ApplyRecruitment> allApplyRecords(User user);
    ApplyRecruitment checkApplyRecruitment(ApplyRecruitment applyRecruitment);
    ApplyRecruitment searchApplyRecruitmentById(ApplyRecruitment applyRecruitment);
    Recruitment searchRecruitmentById(Recruitment recruitment);
}
