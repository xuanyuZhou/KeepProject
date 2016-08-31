package com.example.dllo.keepproject.ui.activity;

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
 * 登录界面activity
 */
public class LoginActivity extends AbsBaseActivity implements View.OnClickListener {
    private ImageView loginBack;
    private EditText userNameEt;
    private EditText passWordEt;
    private TextView loginBtn;

    @Override
    protected int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        loginBack = byView(R.id.aty_login_backIv);
        userNameEt = byView(R.id.aty_login_userNameEd);
        passWordEt = byView(R.id.aty_login_passWordEd);
        loginBtn = byView(R.id.aty_login_loginBtn);

    }

    @Override
    protected void initListeners() {
        loginBack.setOnClickListener(this);
        loginBtn.setOnClickListener(this);


    }

    @Override
    protected void initDatas() {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.aty_login_backIv:
                finish();
                overridePendingTransition(R.anim.finish_out, R.anim.finish_in);
                break;

            case R.id.aty_login_loginBtn:
                String userName = userNameEt.getText().toString();
                String passWord = passWordEt.getText().toString();
                List<IdBean> idList = DBTool.getInstance().getQueryByWhere(IdBean.class, "userName", userName);


                if (!userName.isEmpty() && !passWord.isEmpty() && idList.size() != 0) {
                    if (userName.equals(idList.get(0).getUserName()) && passWord.equals(idList.get(0).getPassWord())) {
                        goTo(this, MainActivity.class);
                        finish();
                    } else if (!passWord.equals(idList.get(0).getPassWord()) && userName.equals(idList.get(0).getUserName())) {
                        Toast.makeText(this, "密码错误", Toast.LENGTH_SHORT).show();
                    }
                } else if (userName.isEmpty()) {
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (passWord.isEmpty()) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else if (idList.size() == 0) {
                    Toast.makeText(this, "账号不存在", Toast.LENGTH_SHORT).show();
                }


                break;
        }
    }
}
