package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.AddressBookBean;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/19.
 * 电话本的适配器
 */
public class AddressBookAdapter extends BaseAdapter {
    private ArrayList<AddressBookBean> bean;
    private Context context;

    public AddressBookAdapter(Context context) {
        this.context = context;
    }

    public void setBean(ArrayList<AddressBookBean> bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean != null ? bean.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return bean != null ? bean.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AddressHoler holer = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_addressbook,parent,false);
            holer = new AddressHoler(convertView);
            convertView.setTag(holer);
        }
        else {
            holer = (AddressHoler) convertView.getTag();
        }
        AddressBookBean data = bean.get(position);
        holer.tvName.setText(data.getUserName());
        holer.IMhead.setImageBitmap(data.getUserImage());

        return convertView;
    }


    class AddressHoler{
        private TextView tvName;
        private CircleImageView IMhead;

        public AddressHoler(View view){
            tvName = (TextView) view.findViewById(R.id.address_item_userNameTv);
            IMhead = (CircleImageView) view.findViewById(R.id.address_item_headImage);
        }
    }
}
