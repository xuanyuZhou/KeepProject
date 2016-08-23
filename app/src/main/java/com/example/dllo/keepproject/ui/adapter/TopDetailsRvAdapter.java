package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.TopDetailsBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/20.
 */
public class TopDetailsRvAdapter extends RecyclerView.Adapter<TopDetailsRvAdapter.TopDetailsHoler> {

    private TopDetailsBean bean;
    private Context context;
    private int type;
    private SpannableString span;

    public TopDetailsRvAdapter(Context context,int type) {
        this.context = context;
        this.type = type;
    }

    public void setBean(TopDetailsBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    /**
     * 初始化缓存类
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public TopDetailsHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_top_details, parent, false);
        TopDetailsHoler holder = new TopDetailsHoler(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TopDetailsHoler holder, int position) {

        // 排行榜
        String a = String.valueOf(position + 1);
        if (position <3) {
            holder.topTv.setTextColor(Color.argb(255, 85, 198, 132));

        } else {
            holder.topTv.setTextColor(Color.argb(255,139,137,137));
        }
        holder.topTv.setText(a);

        if (!bean.getData().get(position).getUser().getAvatar().isEmpty()) {
            Picasso.with(context).load(bean.getData().get(position).getUser().getAvatar()).config(Bitmap.Config.RGB_565).resize(200, 200).into(holder.headImage);
        } else {
            holder.headImage.setImageResource(R.mipmap.ic_keep_xiao);
        }
        holder.userName.setText(bean.getData().get(position).getUser().getUsername());

        // 加油 /推荐 通过type来判断.
        String b = String.valueOf(bean.getData().get(position).getCount());
        if (type == 0) {
            span = new SpannableString(b+"推荐");
        } else {
            span = new SpannableString(b+"加油");

        }
        span.setSpan(new ForegroundColorSpan(Color.argb(255, 85, 198, 132)),0,b.length(),0);
        span.setSpan(new AbsoluteSizeSpan(60),0,b.length(),0);
        span.setSpan(new AbsoluteSizeSpan(30),b.length(),b.length()+2,0);
        holder.recommendNumberTv.setText(span);

    }

    @Override
    public int getItemCount() {
        return bean != null ? bean.getData().size() : 0;
    }

    class TopDetailsHoler extends RecyclerView.ViewHolder {

        private TextView topTv;
        private CircleImageView headImage;
        private TextView userName;
        private TextView recommendNumberTv;

        public TopDetailsHoler(View itemView) {
            super(itemView);
            topTv = (TextView) itemView.findViewById(R.id.item_top_details_toPTv);
            headImage = (CircleImageView) itemView.findViewById(R.id.item_top_details_headImage);
            userName = (TextView) itemView.findViewById(R.id.item_top_details_userName);
            recommendNumberTv = (TextView) itemView.findViewById(R.id.item_top_details_RecommendNumber);
        }
    }
}
