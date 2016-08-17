package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.PhotoAlbumBean;

import java.util.List;

/**
 * Created by dllo on 16/8/16.
 * 相册的vp适配器
 */
public class PhotoAlbumViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<PhotoAlbumBean> datas;
    private ImageView imageView;

    public PhotoAlbumViewPagerAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<PhotoAlbumBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_activity_photo_album_vp,null);
        imageView = (ImageView) view.findViewById(R.id.photoAlbumIv);
        imageView.setImageResource(datas.get(position).getImageViewID());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
