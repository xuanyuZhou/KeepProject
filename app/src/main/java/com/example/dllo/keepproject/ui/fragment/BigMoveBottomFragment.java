package com.example.dllo.keepproject.ui.fragment;

import android.app.Activity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.activity.PhotoAlbumActivity;
import com.example.dllo.keepproject.ui.adapter.IViewPagerCurrent;

/**
 * Created by dllo on 16/8/13.
 * 大图里面最下面的图
 */
public class BigMoveBottomFragment extends AbsBaseFragment implements View.OnClickListener {
    private ImageView photoAlbumIv;
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
        photoAlbumIv = byView(R.id.bigMove_keep_goToIv);
    }

    @Override
    protected void setListeners() {
        btnTop.setOnClickListener(this);
        photoAlbumIv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        // 这里是keep动画效果 渐变效果~稳稳的
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f,1.0f);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        photoAlbumIv.setAnimation(alphaAnimation);
        alphaAnimation.start();


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mViewPagerListener = (IViewPagerCurrent) activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bottom_top:
                mViewPagerListener.setCurrentPager(0);
                break;

            case R.id.bigMove_keep_goToIv:
                goTo(context, PhotoAlbumActivity.class);
                break;
        }
    }
}
