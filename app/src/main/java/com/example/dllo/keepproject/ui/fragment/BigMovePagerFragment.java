package com.example.dllo.keepproject.ui.fragment;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.HorizontalPagerAdapter;
import com.example.dllo.keepproject.ui.adapter.IScrollListener;
import com.example.dllo.keepproject.ui.adapter.IViewPagerCurrent;
import com.example.dllo.keepproject.view.FixedSpeedScroller;
import com.example.dllo.keepproject.view.HorizontalViewPager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/13.
 * 大图里面3个图和一个的页面
 */
public class BigMovePagerFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    /**
     * 左侧fragment
     */
    private final int INDEX_LEFT = 0;
    /**
     * 主页面fragment
     */
    private final int INDEX_HOME = 1;
    /**
     * 右侧fragment
     */
    private final int INDEX_RIGHT = 2;

    private View contentView;
    private HorizontalViewPager horizontalViewPager;
    private HorizontalPagerAdapter mAdapter;
    private IScrollListener mScrollListener;
    private IViewPagerCurrent mViewPagerListener;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mScrollListener = (IScrollListener) activity;
        mViewPagerListener = (IViewPagerCurrent) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.fragment_pager, null);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        horizontalViewPager = (HorizontalViewPager) contentView.findViewById(R.id.horizontal_pager);
        horizontalViewPager.setBackGround(BitmapFactory.decodeResource(getResources(), R.mipmap.changtuthree));
        initViewPagerSpeed();
        BigMoveLeftFragment bigMoveLeftFragment = new BigMoveLeftFragment();
        BigMoveRightFragment bigMoveRightFragment = new BigMoveRightFragment();
        BigMoveHomeFragment bigMoveHomeFragment = new BigMoveHomeFragment();
        fragmentList.add(bigMoveLeftFragment);
        fragmentList.add(bigMoveHomeFragment);
        fragmentList.add(bigMoveRightFragment);
        bigMoveLeftFragment.setPagerOnClickListener(this);
        bigMoveRightFragment.setPagerOnClickListener(this);
        bigMoveHomeFragment.setPagerOnClickListener(this);
        mAdapter = new HorizontalPagerAdapter(getFragmentManager(), fragmentList);
        horizontalViewPager.setOffscreenPageLimit(fragmentList.size() - 1);
        horizontalViewPager.setAdapter(mAdapter);
        horizontalViewPager.setCurrentItem(INDEX_HOME);
        horizontalViewPager.setOnPageChangeListener(this);
        mScrollListener.canScrollView(true);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position != 1) {
            mScrollListener.canScrollView(false);
        } else {
            mScrollListener.canScrollView(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 设置ViewPager的滚动速度
     */
    private void initViewPagerSpeed() {
        try {
            Field mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(horizontalViewPager.getContext());
            mScroller.set(horizontalViewPager, scroller);
        } catch (NoSuchFieldException e) {

        } catch (IllegalArgumentException e) {

        } catch (IllegalAccessException e) {

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left: {
                horizontalViewPager.setCurrentItem(INDEX_LEFT);
            }
            break;
            case R.id.btn_right: {
                horizontalViewPager.setCurrentItem(INDEX_RIGHT);
            }
            break;
            case R.id.btn_bottom: {
                mViewPagerListener.setCurrentPager(INDEX_HOME);
            }
            break;
            case R.id.btn_left_right: {
                horizontalViewPager.setCurrentItem(INDEX_HOME);
            }
            break;
            case R.id.btn_right_left: {
                horizontalViewPager.setCurrentItem(INDEX_HOME);
            }
            break;
        }
    }
}

