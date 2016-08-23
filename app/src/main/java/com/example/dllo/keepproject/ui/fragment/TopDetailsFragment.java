package com.example.dllo.keepproject.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.db.DBTool;
import com.example.dllo.keepproject.model.bean.TopDetailsBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.adapter.TopDetailsRvAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/19.
 */
public class TopDetailsFragment extends AbsBaseFragment {
    private RecyclerView topDetailsRv;
    private TopDetailsRvAdapter rvAdapter;
    private String url;
    private int type;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_top_details;
    }

    @Override
    protected void initView() {
        topDetailsRv = byView(R.id.top_details_Rv);

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initDatas() {
        // 接值
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        type = bundle.getInt("type");

        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", " bdss02");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", " Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyIsImV4cCI6MTQ3NDI0NjI1MSwiaWF0IjoxNDcxNjU0MjUxfQ.CbPhlRaJ6OWNo6pXXSSMkYvBIdXpKqQrGJFdyTq-xmc");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(url, TopDetailsBean.class, headMap, new OnHttpCallback<TopDetailsBean>() {
            @Override
            public void onSuccess(TopDetailsBean response) {
                rvAdapter = new TopDetailsRvAdapter(context,type);
                rvAdapter.setBean(response);
                topDetailsRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
                topDetailsRv.setAdapter(rvAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });



    }
    /**
     * 复用fragment的方法
     *
     * @param url 通过不同的url实现复用
     * @return
     */
    public static TopDetailsFragment getFragments(String url) {
        TopDetailsFragment topDetailsFragment = new TopDetailsFragment();
        // 利用Activity 向fragment里传值   key - value 形式
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        // setArgument 来传递参数. getArgument 得到参数
        topDetailsFragment.setArguments(bundle);
        return topDetailsFragment;
    }
    public static TopDetailsFragment getFragments(String url,int type) {
        TopDetailsFragment topDetailsFragment = new TopDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", url);
        bundle.putInt("type",type);
        topDetailsFragment.setArguments(bundle);
        return topDetailsFragment;
    }
}
