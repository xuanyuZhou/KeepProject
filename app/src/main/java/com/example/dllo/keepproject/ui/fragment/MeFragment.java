package com.example.dllo.keepproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.ui.activity.SetUpActivity;

/**
 * Created by dllo on 16/8/11.
 */
public class MeFragment extends AbsBaseFragment implements View.OnClickListener {
    private ImageView setUpImage;

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initView() {
        setUpImage = byView(R.id.me_setUp);

    }

    @Override
    protected void setListeners() {
        setUpImage.setOnClickListener(this);

    }

    @Override
    protected void initDatas() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_setUp:
                goTo(context, SetUpActivity.class);
                getActivity().overridePendingTransition(R.anim.activity_in,R.anim.activity_out);

                break;
        }
    }
}
