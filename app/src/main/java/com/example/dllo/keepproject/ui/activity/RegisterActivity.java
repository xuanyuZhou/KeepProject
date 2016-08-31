package com.example.dllo.keepproject.ui.activity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.db.DBTool;
import com.example.dllo.keepproject.model.bean.IdBean;

import java.util.List;

/**
 * Created by dllo on 16/8/23.
 * 注册界面activity
 */
public class RegisterActivity extends AbsBaseActivity implements View.OnClickListener {
    private EditText userEd, passEd;
    private TextView registerBtn;
    private ImageView backIv;

    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        userEd = byView(R.id.aty_register_userNameEd);
        passEd = byView(R.id.aty_register_passWordEd);
        registerBtn = byView(R.id.aty_register_registerBtn);
        backIv = byView(R.id.aty_register_backIv);
    }

    @Override
    protected void initListeners() {
        userEd.setOnClickListener(this);
        passEd.setOnClickListener(this);
        registerBtn.setOnClickListener(this);
        backIv.setOnClickListener(this);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aty_register_registerBtn:
                String userName = userEd.getText().toString();
                String passWord = passEd.getText().toString();

                IdBean idBean = new IdBean(userName, passWord);
                List<IdBean> idBeanList = DBTool.getInstance().getQueryByWhere(IdBean.class, "userName", userName);
                Log.d("RegisterActivity", "idBeanList.size():" + idBeanList.size());
                if (!userName.isEmpty() && !passWord.isEmpty() && idBeanList.size() == 0) {
                    DBTool.getInstance().insertData(idBean);
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    goTo(this, LoginActivity.class);
                    finish();
                } else if (userName.isEmpty()) {
                    Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
                } else if (passWord.isEmpty()) {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                } else if (idBeanList.size() != 0) {
                    Toast.makeText(this, "账号已存在", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.aty_register_backIv:
                finish();
                overridePendingTransition(R.anim.finish_out,R.anim.finish_in);
                break;


        }
    }
}
