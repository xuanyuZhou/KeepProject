package com.example.dllo.keepproject.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/13.
 * 训练界面,我的训练listView数据类
 * 加载不同的行布局数据
 */
public class TrainFmMyTrainBean {

    /**
     * ok : true
     * data : {"plans":[{"_id":"57a34f971d43afecd4346620","plan":{"_id":"54f429113419916320da0330","name":"五维腹肌训练计划","difficulty":1,"picture":"http://static1.gotokeep.com/misc/2015/10/20/17/54212a70a5400000.jpg","days":5,"workouts":["54f429113419916320da0331","54f429113419916320da0332","54f429113419916320da0333","54f429113419916320da0334","54f429113419916320da0335"],"pioneer":5484927,"tags":[],"workoutsData":[{"_id":"54f429113419916320da0331","duration":12,"calorie":41},{"_id":"54f429113419916320da0332","duration":14,"calorie":45},{"_id":"54f429113419916320da0333","duration":14,"calorie":38},{"_id":"54f429113419916320da0334","duration":12,"calorie":49},{"_id":"54f429113419916320da0335","duration":13,"calorie":41}]},"days":5,"current_progress":5,"max_progress":5,"surpass":0}],"workouts":[{"_id":"57a9e9271d43afecd4b19e8a","workout":{"_id":"5719d432215b2c1de92cb270","name":"哑铃胸部训练","duration":18,"tags":["new"],"calorie":160,"picture":"http://static1.gotokeep.com/misc/2016/05/04/15/551ea65ea2000000.jpg"},"completed":2},{"_id":"57a9fbb91d43afecd4bf7e1b","workout":{"_id":"54afa35c35fb7f5912e3c6de","name":"腹肌撕裂者初级","duration":10,"tags":[],"calorie":34,"picture":"http://static1.gotokeep.com/misc/2015/10/20/17/542127a3ad800000.jpg"},"completed":2}],"schedules":[]}
     * errorCode : 0
     * now : 2016-08-13T01:53:59.069Z
     * version : 1.0.0
     */

    private boolean ok;
    private DataBean data;
    private int errorCode;
    private String now;
    private String version;

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

    public static class DataBean {
        /**
         * _id : 57a34f971d43afecd4346620
         * plan : {"_id":"54f429113419916320da0330","name":"五维腹肌训练计划","difficulty":1,"picture":"http://static1.gotokeep.com/misc/2015/10/20/17/54212a70a5400000.jpg","days":5,"workouts":["54f429113419916320da0331","54f429113419916320da0332","54f429113419916320da0333","54f429113419916320da0334","54f429113419916320da0335"],"pioneer":5484927,"tags":[],"workoutsData":[{"_id":"54f429113419916320da0331","duration":12,"calorie":41},{"_id":"54f429113419916320da0332","duration":14,"calorie":45},{"_id":"54f429113419916320da0333","duration":14,"calorie":38},{"_id":"54f429113419916320da0334","duration":12,"calorie":49},{"_id":"54f429113419916320da0335","duration":13,"calorie":41}]}
         * days : 5
         * current_progress : 5
         * max_progress : 5
         * surpass : 0
         */

        private List<PlansBean> plans;
        /**
         * _id : 57a9e9271d43afecd4b19e8a
         * workout : {"_id":"5719d432215b2c1de92cb270","name":"哑铃胸部训练","duration":18,"tags":["new"],"calorie":160,"picture":"http://static1.gotokeep.com/misc/2016/05/04/15/551ea65ea2000000.jpg"}
         * completed : 2
         */

        private List<WorkoutsBean> workouts;
        private List<?> schedules;

        public List<PlansBean> getPlans() {
            return plans;
        }

        public void setPlans(List<PlansBean> plans) {
            this.plans = plans;
        }

        public List<WorkoutsBean> getWorkouts() {
            return workouts;
        }

        public void setWorkouts(List<WorkoutsBean> workouts) {
            this.workouts = workouts;
        }

        public List<?> getSchedules() {
            return schedules;
        }

        public void setSchedules(List<?> schedules) {
            this.schedules = schedules;
        }

