package com.example.dllo.keepproject.ui.fragment;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.IViewPagerCurrent;

/**
 * Created by dllo on 16/8/13.
 */
public class BigMoveBottomFragment extends AbsBaseFragment implements View.OnClickListener {
    private View contentView;
    private ImageView btnTop;
    private IViewPagerCurrent mViewPagerListener;
    @Override
    protected int setLayout() {
        return R.layout.fragment_bottom;
    }

    @Override
    protected void initView() {
        btnTop = byView(R.id.btn_bottom_top);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initDatas() {
        btnTop.setOnClickListener(this);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mViewPagerListener = (IViewPagerCurrent) activity;
    }

    @Override
    public void onClick(View v) {
        mViewPagerListener.setCurrentPager(0);
    }
}
