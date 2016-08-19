package com.example.dllo.keepproject.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FocusGroupBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.activity.GroupDetailsActivity;
import com.example.dllo.keepproject.ui.adapter.FocusGroupAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.MyCustomListView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/12.
 * 关注 - 小组
 */
public class FocusGroupFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener {
    // 没有加入任何小组的线性布局
    private LinearLayout noJoinLayout;
    private MyCustomListView groupLV;
    private FocusGroupAdapter groupAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_focus_group;
    }

    @Override
    protected void initView() {
        noJoinLayout = byView(R.id.focus_group_layout);
        groupLV = byView(R.id.focus_group_lv);

    }

    @Override
    protected void setListeners() {

        groupLV.setOnItemClickListener(this);

    }

    @Override
    protected void initDatas() {

        initGroupData();


    }

    public void initGroupData() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", " bdss02");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlhdCI6MTQ3MTIyMjM5MywiZXhwIjoxNDczODE0MzkzLCJpc3MiOiJodHRwOi8vd3d3LmdvdG9rZWVwLmNvbS8ifQ.s6-BH03NGx0BkTZJWoyl4c_VhBBb6-CC8pkt3CGRuaE");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");

        DlaHttp tools = DlaHttp.getInstance();
        tools.startRequest(UrlBean.GROUP_URL, FocusGroupBean.class, headMap, new OnHttpCallback<FocusGroupBean>() {
            @Override
            public void onSuccess(FocusGroupBean response) {


                groupAdapter = new FocusGroupAdapter(MyApp.getContext());
                groupAdapter.setBean(response);
                groupLV.setAdapter(groupAdapter);

            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    /**
     * 行监听 传头像 成员 动态  图片 和拼接网址
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        FocusGroupBean.DataBean.RecommendedBean bean = (FocusGroupBean.DataBean.RecommendedBean) parent.getItemAtPosition(position);
        bundle.putString("title", bean.getGroupName());
        bundle.putString("groupMember", String.valueOf(bean.getMemberCount()));
        bundle.putString("groupCards", String.valueOf(bean.getTotalEntries()));
        bundle.putString("headImage", bean.getAvatar());
        bundle.putString("url", UrlBean.GROUP_URL + "/" + bean.getId());
        Log.d("FocusGroupFragment", "bean:" + bean);
        goTo(context, GroupDetailsActivity.class, bundle);
    }
}
