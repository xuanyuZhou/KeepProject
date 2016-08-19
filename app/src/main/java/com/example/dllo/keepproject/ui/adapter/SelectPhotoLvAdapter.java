package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.view.SmoothImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/17.
 */
public class SelectPhotoLvAdapter extends BaseAdapter{
    private ArrayList<String> strings;
    private Context context;

    public SelectPhotoLvAdapter(Context context) {
        this.context = context;
    }

    public void setStrings(ArrayList<String> strings) {
        this.strings = strings;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder photoMyHolder = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_selectphoto_lv,parent,false);
            photoMyHolder = new MyHolder(convertView);
            convertView.setTag(photoMyHolder);
        }else {
            photoMyHolder = (MyHolder) convertView.getTag();
        }
        Picasso.with(context).load(strings.get(position)).into(photoMyHolder.imageView);
        return convertView;
    }
    class MyHolder{
        private SmoothImageView imageView;

        public MyHolder(View view) {
            imageView = (SmoothImageView) view.findViewById(R.id.selectphoto_Iv);
        }
    }
}
