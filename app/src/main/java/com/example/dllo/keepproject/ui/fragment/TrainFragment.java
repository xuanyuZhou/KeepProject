package com.example.dllo.keepproject.ui.fragment;

import com.example.dllo.keepproject.R;
import com.example.dllo.keepproject.model.net.DlaHttp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 16/8/11.
 */
public class TrainFragment extends AbsBaseFragment {
    @Override
    protected int setLayout() {
        return R.layout.fragment_train;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void initDatas() {
        Map<String,String> headMap = new HashMap<>();
        headMap.put("x-device-id","000000000000000080027ab241a11111b0927a74");
        headMap.put("X-KEEP-FROM","android");
        headMap.put("X-KEEP-TIMEZONE","America/New_York");
        headMap.put("X-KEEP-CHANNEL","baidu");
        headMap.put("X-KEEP-VERSION","3.8.1");
        headMap.put("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJfaWQiOiI1N2EyODlkYjlhMTAzODJkMDU4OGFjYjEiLCJ1c2VybmFtZSI6Ikhlbm5lc3N55a6H6L2pIiwiYXZhdGFyIjoiaHR0cDovL3N0YXRpYzEuZ290b2tlZXAuY29tL2F2YXRhci8yMDE2LzA4LzA0LzA4L2YwMjI5YTY4YjM4ZmJmNTkxYjdlMTA0YmFkYzVmZjEwZjhjZmE4NmIuanBnIiwiaWF0IjoxNDcwOTE5OTUzLCJleHAiOjE0NzM1MTE5NTMsImlzcyI6Imh0dHA6Ly93d3cuZ290b2tlZXAuY29tLyJ9.3hiKu1-Ixi5q3jbhkYHXTSd0584cx2VB5sMLcbOIpTs");
        headMap.put("Host","api.gotokeep.com");
        headMap.put("Connection","Keep-Alive");
        DlaHttp tool = DlaHttp.getInstance();
    }
}
