package com.example.dllo.keepproject.ui.fragment;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.activity.AddFriendActivity;
import com.example.dllo.keepproject.ui.adapter.FocusPagerAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/11.
 * 关注页
 */
public class FocusFragment extends AbsBaseFragment implements View.OnClickListener {

    private ImageView addFriendIv;
    private ImageView newsIv;
    private TabLayout focusTabLayout;
    private ViewPager focusViewPager;
    private ArrayList<Fragment> fragments;
    private FocusPagerAdapter focusPagerAdapter;
    private ImageView triangleImag;
    private ImageView groupImag;

    @Override
    protected int setLayout() {
        return R.layout.fragment_focus;
    }

    @Override
    protected void initView() {
        addFriendIv = byView(R.id.focus_addFriend);
        newsIv = byView(R.id.focus_news);
        focusTabLayout = byView(R.id.focus_tablayout);
        focusViewPager = byView(R.id.focus_viewpager);
        triangleImag = byView(R.id.focus_Triangle_focusbeen);
        groupImag = byView(R.id.focus_Triangle_group);

    }

    @Override
    protected void setListeners() {
        addFriendIv.setOnClickListener(this);
        newsIv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        groupImag.setVisibility(View.GONE);
        fragments = new ArrayList<>();
        fragments.add(new FocusHasBeenFragment());
        fragments.add(new FocusGroupFragment());
        focusPagerAdapter = new FocusPagerAdapter(getChildFragmentManager());
        focusPagerAdapter.setArrayList(fragments);
        focusViewPager.setAdapter(focusPagerAdapter);
        focusTabLayout.setupWithViewPager(focusViewPager);
        focusTabLayout.setTabTextColors(Color.argb(255,172,167,177),Color.WHITE);
        focusTabLayout.setSelectedTabIndicatorColor(Color.argb(255,82,75,92));
//        viewpager 的监听事件
        focusViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(focusTabLayout.getSelectedTabPosition() == 0){
                    triangleImag.setVisibility(View.VISIBLE);
                    groupImag.setVisibility(View.GONE);

                }
                else {
                    groupImag.setVisibility(View.VISIBLE);
                    triangleImag.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.focus_addFriend:
                goTo(MyApp.getContext(), AddFriendActivity.class);
                break;
        }
    }
}
