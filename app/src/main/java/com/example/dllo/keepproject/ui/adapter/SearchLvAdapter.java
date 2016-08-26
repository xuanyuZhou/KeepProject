package com.example.dllo.keepproject.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.bean.SearchBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dllo on 16/8/24.
 * 搜索界面
 */
public class SearchLvAdapter extends BaseAdapter {

    private SearchBean bean;
    private Context context;

    // 标题  课程的标题
    private static final int TYPE_TITLE_ONE = 0;
    // 课程
    private static final int TYPE_1 = 1;
    // 显示更多
    private static final int TYPE_MORE = 2;
    // 用户 用户的标题

    private static final int TYPE_COUNT = 3;


    public SearchLvAdapter(Context context) {
        this.context = context;
    }

    public void setBean(SearchBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return bean.getData().getCourse() != null ? bean.getData().getCourse().size() + 2 : 0;
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().getCourse() != null ? bean.getData().getCourse().get(position) : null;
    }

    @Override
    public int getItemViewType(int position) {
        // 显示课程标题
        if (bean.getData().getCourse().size() != 0 && position == 0) {
            return TYPE_TITLE_ONE;
        } // 显示查看更多
        else if (position == bean.getData().getCourse().size() + 1) {
            return TYPE_MORE;
        } else {
            return TYPE_1;
        }

    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SearchCourseHolder courseHolder = null;
        TitleHolder titleHolder = null;
        MoreHolder moreHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_1:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_searchlv_one, parent, false);
                    courseHolder = new SearchCourseHolder(convertView);
                    convertView.setTag(courseHolder);
                    break;
                case TYPE_TITLE_ONE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_searchlv_one_title, parent, false);
                    titleHolder = new TitleHolder(convertView);
                    convertView.setTag(titleHolder);
                    break;

                case TYPE_MORE:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_search_lookall, parent, false);
                    moreHolder = new MoreHolder(convertView);
                    convertView.setTag(moreHolder);
                    break;


            }
        } else {
            switch (type) {
                case TYPE_TITLE_ONE:
                    titleHolder = (TitleHolder) convertView.getTag();
                    break;
                case TYPE_1:
                    courseHolder = (SearchCourseHolder) convertView.getTag();
                    break;
                case TYPE_MORE:
                    moreHolder = (MoreHolder) convertView.getTag();
                    break;

            }
        }
        List<SearchBean.DataBean.CourseBean> courseBeanList = bean.getData().getCourse();
        switch (type) {
            case TYPE_TITLE_ONE:

                titleHolder.searchCourseTv.setText("课程");
                break;
            case TYPE_1:
                if (!courseBeanList.isEmpty()) {
                    Picasso.with(context).load(courseBeanList.get(position - 1).getPicture()).
                            config(Bitmap.Config.RGB_565).resize(200, 200).into(courseHolder.contentImage);
                    courseHolder.contentTv.setText(courseBeanList.get(position - 1).getDescription());
                    courseHolder.titleTv.setText(courseBeanList.get(position - 1).getName());

                }
                break;
            case TYPE_MORE:
                moreHolder.moreTv.setText("查看更多");
                break;

        }
        return convertView;
    }

    class SearchCourseHolder {
        private ImageView contentImage;
        private TextView titleTv;
        private TextView contentTv;

        public SearchCourseHolder(View view) {
            contentImage = (ImageView) view.findViewById(R.id.item_search_ContentImage);
            titleTv = (TextView) view.findViewById(R.id.item_search_titleTv);
            contentTv = (TextView) view.findViewById(R.id.item_search_contentTv);
        }
    }

    class TitleHolder {
        private TextView searchCourseTv;

        public TitleHolder(View view) {
            searchCourseTv = (TextView) view.findViewById(R.id.item_search_CourseTv);
        }
    }

    class MoreHolder {
        private TextView moreTv;

        public MoreHolder(View view) {
            moreTv = (TextView) view.findViewById(R.id.item_search_lookAllTv);
        }
    }
}
