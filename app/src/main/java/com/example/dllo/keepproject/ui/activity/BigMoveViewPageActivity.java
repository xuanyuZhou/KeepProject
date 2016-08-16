package com.example.dllo.keepproject.ui.activity;

import android.support.v4.app.Fragment;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.IScrollListener;
import com.example.dllo.keepproject.ui.adapter.IViewPagerCurrent;
import com.example.dllo.keepproject.ui.adapter.VerticalPagerAdapter;
import com.example.dllo.keepproject.ui.fragment.BigMoveBottomFragment;
import com.example.dllo.keepproject.ui.fragment.BigMovePagerFragment;
import com.example.dllo.keepproject.view.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/13.
 */
public class BigMoveViewPageActivity extends AbsBaseActivity implements IScrollListener,IViewPagerCurrent{

    private VerticalViewPager verticalViewPager;
    private VerticalPagerAdapter mAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected int setLayout() {
        return R.layout.activity_bigmoveviewpage;
    }

    @Override
    protected void initView() {
        verticalViewPager = (VerticalViewPager) findViewById(R.id.vertical_pager);
        BigMovePagerFragment bigMovePagerFragment = new BigMovePagerFragment();
        BigMoveBottomFragment bottomFragment = new BigMoveBottomFragment();
        mFragments.add(bigMovePagerFragment);
        mFragments.add(bottomFragment);
        mAdapter = new VerticalPagerAdapter(getSupportFragmentManager(), mFragments);
        verticalViewPager.setAdapter(mAdapter);
    }



    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void canScrollView(boolean isCanScroll) {
        verticalViewPager.setScroll(isCanScroll);
    }

    @Override
    public void setCurrentPager(int position) {
        verticalViewPager.setCurrentItem(position);
    }
}
