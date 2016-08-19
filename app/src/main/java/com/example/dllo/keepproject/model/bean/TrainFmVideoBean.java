package com.example.dllo.keepproject.model.bean;

import java.util.List;

/**
 * Created by dllo on 16/8/18.
 * 训练视频type0 数据类
 */
public class TrainFmVideoBean {



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
        private int days;
        private String description;
        private String detail;
        private int cmsOrder;
        private int stateValue;
        private int pioneer;
        private int calorie;
        private int averageDuration;
        private int status;
        private int difficulty;
        private String picture;


        private List<WorkoutsBean> workouts;
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

        public int getDays() {
            return days;
        }

        public void setDays(int days) {
            this.days = days;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public int getPioneer() {
            return pioneer;
        }

        public void setPioneer(int pioneer) {
            this.pioneer = pioneer;
        }

        public int getCalorie() {
            return calorie;
        }

        public void setCalorie(int calorie) {
            this.calorie = calorie;
        }

        public int getAverageDuration() {
            return averageDuration;
        }

        public void setAverageDuration(int averageDuration) {
            this.averageDuration = averageDuration;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public List<WorkoutsBean> getWorkouts() {
            return workouts;
        }

        public void setWorkouts(List<WorkoutsBean> workouts) {
            this.workouts = workouts;
        }

        public List<?> getDetailEquipments() {
            return detailEquipments;
        }

        public void setDetailEquipments(List<?> detailEquipments) {
            this.detailEquipments = detailEquipments;
        }

        public static class WorkoutsBean {
            private String _id;
            private String modified;
            private String name;
            private int duration;
            private int difficulty;
            private int calorie;
            private int stateValue;
            private boolean primary;
            private int uniqueFinished;
            private int totalFinished;
            private int pioneer;
            private int status;
            private int order;
            private String gender;
            /**
             * size : 579608
             * crc32 : 2578564257
             * url : http://dn-keep.qbox.me/commentary/54f429113419916320da0331.zip
             */

            private AudioPacketBean audioPacket;
            private String type;
            /**
             * url : http://static1.gotokeep.com/54f429113419916320da0331_2016061218_male_workoutPacket.zip
             * size : 2617132
             * hash : FpyOK0-OG9KpZsi_gNkiUTKvWyjk
             */

            private WorkoutPacketBean workoutPacket;
            private List<String> moods;
            private List<?> infoVideos;


            private List<StepsBean> steps;


            private List<SectionsBean> sections;
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

            public String getModified() {
                return modified;
            }

            public void setModified(String modified) {
                this.modified = modified;
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

            public int getDifficulty() {
                return difficulty;
            }

            public void setDifficulty(int difficulty) {
                this.difficulty = difficulty;
            }

            public int getCalorie() {
                return calorie;
            }

            public void setCalorie(int calorie) {
                this.calorie = calorie;
            }

            public int getStateValue() {
                return stateValue;
            }

            public void setStateValue(int stateValue) {
                this.stateValue = stateValue;
            }

            public boolean isPrimary() {
                return primary;
            }

            public void setPrimary(boolean primary) {
                this.primary = primary;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public WorkoutPacketBean getWorkoutPacket() {
                return workoutPacket;
            }

            public void setWorkoutPacket(WorkoutPacketBean workoutPacket) {
                this.workoutPacket = workoutPacket;
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

            public static class WorkoutPacketBean {
                private String url;
                private int size;
                private String hash;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }
            }

            public static class StepsBean {
                private int gap;


                private ExerciseBean exercise;
                private int mpergroup;
                private int mgroup;
                private int fpergroup;
                private int fgroup;
                private String _id;
                private boolean videoCover;
                private boolean isBurnCalorie;
                private float fduration;
                private float mduration;
                private String type;
                private String unit;
                private String name;
                private List<?> units;


                private List<CommentaryGapBean> commentaryGap;


                private List<CommentaryTrainingBean> commentaryTraining;

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

                public int getMpergroup() {
                    return mpergroup;
                }

                public void setMpergroup(int mpergroup) {
                    this.mpergroup = mpergroup;
                }

                public int getMgroup() {
                    return mgroup;
                }

                public void setMgroup(int mgroup) {
                    this.mgroup = mgroup;
                }

                public int getFpergroup() {
                    return fpergroup;
                }

                public void setFpergroup(int fpergroup) {
                    this.fpergroup = fpergroup;
                }

                public int getFgroup() {
                    return fgroup;
                }

                public void setFgroup(int fgroup) {
                    this.fgroup = fgroup;
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

                public float getFduration() {
                    return fduration;
                }

                public void setFduration(float fduration) {
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
                     * _id : 54826e417fb786000069ad59
                     * name : 无器械
                     * units : []
                     * created : 2014-12-06T02:47:29.000Z
                     * id : 54826e417fb786000069ad59
                     */

                    private EquipmentBean equipment;
                    private String description;
                    private String audio;
                    /**
                     * _id : 54826e417fb786000069ad98
                     * name : 上腹部
                     * created : 2014-12-06T02:47:29.000Z
                     * id : 54826e417fb786000069ad98
                     */

                    private TrainingpointBean trainingpoint;
                    private String created_by;
                    private int status;
                    private int __v;
                    private String audioCrc32;
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

                    public String getAudio() {
                        return audio;
                    }

                    public void setAudio(String audio) {
                        this.audio = audio;
                    }

                    public TrainingpointBean getTrainingpoint() {
                        return trainingpoint;
                    }

                    public void setTrainingpoint(TrainingpointBean trainingpoint) {
                        this.trainingpoint = trainingpoint;
                    }

                    public String getCreated_by() {
                        return created_by;
                    }

                    public void setCreated_by(String created_by) {
                        this.created_by = created_by;
                    }

                    public int getStatus() {
                        return status;
                    }

                    public void setStatus(int status) {
                        this.status = status;
                    }

                    public int get__v() {
                        return __v;
                    }

                    public void set__v(int __v) {
                        this.__v = __v;
                    }

                    public String getAudioCrc32() {
                        return audioCrc32;
                    }

                    public void setAudioCrc32(String audioCrc32) {
                        this.audioCrc32 = audioCrc32;
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

                    public static class VideosBean {
                        private String name;
                        private String url;
                        private String crc32;
                        private int videosize;
                        private String _id;
                        private String updated_at;
                        private String created_at;
                        private String thumbnail;
                        private String gender;
                        private double videotime;
                        private int videolength;

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
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

                        public int getVideosize() {
                            return videosize;
                        }

                        public void setVideosize(int videosize) {
                            this.videosize = videosize;
                        }

                        public String get_id() {
                            return _id;
                        }

                        public void set_id(String _id) {
                            this._id = _id;
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

                        public double getVideotime() {
                            return videotime;
                        }

                        public void setVideotime(double videotime) {
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
                         * _id : 5627049f661a94266854a4b1
                         * x : 0.43
                         * y : 0.52
                         * tip : 手臂伸直
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
                        private float time;
                        private String id;
                        private String _id;

                        public float getTime() {
                            return time;
                        }

                        public void setTime(float time) {
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

                public static class CommentaryTrainingBean {
                    private String _id;
                    private String gender;
                    /**
                     * time : 5.3
                     * id : C215.mp3
                     * _id : 564c268d5c31b0b296788ecf
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
                private String _id;
                private String name;
                private List<String> subSteps;

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
}
