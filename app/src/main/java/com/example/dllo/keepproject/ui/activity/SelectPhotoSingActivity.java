package com.example.dllo.keepproject.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.keepproject.view.SmoothImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/17.
 */
public class SelectPhotoSingActivity extends Activity{
    private ArrayList<String> mDatas;
    private int mPosition;
    private int mLocationX;
    private int mLocationY;
    private int mWidth;
    private int mHeight;
    SmoothImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDatas = (ArrayList<String>) getIntent().getSerializableExtra("images");
        mPosition = getIntent().getIntExtra("position", 0);
        mLocationX = getIntent().getIntExtra("locationX", 0);
        mLocationY = getIntent().getIntExtra("locationY", 0);
        mWidth = getIntent().getIntExtra("width", 0);
        mHeight = getIntent().getIntExtra("height", 0);


        imageView = new SmoothImageView(this);
        imageView.setOriginalInfo(mWidth, mHeight, mLocationX, mLocationY);

        imageView.transformIn();
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_START);
        setContentView(imageView);
        Picasso.with(this).load(mDatas.get(mPosition)).into(imageView);
    }

    @Override
    public void onBackPressed() {
       imageView.setOnTransformListener(new SmoothImageView.TransformListener() {
           @Override
           public void onTransformComplete(int mode) {
               if (mode == 2){
                   finish();
               }
           }
       });
        imageView.transformOut();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()){
            overridePendingTransition(0,0);
        }
    }
}
