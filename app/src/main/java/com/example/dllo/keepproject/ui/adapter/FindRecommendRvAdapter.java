package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FindFmrecommendBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/12.
 */
public class FindRecommendRvAdapter extends RecyclerView.Adapter<FindRecommendRvAdapter.RecommendRvHolder>{
    private FindFmrecommendBean datas;
    private Context context;

    public void setDatas(FindFmrecommendBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public FindRecommendRvAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecommendRvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecommendRvHolder recommendRvHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_fragment_find_recommend_rv,parent,false);
        recommendRvHolder = new RecommendRvHolder(view);
        return recommendRvHolder;
    }

    @Override
    public void onBindViewHolder(RecommendRvHolder holder, int position) {
        holder.usernameTv.setText(datas.getData().get(position).getUser().getUsername());
        holder.sourceTv.setText(datas.getData().get(position).getSource());
        Picasso.with(context).load(datas.getData().get(position).getUser().getAvatar()).resize(50,50).into(holder.avatarIv);

    }

    @Override
    public int getItemCount() {
        return datas != null ?datas.getData().size():0;
    }

    class RecommendRvHolder extends RecyclerView.ViewHolder{
        TextView usernameTv;
        TextView sourceTv;
        ImageView avatarIv;
        public RecommendRvHolder(View itemView) {
            super(itemView);
            usernameTv = (TextView) itemView.findViewById(R.id.find_fragment_recommend_username);
            sourceTv = (TextView) itemView.findViewById(R.id.find_fragment_recommend_source);
            avatarIv = (ImageView) itemView.findViewById(R.id.find_fragment_recommend_avatarIv);
        }
    }
}
