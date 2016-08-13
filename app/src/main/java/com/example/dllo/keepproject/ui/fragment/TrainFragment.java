package com.example.dllo.keepproject.ui.fragment;

import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FriendsRankingBean;
import com.example.dllo.keepproject.model.bean.TrainFmTrainDataBean;
import com.example.dllo.keepproject.model.bean.UrlBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.example.dllo.keepproject.model.net.OnHttpCallback;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/11.
 * 训练页fragment
 */
public class TrainFragment extends AbsBaseFragment {
    // 训练参数和好友排行组件定义
    private CircleImageView leftAvatarCiv, midAvatarCiv, rightAvatarCiv;
    private TextView totalDurationTv, totalTrainingTv, totalTrainingDayTv, totalCalorieTv, ranKingTv;
    // 网络请求工具类
    private DlaHttp tool;

    @Override
    protected int setLayout() {
        return R.layout.fragment_train;
    }

    @Override
    protected void initView() {
        leftAvatarCiv = byView(R.id.trainFm_avatarLeftCiv);
        midAvatarCiv = byView(R.id.trainFm_avatarMidCiv);
        rightAvatarCiv = byView(R.id.trainFm_avatarRightCiv);
        totalDurationTv = byView(R.id.trainFm_totalDurationTv);
        totalTrainingDayTv = byView(R.id.trainFm_totalTrainingDayTv);
        totalTrainingTv = byView(R.id.trainFm_totalTrainingTv);
        totalCalorieTv = byView(R.id.trainFm_totalCalorieTv);
        ranKingTv = byView(R.id.trainFm_ranKingTv);
    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initDatas() {
        tool = DlaHttp.getInstance();
        initTrainData();
        initFriendsRanking();
    }

    /***************************************************
     * 好友排名数据解析
     */
    private void initFriendsRanking() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", "baidu");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2EyODlkYjlhMTAzODJkMDU4OGFjYjEiLCJ1c2VybmFtZSI6Ikhlbm5lc3N55a6H6L2pIiwiYXZhdGFyIjoiaHR0cDovL3N0YXRpYzEuZ290b2tlZXAuY29tL2F2YXRhci8yMDE2LzA4LzA0LzA4L2YwMjI5YTY4YjM4ZmJmNTkxYjdlMTA0YmFkYzVmZjEwZjhjZmE4NmIuanBnIiwiaWF0IjoxNDcwOTE5OTUzLCJleHAiOjE0NzM1MTE5NTMsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyJ9.3hiKu1-Ixi5q3jbhkYHXTSd0584cx2VB5sMLcbOIpTs");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");
        tool.startRequest(UrlBean.FRIEND_RANKING_URL, FriendsRankingBean.class, headMap, new OnHttpCallback<FriendsRankingBean>() {
            @Override
            public void onSuccess(FriendsRankingBean response) {
                ranKingTv.setText(response.getData().get(1).getRanking()+"");
                Picasso.with(context).load(response.getData().get(0).getUser().getAvatar()).into(leftAvatarCiv);
                Picasso.with(context).load(response.getData().get(1).getUser().getAvatar()).into(midAvatarCiv);
                Picasso.with(context).load(response.getData().get(2).getUser().getAvatar()).into(rightAvatarCiv);
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }

    /***************************************************
     * 训练数据解析
     */
    private void initTrainData() {
        Map<String, String> headMap = new HashMap<>();
        headMap.put("x-device-id", "000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM", "android");
        headMap.put("X-KEEP-TIMEZONE", "America/New_York");
        headMap.put("X-KEEP-CHANNEL", "baidu");
        headMap.put("X-KEEP-VERSION", "3.8.1");
        headMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2EyODlkYjlhMTAzODJkMDU4OGFjYjEiLCJ1c2VybmFtZSI6Ikhlbm5lc3N55a6H6L2pIiwiYXZhdGFyIjoiaHR0cDovL3N0YXRpYzEuZ290b2tlZXAuY29tL2F2YXRhci8yMDE2LzA4LzA0LzA4L2YwMjI5YTY4YjM4ZmJmNTkxYjdlMTA0YmFkYzVmZjEwZjhjZmE4NmIuanBnIiwiaWF0IjoxNDcwOTE5OTUzLCJleHAiOjE0NzM1MTE5NTMsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyJ9.3hiKu1-Ixi5q3jbhkYHXTSd0584cx2VB5sMLcbOIpTs");
        headMap.put("Host", "api.gotokeep.com");
        headMap.put("Connection", "Keep-Alive");
        tool.startRequest(UrlBean.TRAIN_DATA_URL, TrainFmTrainDataBean.class, headMap, new OnHttpCallback<TrainFmTrainDataBean>() {
            @Override
            public void onSuccess(TrainFmTrainDataBean response) {
                // 设置数据
                totalDurationTv.setText(response.getData().getTotalDuration() + "");
                totalCalorieTv.setText(response.getData().getTotalCalorie() + "");
                totalTrainingDayTv.setText(response.getData().getTotalTrainingDay() + "");
                totalTrainingTv.setText(response.getData().getTotalTraining() + "");
            }

            @Override
            public void onError(Throwable ex) {

            }
        });
    }
}
