package com.example.dllo.keepproject.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.CityActivityBean;
import com.example.dllo.keepproject.model.bean.PinyinBean;
import com.example.dllo.keepproject.ui.adapter.CityAdapter;
import com.example.dllo.keepproject.view.CircleTextView;
import com.example.dllo.keepproject.view.MySlideView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by dllo on 16/8/18.
 * 这里是选择城市的Activity
 */
public class CityActivity extends AbsBaseActivity implements MySlideView.onTouchListener, CityAdapter.onItemClickListener, View.OnClickListener {

    private List<CityActivityBean> cityActivityBeanList = new ArrayList<>();
    private Set<String>firstPinYin = new LinkedHashSet<>();
    public static List<String> pinyinList = new ArrayList<>();
    private PinyinComparator pinyinComparator;
    private ImageView cityBackIv;

    private MySlideView mySlideView;
    private CircleTextView circleTxt;

    private RecyclerView recyclerView;
    private TextView tvStickyHeaderView;
    private CityAdapter adapter;
    private LinearLayoutManager layoutManager;
    @Override
    protected int setLayout() {
        return R.layout.activity_city;
    }

    @Override
    protected void initView() {
        mySlideView = byView(R.id.my_slide_view);
        circleTxt = byView(R.id.my_circle_view);
        tvStickyHeaderView = byView(R.id.tv_sticky_header_view);
        recyclerView = byView(R.id.rv_sticky_example);
        cityBackIv = byView(R.id.city_backIv);

    }

    @Override
    protected void initListeners() {
        mySlideView.setListener(this);
        cityBackIv.setOnClickListener(this);


    }

    @Override
    protected void initDatas() {
        cityActivityBeanList.clear();
        firstPinYin.clear();
        pinyinList.clear();
        pinyinComparator = new PinyinComparator();
        for (int i = 0; i < CityActivityBean.stringCitys.length; i++) {
            CityActivityBean cityActivityBean = new CityActivityBean();
            cityActivityBean.setCityName(CityActivityBean.stringCitys[i]);
            cityActivityBean.setCityPinyin(transformPinYin(CityActivityBean.stringCitys[i]));
            cityActivityBeanList.add(cityActivityBean);
        }
        Collections.sort(cityActivityBeanList, pinyinComparator);
        for (CityActivityBean cityActivityBean : cityActivityBeanList) {
            firstPinYin.add(cityActivityBean.getCityPinyin().substring(0, 1));
        }
        for (String string : firstPinYin) {
            pinyinList.add(string);
        }
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CityAdapter(getApplicationContext(), cityActivityBeanList);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


                View stickyInfoView = recyclerView.findChildViewUnder(tvStickyHeaderView.getMeasuredWidth()/2,5);
                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tvStickyHeaderView.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                View transInfoView = recyclerView.findChildViewUnder(
                        tvStickyHeaderView.getMeasuredWidth() / 2, tvStickyHeaderView.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tvStickyHeaderView.getMeasuredHeight();
                    if (transViewStatus == CityAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tvStickyHeaderView.setTranslationY(dealtY);
                        } else {
                            tvStickyHeaderView.setTranslationY(0);
                        }
                    } else if (transViewStatus == CityAdapter.NONE_STICKY_VIEW) {
                        tvStickyHeaderView.setTranslationY(0);
                    }
                }






            }
        });

    }



    public String transformPinYin(String character) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < character.length(); i++) {
            buffer.append(PinyinBean.toPinyin(character.charAt(i)));
        }
        return buffer.toString();
    }

    @Override
    public void showTextView(String textView, boolean dismiss) {
        if (dismiss) {
            circleTxt.setVisibility(View.GONE);
        } else {
            circleTxt.setVisibility(View.VISIBLE);
            circleTxt.setText(textView);
        }

        int selectPosition = 0;
        for (int i = 0; i < cityActivityBeanList.size(); i++) {
            if (cityActivityBeanList.get(i).getFirstPinYin().equals(textView)) {
                selectPosition = i;
                break;
            }
        }
        recyclerView.scrollToPosition(selectPosition);
    }

    @Override
    public void itemClick(int position) {
        Toast.makeText(getApplicationContext(), "你选择了:" + cityActivityBeanList.get(position).getCityName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.city_backIv:
                finish();
                break;
        }
    }


    public class PinyinComparator implements Comparator<CityActivityBean> {
        @Override
        public int compare(CityActivityBean cityActivityBeanFirst, CityActivityBean cityActivityBeanSecond) {
            return cityActivityBeanFirst.getCityPinyin().compareTo(cityActivityBeanSecond.getCityPinyin());
        }
    }
}
