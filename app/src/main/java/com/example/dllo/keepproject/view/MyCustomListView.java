package com.example.dllo.keepproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by dllo on 16/7/13.
 * 指南页面下面那个
 * 自定义listview
 */
public class MyCustomListView extends ListView {
    public MyCustomListView(Context context) {
        super(context);
    }


    public MyCustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 重新测量 - 规定他的高度是展开的.
     * 展开listview
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    /**
     * 点击事件
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            // 禁止listView滑动
            return true;

        }
        return super.dispatchTouchEvent(ev);
    }
}
