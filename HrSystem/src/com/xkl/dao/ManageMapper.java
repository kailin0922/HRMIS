package com.xkl.dao;

import com.xkl.model.ApplyRecruitment;
import com.xkl.model.Position;
import com.xkl.model.Recruitment;

import java.util.List;

/**
 * Created by xkl on 2018/1/27.
 */
public interface ManageMapper {
    List<Recruitment> allRecruitmentInfo();
    List<ApplyRecruitment> allApplyRecords();
    boolean addPosition(Position position);
    boolean addRecruitment(Recruitment recruitment);
    boolean deleteRecruitment(Recruitment recruitment);
}
