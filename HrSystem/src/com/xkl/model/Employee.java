package com.xkl.model;

import java.io.Serializable;

/**
 * Created by xkl on 2018/1/30.
 */
public class Employee implements Serializable{
    private int id;
    private String name;
    private String pass;
    private int age;
    private String sex;
    private int tel;
    private String address;
    private int departmentId;
    private int positionId;
    private double basicsalary;
    private String workstarttime;
    private String workendtime;
    private int state;
    private int resumeId;

    public Employee() {
    }

    public Employee(int id, String name, String pass, int age, String sex, int tel, String address, int departmentId, int positionId, double basicsalary, String workstarttime, String workendtime, int state, int resumeId) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.age = age;
        this.sex = sex;
        this.tel = tel;
        this.address = address;
        this.departmentId = departmentId;
        this.positionId = positionId;
        this.basicsalary = basicsalary;
        this.workstarttime = workstarttime;
        this.workendtime = workendtime;
        this.state = state;
        this.resumeId = resumeId;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public double getBasicsalary() {
        return basicsalary;
    }

    public void setBasicsalary(double basicsalary) {
        this.basicsalary = basicsalary;
    }

    public String getWorkstarttime() {
        return workstarttime;
    }

    public void setWorkstarttime(String workstarttime) {
        this.workstarttime = workstarttime;
    }

    public String getWorkendtime() {
        return workendtime;
    }

    public void setWorkendtime(String workendtime) {
        this.workendtime = workendtime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", tel=" + tel +
                ", address='" + address + '\'' +
                ", departmentId=" + departmentId +
                ", positionId=" + positionId +
                ", basicsalary=" + basicsalary +
                ", workstarttime='" + workstarttime + '\'' +
                ", workendtime='" + workendtime + '\'' +
                ", state=" + state +
                ", resumeId=" + resumeId +
                '}';
    }
}
