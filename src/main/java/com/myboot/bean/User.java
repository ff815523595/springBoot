package com.myboot.bean;

import java.io.Serializable;

/**
 * Created by a on 2017/11/24.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2457436785429397774L;

    private String userid;

    private String name;

    private String passWord;

    private int age;

    private String status;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(){};

    public User(String userName , String passWord){
        this.name = userName;
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
