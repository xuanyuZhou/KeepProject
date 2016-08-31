package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.RecommendFriendBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/8/25.
 * 添加好友界面下面的推荐好友的适配器
 */
public class AddFriendLvAdapter extends BaseAdapter {
    private RecommendFriendBean bean;
    private Context context;
    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;
    private static final int TYPE_COUNT = 2;

    public AddFriendLvAdapter(Context context) {
        this.context = context;
    }

    public void setBean(RecommendFriendBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean.getData() != null ? bean.getData().size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return bean.getData() != null ? bean.getData().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (bean.getData().get(position).getReason() != null) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        AddFriendLvOneHolder oneHolder = null;
        AddFriendLvTwoHolder twoHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_addfriendlv, parent, false);
                    oneHolder = new AddFriendLvOneHolder(convertView);
                    convertView.setTag(oneHolder);
                    break;
                case TYPE_2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_addfriendlv_two, parent, false);
                    twoHolder = new AddFriendLvTwoHolder(convertView);
                    convertView.setTag(twoHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_1:
                    oneHolder = (AddFriendLvOneHolder) convertView.getTag();
                    break;
                case TYPE_2:
                    twoHolder = (AddFriendLvTwoHolder) convertView.getTag();
                    break;
            }
        }


        switch (type) {
            case TYPE_1:


                if (bean.getData().get(position).getUser().getAvatar().isEmpty()) {
                    oneHolder.headImage.setImageResource(R.mipmap.keep_logo);
                } else {
                    Picasso.with(context).load(bean.getData().get(position).getUser().getAvatar()).config(Bitmap.Config.RGB_565).resize(200, 200).into(oneHolder.headImage);
                }
                oneHolder.userNameTv.setText(bean.getData().get(position).getUser().getUsername());
                oneHolder.fromTv.setText(bean.getData().get(position).getSource());
                if (bean.getData().get(position).getEntries().isEmpty()) {

                    oneHolder.contentIv.setImageResource(R.mipmap.no_entryp_hoto);
                } else {
                    Picasso.with(context).load(bean.getData().get(position).getEntries().get(position).getPhoto()).config(Bitmap.Config.RGB_565).resize(200, 200).into(oneHolder.contentIv);
                }
                break;
            case TYPE_2:
                Picasso.with(context).load(bean.getData().get(position).getUser().getAvatar()).config(Bitmap.Config.RGB_565).resize(200, 200).into(twoHolder.headTwoImage);
                twoHolder.userNameTwoTv.setText(bean.getData().get(position).getUser().getUsername());
                twoHolder.fromTwoTv.setText(bean.getData().get(position).getSource());

                Picasso.with(context).load(bean.getData().get(position).getEntries().get(0).getPhoto()).config(Bitmap.Config.RGB_565).resize(200, 200).into(twoHolder.contentTwoFirstIv);
                Picasso.with(context).load(bean.getData().get(position).getEntries().get(1).getPhoto()).config(Bitmap.Config.RGB_565).resize(200, 200).into(twoHolder.contentTwoSecondIv);
                Picasso.with(context).load(bean.getData().get(position).getEntries().get(2).getPhoto()).config(Bitmap.Config.RGB_565).resize(200, 200).into(twoHolder.contentTwoThirdIv);
                break;
        }

        return convertView;
    }

    class AddFriendLvOneHolder {

        private ImageView headImage;
        private TextView userNameTv;
        private TextView fromTv;
        private ImageView contentIv;


        public AddFriendLvOneHolder(View view) {
            headImage = (ImageView) view.findViewById(R.id.item_addfriend_one_headImage);
            userNameTv = (TextView) view.findViewById(R.id.item_addfriend_one_userNameTv);
            fromTv = (TextView) view.findViewById(R.id.item_addfriend_one_fromTv);
            contentIv = (ImageView) view.findViewById(R.id.item_addfriend_one_contentImage);

        }
    }

    class AddFriendLvTwoHolder {

        private ImageView headTwoImage;
        private TextView userNameTwoTv;
        private TextView fromTwoTv;
        private ImageView contentTwoFirstIv;
        private ImageView contentTwoSecondIv;
        private ImageView contentTwoThirdIv;


        public AddFriendLvTwoHolder(View view) {
            headTwoImage = (ImageView) view.findViewById(R.id.item_addfriend_two_headImage);
            userNameTwoTv = (TextView) view.findViewById(R.id.item_addfriend_two_userNameTv);
            fromTwoTv = (TextView) view.findViewById(R.id.item_addfriend_two_fromTv);
            contentTwoFirstIv = (ImageView) view.findViewById(R.id.item_addfriend_two_contentImage_one);
            contentTwoSecondIv = (ImageView) view.findViewById(R.id.item_addfriend_two_contentImage_two);
            contentTwoThirdIv = (ImageView) view.findViewById(R.id.item_addfriend_two_contentImage_there);
        }
    }


}
