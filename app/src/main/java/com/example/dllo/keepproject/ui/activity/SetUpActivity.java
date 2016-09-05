package com.example.dllo.keepproject.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.adapter.SetUpLvAdapter;
import com.example.dllo.keepproject.ui.app.MyApp;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/8/23.
 */
public class SetUpActivity extends AbsBaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ImageView setupBack;
    private ListView setupLv;
    private ListView setupTwoLv;
    private ListView setupThereLv;
    private ListView setupFourLv;
    private SetUpLvAdapter adapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_setup;
    }

    @Override
    protected void initView() {
        setupBack = byView(R.id.setup_back);
        setupLv = byView(R.id.setup_lv);
        setupTwoLv = byView(R.id.setup_Twolv);
        setupThereLv = byView(R.id.setupThere_lv);
        setupFourLv = byView(R.id.setup_Fourlv);

    }

    @Override
    protected void initListeners() {
        setupBack.setOnClickListener(this);
        setupLv.setOnItemClickListener(this);

    }

    @Override
    protected void initDatas() {

        ArrayList<String> listOne = new ArrayList<>();
        listOne.add("个人资料");
        listOne.add("音乐管理");
        listOne.add("账号绑定");
        listOne.add("账号管理");
        adapter = new SetUpLvAdapter(MyApp.getContext());
        adapter.setArrayList(listOne);
        setupLv.setAdapter(adapter);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.setup_back:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         if (position ==0){
         goTo(this,PersonnalActivity.class);
             overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
    }

     if (position == 1){
         goTo(this,MusicManageActivity.class);
         overridePendingTransition(R.anim.activity_in,R.anim.activity_out);
     }
    }

}
