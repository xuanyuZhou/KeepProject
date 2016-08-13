package com.example.dllo.keepproject.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FindFmSelectionBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.adapter.FindFmSelectionLvAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/12.
 */
public class FindSelectionsActivity extends AbsBaseActivity implements OnHttpCallback<FindFmSelectionBean>, View.OnClickListener {
    private ImageView backIv;
    private TextView nameTv;
    private ImageView photoIv;
    private ListView listView;
    private String selectionsUrl = "http://api.gotokeep.com/v1.1/favorites/folders?type=pin";
    private FindFmSelectionLvAdapter selectionLvAdapter;
    @Override
    protected int setLayout() {
        return R.layout.activity_find_selections;
    }

    @Override
    protected void initView() {
        nameTv = byView(R.id.find_fragment_selection_Tv);
        photoIv = byView(R.id.find_fragment_selection_Iv);
        listView = byView(R.id.find_activity_lv);
        backIv = byView(R.id.find_activity_back_Iv);

    }

    @Override
    protected void initListeners() {
        backIv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

        Map<String,String> headMap = new HashMap<>();
        headMap.put("Server","openresty");
        headMap.put("Date","Fri, 12 Aug 2016 08:03:54 GMT");
        headMap.put("Content-Type","application/json; charset=utf-8");
        headMap.put("Connection","keep-alive");
        headMap.put("X-Content-Type-Options"," nosniff");
        headMap.put("X-Frame-Options","SAMEORIGIN");
        headMap.put("X-Download-Options","noopen");
        headMap.put("X-XSS-Protection: 1","mode=block");
        headMap.put("Access-Control-Allow-Origin","*");
        headMap.put("Access-Control-Allow-Methods","GET, POST, OPTIONS, DELETE, PUT");
        headMap.put("Access-Control-Allow-Headers","Accept, Authorization, Content-Type, Origin, X-Requested-With");
        headMap.put("ETag","W/\"2f58-nxeING3PhlYxFOzPvQq5PQ\"");
        DlaHttp tool = DlaHttp.getInstance();
        tool.startRequest(selectionsUrl, FindFmSelectionBean.class,headMap,this);


    }

    @Override
    public void onSuccess(FindFmSelectionBean response) {
        selectionLvAdapter = new FindFmSelectionLvAdapter(this);
        selectionLvAdapter.setData(response,2);
        listView.setAdapter(selectionLvAdapter);
    }

    @Override
    public void onError(Throwable ex) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.find_activity_back_Iv:
                finish();
                break;
        }
    }
}
