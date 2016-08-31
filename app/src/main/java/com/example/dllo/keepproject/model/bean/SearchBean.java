package com.example.dllo.keepproject.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/24.
 */
public class SearchBean {


    /**
     * ok : true
     * data : {"course":[{"id":"55dabcdaf27cfd351f773d6e","name":"膝关节自我康复阶段1","description":"本训练的动作以左膝痛疼为例设计，如右膝也需要康复，请将动作换至另一侧。","picture":"http://static1.gotokeep.com/misc/2015/10/20/17/542129139cc00000.jpg","type":"workout"},{"id":"56d415419f0274a548831890","name":"地狱Burpees挑战","description":"13分钟，100次burpee。","picture":"http://static1.gotokeep.com/misc/2016/03/01/15/54cc47743b800000.jpg","type":"workout"},{"id":"56c2f6f999ca8d1f0603ab0d","name":"12分钟热力Tabata","description":"Tabata法则：20秒竭尽全力，10秒休息。","picture":"http://static1.gotokeep.com/misc/2016/02/16/18/54ba652866400000.jpg","type":"workout"}],"username":[{"id":"55abad03cddfa7b7dbb86ed6","username":"1--","avatar":"http://static1.gotokeep.com/avatar/2015/07/19/21/751e09a7d8321cef467bede6bb20cc9fce05b129.jpg"},{"id":"55add8b27197fe5f2e9ec07a","username":"1----","avatar":""},{"id":"5639f7ec34562b2b055b81bf","username":"1-----","avatar":"http://q.qlogo.cn/qqapp/1103727446/BD46044B8B0386C09BC05D12704DBD2D/100"}],"hashtag":[{"name":"100天健身计划"},{"name":"100天打卡"},{"name":"100天蜕变"}],"hot":[{"id":"557170c05519d9f2035ecdcd","author":"5523f014fbbd395a10f50daf","content":"1\u20e3️","photo":"http://static1.gotokeep.com/picture/2015/06/05/17/8bd24768e0b8acdeb8be002e21269a8d9ebc824c.jpg","state":"hot","type":"normal"},{"id":"550ea964edbc92cb5fe438a6","author":"550e71abf0d03b9d05538be3","content":"DAY 1","photo":"http://static1.gotokeep.com/picture/3a6919e37be4440ceab632e4ddc3ca69.jpg","state":"hot","type":"normal"},{"id":"551caf4aed487d8f2b61cafc","author":"551b7f42ed487d8f2b61732d","content":"day 1","photo":"http://static1.gotokeep.com/picture/ec6da54d72ee8bba2dba9c3b1357bc35.jpg","state":"hot","type":"normal"}],"ec":[{"pid":"72","pname":"Keep 推荐 | 刀切燕麦","redirectUrl":"keep://store_item/72","adMsg":"加工少更营养  10 - 15 分钟水煮后食用|此商品支持7天无理由退货，影响二次销售的除外|此商品由上海首健贸易有限公司提供并负责售后","picUrl":"https://static2.gotokeep.com/ec/product/460/fbdbb688161fa0b3af4e93cfded3f2f6.jpg","attributes":[],"remark":""},{"pid":"70","pname":"Keep 推荐 | 精碾燕麦片","redirectUrl":"keep://store_item/70","adMsg":"5 - 10分钟快速烹饪 |此商品支持7天无理由退货，影响二次销售的除外|此商品由上海首健贸易有限公司提供并负责售后","picUrl":"https://static2.gotokeep.com/ec/product/463/8af8f37b578d376b51bf3c5c4b2019dd.jpg","attributes":[],"remark":""},{"pid":"34","pname":"Keep 推荐 | 泡沫轴","redirectUrl":"keep://store_item/34","adMsg":"承重 150 kg 以上，可以经受住每一天的使用测试|齿轮凹槽设计，肌肉刺激感加深，增加按摩强度|此商品支持7天无理由退货，影响二次销售的情况除外","picUrl":"https://static2.gotokeep.com/ec/product/521/bff9633ba04b5ebda32a7c3097e25716.jpg","attributes":[],"remark":""}],"exercise":[]}
     * errorCode : 0
     * now : 2016-08-24T01:52:06.391Z
     * version : 1.0.0
     * count : {"exercise":0,"hot":9674,"course":8,"ec":3,"hashtag":498,"username":498}
     */

