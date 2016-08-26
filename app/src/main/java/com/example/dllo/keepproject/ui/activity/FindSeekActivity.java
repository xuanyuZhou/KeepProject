package com.example.dllo.keepproject.ui.activity;


import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import android.widget.Adapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.shitou.googleplay.lib.randomlayout.StellarMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dllo on 16/8/19.
 * 这里是第二页的搜索页面(放大镜)
 */
public class FindSeekActivity extends AbsBaseActivity implements View.OnClickListener {
    //这里是我自己导入的一个StellarMap的jar
    private StellarMap stellarMap;
    private ArrayList<String> list = new ArrayList<String>();
    private ImageView backImage;
    private ImageView searchImage;

    @Override
    protected int setLayout() {
        return R.layout.activity_findseek;
    }

    @Override
    protected void initView() {
        backImage = byView(R.id.findseek_activity_backIv);
        searchImage = byView(R.id.search_Image);

    }

    @Override
    protected void initListeners() {
        backImage.setOnClickListener(this);
        searchImage.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {
        // 这里设置要来源的文字
//                list.add("第" + i + "组" + "文字" + j);

        String[] str = new String[]{"阿诺德推举", "健身", "美胸", "美肤", "美臀", "胸肌",
                "腹肌", "马甲线", "人鱼线", "美腿", "肱二头肌", "瘦腿", "减脂",
                "减肥", "丰胸", "瑜伽", "跑步", "有氧运动", "腿部运动", "臀部肌肉",
                "臀大肌", "腹部", "塑身", "线条", "肱三头肌", "史密斯肩上推举", "坐姿侧平举", "美肤",
                "阿诺德推举", "健身", "美胸", "美肤", "美臀", "胸肌",
                "腹肌", "马甲线", "人鱼线", "美腿", "肱二头肌", "瘦腿", "减脂",
                "减肥", "丰胸", "瑜伽", "跑步", "有氧运动", "腿部运动", "臀部肌肉",
                "臀大肌", "腹部", "塑身", "线条", "肱三头肌", "史密斯肩上推举", "坐姿侧平举", "美肤"};
        for (int j = 0; j < str.length; j++) {
            for (int i = 0; i < str.length; i++) {
                list.add(str[i]);
            }
        }


        stellarMap = new StellarMap(this);
        // 1设置内部的TextView距离四周的内边距
        int padding = 15;
        stellarMap.setInnerPadding(padding, padding, padding, padding);
        stellarMap.setAdapter(new StellarMapAdapter());
        // 设置默认显示第几组的数据
        stellarMap.setGroup(0, true);// 这里默认显示第0组
        // 设置x和y方向上的显示的密度
        stellarMap.setRegularity(15, 15);// 如果值设置的过大，有可能造成子View摆放比较稀疏

        // 把fragment显示至界面,new出fragment对象
        FrameLayout fl = (FrameLayout) findViewById(R.id.fl);
        fl.addView(stellarMap);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.findseek_activity_backIv:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;
            case R.id.search_Image:
                goTo(this, SearchActivity.class);
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
                break;
        }
    }

    class StellarMapAdapter implements StellarMap.Adapter {

        private TextView textView;

        /**
         * 返回多少组数据
         */
        @Override
        public int getGroupCount() {
            return 3;
        }

        /**
         * 每组多少个数据
         */
        @Override
        public int getCount(int group) {
            return 11;
        }

        /**
         * group: 当前是第几组 position:是当前组的position
         */
        @Override
        public View getView(int group, int position, View convertView) {
            textView = new TextView(FindSeekActivity.this);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FindSeekActivity.this, "点击事件", Toast.LENGTH_SHORT).show();
                }
            });
            // 根据group和组中的position计算出对应的在list中的位置
            int listPosition = group * getCount(group) + position;
            textView.setText(list.get(listPosition));

            // 1.设置随机的字体大小(随机大小)
            Random random = new Random();
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                    random.nextInt(20) + 14);// 14-29
            // 2.上色，设置随机的字体颜色
            // 如果三原色的值过大会偏白色，过小会偏黑色，所以应该随机一个中间的颜色的值
            int red = random.nextInt(100) + 100;// 50-199
            int green = random.nextInt(100) + 100;// 50-199
            int blue = random.nextInt(100) + 100;// 50-199
            int textColor = Color.rgb(red, green, blue);// 在rgb三原色的基础上混合出一种新的颜色
            textView.setTextColor(textColor);
            return textView;
        }

        /**
         * 虽然定义了，但是并没有什么乱用
         */
        @Override
        public int getNextGroupOnPan(int group, float degree) {
            return 0;
        }

        /**
         * 当前组缩放完成之后下一组加载哪一组的数据 group： 表示当前是第几组
         */
        @Override
        public int getNextGroupOnZoom(int group, boolean isZoomIn) {
            // 0->1->2->0
            return (group + 1) % getGroupCount();
        }

    }


}

