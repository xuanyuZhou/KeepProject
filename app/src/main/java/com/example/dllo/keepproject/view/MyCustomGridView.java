package com.example.dllo.keepproject.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * Created by dllo on 16/7/16.
 * 自定义的表格布局
 * 导前面三个方法
 */
public class MyCustomGridView extends GridView {

    public MyCustomGridView(Context context) {
        super(context);
    }

    public MyCustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * 展开listview
     * onMeasure 这个方法是决定view的大小
     * 重新测量 - 规定他的高度是展开的.
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //对于详细测量值（ measureSpec ）需要两样东西来确定它，参数是大小（size）和模式（mode）。
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    /**
     * 触摸监听函数
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_MOVE){
            // 禁止listView滑动
            return true;

        }
        return super.dispatchTouchEvent(ev);
    }
}
