package com.xkl.model;

/**
 * Created by xkl on 2018/1/29.
 */
public class Resume {
    private int id;
    private String name;
    private String sex;
    private int age;
    private int tel;
    private String address;
    private String major;
    private User user;

    public Resume() {
    }

    public Resume(int id, String name, String sex, int age, int tel, String address, String major, User user) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.major = major;
        this.user = user;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", tel=" + tel +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", user=" + user +
                '}';
    }
}