        public static class PlansBean {
            private String _id;
            /**
             * _id : 54f429113419916320da0330
             * name : 五维腹肌训练计划
             * difficulty : 1
             * picture : http://static1.gotokeep.com/misc/2015/10/20/17/54212a70a5400000.jpg
             * days : 5
             * workouts : ["54f429113419916320da0331","54f429113419916320da0332","54f429113419916320da0333","54f429113419916320da0334","54f429113419916320da0335"]
             * pioneer : 5484927
             * tags : []
             * workoutsData : [{"_id":"54f429113419916320da0331","duration":12,"calorie":41},{"_id":"54f429113419916320da0332","duration":14,"calorie":45},{"_id":"54f429113419916320da0333","duration":14,"calorie":38},{"_id":"54f429113419916320da0334","duration":12,"calorie":49},{"_id":"54f429113419916320da0335","duration":13,"calorie":41}]
             */

            private PlanBean plan;
            private int days;
            private int current_progress;
            private int max_progress;
            private int surpass;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public PlanBean getPlan() {
                return plan;
            }

            public void setPlan(PlanBean plan) {
                this.plan = plan;
            }

            public int getDays() {
                return days;
            }

            public void setDays(int days) {
                this.days = days;
            }

            public int getCurrent_progress() {
                return current_progress;
            }

            public void setCurrent_progress(int current_progress) {
                this.current_progress = current_progress;
            }

            public int getMax_progress() {
                return max_progress;
            }

            public void setMax_progress(int max_progress) {
                this.max_progress = max_progress;
            }

            public int getSurpass() {
                return surpass;
            }

            public void setSurpass(int surpass) {
                this.surpass = surpass;
            }

            public static class PlanBean {
                private String _id;
                private String name;
                private int difficulty;
                private String picture;
                private int days;
                private int pioneer;
                private List<String> workouts;
                private List<?> tags;
                /**
                 * _id : 54f429113419916320da0331
                 * duration : 12
                 * calorie : 41
                 */

                private List<WorkoutsDataBean> workoutsData;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getDifficulty() {
                    return difficulty;
                }

                public void setDifficulty(int difficulty) {
                    this.difficulty = difficulty;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public int getDays() {
                    return days;
                }

                public void setDays(int days) {
                    this.days = days;
                }

                public int getPioneer() {
                    return pioneer;
                }

                public void setPioneer(int pioneer) {
                    this.pioneer = pioneer;
                }

                public List<String> getWorkouts() {
                    return workouts;
                }

                public void setWorkouts(List<String> workouts) {
                    this.workouts = workouts;
                }

                public List<?> getTags() {
                    return tags;
                }

                public void setTags(List<?> tags) {
                    this.tags = tags;
                }

                public List<WorkoutsDataBean> getWorkoutsData() {
                    return workoutsData;
                }

                public void setWorkoutsData(List<WorkoutsDataBean> workoutsData) {
                    this.workoutsData = workoutsData;
                }

                public static class WorkoutsDataBean {
                    private String _id;
                    private int duration;
                    private int calorie;

                    public String get_id() {
                        return _id;
                    }

                    public void set_id(String _id) {
                        this._id = _id;
                    }

                    public int getDuration() {
                        return duration;
                    }

                    public void setDuration(int duration) {
                        this.duration = duration;
                    }

                    public int getCalorie() {
                        return calorie;
                    }

                    public void setCalorie(int calorie) {
                        this.calorie = calorie;
                    }
                }
            }
        }

        public static class WorkoutsBean {
            private String _id;
            /**
             * _id : 5719d432215b2c1de92cb270
             * name : 哑铃胸部训练
             * duration : 18
             * tags : ["new"]
             * calorie : 160
             * picture : http://static1.gotokeep.com/misc/2016/05/04/15/551ea65ea2000000.jpg
             */

            private WorkoutBean workout;
            private int completed;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public WorkoutBean getWorkout() {
                return workout;
            }

            public void setWorkout(WorkoutBean workout) {
                this.workout = workout;
            }

            public int getCompleted() {
                return completed;
            }

            public void setCompleted(int completed) {
                this.completed = completed;
            }

            public static class WorkoutBean {
                private String _id;
                private String name;
                private int duration;
                private int calorie;
                private String picture;
                private List<String> tags;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public int getCalorie() {
                    return calorie;
                }

                public void setCalorie(int calorie) {
                    this.calorie = calorie;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public List<String> getTags() {
                    return tags;
                }

                public void setTags(List<String> tags) {
                    this.tags = tags;
                }
            }
        }
    }
}
