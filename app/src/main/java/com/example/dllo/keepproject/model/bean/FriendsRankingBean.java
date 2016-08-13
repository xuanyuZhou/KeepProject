package com.example.dllo.keepproject.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/12.
 * 好友排名数据类
 */
public class FriendsRankingBean {
    /**
     * ok : true
     * data : [{"user":{"_id":"57a2c618b34ac90c53d55ffb","avatar":"http://static1.gotokeep.com/avatar/2016/08/04/12/e0c434abdcc4b74f3fbd3d2225be081af80a2a66.jpg","username":"爱轩么么哒"},"count":287,"ranking":4},{"user":{"_id":"57a289db9a10382d0588acb1","avatar":"http://static1.gotokeep.com/avatar/2016/08/04/08/f0229a68b38fbf591b7e104badc5ff10f8cfa86b.jpg","username":"Hennessy宇轩"},"count":179,"ranking":5},{"user":{"_id":"5586a4093568e007bf0e9b46","username":"就叫我小A","avatar":"http://static1.gotokeep.com/avatar/2016/07/26/14/8b991a33ee2bb49acba9efd56288785f8c11a1ce.jpg"},"count":29,"ranking":6}]
     * errorCode : 0
     * now : 2016-08-12T06:45:06.744Z
     * version : 1.0.0
     */

    private boolean ok;
    private int errorCode;
    private String now;
    private String version;
    /**
     * user : {"_id":"57a2c618b34ac90c53d55ffb","avatar":"http://static1.gotokeep.com/avatar/2016/08/04/12/e0c434abdcc4b74f3fbd3d2225be081af80a2a66.jpg","username":"爱轩么么哒"}
     * count : 287
     * ranking : 4
     */

    private List<DataBean> data;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * _id : 57a2c618b34ac90c53d55ffb
         * avatar : http://static1.gotokeep.com/avatar/2016/08/04/12/e0c434abdcc4b74f3fbd3d2225be081af80a2a66.jpg
         * username : 爱轩么么哒
         */

        private UserBean user;
        private int count;
        private int ranking;

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getRanking() {
            return ranking;
        }

        public void setRanking(int ranking) {
            this.ranking = ranking;
        }

        public static class UserBean {
            private String _id;
            private String avatar;
            private String username;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
