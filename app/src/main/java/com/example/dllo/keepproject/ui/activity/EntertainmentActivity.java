package com.example.dllo.keepproject.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.view.SparkView;

/**
 * Created by dllo on 16/8/18.
 * 这里是娱乐页面自己画画的Activity
 */
public class EntertainmentActivity extends AbsBaseActivity{

    @Override
    protected int setLayout() {
        return R.layout.activity_entertainment;
    }

    @Override
    protected void initView() {
        SparkView sparkView = new SparkView(this);
        setContentView(sparkView);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {

    }
}
