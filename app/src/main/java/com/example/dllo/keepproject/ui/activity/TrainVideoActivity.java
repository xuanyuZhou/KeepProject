package com.example.dllo.keepproject.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.TrainFmVideoBean;
import com.example.dllo.keepproject.model.bean.TrainFmVideoTypeTwoBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.example.dllo.keepproject.view.DIYVideoView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/16.
 * 开始训练播放视频activity
 */
public class TrainVideoActivity extends AbsBaseActivity implements View.OnClickListener {
    private DIYVideoView trainVideoView; // 自定义videoView
    private MediaPlayer trainMediaPlayer; // 音频播放
    private DlaHttp tool = DlaHttp.getInstance(); // 网络获取工具类
    private String url; // 传过来的网址url
    private int type; // 传过来的状态
    private ImageView closeIv;// 左上角叉
    private Chronometer chronometer; // 计时器
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.d("xxx", "videoView.getCurrentPosition():" + trainVideoView.getCurrentPosition());
            handler.postDelayed(runnable, 1000);
        }
    };

    @Override
    protected int setLayout() {
        return R.layout.activity_video_train;
    }

    @Override
    protected void initView() {
        trainVideoView = byView(R.id.aty_train_videoView);
        closeIv = byView(R.id.aty_train_closeIv);
        chronometer = byView(R.id.aty_train_timer_Chronometer);
    }

    @Override
    protected void initListeners() {
        closeIv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {
        // 接收url
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.url = bundle.getString("url");
        this.type = bundle.getInt("type");
        Log.d("xxx","url" + url);
        Log.d("xxx", "type:" + type);
        // 解析url
        initUrlData();
    }


    /**
     * 解析数据
     */
    private void initUrlData() {
        // 请求头
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", "baidu");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2EyODlkYjlhMTAzODJkMDU4OGFjYjEiLCJ1c2VybmFtZSI6Ikhlbm5lc3N55a6H6L2pIiwiYXZhdGFyIjoiaHR0cDovL3N0YXRpYzEuZ290b2tlZXAuY29tL2F2YXRhci8yMDE2LzA4LzA0LzA4L2YwMjI5YTY4YjM4ZmJmNTkxYjdlMTA0YmFkYzVmZjEwZjhjZmE4NmIuanBnIiwiZ2VuZGVyIjoiTSIsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyIsImV4cCI6MTQ3NDA3Mjg5MCwiaWF0IjoxNDcxNDgwODkwfQ.Si3SlhDI6--xTGrV9y1HZaBmw4zSKOKEcwTb7r5rz6E");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");

        // 网络解析
        if (type == 0) {
            tool.startRequest(url, TrainFmVideoBean.class,headMap, new OnHttpCallback<TrainFmVideoBean>() {
                @Override
                public void onSuccess(TrainFmVideoBean response) {
                    // 播放训练视频
                    initVideoOne(response);
                    chronometer.start();
                    Log.d("xxx", "解析成功");
                    Log.d("xxx","url>>>" + response.getData().getWorkouts().get(0).
                            getSteps().get(0).getExercise().getVideos().get(0).getUrl());
                }

                @Override
                public void onError(Throwable ex) {
                    Log.d("xxx", "解析失败");

                }
            });
        } else {
            tool.startRequest(url, TrainFmVideoTypeTwoBean.class,headMap, new OnHttpCallback<TrainFmVideoTypeTwoBean>() {
                @Override
                public void onSuccess(TrainFmVideoTypeTwoBean response) {
                    // 播放训练视频
                    initVideoTwo(response);
                    Log.d("xxx", "解析成功");
                    Log.d("xxx","url>>>" + response.getData().getSteps().get(0).getExercise()
                            .getVideos().get(0).getUrl());
                }

                @Override
                public void onError(Throwable ex) {
                    Log.d("xxx", "解析失败");
                }
            });

        }
    }

    private void initVideoOne(TrainFmVideoBean response) {

        trainMediaPlayer = MediaPlayer.create(this, Uri.parse(response.getData().getWorkouts().get(0).
                getSteps().get(0).getExercise().getVideos().get(0).getThumbnail()));

        trainVideoView.setVideoURI(Uri.parse(response.getData().getWorkouts().get(0).
                getSteps().get(0).getExercise().getVideos().get(0).getUrl()));
        // 横屏
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //trainMediaPlayer.start();
        trainVideoView.start();
        /**
         * 循环播放
         */
        trainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });

      //  new Thread(runnable).start();
    }

    private void initVideoTwo(TrainFmVideoTypeTwoBean response) {

        trainMediaPlayer = MediaPlayer.create(this, Uri.parse(response.getData().getSteps().get(0).getExercise()
        .getAudio()));

        trainVideoView.setVideoURI(Uri.parse(response.getData().getSteps().get(0).getExercise()
        .getVideos().get(0).getUrl()));
        // 横屏
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        trainMediaPlayer.start();
        trainVideoView.start();
        /**
         * 循环播放
         */
        trainVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });

      //  new Thread(runnable).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aty_train_closeIv:
                showDialog();
                break;
        }
    }

    /**
     * 显示DiaLog
     */
    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确认退出训练吗？");
        builder.setTitle("提示");
        builder.setIcon(R.mipmap.keep_logo);
        builder.setPositiveButton("退出训练", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton("再练一会", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show();
    }
}
