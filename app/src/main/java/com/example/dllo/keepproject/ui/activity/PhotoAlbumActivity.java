package com.example.dllo.keepproject.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.PhotoAlbumBean;
import com.example.dllo.keepproject.tools.DepthPageTransformer;
import com.example.dllo.keepproject.ui.adapter.PhotoAlbumViewPagerAdapter;
import com.example.dllo.keepproject.view.MyTestView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/16.
 * 这里是我自己定义相册的Activity
 */
public class PhotoAlbumActivity extends AbsBaseActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private PhotoAlbumViewPagerAdapter viewPagerAdapter;
    private List<PhotoAlbumBean> datas = new ArrayList<>();
    private ImageView photoAlbumBack;
    private MyTestView testView;
    private int xDown, xMove, yDown, yMove, dx, dy;
    @Override
    protected int setLayout() {
        return R.layout.activity_photo_album;
    }

    @Override
    protected void initView() {
        testView = byView(R.id.photoAlbum_myTestView);
        photoAlbumBack = byView(R.id.photoAlbum_back);
        viewPager = byView(R.id.photoAlbum_viewPager);
    }

    @Override
    protected void initListeners() {
        photoAlbumBack.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        // 自定义相册这里是viewpager的滑动增加页面
        datas = new ArrayList<>();
        datas.add(new PhotoAlbumBean(R.mipmap.keepone));
        datas.add(new PhotoAlbumBean(R.mipmap.keeptwo));
        datas.add(new PhotoAlbumBean(R.mipmap.keepthree));
        datas.add(new PhotoAlbumBean(R.mipmap.keepfour));
        datas.add(new PhotoAlbumBean(R.mipmap.keepxxx));
        datas.add(new PhotoAlbumBean(R.mipmap.keepsix));
        datas.add(new PhotoAlbumBean(R.mipmap.keepseven));


        viewPagerAdapter = new PhotoAlbumViewPagerAdapter(this);
        viewPagerAdapter.setDatas(datas);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setPageTransformer(true,new DepthPageTransformer());
    }
    // 这里是自定义Textview移动算法
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                xDown = x;
                yDown = y;
                break;
            case MotionEvent.ACTION_MOVE:
                xMove = x;
                yMove = y;
                dx = xMove - xDown;
                dy = yMove - yDown;

                float scaleX = testView.getScrollX();

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.photoAlbum_back:
                finish();
                break;
        }
    }
}
