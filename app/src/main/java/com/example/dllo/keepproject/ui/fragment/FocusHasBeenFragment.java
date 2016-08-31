package com.example.dllo.keepproject.ui.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FocusHasBeenBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.ui.activity.DetailsActivity;
import com.example.dllo.keepproject.ui.activity.DynamicActivity;
import com.example.dllo.keepproject.ui.activity.DynamicSingleActivity;
import com.example.dllo.keepproject.ui.adapter.FocusHasBeenAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.MyCustomListView;
import com.example.dllo.keepproject.view.RefreshListView;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/12.
 * 已关注的 fragment
 */
public class FocusHasBeenFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {

    private RefreshListView listView;
    private FocusHasBeenAdapter adapter;
    private CircleImageView topicImg;
//    private int pos = 6;
//    private int postion = 20;
//    private int num;
//    private String id;


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

        // 下拉刷新
        // 我的自定义lv继承自定义的接口
        listView.setonRefreshListener(new RefreshListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 异步任务
                new AsyncTask<Void, Void, Void>() {

                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(500);

                            initHasBeenData();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        return null;
                    }

                    protected void onPostExecute(Void result) {
                        adapter.notifyDataSetChanged();
                        listView.onRefreshComplete();

                    }

                    ;

                }.execute();

            }
        });
    }


//        // 上拉加载
//        listView.setOnLoadMoreListener(new RefreshListView.IOnLoadMoreListener() {
//
//
//            @Override
//            public void OnLoadMore() {
//
//
//                // 异步任务
//                new AsyncTask<Void, Void, Void>() {
//
//                    @Override
//                    protected Void doInBackground(Void... params) {
//                        try {
//                            Thread.sleep(500);
//                            Map<String, String> headMap = new HashMap<>();
//                            headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
//                            headMap.put("X-KEEP-FROM", "android");
//                            headMap.put("X-KEEP-TIMEZONE", "America/New_York");
//                            headMap.put("X-KEEP-CHANNEL", " bdss02");
//                            headMap.put("X-KEEP-VERSION", "3.8.1");
//                            headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlhdCI6MTQ3MDk4OTY4NCwiZXhwIjoxNDczNTgxNjg0LCJpc3MiOiJodHRwOi8vd3d3LmdvdG9rZWVwLmNvbS8ifQ.Jf1lL81CMcsuu4-xRstXnRVOGAcXKifndx7pYQl3v3Q");
//                            headMap.put("Host", "api.gotokeep.com");
//                            headMap.put("Connection", "Keep-Alive");
//                            DlaHttp tool = DlaHttp.getInstance();
//
//                            tool.startRequest(UrlBean.HAS_BEEN_URL + "?lastid=" + id, FocusHasBeenBean.class, headMap, new OnHttpCallback<FocusHasBeenBean>() {
//                                @Override
//                                public void onSuccess(FocusHasBeenBean response) {
////
////                                    if (postion < 100){
////                                        adapter.refreshIndex(postion);
////
////                                    }
//                                    postion += 20;
//                                    Log.d("FocusHasBeenFragment", "postion:" + postion);
//                                    Log.d("FocusHasBeenFragment", (UrlBean.HAS_BEEN_URL + "?lastid=" + id));
//                                    id = response.getData().get(19).getId();
//                                    adapter.setBean(response);
//                                    adapter.refreshIndex(postion);
//                                    listView.onLoadMoreComplete(true);
//                                    adapter.notifyDataSetChanged();
//                                    Log.d("FocusHasBeenFragment", "postion:" + postion);
//                                    listView.setAdapter(adapter);
//                                }
//
//                                @Override
//                                public void onError(Throwable ex) {
//
//                                }
//                            });
//
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        return null;
//                    }
//
//                    protected void onPostExecute(Void result) {
//
//
//
//                                                       if (pos <= num - 2) {
//                                                           pos += 2;
//                                                           adapter.refreshIndex(pos);
//                                                       }
//                                                       adapter.notifyDataSetChanged();
//                                                       if (pos >= num) {
//
//                                                           listView.onLoadMoreComplete(true);
//
//                                                       } else {
//                                                           listView.onLoadMoreComplete(false);
//
//                                                       }
//
//
//                    }
//
//                    ;
//                }.execute();
//
//
//            }
//        });


    public void initHasBeenData() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", " bdss02");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2FkMWM4MjFiY2M1YjJlMTg2NTA4YzAiLCJ1c2VybmFtZSI6IumYv-emu-emu-WViiIsImF2YXRhciI6IiIsImlhdCI6MTQ3MDk4OTY4NCwiZXhwIjoxNDczNTgxNjg0LCJpc3MiOiJodHRwOi8vd3d3LmdvdG9rZWVwLmNvbS8ifQ.Jf1lL81CMcsuu4-xRstXnRVOGAcXKifndx7pYQl3v3Q");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");
        DlaHttp tool = DlaHttp.getInstance();


        tool.startRequest(UrlBean.HAS_BEEN_URL, FocusHasBeenBean.class, headMap, new OnHttpCallback<FocusHasBeenBean>() {
            @Override
            public void onSuccess(FocusHasBeenBean response) {

                //num = response.getData().size();
//                StringBuffer sb = new StringBuffer();
//                sb.append(response.getData().get());
                // id = response.getData().get(19).getId();
                adapter = new FocusHasBeenAdapter(context);
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
        Bundle bundle = new Bundle();
        FocusHasBeenBean.DataBean bean = (FocusHasBeenBean.DataBean) parent.getItemAtPosition(position);
        bundle.putString("url", "http://api.gotokeep.com/v1.1/entries/" + bean.get_id() + "?limit=20&reverse=true");
        goTo(context, DynamicSingleActivity.class, bundle);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.focus_hasbeen_topic:
                goTo(context, DynamicActivity.class);
                getActivity().overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;
        }

    }
}
