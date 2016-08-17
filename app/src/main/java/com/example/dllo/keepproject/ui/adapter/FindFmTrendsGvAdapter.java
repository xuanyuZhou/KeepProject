package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FindFmTrendsBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/13.
 * 精选动态适配器
 */
public class FindFmTrendsGvAdapter extends BaseAdapter{
    private FindFmTrendsBean datas;
    private Context context;

    public FindFmTrendsGvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(FindFmTrendsBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ?datas.getData().size():0;
    }

    @Override
    public Object getItem(int position) {
        return datas != null ? datas.getData().get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       // Log.d("FindFmTrendsGvAdapter", "position:" + position);
        FindFmTrendsGvHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fragment_find_trends_gv,parent,false);
            holder = new FindFmTrendsGvHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (FindFmTrendsGvHolder) convertView.getTag();
        }
        holder.contentTv.setText(datas.getData().get(position).getContent());
        holder.commentTv.setText(String.valueOf(datas.getData().get(position).getComments()));
        holder.likesTv.setText(String.valueOf(datas.getData().get(position).getLikes()));
        Picasso.with(context).load(datas.getData().get(position).getPhoto()).config(Bitmap.Config.RGB_565).into(holder.photoIv);
        return convertView;
    }
    class FindFmTrendsGvHolder{
        TextView contentTv;
        TextView likesTv;
        TextView commentTv;
        ImageView photoIv;

        public FindFmTrendsGvHolder(View view) {
            contentTv = (TextView) view.findViewById(R.id.find_fragment_trends_content);
            likesTv = (TextView) view.findViewById(R.id.find_fragment_trends_likes);
            commentTv = (TextView) view.findViewById(R.id.find_fragment_trends_comments);
            photoIv = (ImageView) view.findViewById(R.id.find_fragment_trends_photo);
        }
    }
}
