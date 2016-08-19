package com.example.dllo.keepproject.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/18.
 * 训练视频type1数据类
 */
public class TrainFmVideoTypeTwoBean {


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
        private String _id;
        private String name;
        private int difficulty;
        private int duration;
        private int calorie;
        private String created_by;
        private int __v;
        private String description;
        private String picture;
        private String publishDate;
        private String detail;
        private int cmsOrder;
        private int stateValue;
        private String state;
        /**
         * hash : FjjiJqyzucz5ciH8r5Y3x1fN86nC
         * size : 2663827
         * url : http://static1.gotokeep.com/54afa35c35fb7f5912e3c6de_2016061217_male_workoutPacket.zip
         */

        private WorkoutPacketBean workoutPacket;
        private String type;
        private boolean primary;
        private String modified;
        private int uniqueFinished;
        private int totalFinished;
        private int pioneer;
        private int status;
        private int order;
        private String gender;
        /**
         * size : 280628
         * crc32 : 3656546519
         * url : http://dn-keep.qbox.me/commentary/54afa35c35fb7f5912e3c6de.zip
         */

        private AudioPacketBean audioPacket;
        private String created;
        private String id;
        private List<?> comments;
        private List<String> hashtags;
        private List<String> courseType;
        private List<String> moods;
        private List<?> infoVideos;
        private List<?> tags;

        private List<StepsBean> steps;
        /**
         * name : 循环1-Circuit 1
         * _id : 560ceb011421f68101939667
         * subSteps : ["578deed255693a940cf285b8","578deed255693a940cf285b7","578deed255693a940cf285b6","578deed255693a940cf285b5","578deed255693a940cf285b4","578deed255693a940cf285b3"]
         */

        private List<SectionsBean> sections;
        private List<?> auditLogs;
        /**
         * _id : 54826e417fb786000069ad86
         * name : 腹部
         * created : 2014-12-06T02:47:29.000Z
         * id : 54826e417fb786000069ad86
         */

        private List<TrainingpointsBean> trainingpoints;
        /**
         * _id : 54826e417fb786000069ad59
         * name : 无器械
         * created : 2014-12-06T02:47:29.000Z
         * id : 54826e417fb786000069ad59
         */

        private List<EquipmentsBean> equipments;
        private List<Integer> goals;
        private List<?> detailEquipments;

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

        public String getCreated_by() {
            return created_by;
        }

