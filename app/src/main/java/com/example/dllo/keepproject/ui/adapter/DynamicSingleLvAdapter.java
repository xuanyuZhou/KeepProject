package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.DynamicSingleBean;
import com.example.dllo.keepproject.model.net.DlaHttp;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/8/15.
 */
public class DynamicSingleLvAdapter extends BaseAdapter {
    private DynamicSingleBean datas;
    private Context context;
    private RecyclerView recyclerView;
    private static final int TYPE_COUNT = 4;
    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private static final int TYPE_THREE = 2;
    private static final int TYPE_FOUR = 3;

    public DynamicSingleLvAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(DynamicSingleBean datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        }else if (position == 1) {
            return TYPE_TWO;
        }else if (position == 2) {
            return TYPE_THREE;
        } else {
            return TYPE_FOUR;
        }
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }



    @Override
    public int getCount() {
        return datas != null ? datas.getData().getCommentsList().size() : 0;

    }

    @Override
    public Object getItem(int position) {
        return datas != null ? datas.getData().getCommentsList().get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch (type) {
            case TYPE_ONE:
                DynamicSingleLvHolderOne lvHolderOne = null;
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_dynamicsingle_one_lv, parent, false);
                    lvHolderOne = new DynamicSingleLvHolderOne(convertView);
                    convertView.setTag(lvHolderOne);
                } else {
                    lvHolderOne = (DynamicSingleLvHolderOne) convertView.getTag();
                }
                lvHolderOne.usernameTv.setText(datas.getData().getAuthor().getUsername());
                lvHolderOne.contentTv.setText(datas.getData().getContent());
                lvHolderOne.createdTv.setText(String.valueOf(datas.getData().getAuthor().getCreated()));
                Picasso.with(context).load(datas.getData().getPhoto()).into(lvHolderOne.photoIv);
                Picasso.with(context).load(datas.getData().getAuthor().getAvatar()).into(lvHolderOne.avatarIv);

                break;
            case TYPE_TWO:
                DynamicSingleLvHolderTwo lvHolderTwo = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_dynamicsingle_two_lv,parent,false);
                    lvHolderTwo = new DynamicSingleLvHolderTwo(convertView);
                    convertView.setTag(lvHolderTwo);
                }else {
                    lvHolderTwo = (DynamicSingleLvHolderTwo) convertView.getTag();
                }
                lvHolderTwo.likesTwoIv.setText(String.valueOf(datas.getData().getLikes()));

                DynamicSingleRvAdapter rvAdapter = new DynamicSingleRvAdapter(context);
                rvAdapter.setDatas(datas);
                recyclerView.setAdapter(rvAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));



                break;

            case TYPE_THREE:
                DynamicSingleLvHolderThree lvHolderThree = null;
                if (convertView == null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_dymicsingle_three_lv,parent,false);
                    lvHolderThree = new DynamicSingleLvHolderThree(convertView);
                    convertView.setTag(lvHolderThree);
                }else {
                    lvHolderThree = (DynamicSingleLvHolderThree) convertView.getTag();
                }
                lvHolderThree.commentsThreeIv.setText(String.valueOf(datas.getData().getComments()));
                break;

            case TYPE_FOUR:
                DynamicSingleLvHolderFour lvHolderFour = null;
                if (convertView ==null){
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_activity_dymicsingle_four_lv,parent,false);
                    lvHolderFour = new DynamicSingleLvHolderFour(convertView);
                    convertView.setTag(lvHolderFour);
                }else {
                    lvHolderFour = (DynamicSingleLvHolderFour) convertView.getTag();
                }
                lvHolderFour.usernameFourTv.setText(datas.getData().getCommentsList().get(position).getAuthor().getUsername());
                lvHolderFour.contentFourTv.setText(datas.getData().getCommentsList().get(position).getContent());
                lvHolderFour.modifiedFourTv.setText(String.valueOf(datas.getData().getCommentsList().get(position).getModified()));
                if (!datas.getData().getCommentsList().get(position).getAuthor().getAvatar().isEmpty()){
                    lvHolderFour.avatarFourIv.setVisibility(View.VISIBLE);
                    Picasso.with(context).load(datas.getData().getCommentsList().get(position).getAuthor().getAvatar()).into(lvHolderFour.avatarFourIv);
                }else {
                    lvHolderFour.avatarFourIv.setVisibility(View.INVISIBLE);
                }



        }

        return convertView;
    }

    class DynamicSingleLvHolderOne {
        TextView contentTv;
        TextView usernameTv;
        TextView createdTv;
        CircleImageView avatarIv;
        ImageView photoIv;

        public DynamicSingleLvHolderOne(View view) {
            contentTv = (TextView) view.findViewById(R.id.dynamicsSingle_one_contentTv);
            usernameTv = (TextView) view.findViewById(R.id.dynamicsSingle_one_usernameIv);
            createdTv = (TextView) view.findViewById(R.id.dynamicsSingle_one_createdIv);
            avatarIv = (CircleImageView) view.findViewById(R.id.dynamicsSingle_one_avatarIv);
            photoIv = (ImageView) view.findViewById(R.id.dynamicsSingle_one_photoIv);
        }
    }

    class DynamicSingleLvHolderTwo {
        TextView likesTwoIv;



        public DynamicSingleLvHolderTwo(View view) {
            likesTwoIv = (TextView) view.findViewById(R.id.dynamicsSingle_two_likes);
            recyclerView = (RecyclerView) view.findViewById(R.id.dynamicsSingle_two_rv);


        }
    }

    class DynamicSingleLvHolderThree{
        TextView commentsThreeIv;

        public DynamicSingleLvHolderThree(View view) {
            commentsThreeIv = (TextView) view.findViewById(R.id.dynamicsSingle_three_commentsIv);
        }
    }

    class DynamicSingleLvHolderFour{
        TextView contentFourTv;
        TextView usernameFourTv;
        TextView modifiedFourTv;
        CircleImageView avatarFourIv;

        public DynamicSingleLvHolderFour(View view) {
            contentFourTv = (TextView) view.findViewById(R.id.dynamicsSingle_four_contentTv);
            usernameFourTv = (TextView) view.findViewById(R.id.dynamicsSingle_four_username);
            modifiedFourTv = (TextView) view.findViewById(R.id.dynamicsSingle_four_modified);
            avatarFourIv = (CircleImageView) view.findViewById(R.id.dynamicsSingle_four_avatarIv);
        }
    }
}
