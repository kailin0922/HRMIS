package com.xkl.model;

import java.io.Serializable;

/**
 * Created by xkl on 2018/1/27.
 */
public class Recruitment implements Serializable {
    private int id;
    private int deptid;

    private int peoplenumber;
    private String requirement;
    private double salary;
    private String workplace;

    public Recruitment() {
    }

    public Recruitment(int id, int deptid, int peoplenumber, String requirement, double salary, String workplace) {
        this.id = id;
        this.deptid = deptid;

        this.peoplenumber = peoplenumber;
        this.requirement = requirement;
        this.salary = salary;
        this.workplace = workplace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }



    public int getPeoplenumber() {
        return peoplenumber;
    }

    public void setPeoplenumber(int peoplenumber) {
        this.peoplenumber = peoplenumber;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "id=" + id +
                ", deptid=" + deptid +

                ", peoplenumber=" + peoplenumber +
                ", requirement='" + requirement + '\'' +
                ", salary=" + salary +
                ", workplace='" + workplace + '\'' +
                '}';
    }
}
