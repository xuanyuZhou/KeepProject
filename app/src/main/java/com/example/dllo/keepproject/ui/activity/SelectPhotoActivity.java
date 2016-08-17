package com.example.dllo.keepproject.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.SelectPhotoLvAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/8/17.
 * 这里是精选相册的activity
 */
public class SelectPhotoActivity extends AbsBaseActivity{
    private ArrayList<String> strings;
    private SelectPhotoLvAdapter lvAdapter;
    private ListView listView;
    @Override
    protected int setLayout() {
        return R.layout.activity_selectphoto;
    }

    @Override
    protected void initView() {
        listView = byView(R.id.selectphoto_lv);

    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initDatas() {
        strings = new ArrayList<>();
        strings.add("http://pic.7kk.com/wp/480_800/a/d7/4d71bf48af37830536bc6b31788be.jpg");
        strings.add("http://s15.sinaimg.cn/mw600/0065EJjGgy6XeokL8o6be&690");
        strings.add("http://pic26.photophoto.cn/20130331/0036036703131019_b.jpg");
        strings.add("http://pic.7kk.com/wp/480_800/7/f0/005bb3e4385b416fe666ff72fbfaf.jpg");
        strings.add("http://brookewylde.hcfeed.com/boobs/aHR0cDovL2ltZzAucGguMTI2Lm5ldC9rUm8wYXZiR2RsZFFodk5MbjhrLXBnPT0vNjU0MTQ3ODQ1ODkyOTM5NDkyLmpwZWc=.jpg");
        strings.add("http://img01.taopic.com/160430/240368-1604300Z55436.jpg");
        strings.add("http://imgsrc.baidu.com/forum/w=580/sign=5707ea1b45166d223877159c76210945/b54cf358ccbf6c8182f64138ba3eb13531fa406e.jpg");
        strings.add("http://i.dimg.cc/f3/98/6f/cf/a0/fc/9c/67/c2/0b/64/f6/48/cc/c6/71.jpg");
        strings.add("http://img01.taopic.com/150519/267856-15051ZQT635.jpg");
        strings.add("http://s17.mogucdn.com/p1/150807/14dhcd_ie2tcmlehe2tqztegizdambqhayde_750x1125.jpg_750x999.jpg");
        lvAdapter = new SelectPhotoLvAdapter(this);
        lvAdapter.setStrings(strings);
        listView.setAdapter(lvAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SelectPhotoActivity.this,SelectPhotoSingActivity.class);
                intent.putExtra("images",strings);
                intent.putExtra("position",position);
                // 自己baidu的~
                int[] location = new int[2];
                //获取在整个屏幕内的绝对坐标，注意这个值是要从屏幕顶端算起，也就是包括了通知栏的高度。
                view.getLocationOnScreen(location);
                intent.putExtra("locationX", location[0]);
                intent.putExtra("locationY", location[1]);
                intent.putExtra("width", view.getWidth());
                intent.putExtra("height", view.getHeight());
                startActivity(intent);
                overridePendingTransition(0,0);

            }
        });

    }
}
