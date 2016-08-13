package com.example.dllo.keepproject.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/12.
 * 发现页面上面的 适配器
 */
public class FocusPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList;
    private ArrayList<String> title;

    public FocusPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setArrayList(ArrayList<Fragment> arrayList) {
        this.arrayList = arrayList;
        title = new ArrayList<>();
        title.add("已关注");
        title.add("小组");
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList!=null?arrayList.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
