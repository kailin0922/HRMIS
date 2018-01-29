package com.xkl.model;

import java.io.Serializable;

/**
 * Created by xkl on 2018/1/27.
 */
public class Department implements Serializable {
    private int id;
    private String deptname;

    public Department() {
    }

    public Department(int id, String deptname) {
        this.id = id;
        this.deptname = deptname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
