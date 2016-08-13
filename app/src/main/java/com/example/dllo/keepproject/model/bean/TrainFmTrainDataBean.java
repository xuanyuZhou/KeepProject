package com.example.dllo.keepproject.model.bean;

/**
 * Created by dllo on 16/8/12.
 * 训练页上方训练数据的数据类
 */
public class TrainFmTrainDataBean {

    /**
     * ok : true
     * data : {"totalTrainingDay":7,"totalTraining":11,"totalCalorie":688,"totalDuration":179,"currentCombo":7,"maxCombo":7,"totalEntries":10}
     * errorCode : 0
     * now : 2016-08-12T06:45:06.695Z
     * version : 1.0.0
     */

    private boolean ok;
    /**
     * totalTrainingDay : 7
     * totalTraining : 11
     * totalCalorie : 688
     * totalDuration : 179
     * currentCombo : 7
     * maxCombo : 7
     * totalEntries : 10
     */

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
        private int totalTrainingDay;
        private int totalTraining;
        private int totalCalorie;
        private int totalDuration;
        private int currentCombo;
        private int maxCombo;
        private int totalEntries;

        public int getTotalTrainingDay() {
            return totalTrainingDay;
        }

        public void setTotalTrainingDay(int totalTrainingDay) {
            this.totalTrainingDay = totalTrainingDay;
        }

        public int getTotalTraining() {
            return totalTraining;
        }

        public void setTotalTraining(int totalTraining) {
            this.totalTraining = totalTraining;
        }

        public int getTotalCalorie() {
            return totalCalorie;
        }

        public void setTotalCalorie(int totalCalorie) {
            this.totalCalorie = totalCalorie;
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(int totalDuration) {
            this.totalDuration = totalDuration;
        }

        public int getCurrentCombo() {
            return currentCombo;
        }

        public void setCurrentCombo(int currentCombo) {
            this.currentCombo = currentCombo;
        }

        public int getMaxCombo() {
            return maxCombo;
        }

        public void setMaxCombo(int maxCombo) {
            this.maxCombo = maxCombo;
        }

        public int getTotalEntries() {
            return totalEntries;
        }

        public void setTotalEntries(int totalEntries) {
            this.totalEntries = totalEntries;
        }
    }
}
