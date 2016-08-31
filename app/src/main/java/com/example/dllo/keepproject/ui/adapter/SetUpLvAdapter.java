package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.keepproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/8/23.
 */
public class SetUpLvAdapter extends BaseAdapter {

    private ArrayList<String> arrayList;
    private Context context;
    private int TYPE;


    public SetUpLvAdapter(Context context) {
        this.context = context;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arrayList.size();
//
//        if (TYPE == 1) {
//            return 4;
//        } else if (TYPE == 2) {
//            return 6;
//        } else if (TYPE == 3) {
//            return 3;
//
//        } else
//            return 4;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SetUpHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_setup, parent, false);
            holder = new SetUpHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (SetUpHolder) convertView.getTag();
        }


        holder.tv.setText(arrayList.get(position));
        return convertView;
    }

    class SetUpHolder {
        private TextView tv;

        public SetUpHolder(View view) {
            tv = (TextView) view.findViewById(R.id.item_setup_tv);
        }
    }
}
