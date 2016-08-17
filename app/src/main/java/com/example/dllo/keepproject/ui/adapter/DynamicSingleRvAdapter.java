package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.DynamicSingleBean;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/16.
 */
public class DynamicSingleRvAdapter extends RecyclerView.Adapter<DynamicSingleRvAdapter.DynamicSingleRvTwoHolder> {
    private Context context;
    private DynamicSingleBean datas;

    public DynamicSingleRvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(DynamicSingleBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public DynamicSingleRvTwoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DynamicSingleRvTwoHolder rvTwoHolder = null;
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity_dymicsingle_two_rv, parent, false);
        rvTwoHolder = new DynamicSingleRvTwoHolder(view);
        return rvTwoHolder;
    }

    @Override
    public void onBindViewHolder(DynamicSingleRvTwoHolder holder, int position) {
        if (!datas.getData().getLikers().get(position).getAvatar().isEmpty()){
            holder.avatarTwoIv.setVisibility(View.VISIBLE);
            Picasso.with(context).load(datas.getData().getLikers().get(position).getAvatar()).resize(200,200).into(holder.avatarTwoIv);
        }else{
            holder.avatarTwoIv.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
       return datas != null ? datas.getData().getLikers().size() : 0;
    }

    class DynamicSingleRvTwoHolder extends RecyclerView.ViewHolder {
        CircleImageView avatarTwoIv;

        public DynamicSingleRvTwoHolder(View itemView) {
            super(itemView);
            avatarTwoIv = (CircleImageView) itemView.findViewById(R.id.dynamicsSingle_two_avatarIv);
        }
    }
}
