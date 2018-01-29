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
    private String honor;
    private String credential;
    private String experience;
    private String introduction;
    private int uid;

    public Resume() {
    }

    public Resume(int id, String name, String sex, int age, int tel, String address, String major, String honor, String credential, String experience, String introduction, int uid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.tel = tel;
        this.address = address;
        this.major = major;
        this.honor = honor;
        this.credential = credential;
        this.experience = experience;
        this.introduction = introduction;
        this.uid = uid;
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

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
                ", honor='" + honor + '\'' +
                ", credential='" + credential + '\'' +
                ", experience='" + experience + '\'' +
                ", introduction='" + introduction + '\'' +
                ", uid=" + uid +
                '}';
    }
}
