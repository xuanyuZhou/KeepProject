package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.GroupHotBean;

import com.example.dllo.keepproject.ui.activity.ShowPhotoActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/19.
 * 小组详情页面 - 热门的适配器
 */
public class GroupDetailsHotAdapter extends BaseAdapter {
    private GroupHotBean bean;
    private Context context;

    public GroupDetailsHotAdapter(Context context) {
        this.context = context;
    }

    public void setBean(GroupHotBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean!=null?bean.getData().size():0;
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        NewsViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news_group,parent,false);
            holder = new NewsViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (NewsViewHolder) convertView.getTag();
        }

        // 内容和图片先gone
        holder.contentTv.setVisibility(View.GONE);
        holder.contentImage.setVisibility(View.GONE);

        // 头像
        if (!bean.getData().get(position).getAuthor().getAvatar().isEmpty()){
            Picasso.with(context).load(bean.getData().get(position).getAuthor().getAvatar()).config(Bitmap.Config.RGB_565).resize(300,300).into(holder.userHead);
        }
        else {
            holder.userHead.setImageResource(R.mipmap.take_icon);
        }
        // 用户名
        if (!bean.getData().get(position).getAuthor().getUsername().isEmpty()){
            holder.userTv.setText(bean.getData().get(position).getAuthor().getUsername());
        }
        // 内容
        if (!bean.getData().get(position).getContent().isEmpty()){
            holder.contentTv.setVisibility(View.VISIBLE);
            holder.contentTv.setText(bean.getData().get(position).getContent());
        }
        // 内容配图
        if (!bean.getData().get(position).getPhoto().isEmpty()){
            holder.contentImage.setVisibility(View.VISIBLE);
            Picasso.with(context).load(bean.getData().get(position).getPhoto()).config(Bitmap.Config.RGB_565).resize(300,300).into(holder.contentImage);
        }
        else {
            holder.contentImage.setVisibility(View.GONE);
        }
        // 点击图片显示大图
        holder.contentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowPhotoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("image",bean.getData().get(position).getPhoto());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        // 喜欢个数
        if (!String.valueOf(bean.getData().get(position).getLikes()).isEmpty()){
            holder.likeCountTv.setText(String.valueOf(bean.getData().get(position).getLikes()));
        }
        // 留言个数
        if (!String.valueOf(bean.getData().get(position).getComments()).isEmpty()){
            holder.chatTv.setText(String.valueOf(bean.getData().get(position).getComments()));
        }




        return convertView;
    }

    class NewsViewHolder{
        private CircleImageView userHead;
        private TextView userTv;
        private TextView contentTv;
        private ImageView contentImage;
        private TextView likeCountTv;
        private TextView chatTv;

        public NewsViewHolder(View view){
            userHead = (CircleImageView) view.findViewById(R.id.item_news_headImage);
            userTv = (TextView) view.findViewById(R.id.item_news_userNameTv);
            contentTv = (TextView) view.findViewById(R.id.item_news_contentTv);
            contentImage = (ImageView) view.findViewById(R.id.item_news_contentImage);
            likeCountTv = (TextView) view.findViewById(R.id.item_news_likeCountTv);
            chatTv = (TextView) view.findViewById(R.id.item_news_reviewTv);
        }
    }
}
