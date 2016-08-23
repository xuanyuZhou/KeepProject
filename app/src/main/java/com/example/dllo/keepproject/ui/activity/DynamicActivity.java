package com.example.dllo.keepproject.ui.activity;


import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dllo.keepproject.R;


/**
 * Created by dllo on 16/8/20.
 * 发表动态界面
 */
public class DynamicActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView backImage;
    private Button releaseBtn;
    private EditText dynamicEt;
    private RelativeLayout dynamicRL;
    private TranslateAnimation animation;


    @Override
    protected int setLayout() {
        return R.layout.activity_dynamic;
    }

    @Override
    protected void initView() {

        backImage = byView(R.id.dynamic_back);
        releaseBtn = byView(R.id.dynamic_releaseBtn);
        dynamicEt = byView(R.id.dynamic_editText);
        dynamicRL = byView(R.id.dynamic_RelativeLayout);
    }

    @Override
    protected void initListeners() {

        backImage.setOnClickListener(this);
        releaseBtn.setOnClickListener(this);
        dynamicEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {


                // 如果获得焦点
                if (hasFocus) {
                    dynamicRL.setAnimation(animation);
                    animation.start();
                }
                dynamicEt.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {


                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        if (dynamicEt.getText().toString().equals("")) {
                            //当text内容为空的时候.button又设置为浅色
                            releaseBtn.setBackgroundColor(Color.argb(255, 148, 195, 167));
                        } else {
                            // 当文字改变后 设置下面的button的背景变成绿色
                            releaseBtn.setBackgroundColor(Color.argb(255, 78, 164, 105));
                        }

                    }
                });
            }
        });

    }

    @Override
    protected void initDatas() {

        // 隐藏光标
        dynamicEt.setCursorVisible(false);
        // 设置不可编辑状态
        dynamicEt.setFocusable(false);
        dynamicEt.setFocusableInTouchMode(false);

        // 平移动画
        animation = new TranslateAnimation(0, 0, 0, 150);
        // 设置动画持续时间
        animation.setDuration(500);
        // 设置重复次数
        animation.setRepeatCount(0);
        // 动画结束后 不返回原路
        animation.setFillAfter(true);

        // 点击ET获得焦点
        dynamicEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显示光标
                dynamicEt.setCursorVisible(true);
                // 设置可编辑状态
                dynamicEt.setFocusableInTouchMode(true);
                dynamicEt.setFocusable(true);
                // 得到请求焦点
                dynamicEt.requestFocus();

                backImage.setVisibility(View.GONE);

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dynamic_back:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            ShowDialog();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void ShowDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("你还没发布动态,确定不发布吗?");
        builder.setPositiveButton("不发了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
            }
        });

        builder.setNegativeButton("再看看", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

}
