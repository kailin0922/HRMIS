package com.xkl.model;

import java.io.Serializable;

/**
 * Created by xkl on 2018/1/27.
 */
public class Position implements Serializable {
    private int id;
    private String name;
    private int deptid;
    private String createtime;

    public Position() {
    }

    public Position(int id, String name, int deptid, String createtime) {
        this.id = id;
        this.name = name;
        this.deptid = deptid;
        this.createtime = createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deptid=" + deptid +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
