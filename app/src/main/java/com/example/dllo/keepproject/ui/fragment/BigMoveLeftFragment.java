package com.example.dllo.keepproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;

/**
 * Created by dllo on 16/8/13.
 */
public class BigMoveLeftFragment extends AbsBaseFragment{

    private View contentView;
    private ImageView btnRight;
    private View.OnClickListener mListener;
    @Override
    protected int setLayout() {
        return R.layout.fragment_left;
    }

    @Override
    protected void initView() {
        btnRight = byView(R.id.btn_left_right);
    }

    public void setPagerOnClickListener(View.OnClickListener listener) {
        mListener = listener;
    }
    @Override
    protected void setListeners() {

    }

    @Override
    protected void initDatas() {
        btnRight.setOnClickListener(mListener);
    }
}
