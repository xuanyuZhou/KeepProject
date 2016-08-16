package com.example.dllo.keepproject.ui.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.keepproject.R;

/**
 * Created by dllo on 16/8/15.
 * 添加好友界面
 */
public class AddFriendActivity extends AbsBaseActivity implements View.OnClickListener {

    private ImageView backImage;
    private EditText searchEd;
    private LinearLayout addFriendFromPhoneLayout;
    private LinearLayout addFriendFromWeiboLayout;
    private LinearLayout addFriendFromWechatLayout;
    private LinearLayout addFriendFromQQLayout;
    private LinearLayout addFriendFromRankListLayout;

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addfriend_back:
                finish();
                break;
            case R.id.addfriend_Searched:

                break;
            case R.id.addfriend_fromPhone:

                break;
            case R.id.addfriend_fromWeibo:

                break;
            case R.id.addfriend_fromWechat:

                break;
            case R.id.addfriend_fromQQ:

                break;
            case R.id.addfriend_from_ranklist:

                break;

        }

    }
}
