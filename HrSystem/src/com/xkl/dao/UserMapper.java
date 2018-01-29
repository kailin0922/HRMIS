package com.xkl.dao;

import com.xkl.model.ApplyRecruitment;
import com.xkl.model.Recruitment;
import com.xkl.model.Resume;
import com.xkl.model.User;

import java.util.List;

/**
 * Created by xkl on 2018/1/25.
 */
public interface UserMapper {
    boolean addUser(User user);
    User checkName(User user);
    User getUser(User user);
    Resume getResume(User user);
    boolean addResume(Resume resume);
    boolean updateResume(Resume resume);
    boolean addApplyrecruitment(ApplyRecruitment applyRecruitment);
    Recruitment getRecrument(Recruitment recruitment);
    List<ApplyRecruitment> allApplyRecords(User user);
}
