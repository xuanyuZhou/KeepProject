package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.TrainFmMyTrainBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/13.
 * 训练页 我的训练 listView适配器
 * 加载不同的行布局,
 */
public class TrainFmMyTrainLvAdapter extends BaseAdapter {
    private Context context;
    private TrainFmMyTrainBean data;

    // TYPE类型不可以随意设置,
    // 保证TYPE类型必须为整数并且小于TYPE_COUNT.
    final int TYPE_1 = 0; // 代表第一种行布局的类型
    final int TYPE_2 = 1; // 代表第二种行布局的类型
    final int TYPE_COUNT = 2; // 一共有多少种行布局类型

    public TrainFmMyTrainLvAdapter(Context context) {
        this.context = context;
    }

    public void setData(TrainFmMyTrainBean data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        int top = data.getData().getPlans().size();
        if (top != 0 && top > position) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return data != null ? data.getData().getPlans().size() + data.getData().getWorkouts().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        if (position < data.getData().getPlans().size() && data.getData().getPlans().size() != 0) {
            return data.getData().getPlans().get(position);
        } else {
            return data.getData().getWorkouts().get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        TopHolder topHolder = null;
        DownHolder downHolder = null;
        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_top_mytrain_lv, parent, false);
                    topHolder = new TopHolder(convertView);
                    convertView.setTag(topHolder);
                    break;
                case TYPE_2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_down_mytrain_lv, parent, false);
                    downHolder = new DownHolder(convertView);
                    convertView.setTag(downHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_1:
                    topHolder = (TopHolder) convertView.getTag();
                    break;
                case TYPE_2:
                    downHolder = (DownHolder) convertView.getTag();
                    break;
            }
        }
        /**
         * 设置数据
         */
        switch (type) {
            case TYPE_1:
                Picasso.with(context).load(data.getData().getPlans().get(position).getPlan().getPicture()).into(topHolder.topBgiIv);
                topHolder.topNameTv.setText(data.getData().getPlans().get(position).getPlan().getName());
                topHolder.topProgressTv.setText("第 " + data.getData().getPlans().get(position).getCurrent_progress()
                        + "/" + data.getData().getPlans().get(position).getMax_progress() + " 节");
                break;
            case TYPE_2:
                downHolder.downNameTv.setText(data.getData().getWorkouts().get((position - data.getData().getPlans().size()))
                        .getWorkout().getName());
                downHolder.downCompletedTv.setText("已完成" + data.getData().getWorkouts().get((position - data.getData().getPlans().size())).getCompleted()
                        + "次训练");
                downHolder.downCalorieTv.setText(data.getData().getWorkouts().get((position - data.getData().getPlans().size())).getWorkout().getDuration()
                        +"分钟 " + data.getData().getWorkouts().get((position - data.getData().getPlans().size())).getWorkout().getCalorie() + "千卡");
                break;
        }
        return convertView;
    }

    class TopHolder {
        private TextView topNameTv, topProgressTv;
        private ImageView topBgiIv;

        public TopHolder(View view) {
            topNameTv = (TextView) view.findViewById(R.id.myTrain_lvTop_nameTv);
            topProgressTv = (TextView) view.findViewById(R.id.myTrain_lvTop_progressTv);
            topBgiIv = (ImageView) view.findViewById(R.id.myTrain_lvTop_BgImageIv);
        }
    }

    class DownHolder {
        private TextView downNameTv, downCompletedTv, downCalorieTv;

        public DownHolder(View view) {
            downCalorieTv = (TextView) view.findViewById(R.id.myTrain_lvDown_calorieTv);
            downCompletedTv = (TextView) view.findViewById(R.id.myTrain_lvDown_completedTv);
            downNameTv = (TextView) view.findViewById(R.id.myTrain_lvDown_nameTv);
        }
    }
}
