package com.example.dllo.keepproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * Created by dllo on 16/8/17.
 * 自定义videoView 适应屏幕
 */
public class DIYVideoView extends VideoView {
    public DIYVideoView(Context context) {
        super(context);
    }

    public DIYVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DIYVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}
