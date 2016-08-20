package com.example.dllo.keepproject.model.bean;

import android.graphics.Bitmap;

/**
 * Created by dllo on 16/8/19.
 * 电话本的实体类
 */
public class AddressBookBean {

    private String userName;
    private Bitmap userImage;

    public AddressBookBean(String userName, Bitmap userImage) {
        this.userName = userName;
        this.userImage = userImage;
    }

    public AddressBookBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Bitmap getUserImage() {
        return userImage;
    }

    public void setUserImage(Bitmap userImage) {
        this.userImage = userImage;
    }
}
