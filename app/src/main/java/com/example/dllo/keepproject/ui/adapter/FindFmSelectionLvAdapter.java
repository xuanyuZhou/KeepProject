package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FindFmSelectionBean;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/8/12.
 */
public class FindFmSelectionLvAdapter extends BaseAdapter {
    private int TYPE = 1;
    private FindFmSelectionBean data;
    private Context context;

    public FindFmSelectionLvAdapter(Context context) {
        this.context = context;
    }

    public void setData(FindFmSelectionBean data,int type) {
        this.TYPE = type;
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (TYPE == 1){
            return 2;
        }else{
            return data != null ? data.getData().size() : 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return data != null ? data.getData().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FindFmSelectionsLvHolder lvHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fragment_find_selections_lv,parent,false);
            lvHolder = new FindFmSelectionsLvHolder(convertView);
            convertView.setTag(lvHolder);
        }else {
            lvHolder = (FindFmSelectionsLvHolder) convertView.getTag();
        }
        lvHolder.nameTv.setText(data.getData().get(position).getName());
        Picasso.with(context).load(data.getData().get(position).getPhoto()).into(lvHolder.photoTv);
        return convertView;
    }
    class FindFmSelectionsLvHolder{
        TextView nameTv;
        ImageView photoTv;

        public FindFmSelectionsLvHolder(View view) {
            nameTv = (TextView) view.findViewById(R.id.find_fragment_selection_Tv);
            photoTv = (ImageView) view.findViewById(R.id.find_fragment_selection_Iv);
        }
    }
}
