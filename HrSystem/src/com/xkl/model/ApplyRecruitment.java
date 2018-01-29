package com.xkl.model;

import java.io.Serializable;

/**
 * Created by xkl on 2018/1/29.
 */
public class ApplyRecruitment implements Serializable {
    private int id;
    private int uid;
    private int recruid;
    private int state;

    public ApplyRecruitment() {
    }

    public ApplyRecruitment(int id, int uid, int recruid, int state) {
        this.id = id;
        this.uid = uid;
        this.recruid = recruid;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRecruid() {
        return recruid;
    }

    public void setRecruid(int recruid) {
        this.recruid = recruid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ApplyRecruitment{" +
                "id=" + id +
                ", uid=" + uid +
                ", recruid=" + recruid +
                ", state=" + state +
                '}';
    }
}
