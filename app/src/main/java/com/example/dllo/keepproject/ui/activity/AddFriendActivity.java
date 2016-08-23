package com.example.dllo.keepproject.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.ui.fragment.FocusFragment;

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
                overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
                break;

        }

    }
}
