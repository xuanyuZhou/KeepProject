package com.example.dllo.keepproject.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.keepproject.R;

/**
 * Created by dllo on 16/8/20.
 * 消息界面
 */
public class NewsActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout talkLL;
    private LinearLayout mentionLL;
    private LinearLayout likeLL;
    private LinearLayout faneLL;
    private LinearLayout noticeLL;
    private ImageView newsBack;

    @Override
    protected int setLayout() {
        return R.layout.activity_news;
    }

    @Override
    protected void initView() {

        talkLL = byView(R.id.news_talk);
        mentionLL = byView(R.id.news_mention);
        likeLL = byView(R.id.news_like);
        faneLL = byView(R.id.news_fane);
        noticeLL = byView(R.id.news_notice);
        newsBack = byView(R.id.news_back);
    }

    @Override
    protected void initListeners() {
        talkLL.setOnClickListener(this);
        mentionLL.setOnClickListener(this);
        likeLL.setOnClickListener(this);
        faneLL.setOnClickListener(this);
        noticeLL.setOnClickListener(this);
        newsBack.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.news_back:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;
            case R.id.news_talk:
                break;
            case R.id.news_mention:
                break;
            case R.id.news_like:
                break;
            case R.id.news_fane:
                break;
            case R.id.news_notice:
                break;
        }
    }
}
