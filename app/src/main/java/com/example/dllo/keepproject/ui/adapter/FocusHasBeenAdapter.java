package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.FocusHasBeenBean;
import com.example.dllo.keepproject.ui.activity.DetailsActivity;
import com.example.dllo.keepproject.ui.activity.DynamicSingleActivity;
import com.example.dllo.keepproject.ui.activity.WelcomeActivity;
import com.example.dllo.keepproject.ui.app.MyApp;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by dllo on 16/8/12.
 * 已关注的适配器
 */
public class FocusHasBeenAdapter extends BaseAdapter {
    private FocusHasBeenBean bean;
    private Context context;
    final int TYPE_1 = 0;
    final int TYPE_2 = 1;
    final int TYPE_COUNT = 2;
    private int lineCount;

    public FocusHasBeenAdapter(Context context) {
        this.context = context;
    }

    public void setBean(FocusHasBeenBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean != null ? bean.getData().size() : 0;
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
    public int getItemViewType(int position) {
        // 根据接口中的type 类型来显示不同的行布局
        if (bean.getData().get(position).getType().equals("direct")) {
            return TYPE_1;
        } else {
            return TYPE_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        hasBeenViewHolder holder = null;
        hasBeenTwoViewHolder twoHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.fragment_focus_hasbeen_item, parent, false);
                    holder = new hasBeenViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_2:
                    convertView = LayoutInflater.from(context).inflate(R.layout.fragment_focus_hasbeen_item_two, parent, false);
                    twoHolder = new hasBeenTwoViewHolder(convertView);
                    convertView.setTag(twoHolder);
                    break;
            }

        } else {
            switch (type) {
                case TYPE_1:
                    holder = (hasBeenViewHolder) convertView.getTag();
                    break;
                case TYPE_2:
                    twoHolder = (hasBeenTwoViewHolder) convertView.getTag();
                    break;
            }


        }

        switch (type) {
            case TYPE_1:
                holder.allTv.setVisibility(View.GONE);
                Picasso.with(context).load(bean.getData().get(position).getAuthor().getAvatar()).config(Bitmap.Config.RGB_565).resize(200,200).into(holder.headImage);
                holder.userNameTv.setText(bean.getData().get(position).getAuthor().getUsername());
                holder.addressTv.setText(bean.getData().get(position).getCity());
               // holder.contentTv.setText(bean.getData().get(position).getContent());
                // holder.greenContentTv.setText(bean.getData().get(position).getContent());
                // 第一种行布局中 如果有照片的话就显示出来
                if (!bean.getData().get(position).getPhoto().isEmpty()) {
                    holder.contentImage.setVisibility(View.VISIBLE);
                    Picasso.with(context).load(bean.getData().get(position).getPhoto()).config(Bitmap.Config.RGB_565).into(holder.contentImage);
                } else {
                    holder.contentImage.setVisibility(View.GONE);
                }



                String sb = bean.getData().get(position).getContent();
                SpannableString span = new SpannableString(sb);

                ArrayList<String> array = new ArrayList<>();
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = 0; i < sb.length(); i++) {
                    String j = String.valueOf(sb.charAt(i));
                    array.add(j);
                    if(array.get(i).equals("#")){
                        arr.add(i);
                    }
                }
                for (int i = 0; i < arr.size(); i++) {
                    span.setSpan(new ForegroundColorSpan(Color.argb(255, 78, 164, 105)), arr.get(i), arr.get(i + 1) + 1, 0);
                    i++;
                }

                holder.contentTv.setText(span);

                // 如果得到的行数大于5 让TV显示 全部字样并且有点击事件
                final hasBeenViewHolder finalHolder = holder;
                holder.contentTv.post(new Runnable() {
                    @Override
                    public void run() {
                        lineCount = finalHolder.contentTv.getLineCount();
                        finalHolder.allTv.setVisibility(View.VISIBLE);
                        finalHolder.allTv.setText("全部");
                    }
                });
//                if (lineCount > 5) {
//                    holder.allTv.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Intent intent = new Intent(context, DynamicSingleActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//                            context.startActivity(intent);
//                        }
//                    });
//                }

                holder.likeCountTv.setText(String.valueOf(bean.getData().get(position).getLikes()));
                holder.reviewTv.setText(String.valueOf(bean.getData().get(position).getComments()));

                break;
            case TYPE_2:

