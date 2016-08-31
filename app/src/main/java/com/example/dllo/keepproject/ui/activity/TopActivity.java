package com.example.dllo.keepproject.ui.activity;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.ui.adapter.FocusPagerAdapter;
import com.example.dllo.keepproject.ui.fragment.TopDetailsFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/19.
 * 排行榜
 */
public class TopActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ImageView contributeImage;
    private ImageView newsPeopleImage;
    private ImageView topBack;

    @Override
    protected int setLayout() {
        return R.layout.activity_top;
    }

    @Override
    protected void initView() {
        tabLayout = byView(R.id.top_tablayout);
        viewPager = byView(R.id.top_viewpager);
        contributeImage = byView(R.id.top_contributeImage);
        newsPeopleImage = byView(R.id.top_newsPeopleImage);
        topBack = byView(R.id.top_back);

    }

    @Override
    protected void initListeners() {

        topBack.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        // 开始的第二个GONE掉.
        newsPeopleImage.setVisibility(View.GONE);
        // 复用fragment
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(TopDetailsFragment.getFragments(UrlBean.MYRECOMMEND_URL,0));
        fragments.add(TopDetailsFragment.getFragments(UrlBean.NEWSPEOPLE_URL,1));
        FocusPagerAdapter adapter = new FocusPagerAdapter(getSupportFragmentManager());
        adapter.setArrayList(fragments, 2);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(Color.argb(255, 172, 167, 177), Color.WHITE);
        tabLayout.setSelectedTabIndicatorColor(Color.argb(255, 82, 75, 92));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (tabLayout.getSelectedTabPosition() == 0) {
                    contributeImage.setVisibility(View.VISIBLE);
                    newsPeopleImage.setVisibility(View.GONE);
                } else {
                    newsPeopleImage.setVisibility(View.VISIBLE);
                    contributeImage.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.top_back:
                goTo(this, AddFriendActivity.class);
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;
        }
    }
}
