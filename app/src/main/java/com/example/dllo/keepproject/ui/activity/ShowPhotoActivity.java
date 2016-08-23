package com.example.dllo.keepproject.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/20.
 * 点击查看大图的Activity
 * 通过手势判断 显示大图后点击退出
 */
public class ShowPhotoActivity extends AbsBaseActivity {
    private ImageView showPhotoImage;
    private String url;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected int setLayout() {
        return R.layout.activity_showphoto;
    }

    @Override
    protected void initView() {

        showPhotoImage = byView(R.id.showPhoto_Image);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {
        intent = getIntent();
        bundle = intent.getExtras();
        url = bundle.getString("image");
        Picasso.with(this).load(url).config(Bitmap.Config.RGB_565).into(showPhotoImage);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                 finish();
                break;
        }
        return super.onTouchEvent(event);
    }
}
