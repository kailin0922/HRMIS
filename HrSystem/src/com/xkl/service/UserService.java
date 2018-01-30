package com.xkl.service;

import com.xkl.model.*;

import java.util.List;

/**
 * Created by xkl on 2018/1/25.
 */
public interface UserService {
    boolean addUser(User user);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean addApplyrecruitment(ApplyRecruitment applyRecruitment);
    User checkName(User user);
    User getUser(User user);
    Resume getResume(User user);
    Employee searchEmployeeByResumeId(Employee employee);
    Recruitment getRecrument(Recruitment recruitment);
    List<ApplyRecruitment> allApplyRecords(User user);
    ApplyRecruitment searchApplyRecruitmentById(ApplyRecruitment applyRecruitment);
    Recruitment searchRecruitmentById(Recruitment recruitment);
}
