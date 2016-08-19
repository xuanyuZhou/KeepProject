package com.example.dllo.keepproject.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.GroupDetailsViewPagerAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.ui.fragment.GroupHotFragment;
import com.example.dllo.keepproject.ui.fragment.GroupNewsFragment;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


/**
 * Created by dllo on 16/8/15.
 * 小组的详情页
 */
public class GroupDetailsActivity extends AbsBaseActivity {

    private ViewPager detailsVp;
    private TextView memberTv;
    private TextView cardsTv;
    private TabLayout detailsTabLayout;
    private ImageView contentImage;
    private String url;
    private ArrayList<Fragment> fragments;
    private GroupDetailsViewPagerAdapter detailsAdapter;
    private CollapsingToolbarLayout mycoll;
    private Toolbar toolbar;
    private Intent intent;
    private Bundle bundle;


    @Override
    protected int setLayout() {
        return R.layout.activity_group_details;
    }

    @Override
    protected void initView() {

        detailsVp = byView(R.id.group_details_viewPager);
        memberTv = byView(R.id.group_details_member);
        cardsTv = byView(R.id.group_details_cards);
        detailsTabLayout = byView(R.id.group_details_tablayout);
        contentImage = byView(R.id.group_details_contentImage);
        mycoll = byView(R.id.group_details_coll);
        toolbar = byView(R.id.toolbar);


    }


    @Override
    protected void initListeners() {


    }

    @Override
    protected void initDatas() {
        // 接收值
        intent = getIntent();
        bundle = intent.getExtras();

        initToolBar(toolbar, true, bundle.getString("title"));
        // 设置协调布局开始的margin
        mycoll.setExpandedTitleMargin(20, 50, 100, 100);
        memberTv.setText(bundle.getString("groupMember") + "成员,");
        cardsTv.setText(bundle.getString("groupCards") + "动态");
        Picasso.with(MyApp.getContext()).load(bundle.getString("headImage")).into(contentImage);
        this.url = bundle.getString("url");


        // 传值到fragment
        fragments = new ArrayList<>();
        GroupNewsFragment newsFragment = new GroupNewsFragment();
        GroupHotFragment hotFragment = new GroupHotFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        newsFragment.setArguments(bundle);
        hotFragment.setArguments(bundle);
        fragments.add(newsFragment);
        fragments.add(hotFragment);

        detailsAdapter = new GroupDetailsViewPagerAdapter(getSupportFragmentManager());
        detailsAdapter.setArrayList(fragments);
        detailsVp.setAdapter(detailsAdapter);

        detailsTabLayout.setupWithViewPager(detailsVp);
        detailsTabLayout.setTabTextColors(Color.argb(255, 97, 89, 106), Color.argb(255, 78, 164, 105));
        detailsTabLayout.setSelectedTabIndicatorColor(Color.WHITE);


    }

    /**
     * 设置toolbar
     *
     * @param toolbar
     * @param homeAsUpEnabled
     * @param title
     */
    public void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(homeAsUpEnabled);
    }

    /**
     * 返回键
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
