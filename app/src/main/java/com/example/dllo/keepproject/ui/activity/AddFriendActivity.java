package com.example.dllo.keepproject.ui.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.RecommendFriendBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.VolleyInstance;
import com.example.dllo.keepproject.model.net.VolleyPort;
import com.example.dllo.keepproject.ui.adapter.AddFriendLvAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.MyCustomListView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/15.
 * 添加好友界面
 */
public class AddFriendActivity extends AbsBaseActivity implements View.OnClickListener, VolleyPort {

    private ImageView backImage;
    private EditText searchEd;
    private LinearLayout addFriendFromPhoneLayout;
    private LinearLayout addFriendFromWeiboLayout;
    private LinearLayout addFriendFromWechatLayout;
    private LinearLayout addFriendFromQQLayout;
    private LinearLayout addFriendFromRankListLayout;
    private MyCustomListView recommendLv;

    @Override
    protected int setLayout() {
        return R.layout.activity_addfriend;
    }

    @Override
    protected void initView() {
        backImage = byView(R.id.addfriend_back);
        searchEd = byView(R.id.addfriend_Searched);
        addFriendFromPhoneLayout = byView(R.id.addfriend_fromPhone);
        addFriendFromWeiboLayout = byView(R.id.addfriend_fromWeibo);
        addFriendFromWechatLayout = byView(R.id.addfriend_fromWechat);
        addFriendFromQQLayout = byView(R.id.addfriend_fromQQ);
        addFriendFromRankListLayout = byView(R.id.addfriend_from_ranklist);
        recommendLv = byView(R.id.addfriend_Lv);
    }

    @Override
    protected void initListeners() {
        backImage.setOnClickListener(this);
        searchEd.setOnClickListener(this);
        addFriendFromPhoneLayout.setOnClickListener(this);
        addFriendFromWeiboLayout.setOnClickListener(this);
        addFriendFromWechatLayout.setOnClickListener(this);
        addFriendFromQQLayout.setOnClickListener(this);
        addFriendFromRankListLayout.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027f482c2111119b127f0a");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", " bdss02");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImdlbmRlciI6IkYiLCJpc3MiOiJodHRwOi8vd3d3LmdvdG9rZWVwLmNvbS8iLCJleHAiOjE0NzQ2ODg5NzcsImlhdCI6MTQ3MjA5Njk3N30.C1Q1fbf8abIpwOH014wvOHzl1rECB9attzhO-OmmzUk");
        headMap.put("Connection", "Keep-Alive");
        VolleyInstance.getInstance(this).startStringRequest(UrlBean.RECOMMENDFRIEND_URL,this,headMap);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addfriend_back:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);

                break;
            case R.id.addfriend_Searched:

                break;
            case R.id.addfriend_fromPhone:

                goTo(this, AddressBookActivity.class);
                // 参数1 进入动画 参数2 消失动画
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;
            case R.id.addfriend_fromWeibo:

                break;
            case R.id.addfriend_fromWechat:
                Toast.makeText(AddFriendActivity.this, "未安装微信不能分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addfriend_fromQQ:
                Toast.makeText(AddFriendActivity.this, "未安装QQ不能分享", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addfriend_from_ranklist:
                goTo(this, TopActivity.class);
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;

        }

    }

    @Override
    public void stringSuccess(String result) {
        Gson gson = new Gson();
        RecommendFriendBean recommendFriendBean = gson.fromJson(result,RecommendFriendBean.class);
        AddFriendLvAdapter addFriendLvAdapter = new AddFriendLvAdapter(MyApp.getContext());
        addFriendLvAdapter.setBean(recommendFriendBean);
        recommendLv.setAdapter(addFriendLvAdapter);

    }

    @Override
    public void stringFailure() {

    }
}
