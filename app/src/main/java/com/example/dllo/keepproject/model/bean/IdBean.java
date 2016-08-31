package com.example.dllo.keepproject.model.bean;

/**
 * Created by dllo on 16/8/24.
 * 储存账号的数据类
 */
public class IdBean {
    private String userName;
    private String passWord;
    private int _id;

    public IdBean() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public IdBean(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
