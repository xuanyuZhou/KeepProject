package com.example.dllo.keepproject.ui.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.WelcomePagerAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.example.dllo.keepproject.view.CustomVideoView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by dllo on 16/8/11.
 */
public class WelcomeActivity extends AbsBaseActivity implements View.OnClickListener {
    private CustomVideoView welcomeVideoView;
    private Button registerBtn;
    private Button loginBtn;
    private WelcomePagerAdapter welcomeAdapter;
    private ViewPager welcomeViewPager;
    private LinearLayout cricleLinearLayout;
    private String tvResIds[] = new String[]{
            "规范你的训练过程",
            "陪伴你迈出跑步的第一步",
            "分享汗水后你的性感",
            "全程记录你的健身过程"
    };
    private int curIndex = 0;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        welcomeVideoView = byView(R.id.welcome_videoview);
        registerBtn = byView(R.id.welcome_register);
        loginBtn = byView(R.id.welcome_login);


    }

    @Override
    protected void initListeners() {

        loginBtn.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        // 显示video
        showVideo();
        // 设置viewpager
        setViewPager();


    }


    private void showVideo() {
        // 添加video的资源
        welcomeVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro));
        welcomeVideoView.start();
        // 播放完成的监听 - 循环播放
        welcomeVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcomeVideoView.start();
            }
        });
    }

    private void setViewPager() {
        welcomeViewPager = byView(R.id.welcome_viewpager);
        cricleLinearLayout = byView(R.id.welcome_linearlayout);
        welcomeAdapter = new WelcomePagerAdapter(MyApp.getContext());
        welcomeAdapter.setData(tvResIds);
        welcomeViewPager.setAdapter(welcomeAdapter);

        // 设置页面切换监听器
        welcomeViewPager.setOnPageChangeListener(new MyPageChangeListener());

        // 获得小圆点出现位置
        initPoints(tvResIds.length);
        // 开启自动播放
        startAutoScrool();

    }

    /**
     * 初始化图片轮播的小圆点和目录
     *
     * @param count
     */
    private void initPoints(int count) {
        for (int i = 0; i < count; i++) {
            // 小圆点
            ImageView littleImg = new ImageView(MyApp.getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(0, 0, 20, 0);
            littleImg.setLayoutParams(params);
            // 小圆点默认颜色
            littleImg.setImageResource(R.mipmap.map_gps_normal);
            // 将小圆点加入到layout中
            cricleLinearLayout.addView(littleImg);
        }

        // 小圆点滑动到的位置为绿色
        ((ImageView) cricleLinearLayout.getChildAt(curIndex)).setImageResource(R.mipmap.map_gps_best);

    }

    /**
     * 自动播放
     */
    private void startAutoScrool() {
        // 开启
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        // 每隔4秒钟切换一张图片
        //安排所提交的Runnable任务在每次执行完后，等待所指定的时间后重复执行。
        // 参数1 要执行的任务
        // 参数2 首次执行的延迟时间
        // 参数3 delay - 一次执行终止和下一次执行开始之间的延迟
        // 参数4 unit - initialdelay 和 delay 参数的时间单位
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(), 5, 4, TimeUnit.SECONDS);

    }

    @Override
    public void onClick(View v) {
        goTo(this,MainActivity.class);
    }

    /**
     * 切换图片任务
     */
    private class ViewPagerTask implements Runnable {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    int count = welcomeAdapter.getCount();
                    welcomeViewPager.setCurrentItem((curIndex + 1) % count);
                }
            });
        }
    }

    /**
     * 定义viewpager控件页面切换监听
     */
    class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            ImageView smallImagePut = (ImageView) cricleLinearLayout.getChildAt(position);
            ImageView smallImageNoPut = (ImageView) cricleLinearLayout.getChildAt(curIndex);
            if (smallImagePut != null) {
                smallImagePut.setImageResource(R.mipmap.map_gps_best);
            }
            if (smallImageNoPut != null) {
                smallImageNoPut.setImageResource(R.mipmap.map_gps_normal);
            }
            curIndex = position;
        }

        boolean b = false;

        /**
         * 页面滑动改变事件
         * arg0 == 1表示正在滑动，
         * arg0 == 2表示滑动完毕了，
         * arg0 == 0表示什么都没做。
         *
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

            // 这段代码可不加,主要功能是实现切换到末尾后返回到第一张
            switch (state){
                // 手势滑动
                case 1:
                    b = false;
                    break;
                // 界面切换中
                case 2:
                    b = true;
                    break;
                // 滑动结束 --> 切换完毕或者加重完毕
                case 0:
                    // 当前为最后一张,此时从右向左滑,则切换到第一张
                    if (welcomeViewPager.getCurrentItem() ==
                            welcomeViewPager.getAdapter().getCount()-1&& !b){
                        welcomeViewPager.setCurrentItem(0);
                    }
                    // 当前为第一张,此时从左向右滑,则切换到最后一张
                    else if (welcomeViewPager.getCurrentItem() == 0 && !b){
                        welcomeViewPager.setCurrentItem(welcomeViewPager.
                                getAdapter().getCount() -1);
                    }

                    break;
                default:
                    break;
            }
        }
    }
}
