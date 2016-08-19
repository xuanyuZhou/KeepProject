package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.TopicActivityBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/15.
 * 热门话题的适配器
 */
public class TopicActivityLvAdaptet extends BaseAdapter{
    private TopicActivityBean datas;
    private Context context;

    public TopicActivityLvAdaptet(Context context) {
        this.context = context;
    }

    public void setDatas(TopicActivityBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.getData().size():0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null ?datas.getData().get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TopicActivityLvHolder lvHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_topic_lv,parent,false);
            lvHolder = new TopicActivityLvHolder(convertView);
            convertView.setTag(lvHolder);
        }else{
            lvHolder = (TopicActivityLvHolder) convertView.getTag();
        }
        lvHolder.nameTv.setText("#"+datas.getData().get(position).getName()+"#");
        lvHolder.contentTv.setText(datas.getData().get(position).getContent());
        lvHolder.countTv.setText(String.valueOf(datas.getData().get(position).getCount())+"人参与");
        Picasso.with(context).load(datas.getData().get(position).getCover()).resize(200,200).into(lvHolder.coverIv);
        return convertView;
    }
    class TopicActivityLvHolder{
        TextView nameTv;
        TextView contentTv;
        TextView countTv;
        ImageView coverIv;
        public TopicActivityLvHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.topic_activity_nameTv);
            contentTv = (TextView) view.findViewById(R.id.topic_activity_contentTv);
            countTv = (TextView) view.findViewById(R.id.topic_activity_count);
            coverIv = (ImageView) view.findViewById(R.id.topic_activity_coverIv);
        }
    }
}
