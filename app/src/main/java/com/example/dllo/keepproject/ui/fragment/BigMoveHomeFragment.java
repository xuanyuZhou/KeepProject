package com.example.dllo.keepproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;

/**
 * Created by dllo on 16/8/13.
 */
public class BigMoveHomeFragment extends AbsBaseFragment{
    private View contentView;
    private ImageView btnLeft, btnRight, btnBottom;
    private View.OnClickListener mListener;

    @Override
    protected int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        btnLeft = byView(R.id.btn_left);
        btnRight= byView(R.id.btn_right);
        btnBottom = byView(R.id.btn_bottom);
    }

    public void setPagerOnClickListener(View.OnClickListener listener) {
        mListener = listener;
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initDatas() {
        btnLeft.setOnClickListener(mListener);
        btnRight.setOnClickListener(mListener);
        btnBottom.setOnClickListener(mListener);
    }
}
