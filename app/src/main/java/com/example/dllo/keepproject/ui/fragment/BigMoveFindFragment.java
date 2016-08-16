package com.example.dllo.keepproject.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FindFmSelectionBean;
import com.example.dllo.keepproject.model.bean.FindFmTrendsBean;
import com.example.dllo.keepproject.model.bean.FindFmrecommendBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.activity.BigMoveViewPageActivity;
import com.example.dllo.keepproject.ui.activity.FindSelectionsActivity;
import com.example.dllo.keepproject.ui.adapter.FindFmSelectionLvAdapter;
import com.example.dllo.keepproject.ui.adapter.FindFmTrendsGvAdapter;
import com.example.dllo.keepproject.ui.adapter.FindRecommendRvAdapter;
import com.example.dllo.keepproject.view.MyCustomGridView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/11.
 */
public class BigMoveFindFragment extends AbsBaseFragment implements View.OnClickListener {
    private ImageView keepIv;
    private TextView nameTv;
    private TextView userNameTv;
    private TextView sourceTv;
    private ImageView avatarIv;
    private ImageView photoIv;
    private ImageView goToIv;
    private TextView gvContentTv;
    private TextView gvLikesTv;
    private TextView gvCommentTv;
    private ImageView gvPhotoIv;
    private ListView seletionsListView;
    private RecyclerView recommmendRv;
    private MyCustomGridView myCustomGridView;
    private FindFmTrendsGvAdapter trendsGvAdapter;
    private String trendsUrl = "http://api.gotokeep.com/v1.1/timeline/hot";
    private String recommendUrl = "http://api.gotokeep.com/v1.1/rankinglist/user/recommend";
    private String selectionsUrl = "http://api.gotokeep.com/v1.1/favorites/folders?type=pin";
    private FindFmSelectionLvAdapter selectionLvAdapter;
    private FindRecommendRvAdapter recommendRvAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        nameTv = byView(R.id.find_fragment_selection_Tv);
        photoIv = byView(R.id.find_fragment_selection_Iv);
        userNameTv = byView(R.id.find_fragment_recommend_username);
        sourceTv = byView(R.id.find_fragment_recommend_source);
        avatarIv = byView(R.id.find_fragment_recommend_avatarIv);
        goToIv = byView(R.id.find_fragment_selection_goTo_Iv);
        gvCommentTv = byView(R.id.find_fragment_trends_comments);
        gvContentTv = byView(R.id.find_fragment_trends_content);
        gvLikesTv = byView(R.id.find_fragment_trends_likes);
        gvPhotoIv = byView(R.id.find_fragment_trends_photo);
        myCustomGridView = byView(R.id.find_fragment_recommend_gv);
        seletionsListView = byView(R.id.find_fragment_selection_Lv);
        recommmendRv = byView(R.id.find_fragment_recommend_rv);
        keepIv = byView(R.id.find_fragment_keep_goToIv);


    }

    @Override
    protected void setListeners() {
        goToIv.setOnClickListener(this);
        keepIv.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        initFindRvData();
        initFindLvData();
        initFindGvData();

    }

    /**
     * 这里是解析精选合集的东西
     */
    private void initFindLvData() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("Server", "openresty");
        headMap.put("Date", "Fri, 12 Aug 2016 08:03:54 GMT");
        headMap.put("Content-Type", "application/json; charset=utf-8");
        headMap.put("Connection", "keep-alive");
        headMap.put("X-Content-Type-Options", " nosniff");
        headMap.put("X-Frame-Options", "SAMEORIGIN");
        headMap.put("X-Download-Options", "noopen");
        headMap.put("X-XSS-Protection: 1", "mode=block");
        headMap.put("Access-Control-Allow-Origin", "*");
        headMap.put("Access-Control-Allow-Methods", "GET, POST, OPTIONS, DELETE, PUT");
        headMap.put("Access-Control-Allow-Headers", "Accept, Authorization, Content-Type, Origin, X-Requested-With");
        headMap.put("ETag", "W/\"2f58-nxeING3PhlYxFOzPvQq5PQ\"");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(selectionsUrl, FindFmSelectionBean.class, headMap, new OnHttpCallback<FindFmSelectionBean>() {
            @Override
            public void onSuccess(FindFmSelectionBean response) {
                selectionLvAdapter = new FindFmSelectionLvAdapter(context);
                selectionLvAdapter.setData(response, 1);
                seletionsListView.setAdapter(selectionLvAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    private void initFindRvData() {
        Map<String, String> rvHeadMap = new HashMap<>();
        rvHeadMap.put("x-device-id", "000000000000000080027dfd41d11111b0c27dbf");
        rvHeadMap.put("X-KEEP-FROM", "android");
        rvHeadMap.put("X-KEEP-TIMEZONE", "America/New_York");
        rvHeadMap.put("X-KEEP-CHANNEL", "baidu");
        rvHeadMap.put("X-DEVICE", "unknown-Google Nexus 5 - 5.1.0 - API 22 - 1080x1920");
        rvHeadMap.put("X-KEEP-VERSION", "3.8.1");
        rvHeadMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2E3ZDRmZDRhMzEyMTY0MTRiZDZlM2QiLCJ1c2VybmFtZSI6Ik1hcnPlhqzlrp0iLCJhdmF0YXIiOiJodHRwOi8vc3RhdGljMS5nb3Rva2VlcC5jb20vYXZhdGFyLzIwMTYvMDgvMDgvMDgvM2VmNTUyMjJmODNlNTdkOWEyZmFlMjg1ODRiMGMzZTg5YzE3ZGEyNC5qcGciLCJpYXQiOjE0NzEwNDczNDMsImV4cCI6MTQ3MzYzOTM0MywiaXNzIjoiaHR0cDovL3d3dy5nb3Rva2VlcC5jb20vIn0.jgLJUAM8LmWozbrbDF2xoEXtJtZFC_zcfXfaCOqSSb4");
        rvHeadMap.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1; Google Nexus 5 - 5.1.0 - API 22 - 1080x1920 Build/LMY47D) Paros/3.2.13");
        rvHeadMap.put("Host", "api.gotokeep.com");
        rvHeadMap.put("Connection", "Keep-Alive");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(recommendUrl, FindFmrecommendBean.class, rvHeadMap, new OnHttpCallback<FindFmrecommendBean>() {
            @Override
            public void onSuccess(FindFmrecommendBean response) {
                recommendRvAdapter = new FindRecommendRvAdapter(context);
                recommendRvAdapter.setDatas(response);
                recommmendRv.setAdapter(recommendRvAdapter);
                recommmendRv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    private void initFindGvData() {
        Map<String, String> gvHeadMap = new HashMap<>();
        gvHeadMap.put("x-device-id", "000000000000000080027dfd41d11111b0c27dbf");
        gvHeadMap.put("X-KEEP-FROM", "android");
        gvHeadMap.put("X-KEEP-TIMEZONE", "America/New_York");
        gvHeadMap.put("X-KEEP-CHANNEL", "baidu");
        gvHeadMap.put("X-DEVICE", "unknown-Google Nexus 5 - 5.1.0 - API 22 - 1080x1920");
        gvHeadMap.put("X-KEEP-VERSION", "3.8.1");
        gvHeadMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2E3ZDRmZDRhMzEyMTY0MTRiZDZlM2QiLCJ1c2VybmFtZSI6Ik1hcnPlhqzlrp0iLCJhdmF0YXIiOiJodHRwOi8vc3RhdGljMS5nb3Rva2VlcC5jb20vYXZhdGFyLzIwMTYvMDgvMDgvMDgvM2VmNTUyMjJmODNlNTdkOWEyZmFlMjg1ODRiMGMzZTg5YzE3ZGEyNC5qcGciLCJpYXQiOjE0NzEwNDczNDMsImV4cCI6MTQ3MzYzOTM0MywiaXNzIjoiaHR0cDovL3d3dy5nb3Rva2VlcC5jb20vIn0.jgLJUAM8LmWozbrbDF2xoEXtJtZFC_zcfXfaCOqSSb4");
        gvHeadMap.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 5.1; Google Nexus 5 - 5.1.0 - API 22 - 1080x1920 Build/LMY47D) Paros/3.2.13");
        gvHeadMap.put("Host", "api.gotokeep.com");
        gvHeadMap.put("Connection", "Keep-Alive");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(trendsUrl, FindFmTrendsBean.class, gvHeadMap, new OnHttpCallback<FindFmTrendsBean>() {
            @Override
            public void onSuccess(FindFmTrendsBean response) {
                trendsGvAdapter = new FindFmTrendsGvAdapter(context);
                trendsGvAdapter.setDatas(response);
                myCustomGridView.setAdapter(trendsGvAdapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_fragment_selection_goTo_Iv:
                goTo(context, FindSelectionsActivity.class);

                break;
            case R.id.find_fragment_keep_goToIv:
                goTo(context, BigMoveViewPageActivity.class);
                break;
        }
    }
}
