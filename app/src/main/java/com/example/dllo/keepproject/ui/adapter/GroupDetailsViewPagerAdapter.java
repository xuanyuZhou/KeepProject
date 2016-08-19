package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/16.
 * 小组详情界面 VP 适配器
 */
public class GroupDetailsViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayList;
    private ArrayList<String> titleBean;

    public void setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
        titleBean = new ArrayList<>();
        titleBean.add("最新");
        titleBean.add("热门");
        notifyDataSetChanged();
    }

    public GroupDetailsViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList != null ? arrayList.get(position) : null;
    }

    @Override
    public int getCount() {
        return arrayList != null ? arrayList.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleBean.get(position);
    }
}
