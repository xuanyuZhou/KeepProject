package com.example.dllo.keepproject.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.fragment.FindFragment;
import com.example.dllo.keepproject.ui.fragment.FocusFragment;
import com.example.dllo.keepproject.ui.fragment.MeFragment;
import com.example.dllo.keepproject.ui.fragment.TrainFragment;

/**
 * 程序主界面
 */
public class MainActivity extends AbsBaseActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mainAtyRadioGroup;
    private TrainFragment trainFragment;
    private FindFragment findFragment;
    private FocusFragment focusFragment;
    private MeFragment meFragment;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mainAtyRadioGroup = byView(R.id.mainAty_radioGroup);
    }

    @Override
    protected void initListeners() {
        mainAtyRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initDatas() {
        // 初始化fragment
        trainFragment = new TrainFragment();
        findFragment = new FindFragment();
        focusFragment = new FocusFragment();
        meFragment = new MeFragment();

        // 设置第一个fragment为默认
        mainAtyRadioGroup.check(R.id.mainAty_radioGroup_trainRBtn);
    }

    /**
     * radioGroup点击事件
     *
     * @param group
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // 初始化fragment管理者
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (checkedId) {
            case R.id.mainAty_radioGroup_trainRBtn:
                fragmentTransaction.replace(R.id.mainAty_frameLayout, trainFragment);
                break;
            case R.id.mainAty_radioGroup_findRBtn:
                fragmentTransaction.replace(R.id.mainAty_frameLayout, findFragment);
                break;
            case R.id.mainAty_radioGroup_focusRBtn:
                fragmentTransaction.replace(R.id.mainAty_frameLayout, focusFragment);
                break;
            case R.id.mainAty_radioGroup_meRBtn:
                fragmentTransaction.replace(R.id.mainAty_frameLayout, meFragment);
                break;
        }
        fragmentTransaction.commit();
    }
}
