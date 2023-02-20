package com.xiaoye.model;

public class User {
    private Integer uid;

    private String uname;

    private String uaccount;

    private String upassword;

    public User(Integer uid, String uname, String uaccount, String upassword) {
        this.uid = uid;
        this.uname = uname;
        this.uaccount = uaccount;
        this.upassword = upassword;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uaccount='" + uaccount + '\'' +
                ", upassword='" + upassword + '\'' +
                '}';
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUaccount() {
        return uaccount;
    }

    public void setUaccount(String uaccount) {
        this.uaccount = uaccount;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }
}