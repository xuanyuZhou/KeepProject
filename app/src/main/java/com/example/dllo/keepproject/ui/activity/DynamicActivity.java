package com.example.dllo.keepproject.ui.activity;


import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
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
public class DynamicActivity extends AbsBaseActivity implements View.OnClickListener, TextWatcher {
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
        dynamicEt.addTextChangedListener(this);

//        dynamicRL.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 给我的RL设置动画
//                releaseBtn.setAnimation(animation);
//                // 开始动画
//                animation.start();
//            }
//        });
    }

    @Override
    protected void initDatas() {

//        // 平移动画
//        animation = new TranslateAnimation(200,500,200,600);
//        // 设置动画持续时间
//        animation.setDuration(2000);
//        // 设置重复次数
//        animation.setRepeatCount(1);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dynamic_back:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;

            case R.id.dynamic_releaseBtn:

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

    /**
     * 监听ED的文字改变来使下面的组件平移下去
     * @param s
     * @param start
     * @param count
     * @param after
     */
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        Log.i("xxxx", s +"beforeTextChanged: ");
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Log.i("xxxx", s +"ontext: ");
    }

    @Override
    public void afterTextChanged(Editable s) {
        Log.i("xxxx", s +"afterText: ");
    }
}
