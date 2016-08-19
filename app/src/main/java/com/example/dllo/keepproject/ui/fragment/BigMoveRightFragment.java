package com.example.dllo.keepproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;

/**
 * Created by dllo on 16/8/13.
 * 大图里面右面的图
 */
public class BigMoveRightFragment extends AbsBaseFragment{

    private View contentView;
    private ImageView btnLeft;
    private View.OnClickListener mListener;
    @Override
    protected int setLayout() {
        return R.layout.fragment_right;
    }

    @Override
    protected void initView() {
        btnLeft = byView(R.id.btn_right_left);
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
    }
}