        public void setCreated_by(String created_by) {
            this.created_by = created_by;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
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

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String publishDate) {
            this.publishDate = publishDate;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public int getCmsOrder() {
            return cmsOrder;
        }

        public void setCmsOrder(int cmsOrder) {
            this.cmsOrder = cmsOrder;
        }

        public int getStateValue() {
            return stateValue;
        }

        public void setStateValue(int stateValue) {
            this.stateValue = stateValue;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public WorkoutPacketBean getWorkoutPacket() {
            return workoutPacket;
        }

        public void setWorkoutPacket(WorkoutPacketBean workoutPacket) {
            this.workoutPacket = workoutPacket;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isPrimary() {
            return primary;
        }

        public void setPrimary(boolean primary) {
            this.primary = primary;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public int getUniqueFinished() {
            return uniqueFinished;
        }

        public void setUniqueFinished(int uniqueFinished) {
            this.uniqueFinished = uniqueFinished;
        }

        public int getTotalFinished() {
            return totalFinished;
        }

        public void setTotalFinished(int totalFinished) {
            this.totalFinished = totalFinished;
        }

        public int getPioneer() {
            return pioneer;
        }

        public void setPioneer(int pioneer) {
            this.pioneer = pioneer;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public AudioPacketBean getAudioPacket() {
            return audioPacket;
        }

        public void setAudioPacket(AudioPacketBean audioPacket) {
            this.audioPacket = audioPacket;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<?> getComments() {
            return comments;
        }

        public void setComments(List<?> comments) {
            this.comments = comments;
        }

        public List<String> getHashtags() {
            return hashtags;
        }

        public void setHashtags(List<String> hashtags) {
            this.hashtags = hashtags;
        }

        public List<String> getCourseType() {
            return courseType;
        }

        public void setCourseType(List<String> courseType) {
            this.courseType = courseType;
        }

        public List<String> getMoods() {
            return moods;
        }

        public void setMoods(List<String> moods) {
            this.moods = moods;
        }

        public List<?> getInfoVideos() {
            return infoVideos;
        }

        public void setInfoVideos(List<?> infoVideos) {
            this.infoVideos = infoVideos;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public List<StepsBean> getSteps() {
            return steps;
        }

        public void setSteps(List<StepsBean> steps) {
            this.steps = steps;
        }

        public List<SectionsBean> getSections() {
            return sections;
        }

        public void setSections(List<SectionsBean> sections) {
            this.sections = sections;
        }

        public List<?> getAuditLogs() {
            return auditLogs;
        }

        public void setAuditLogs(List<?> auditLogs) {
            this.auditLogs = auditLogs;
        }

        public List<TrainingpointsBean> getTrainingpoints() {
            return trainingpoints;
        }

        public void setTrainingpoints(List<TrainingpointsBean> trainingpoints) {
            this.trainingpoints = trainingpoints;
        }

        public List<EquipmentsBean> getEquipments() {
            return equipments;
        }

        public void setEquipments(List<EquipmentsBean> equipments) {
            this.equipments = equipments;
        }

        public List<Integer> getGoals() {
            return goals;
        }

        public void setGoals(List<Integer> goals) {
            this.goals = goals;
        }

        public List<?> getDetailEquipments() {
            return detailEquipments;
        }

        public void setDetailEquipments(List<?> detailEquipments) {
            this.detailEquipments = detailEquipments;
        }

        public static class WorkoutPacketBean {
            private String hash;
            private int size;
            private String url;

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class AudioPacketBean {
            private int size;
            private String crc32;
            private String url;

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public String getCrc32() {
                return crc32;
            }

            public void setCrc32(String crc32) {
                this.crc32 = crc32;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class StepsBean {
            private int fgroup;
            private int fpergroup;
            private int gap;

            private ExerciseBean exercise;
            private int mgroup;
            private int mpergroup;
            private String _id;
            private boolean videoCover;
            private boolean isBurnCalorie;
            private double fduration;
            private float mduration;
            private String type;
            private String unit;
            private String name;
            private List<?> units;
            /**
             * _id : 564ae8a75c31b0b296788c88
             * gender : m
             * sets : []
             */

            private List<CommentaryGapBean> commentaryGap;
            /**
             * _id : 564ae8a75c31b0b296788c8a
             * gender : m
             * sets : [{"time":6.1,"id":"C126.mp3","_id":"564ae8a75c31b0b296788c91"},{"time":19.6,"id":"C022.mp3","_id":"564ae8a75c31b0b296788c8f"},{"time":43.1,"id":"C215.mp3","_id":"564ae8a75c31b0b296788c8c"},{"time":59,"id":"C258.mp3","_id":"564ae8a75c31b0b296788c8b"}]
             */

            private List<CommentaryTrainingBean> commentaryTraining;

            public float getFgroup() {
                return fgroup;
            }

            public void setFgroup(int fgroup) {
                this.fgroup = fgroup;
            }

            public int getFpergroup() {
                return fpergroup;
            }

            public void setFpergroup(int fpergroup) {
                this.fpergroup = fpergroup;
            }

            public int getGap() {
                return gap;
            }

            public void setGap(int gap) {
                this.gap = gap;
            }

            public ExerciseBean getExercise() {
                return exercise;
            }

            public void setExercise(ExerciseBean exercise) {
                this.exercise = exercise;
            }

            public int getMgroup() {
                return mgroup;
            }

            public void setMgroup(int mgroup) {
                this.mgroup = mgroup;
            }

            public int getMpergroup() {
                return mpergroup;
            }

            public void setMpergroup(int mpergroup) {
                this.mpergroup = mpergroup;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public boolean isVideoCover() {
                return videoCover;
            }

            public void setVideoCover(boolean videoCover) {
                this.videoCover = videoCover;
            }

            public boolean isIsBurnCalorie() {
                return isBurnCalorie;
            }

            public void setIsBurnCalorie(boolean isBurnCalorie) {
                this.isBurnCalorie = isBurnCalorie;
            }

            public double getFduration() {
                return fduration;
            }

            public void setFduration(double fduration) {
                this.fduration = fduration;
            }

            public float getMduration() {
                return mduration;
            }

            public void setMduration(float mduration) {
                this.mduration = mduration;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<?> getUnits() {
                return units;
            }

            public void setUnits(List<?> units) {
                this.units = units;
            }

            public List<CommentaryGapBean> getCommentaryGap() {
                return commentaryGap;
            }

            public void setCommentaryGap(List<CommentaryGapBean> commentaryGap) {
                this.commentaryGap = commentaryGap;
            }

            public List<CommentaryTrainingBean> getCommentaryTraining() {
                return commentaryTraining;
            }

            public void setCommentaryTraining(List<CommentaryTrainingBean> commentaryTraining) {
                this.commentaryTraining = commentaryTraining;
            }

            public static class ExerciseBean {
                private String _id;
                private String name;
                /**
                 * _id : 54826e417fb786000069ad98
                 * name : 上腹部
                 * created : 2014-12-06T02:47:29.000Z
                 * id : 54826e417fb786000069ad98
                 */

                private TrainingpointBean trainingpoint;
                /**
                 * _id : 54826e417fb786000069ad59
                 * name : 无器械
                 * units : []
                 * created : 2014-12-06T02:47:29.000Z
                 * id : 54826e417fb786000069ad59
                 */

                private EquipmentBean equipment;
                private String description;
                private String created_by;
                private int __v;
                private String audio;
                private String audioCrc32;
                private int stateValue;
                private String modified;
                private int version;
                private String code;
                private int difficulty;
                private String created;
                private String id;
                private List<?> explainVideos;

                private List<VideosBean> videos;

                private List<CoversBean> covers;
                private List<?> audios;
                private List<String> minorTrainingPoints;
                private List<String> majorTrainingPoints;

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

                public TrainingpointBean getTrainingpoint() {
                    return trainingpoint;
                }

                public void setTrainingpoint(TrainingpointBean trainingpoint) {
                    this.trainingpoint = trainingpoint;
                }

                public EquipmentBean getEquipment() {
                    return equipment;
                }

                public void setEquipment(EquipmentBean equipment) {
                    this.equipment = equipment;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getCreated_by() {
                    return created_by;
                }

                public void setCreated_by(String created_by) {
                    this.created_by = created_by;
                }

                public int get__v() {
                    return __v;
                }

                public void set__v(int __v) {
                    this.__v = __v;
                }

                public String getAudio() {
                    return audio;
                }

                public void setAudio(String audio) {
                    this.audio = audio;
                }

                public String getAudioCrc32() {
                    return audioCrc32;
                }

                public void setAudioCrc32(String audioCrc32) {
                    this.audioCrc32 = audioCrc32;
                }

                public int getStateValue() {
                    return stateValue;
                }

                public void setStateValue(int stateValue) {
                    this.stateValue = stateValue;
                }

                public String getModified() {
                    return modified;
                }

                public void setModified(String modified) {
                    this.modified = modified;
                }

                public int getVersion() {
                    return version;
                }

                public void setVersion(int version) {
                    this.version = version;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public int getDifficulty() {
                    return difficulty;
                }

                public void setDifficulty(int difficulty) {
                    this.difficulty = difficulty;
                }

                public String getCreated() {
                    return created;
                }

                public void setCreated(String created) {
                    this.created = created;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public List<?> getExplainVideos() {
                    return explainVideos;
                }

                public void setExplainVideos(List<?> explainVideos) {
                    this.explainVideos = explainVideos;
                }

                public List<VideosBean> getVideos() {
                    return videos;
                }

                public void setVideos(List<VideosBean> videos) {
                    this.videos = videos;
                }

                public List<CoversBean> getCovers() {
                    return covers;
                }

                public void setCovers(List<CoversBean> covers) {
                    this.covers = covers;
                }

                public List<?> getAudios() {
                    return audios;
                }

                public void setAudios(List<?> audios) {
                    this.audios = audios;
                }

                public List<String> getMinorTrainingPoints() {
                    return minorTrainingPoints;
                }

                public void setMinorTrainingPoints(List<String> minorTrainingPoints) {
                    this.minorTrainingPoints = minorTrainingPoints;
                }

                public List<String> getMajorTrainingPoints() {
                    return majorTrainingPoints;
                }

                public void setMajorTrainingPoints(List<String> majorTrainingPoints) {
                    this.majorTrainingPoints = majorTrainingPoints;
                }

                public static class TrainingpointBean {
                    private String _id;
                    private String name;
                    private String created;
                    private String id;

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

                    public String getCreated() {
                        return created;
                    }

                    public void setCreated(String created) {
                        this.created = created;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }
                }

                public static class EquipmentBean {
                    private String _id;
                    private String name;
                    private String created;
                    private String id;
                    private List<?> units;

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

                    public String getCreated() {
                        return created;
                    }

                    public void setCreated(String created) {
                        this.created = created;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public List<?> getUnits() {
                        return units;
                    }

                    public void setUnits(List<?> units) {
                        this.units = units;
                    }
                }

                public static class VideosBean {
                    private String _id;
                    private String name;
                    private int videosize;
                    private String url;
                    private String crc32;
                    private String updated_at;
                    private String created_at;
                    private String thumbnail;
                    private String gender;
                    private float videotime;
                    private int videolength;

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

                    public int getVideosize() {
                        return videosize;
                    }

                    public void setVideosize(int videosize) {
                        this.videosize = videosize;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getCrc32() {
                        return crc32;
                    }

                    public void setCrc32(String crc32) {
                        this.crc32 = crc32;
                    }

                    public String getUpdated_at() {
                        return updated_at;
                    }

                    public void setUpdated_at(String updated_at) {
                        this.updated_at = updated_at;
                    }

                    public String getCreated_at() {
                        return created_at;
                    }

                    public void setCreated_at(String created_at) {
                        this.created_at = created_at;
                    }

                    public String getThumbnail() {
                        return thumbnail;
                    }

                    public void setThumbnail(String thumbnail) {
                        this.thumbnail = thumbnail;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public float getVideotime() {
                        return videotime;
                    }

                    public void setVideotime(float videotime) {
                        this.videotime = videotime;
                    }

                    public int getVideolength() {
                        return videolength;
                    }

                    public void setVideolength(int videolength) {
                        this.videolength = videolength;
                    }
                }

                public static class CoversBean {
                    private String _id;
                    private String url;
                    private String gender;
                    /**
                     * _id : 56090e6a5ec8e896cdeaebcd
                     * x : 0.33
                     * y : 0.33
                     * tip : 双手垂直上举
                     */

                    private List<CoordinatesBean> coordinates;

                    public String get_id() {
                        return _id;
                    }

                    public void set_id(String _id) {
                        this._id = _id;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public List<CoordinatesBean> getCoordinates() {
                        return coordinates;
                    }

                    public void setCoordinates(List<CoordinatesBean> coordinates) {
                        this.coordinates = coordinates;
                    }

                    public static class CoordinatesBean {
                        private String _id;
                        private double x;
                        private double y;
                        private String tip;

                        public String get_id() {
                            return _id;
                        }

                        public void set_id(String _id) {
                            this._id = _id;
                        }

                        public double getX() {
                            return x;
                        }

                        public void setX(double x) {
                            this.x = x;
                        }

                        public double getY() {
                            return y;
                        }

                        public void setY(double y) {
                            this.y = y;
                        }

                        public String getTip() {
                            return tip;
                        }

                        public void setTip(String tip) {
                            this.tip = tip;
                        }
                    }
                }
            }

            public static class CommentaryGapBean {
                private String _id;
                private String gender;
                private List<?> sets;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public List<?> getSets() {
                    return sets;
                }

                public void setSets(List<?> sets) {
                    this.sets = sets;
                }
            }

            public static class CommentaryTrainingBean {
                private String _id;
                private String gender;
                /**
                 * time : 6.1
                 * id : C126.mp3
                 * _id : 564ae8a75c31b0b296788c91
                 */

                private List<SetsBean> sets;

                public String get_id() {
                    return _id;
                }

                public void set_id(String _id) {
                    this._id = _id;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public List<SetsBean> getSets() {
                    return sets;
                }

                public void setSets(List<SetsBean> sets) {
                    this.sets = sets;
                }

                public static class SetsBean {
                    private double time;
                    private String id;
                    private String _id;

                    public double getTime() {
                        return time;
                    }

                    public void setTime(double time) {
                        this.time = time;
                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String get_id() {
                        return _id;
                    }

                    public void set_id(String _id) {
                        this._id = _id;
                    }
                }
            }
        }

        public static class SectionsBean {
            private String name;
            private String _id;
            private List<String> subSteps;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public List<String> getSubSteps() {
                return subSteps;
            }

            public void setSubSteps(List<String> subSteps) {
                this.subSteps = subSteps;
            }
        }

        public static class TrainingpointsBean {
            private String _id;
            private String name;
            private String created;
            private String id;

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

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class EquipmentsBean {
            private String _id;
            private String name;
            private String created;
            private String id;

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

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
