package com.example.dllo.keepproject.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FocusHasBeenBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.activity.DetailsActivity;
import com.example.dllo.keepproject.ui.adapter.FocusHasBeenAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.MyCustomListView;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/12.
 * 已关注的 fragment
 */
public class FocusHasBeenFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView listView;
    private FocusHasBeenAdapter adapter;
    private CircleImageView topicImg;

    @Override
    protected int setLayout() {
        return R.layout.fragment_focus_hasbeen;
    }

    @Override
    protected void initView() {
        listView = byView(R.id.focus_hasbeen_lv);
        topicImg = byView(R.id.focus_hasbeen_topic);


    }

    @Override
    protected void setListeners() {
        listView.setOnItemClickListener(this);
        topicImg.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

        initHasBeenData();

    }

    public void initHasBeenData() {
        Map<String,String> headMap = new HashMap<>();
        headMap.put("x-device-id","000000000000000080027f482c2111119b127f0a");
        headMap.put("X-KEEP-FROM","android");
        headMap.put("X-KEEP-TIMEZONE","America/New_York");
        headMap.put("X-KEEP-CHANNEL"," bdss02");
        headMap.put("X-KEEP-VERSION","3.8.1");
        headMap.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlhdCI6MTQ3MDk4OTY4NCwiZXhwIjoxNDczNTgxNjg0LCJpc3MiOiJodHRwOi8vd3d3LmdvdG9rZWVwLmNvbS8ifQ.Jf1lL81CMcsuu4-xRstXnRVOGAcXKifndx7pYQl3v3Q");
        headMap.put("Host","api.gotokeep.com");
        headMap.put("Connection","Keep-Alive");
        DlaHttp tool = DlaHttp.getInstance();

        tool.startRequest(UrlBean.HAS_BEEN_URL, FocusHasBeenBean.class, headMap, new OnHttpCallback<FocusHasBeenBean>() {
            @Override
            public void onSuccess(FocusHasBeenBean response) {

                adapter = new FocusHasBeenAdapter(MyApp.getContext());
                adapter.setBean(response);
                listView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        goTo(MyApp.getContext(), DetailsActivity.class);
    }

    @Override
    public void onClick(View v) {

    }
}
