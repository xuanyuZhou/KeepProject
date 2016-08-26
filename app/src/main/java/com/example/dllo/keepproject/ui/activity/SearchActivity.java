package com.example.dllo.keepproject.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.SearchBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.adapter.SearchLvAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/24.
 * 搜索界面
 */
public class SearchActivity extends AbsBaseActivity implements TextWatcher, View.OnClickListener {
    private EditText searchEt;
    private TextView cancelTv;
    private ListView searchLv;
    private SearchLvAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        searchEt = byView(R.id.search_Et);
        cancelTv = byView(R.id.search_cancel);
        searchLv = byView(R.id.search_Lv);
    }

    @Override
    protected void initListeners() {

        searchEt.addTextChangedListener(this);
        cancelTv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {


    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String content = searchEt.getText().toString();
        if (!content.isEmpty()) {
            String searchContent = String.valueOf(s);
            String y = null;
            try {
                y = new String(searchContent.getBytes(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            String url = "http://api.gotokeep.com/v1.1/search?keyword=" + y;
            Map<String, String> headMap = new HashMap<>();
            headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
            headMap.put("X-KEEP-FROM", "android");
            headMap.put("X-KEEP-TIMEZONE", "America/New_York");
            headMap.put("X-KEEP-CHANNEL", " bdss02");
            headMap.put("X-KEEP-VERSION", "3.8.1");
            headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyIsImV4cCI6MTQ3NDU5MjA1NywiaWF0IjoxNDcyMDAwMDU3fQ.HKmWgMWRQmo8k-09U9edYRZ-EzSYDGXGwwvGBUV1fg0");
            headMap.put("Connection", "Keep-Alive");
            DlaHttp tool = DlaHttp.getInstance();
            tool.startRequest(url, SearchBean.class, headMap, new OnHttpCallback<SearchBean>() {
                @Override
                public void onSuccess(SearchBean response) {
                    adapter = new SearchLvAdapter(MyApp.getContext());
                    adapter.setBean(response);
                    searchLv.setAdapter(adapter);
                }

                @Override
                public void onError(Throwable ex) {

                }
            });
        }

    }

    @Override
    public void afterTextChanged(Editable s) {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_cancel:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;
        }
    }
}
