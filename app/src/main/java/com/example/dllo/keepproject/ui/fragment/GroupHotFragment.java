package com.example.dllo.keepproject.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.GroupHotBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.adapter.GroupDetailsHotAdapter;
import com.example.dllo.keepproject.ui.adapter.GroupDetailsNewsAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.NestedListView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/16.
 * 小组 - 热门
 */
public class GroupHotFragment extends AbsBaseFragment {

    private NestedListView listView;
    private GroupDetailsHotAdapter adapter;
    private NestedScrollView nestedSV;
    private Button newsBtn;

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_group;
    }

    @Override
    protected void initView() {

        listView = byView(R.id.news_LV);
        newsBtn = byView(R.id.news_group_btn);
        nestedSV = byView(R.id.news_nestedSV);
    }

    @Override
    protected void setListeners() {
        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                newsBtn.setVisibility(View.VISIBLE);
                if ((scrollY - oldScrollY) > 0) {
                    //上
                    if (newsBtn.getVisibility() == View.VISIBLE) {
                        // 消失
                        newsBtn.startAnimation(AnimationUtils.loadAnimation(context, R.anim.botton_in));

                    } else if (newsBtn.getVisibility() == View.INVISIBLE) {
                        newsBtn.setVisibility(View.INVISIBLE);
                    }

                } else {
                    //下
                    // 下滑的时候 没出现 加个动画让它出现
                    if (newsBtn.getVisibility() == View.INVISIBLE) {
                        newsBtn.startAnimation(AnimationUtils.loadAnimation(context, R.anim.botton_out));
                    } else if (newsBtn.getVisibility() == View.VISIBLE) {
                        newsBtn.setVisibility(View.VISIBLE);
                    }

                }
            }
        });


    }

    @Override
    protected void initDatas() {
        Bundle bundle = getArguments();
        String url = bundle.getString("url") + "/hotentries";
        initHotData(url);
    }

    private void initHotData(String url) {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", " bdss02");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyIsImV4cCI6MTQ3MzkwMDcwMSwiaWF0IjoxNDcxMzA4NzAxfQ.UYdr4yZcvN8Y4nwlWNo8toC8nLzK-XUGimgQGF5ZgFY");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");

        DlaHttp tools = DlaHttp.getInstance();
        tools.startRequest(url, GroupHotBean.class, headMap, new OnHttpCallback<GroupHotBean>() {
            @Override
            public void onSuccess(GroupHotBean response) {
                adapter = new GroupDetailsHotAdapter(MyApp.getContext());
                adapter.setBean(response);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
