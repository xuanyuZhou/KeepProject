package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FocusGroupBean;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 * 关注 - 小组 适配器
 */
public class FocusGroupAdapter extends BaseAdapter {
    private FocusGroupBean bean;
    private Context context;

    public FocusGroupAdapter(Context context) {
        this.context = context;
    }

    public void setBean(FocusGroupBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean!=null?bean.getData().getRecommended().size():0;
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getRecommended().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       GroupViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fragment_focus_group,parent,false);
            holder = new GroupViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (GroupViewHolder) convertView.getTag();
        }

        Picasso.with(context).load(bean.getData().getRecommended().get(position).getAvatar()).config(Bitmap.Config.RGB_565).resize(200,200).into(holder.headImage);
        holder.titleTv.setText(bean.getData().getRecommended().get(position).getGroupName());
        holder.groupMember.setText(String.valueOf(bean.getData().getRecommended().get(position).getMemberCount())+"成员");
        holder.groupCards.setText(String.valueOf(bean.getData().getRecommended().get(position).getTotalEntries())+"帖子");
        return convertView;
    }

    class GroupViewHolder{
        private CircleImageView headImage;
        private TextView titleTv;
        private TextView groupMember;
        private TextView groupCards;

        public GroupViewHolder(View view){
            headImage = (CircleImageView) view.findViewById(R.id.focus_group_headImage);
            titleTv = (TextView) view.findViewById(R.id.focus_group_title);
            groupMember = (TextView) view.findViewById(R.id.focus_group_member);
            groupCards = (TextView) view.findViewById(R.id.focus_group_cards);
         }
    }
}
