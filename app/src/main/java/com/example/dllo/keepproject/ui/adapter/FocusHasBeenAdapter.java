package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FocusHasBeenBean;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/8/12.
 * 已关注的适配器
 */
public class FocusHasBeenAdapter extends BaseAdapter{
    private FocusHasBeenBean bean;
    private Context context;

    public FocusHasBeenAdapter(Context context) {
        this.context = context;
    }

    public void setBean(FocusHasBeenBean bean) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        hasBeenViewHolder holder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_focus_hasbeen_item,parent,false);
            holder = new hasBeenViewHolder(convertView);
            convertView.setTag(holder);
        }
        else {
            holder = (hasBeenViewHolder) convertView.getTag();

        }

        Picasso.with(context).load(bean.getData().get(position).getAuthor().getAvatar()).into(holder.headImage);
        holder.userNameTv.setText(bean.getData().get(position).getAuthor().getUsername());
        holder.addressTv.setText(bean.getData().get(position).getCity());
        holder.contentTv.setText(bean.getData().get(position).getContent());
       // holder.greenContentTv.setText(bean.getData().get(position).getContent());
        if (!bean.getData().get(position).getMeta().equals(null)){
            holder.metaTv.setText("完成"+bean.getData().get(position).getMeta().getName()+"第"+bean.getData().get(position).getMeta().getCount()+"次");

        }
        if (!bean.getData().get(position).getPhoto().isEmpty()){
            Picasso.with(context).load(bean.getData().get(position).getPhoto()).into(holder.contentImage);
        }
       // Picasso.with(context).load(bean.getData().get(position).getPhoto()).into(holder.contentImage);
        holder.likeCountTv.setText(String.valueOf(bean.getData().get(position).getLikes()));
        holder.reviewTv.setText(String.valueOf(bean.getData().get(position).getComments()));

        return convertView;
    }


    class hasBeenViewHolder{

        private CircleImageView headImage;
        private TextView userNameTv;
        private TextView addressTv;
        private TextView contentTv;
        private TextView greenContentTv;
        private ImageView contentImage;
        private TextView likeCountTv;
        private TextView reviewTv;
        private TextView metaTv;

        public hasBeenViewHolder(View view) {
            headImage = (CircleImageView) view.findViewById(R.id.focus_hasbeen_item_headImage);
            userNameTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_userNameTv);
            addressTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_addressTv);
            contentTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_contentTv);
            greenContentTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_greenContentTv);
            contentImage = (ImageView) view.findViewById(R.id.focus_hasbeen_item_contentImage);
            likeCountTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_likeCountTv);
            reviewTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_reviewTv);
            metaTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_metaTv);
        }
    }
}