    private boolean ok;
    private DataBean data;
    private int errorCode;
    private String now;
    private String version;
    /**
     * exercise : 0
     * hot : 9674
     * course : 8
     * ec : 3
     * hashtag : 498
     * username : 498
     */

    private CountBean count;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public CountBean getCount() {
        return count;
    }

    public void setCount(CountBean count) {
        this.count = count;
    }

    public static class DataBean {
        /**
         * id : 55dabcdaf27cfd351f773d6e
         * name : 膝关节自我康复阶段1
         * description : 本训练的动作以左膝痛疼为例设计，如右膝也需要康复，请将动作换至另一侧。
         * picture : http://static1.gotokeep.com/misc/2015/10/20/17/542129139cc00000.jpg
         * type : workout
         */

        private List<CourseBean> course;
        /**
         * id : 55abad03cddfa7b7dbb86ed6
         * username : 1--
         * avatar : http://static1.gotokeep.com/avatar/2015/07/19/21/751e09a7d8321cef467bede6bb20cc9fce05b129.jpg
         */

        private List<UsernameBean> username;
        /**
         * name : 100天健身计划
         */

        private List<HashtagBean> hashtag;
        /**
         * id : 557170c05519d9f2035ecdcd
         * author : 5523f014fbbd395a10f50daf
         * content : 1⃣️
         * photo : http://static1.gotokeep.com/picture/2015/06/05/17/8bd24768e0b8acdeb8be002e21269a8d9ebc824c.jpg
         * state : hot
         * type : normal
         */

        private List<HotBean> hot;
        /**
         * pid : 72
         * pname : Keep 推荐 | 刀切燕麦
         * redirectUrl : keep://store_item/72
         * adMsg : 加工少更营养  10 - 15 分钟水煮后食用|此商品支持7天无理由退货，影响二次销售的除外|此商品由上海首健贸易有限公司提供并负责售后
         * picUrl : https://static2.gotokeep.com/ec/product/460/fbdbb688161fa0b3af4e93cfded3f2f6.jpg
         * attributes : []
         * remark :
         */

        private List<EcBean> ec;
        private List<?> exercise;

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public List<UsernameBean> getUsername() {
            return username;
        }

        public void setUsername(List<UsernameBean> username) {
            this.username = username;
        }

        public List<HashtagBean> getHashtag() {
            return hashtag;
        }

        public void setHashtag(List<HashtagBean> hashtag) {
            this.hashtag = hashtag;
        }

        public List<HotBean> getHot() {
            return hot;
        }

        public void setHot(List<HotBean> hot) {
            this.hot = hot;
        }

        public List<EcBean> getEc() {
            return ec;
        }

        public void setEc(List<EcBean> ec) {
            this.ec = ec;
        }

        public List<?> getExercise() {
            return exercise;
        }

        public void setExercise(List<?> exercise) {
            this.exercise = exercise;
        }

        public static class CourseBean {
            private String id;
            private String name;
            private String description;
            private String picture;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class UsernameBean {
            private String id;
            private String username;
            private String avatar;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }

        public static class HashtagBean {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class HotBean {
            private String id;
            private String author;
            private String content;
            private String photo;
            private String state;
            private String type;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class EcBean {
            private String pid;
            private String pname;
            private String redirectUrl;
            private String adMsg;
            private String picUrl;
            private String remark;
            private List<?> attributes;

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getPname() {
                return pname;
            }

            public void setPname(String pname) {
                this.pname = pname;
            }

            public String getRedirectUrl() {
                return redirectUrl;
            }

            public void setRedirectUrl(String redirectUrl) {
                this.redirectUrl = redirectUrl;
            }

            public String getAdMsg() {
                return adMsg;
            }

            public void setAdMsg(String adMsg) {
                this.adMsg = adMsg;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public List<?> getAttributes() {
                return attributes;
            }

            public void setAttributes(List<?> attributes) {
                this.attributes = attributes;
            }
        }
    }

    public static class CountBean {
        private int exercise;
        private int hot;
        private int course;
        private int ec;
        private int hashtag;
        private int username;

        public int getExercise() {
            return exercise;
        }

        public void setExercise(int exercise) {
            this.exercise = exercise;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public int getEc() {
            return ec;
        }

        public void setEc(int ec) {
            this.ec = ec;
        }

        public int getHashtag() {
            return hashtag;
        }

        public void setHashtag(int hashtag) {
            this.hashtag = hashtag;
        }

        public int getUsername() {
            return username;
        }

        public void setUsername(int username) {
            this.username = username;
        }
    }
}
