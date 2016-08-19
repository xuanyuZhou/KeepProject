package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.CityActivityBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/18.
 */
public class CityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;
    private Context context;
    private List<CityActivityBean> cityActivityBeanLists = new ArrayList<>();
    private onItemClickListener listener;

    public CityAdapter(Context context, List<CityActivityBean> cityActivityBeanLists) {
        this.context = context;
        this.cityActivityBeanLists = cityActivityBeanLists;
    }


    public interface onItemClickListener {

        void itemClick(int position);
    }

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_activity_city_lv, parent, false);
        return new CityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof CityViewHolder) {
            CityViewHolder viewHolder = (CityViewHolder) holder;
            CityActivityBean cityActivityBeanModel = cityActivityBeanLists.get(position);
            viewHolder.tvCityName.setText(cityActivityBeanModel.getCityName());

            viewHolder.rlContentWrapper.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(position);
                }
            });


            if (position == 0) {
                viewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
                viewHolder.tvStickyHeader.setText(cityActivityBeanModel.getFirstPinYin());
                viewHolder.itemView.setTag(FIRST_STICKY_VIEW);
            } else {
                if (!TextUtils.equals(cityActivityBeanModel.getFirstPinYin(), cityActivityBeanLists.get(position - 1).getFirstPinYin())) {
                    viewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
                    viewHolder.tvStickyHeader.setText(cityActivityBeanModel.getFirstPinYin());
                    viewHolder.itemView.setTag(HAS_STICKY_VIEW);
                } else {
                    viewHolder.tvStickyHeader.setVisibility(View.GONE);
                    viewHolder.itemView.setTag(NONE_STICKY_VIEW);
                }
            }

            viewHolder.itemView.setContentDescription(cityActivityBeanModel.getFirstPinYin());
        }


    }

    @Override
    public int getItemCount() {
        return cityActivityBeanLists.size() == 0 ? 0 : cityActivityBeanLists.size();
    }


    public class CityViewHolder extends RecyclerView.ViewHolder {

        TextView tvStickyHeader, tvCityName;
        RelativeLayout rlContentWrapper;


        public CityViewHolder(View itemView) {
            super(itemView);

            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_sticky_header_view);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);
            tvCityName = (TextView) itemView.findViewById(R.id.tv_name);
        }
    }


}

