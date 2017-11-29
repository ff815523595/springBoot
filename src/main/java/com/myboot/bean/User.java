package com.myboot.bean;

import java.io.Serializable;

/**
 * Created by a on 2017/11/24.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2457436785429397774L;

    private String userid;

    private String name;

    private int age;

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
}
