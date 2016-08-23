package com.example.dllo.keepproject.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.TopicActivityBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.adapter.TopicActivityLvAdaptet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/15.
 * 这里是热门话题的activity
 */
public class TopicActivity extends AbsBaseActivity implements View.OnClickListener, OnHttpCallback<TopicActivityBean> {
    private TextView nameTv;
    private TextView contentTv;
    private TextView countTv;
    private ImageView topicBack;
    private ImageView coverIv;
    private ListView topicListView;
    private String topicAvtivityUrl = "http://api.gotokeep.com/v1.1/hashtag/?type=hot&perPage=10";
    private TopicActivityLvAdaptet lvAdaptet;
    @Override
    protected int setLayout() {
        return R.layout.activity_topic;
    }

    @Override
    protected void initView() {
        nameTv = byView(R.id.topic_activity_nameTv);
        contentTv = byView(R.id.topic_activity_contentTv);
        countTv = byView(R.id.topic_activity_count);
        coverIv = byView(R.id.topic_activity_coverIv);
        topicListView = byView(R.id.topic_activity_lv);
        topicBack = byView(R.id.topic_back);

    }

    @Override
    protected void initListeners() {
        topicBack.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        Map<String,String> headMap = new HashMap<>();
        headMap.put("x-device-id","000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM","android");
        headMap.put("X-KEEP-TIMEZONE","America/New_York");
        headMap.put("X-KEEP-CHANNEL","baidu");
        headMap.put("X-DEVICE","unknown-Google Nexus 5 - 5.1.0 - API 22 - 1080x1920");
        headMap.put("f-None-Match","W/\"2b88-OawtX6C+NwmmTf8YO/DiCw\"");
        headMap.put("X-KEEP-VERSION","3.8.1");
        headMap.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2E3ZDRmZDRhMzEyMTY0MTRiZDZlM2QiLCJ1c2VybmFtZSI6Ik1hcnPlhqzlrp0iLCJhdmF0YXIiOiJodHRwOi8vc3RhdGljMS5nb3Rva2VlcC5jb20vYXZhdGFyLzIwMTYvMDgvMDgvMDgvM2VmNTUyMjJmODNlNTdkOWEyZmFlMjg1ODRiMGMzZTg5YzE3ZGEyNC5qcGciLCJpYXQiOjE0NzEyMjEzNjEsImV4cCI6MTQ3MzgxMzM2MSwiaXNzIjoiaHR0cDovL3d3dy5nb3Rva2VlcC5jb20vIn0.bSL4G5D7qdhf1zTBZSDRnW2zhoK7sRw-IrD1VotO7Vs");
        headMap.put("User-Agent","Dalvik/2.1.0 (Linux; U; Android 5.1; Google Nexus 5 - 5.1.0 - API 22 - 1080x1920 Build/LMY47D) Paros/3.2.13");
        headMap.put("Host","api.gotokeep.com");
        headMap.put("Connection","Keep-Alive\n");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(topicAvtivityUrl, TopicActivityBean.class,headMap,this);

    }



    @Override
    public void onSuccess(TopicActivityBean response) {
        lvAdaptet = new TopicActivityLvAdaptet(this);
        lvAdaptet.setDatas(response);
        topicListView.setAdapter(lvAdaptet);
    }

    @Override
    public void onError(Throwable ex) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.topic_back:
                finish();
                break;
        }
    }
}
