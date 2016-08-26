package com.example.dllo.keepproject.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.db.DBTool;
import com.example.dllo.keepproject.model.bean.GroupNewsBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.model.net.VolleyInstance;
import com.example.dllo.keepproject.ui.adapter.GroupDetailsNewsAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.NestedListView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/16.
 * 小组 - 最新
 */
public class GroupNewsFragment extends AbsBaseFragment {
    private NestedListView newsLv;
    private GroupDetailsNewsAdapter adapter;
    private NestedScrollView nestedSV;
    private Button newsBtn;


    @Override
    protected int setLayout() {
        return R.layout.fragment_news_group;
    }

    @Override
    protected void initView() {
        newsLv = byView(R.id.news_LV);
        newsBtn = byView(R.id.news_group_btn);
        nestedSV = byView(R.id.news_nestedSV);

    }

    @Override
    protected void setListeners() {

        // 当 刚开始进入的时候 view 是V的 向上滑动的时候 一直不出现 动画
        // 当 VIew是I 的 向上滑动也不出现
        // 当 刚来时进入的时候 view是V的.向下一直不消失
        // 当 view 是I的时候 出现 动画
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
        String url = bundle.getString("url") + "/entries";
        initNewsData(url);
    }


    private void initNewsData(String url) {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", " bdss02");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyIsImV4cCI6MTQ3NDAzMDEzNCwiaWF0IjoxNDcxNDM4MTM0fQ.waIRXnjf5_hWvwnB7f_Frjfzid4tmJfvrm-Q1NDGiA8");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");
        DlaHttp tools = DlaHttp.getInstance();


        tools.startRequest(url, GroupNewsBean.class, headMap, new OnHttpCallback<GroupNewsBean>() {


            @Override
            public void onSuccess(GroupNewsBean response) {
                adapter = new GroupDetailsNewsAdapter(MyApp.getContext());
                adapter.setBean(response);
                newsLv.setAdapter(adapter);

            }

            @Override
            public void onError(Throwable ex) {


            }
        });
    }
}