                twoHolder.allTwoTv.setVisibility(View.GONE);
                Picasso.with(context).load(bean.getData().get(position).getAuthor().getAvatar()).config(Bitmap.Config.RGB_565).resize(200,200).into(twoHolder.headTwoImage);
                twoHolder.userNameTwoTv.setText(bean.getData().get(position).getAuthor().getUsername());
                twoHolder.addressTwoTv.setText(bean.getData().get(position).getCity());
                //twoHolder.contentTwoTv.setText(bean.getData().get(position).getContent());
                //holder.greenContentTv.setText(bean.getData().get(position).getContent());
                twoHolder.metaTwoTv.setText("完成" + bean.getData().get(position).getMeta().getName() +
                        "第" + String.valueOf(bean.getData().get(position).getMeta().getCount()) + "次");

                // 如果得到的照片不为空 显示图片的Image显示,否则隐藏
                if (!bean.getData().get(position).getPhoto().isEmpty()) {
                    twoHolder.contentTwoImage.setVisibility(View.VISIBLE);
                    Picasso.with(context).load(bean.getData().get(position).getPhoto()).config(Bitmap.Config.RGB_565).into(twoHolder.contentTwoImage);
                } else {
                    twoHolder.contentTwoImage.setVisibility(View.GONE);
                }

                String sbs = bean.getData().get(position).getContent();
                SpannableString spans = new SpannableString(sbs);

                ArrayList<String> arrays = new ArrayList<>();
                ArrayList<Integer> arrs = new ArrayList<>();
                for (int i = 0; i < sbs.length(); i++) {
                    String j = String.valueOf(sbs.charAt(i));
                    arrays.add(j);
                    if(arrays.get(i).equals("#")){
                        arrs.add(i);
                    }
                }
                for (int i = 0; i < arrs.size(); i++) {
                    spans.setSpan(new ForegroundColorSpan(Color.argb(255, 78, 164, 105)), arrs.get(i), arrs.get(i + 1) + 1, 0);
                    i++;
                }

                twoHolder.contentTwoTv.setText(spans);
                // 如果得到的文字内容不为空 显示文字的Tv出现,否则隐藏
                if (!bean.getData().get(position).getContent().isEmpty()) {
                    twoHolder.contentTwoTv.setVisibility(View.VISIBLE);
                } else {
                    twoHolder.contentTwoTv.setVisibility(View.GONE);
                }


                // 如果得到的行数大于5 让TV显示 全部字样并且有点击事件
                final hasBeenTwoViewHolder finalTwoHolder = twoHolder;
                twoHolder.contentTwoTv.post(new Runnable() {
                    @Override
                    public void run() {
                        lineCount = finalTwoHolder.contentTwoTv.getLineCount();
                        if (lineCount > 5) {

                            finalTwoHolder.allTwoTv.setVisibility(View.VISIBLE);
                            finalTwoHolder.allTwoTv.setText("全部");

                        }
                    }
                });
//                finalTwoHolder.allTwoTv.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(context, DynamicSingleActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
//                        context.startActivity(intent);
//                    }
//                });
                twoHolder.likeCountTwoTv.setText(String.valueOf(bean.getData().get(position).getLikes()));
                twoHolder.reviewTwoTv.setText(String.valueOf(bean.getData().get(position).getComments()));
                break;
        }


        return convertView;
    }


    class hasBeenViewHolder {

        private CircleImageView headImage;
        private TextView userNameTv;
        private TextView addressTv;
        private TextView contentTv;
        private ImageView contentImage;
        private TextView likeCountTv;
        private TextView reviewTv;
        private TextView allTv;

        public hasBeenViewHolder(View view) {
            headImage = (CircleImageView) view.findViewById(R.id.focus_hasbeen_item_headImage);
            userNameTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_userNameTv);
            addressTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_addressTv);
            contentTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_contentTv);
            contentImage = (ImageView) view.findViewById(R.id.focus_hasbeen_item_contentImage);
            likeCountTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_likeCountTv);
            reviewTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_reviewTv);
            allTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_contentTv_all);

        }
    }

    class hasBeenTwoViewHolder {
        private CircleImageView headTwoImage;
        private TextView userNameTwoTv;
        private TextView addressTwoTv;
        private TextView contentTwoTv;
        private ImageView contentTwoImage;
        private TextView likeCountTwoTv;
        private TextView reviewTwoTv;
        private TextView metaTwoTv;
        private TextView allTwoTv;

        public hasBeenTwoViewHolder(View view) {
            headTwoImage = (CircleImageView) view.findViewById(R.id.focus_hasbeen_item_Two_headImage);
            userNameTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_userNameTv);
            addressTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_addressTv);
            contentTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_contentTv);
            contentTwoImage = (ImageView) view.findViewById(R.id.focus_hasbeen_item_Two_contentImage);
            likeCountTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_likeCountTv);
            reviewTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_reviewTv);
            metaTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_metaTv);
            allTwoTv = (TextView) view.findViewById(R.id.focus_hasbeen_item_Two_contentTv_all);
        }

    }

}
