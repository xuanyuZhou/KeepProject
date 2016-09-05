package com.example.dllo.keepproject.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.view.ImageControl;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/20.
 * 点击查看大图的Activity
 * 通过手势判断 显示大图后点击退出
 */
public class ShowPhotoActivity extends AbsBaseActivity {
    private ImageControl showPhotoImage;
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

        // 设置图片放大缩小
        Bitmap bmp;
        if (showPhotoImage.getDrawingCache() != null) {
            bmp = Bitmap.createBitmap(showPhotoImage.getDrawingCache());
        } else {
            bmp = ((BitmapDrawable) showPhotoImage.getDrawable()).getBitmap();
        }
        Rect frame = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        int screenW = this.getWindowManager().getDefaultDisplay().getWidth();
        int screenH = this.getWindowManager().getDefaultDisplay().getHeight()
                - statusBarHeight;
        if (bmp != null) {
            showPhotoImage.imageInit(bmp, screenW, screenH, statusBarHeight,
                    new ImageControl.ICustomMethod() {

                        @Override
                        public void customMethod(Boolean currentStatus) {
                            // 当图片处于放大或缩小状态时，

                        }
                    });
        }

    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                showPhotoImage.mouseDown(event);
                break;

            /**
             * 非第一个点按下
             */
            case MotionEvent.ACTION_POINTER_DOWN:

                showPhotoImage.mousePointDown(event);

                break;
            case MotionEvent.ACTION_MOVE:
                showPhotoImage.mouseMove(event);

                break;

            case MotionEvent.ACTION_UP:
                showPhotoImage.mouseUp();
                break;

        }

        return super.onTouchEvent(event);
    }
}
