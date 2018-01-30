package com.xkl.dao;

import com.xkl.model.*;
import javafx.geometry.Pos;

import java.util.List;

/**
 * Created by xkl on 2018/1/27.
 */
public interface ManageMapper {
    List<Recruitment> allRecruitmentInfo();
    List<ApplyRecruitment> allApplyRecords();
    List<User> allUsers();
    Position searchPosition(Position position);
    Resume searchResumeByUid(Resume resume);
    Employee getEmployee(Employee employee);
    Employee searchEmployeeByResumeId(Employee employee);
    boolean addEmployee(Employee employee);
    boolean addPosition(Position position);
    boolean addRecruitment(Recruitment recruitment);
    boolean deleteRecruitment(Recruitment recruitment);
    boolean updateApplyRecruuitment(ApplyRecruitment applyRecruitment);
}
