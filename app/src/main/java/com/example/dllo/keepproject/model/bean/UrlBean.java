package com.example.dllo.keepproject.model.bean;

/**
 * Created by dllo on 16/8/12.
 * 接口数据类,********************一定要去掉s**********************
 */
public class UrlBean {
    /**
     * 训练页的训练数据接口
     */
    public static final String TRAIN_DATA_URL = "http://api.gotokeep.com/v1.1/home/dashboard/statistics";
    /**
     * 好友排名接口
     */
    public static final String FRIEND_RANKING_URL = "http://api.gotokeep.com/v1.1/rankinglist/user/following/brief";
    /**
     * 训练页,我的训练listView接口
     */
    public static final String TRAIN_MY_TRAIN_LV_URL = "http://api.gotokeep.com/v1.1/home/dashboard/pwData";

    public static final String HAS_BEEN_URL = "http://api.gotokeep.com/v1.1/timeline/followings";

    /**
     * 小组接口
     */
    public static final String GROUP_URL ="http://api.gotokeep.com/v1.1/group";
}
