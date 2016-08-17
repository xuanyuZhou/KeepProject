package com.example.dllo.keepproject.ui.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.Button;
import android.widget.VideoView;

import com.example.dllo.keepproject.R;

/**
 * Created by dllo on 16/8/16.
 * 开始训练播放视频activity
 */
public class TrainVideoActivity extends AbsBaseActivity {
    private VideoView trainVideoView;
    private MediaPlayer trainMediaPlayer;
    private Button startBtn, pauseBtn;
    private String url = "http://static1.gotokeep.com/video/b272c00e9fabe2f69aaf435840849233a7551869.mp4";
    private String audioUrl = "http://static1.gotokeep.com/misc/2015/08/13/16/53c98979c6c00000.mp3";
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Log.d("MainActivity", "videoView.getCurrentPosition():" + trainVideoView.getCurrentPosition());
            handler.postDelayed(runnable,1000);
        }
    };

    @Override
    protected int setLayout() {
        return R.layout.activity_video_train;
    }

    @Override
    protected void initView() {
        trainVideoView = byView(R.id.aty_train_videoView);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {
        // 播放训练视频
        initVideo();

    }

    private void initVideo() {
        trainMediaPlayer = MediaPlayer.create(this, Uri.parse(audioUrl));
        trainVideoView.setVideoURI(Uri.parse(url));
        // 横屏
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

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

        new Thread(runnable).start();
    }
}
