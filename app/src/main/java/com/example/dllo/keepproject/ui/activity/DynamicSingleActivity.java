package com.example.dllo.keepproject.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.DynamicSingleBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.adapter.DynamicSingleLvAdapter;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 * 这里是我的动态单品详情的activity
 */
public class DynamicSingleActivity extends AbsBaseActivity implements OnHttpCallback<DynamicSingleBean>, View.OnClickListener {
    private TextView contentTv;
    private TextView usernameTv;
    private TextView createdTv;
    private CircleImageView avatarIv;
    private ImageView photoIv;
    private TextView likesTwoIv;
    private CircleImageView avatarTwoIv;
    private TextView commentsThreeIv;
    private ListView dynamicListView;
    private DynamicSingleLvAdapter dynamicSingleLvAdapter;
    private ImageView dynamicBack;
<<<<<<< HEAD
    private String dynamicUrl ;
=======
    //private String dynamicUrl = "http://api.gotokeep.com/v1.1/entries/57b12042aefd06e20c4cacba?limit=20&reverse=true";
    private String dynamicUrl;
>>>>>>> feature/刘冬_findfragment_小组功能开启
    @Override
    protected int setLayout() {
        return R.layout.activity_dynamicsingle;
    }

    @Override
    protected void initView() {
        contentTv = byView(R.id.dynamicsSingle_one_contentTv);
        usernameTv = byView(R.id.dynamicsSingle_one_usernameIv);
        createdTv = byView(R.id.dynamicsSingle_one_createdIv);
        avatarIv = byView(R.id.dynamicsSingle_one_avatarIv);
        photoIv = byView(R.id.dynamicsSingle_one_photoIv);
        dynamicListView = byView(R.id.dynamicSingle_activity_lv);
        dynamicBack = byView(R.id.dynamic_back);
        likesTwoIv = byView(R.id.dynamicsSingle_two_likes);
        avatarTwoIv = byView(R.id.dynamicsSingle_two_avatarIv);
        commentsThreeIv = byView(R.id.dynamicsSingle_three_commentsIv);

    }

    @Override
    protected void initListeners() {
        dynamicBack.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        Map<String,String> headMap = new HashMap<>();
        headMap.put("x-device-id","000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM","android");
        headMap.put("X-KEEP-TIMEZONE","America/New_York");
        headMap.put("X-KEEP-CHANNEL","baidu");
        headMap.put("X-DEVICE","unknown-Google Nexus 5 - 5.1.0 - API 22 - 1080x1920");
        headMap.put("X-KEEP-VERSION","3.8.1");
        headMap.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2E3ZDRmZDRhMzEyMTY0MTRiZDZlM2QiLCJ1c2VybmFtZSI6Ik1hcnPlhqzlrp0iLCJhdmF0YXIiOiJodHRwOi8vc3RhdGljMS5nb3Rva2VlcC5jb20vYXZhdGFyLzIwMTYvMDgvMDgvMDgvM2VmNTUyMjJmODNlNTdkOWEyZmFlMjg1ODRiMGMzZTg5YzE3ZGEyNC5qcGciLCJpYXQiOjE0NzEyNDUzNjQsImV4cCI6MTQ3MzgzNzM2NCwiaXNzIjoiaHR0cDovL3d3dy5nb3Rva2VlcC5jb20vIn0.XBzdUB3_gnbGQxT3VGfHbCCLv9DJlS6BxaRauOE4oTk");
        headMap.put("User-Agent","Dalvik/2.1.0 (Linux; U; Android 5.1; Google Nexus 5 - 5.1.0 - API 22 - 1080x1920 Build/LMY47D) Paros/3.2.13");
        headMap.put("Host","api.gotokeep.com");
        headMap.put("Connection","Keep-Alive");
        Intent intent = getIntent();
        Bundle bundle  = intent.getExtras();
        this.dynamicUrl = bundle.getString("url");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(dynamicUrl, DynamicSingleBean.class,headMap,this);

    }

    @Override
    public void onSuccess(DynamicSingleBean response) {
        dynamicSingleLvAdapter = new DynamicSingleLvAdapter(this);
        dynamicSingleLvAdapter.setDatas(response);
        dynamicListView.setAdapter(dynamicSingleLvAdapter);
    }

    @Override
    public void onError(Throwable ex) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.dynamic_back:
                finish();
                break;
        }
    }
}
