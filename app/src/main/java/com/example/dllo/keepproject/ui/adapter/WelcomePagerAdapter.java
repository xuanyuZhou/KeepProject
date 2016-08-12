package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/11.
 * 欢迎页面滑动的轮播文字的适配器
 */
public class WelcomePagerAdapter extends PagerAdapter {
    // 存放tv的数组
    private List<TextView> views = new ArrayList<>();
    private Context context;

    public WelcomePagerAdapter(Context context) {

        this.context = context;
    }


    @Override
    public int getCount() {

        return views != null ? views.size() : 0;
    }

    public void setData(String[] welcomeTv) {
        for (int i = 0; i < welcomeTv.length; i++) {
            TextView tv = new TextView(context);
            // 设置文字背景透明 字体大小 颜色
            tv.setBackgroundColor(Color.TRANSPARENT);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(20);
            tv.setTextColor(Color.WHITE);
            tv.setText(welcomeTv[i]);
            views.add(tv);
        }
    }


    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }


    /**
     * 删除视图
     *
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(View container, int position, Object object) {

        if (position < views.size())
            ((ViewPager) container).removeView(views.get(position));
    }

    /**
     * 得到行布局的位置
     *
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        return views.indexOf(object);
    }

    /**
     * 增加视图
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(View container, int position) {
        if (position < views.size()) {
            final TextView textView = views.get(position);
            ((ViewPager) container).addView(textView);
            return views.get(position);
        }
        return null;
    }

}