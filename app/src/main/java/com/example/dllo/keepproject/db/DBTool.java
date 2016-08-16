package com.example.dllo.keepproject.db;

import com.example.dllo.keepproject.ui.app.MyApp;
import com.litesuits.orm.LiteOrm;

import java.util.List;

/**
 * Created by dllo on 16/8/15.
 * 数据库工具类 - liteOrm
 */
public class DBTool {

    public static String DB_NAME;
    public static LiteOrm liteOrm;
    // 定义一个当前类的静态对象
    private static DBTool instance;

    // 私有化构造方法
    private DBTool() {
        _createDb();
    }


    // 对外提供一个获得对象的方法
    public static DBTool getInstance() {
        if (instance == null) {
            synchronized (DBTool.class) {
                if (instance == null) {
                    instance = new DBTool();
                }
            }
        }
        return instance;
    }


    /**
     * 内部创建数据库方法
     */
    private  void _createDb() {
        DB_NAME = "keep.db";
        liteOrm = LiteOrm.newCascadeInstance(MyApp.getContext(), DB_NAME);
        liteOrm.setDebugged(true);
    }

    /**
     * 对内提供添加单条数据的方法
     *
     * @param bean
     * @param <T>
     */
    private  <T> void _insertData(T bean) {
        liteOrm.save(bean);
    }

    /**
     * 对外提供添加单条数据的方法
     *
     * @param bean
     * @param <T>
     */
    public  <T> void insertData(T bean) {
        _insertData(bean);
    }

    /**
     * 对内提供添加集合数据的方法
     *
     * @param list
     * @param <T>
     */
    private  <T> void _insertDataList(List<T> list) {
        liteOrm.save(list);
    }

    /**
     * 对外提供添加集合数据的方法
     *
     * @param list
     * @param <T>
     */
    public  <T> void insertDataList(List<T> list) {
        _insertDataList(list);
    }

    /**
     * 对内提供查询所有的方法
     *
     * @param tClass
     * @param <T>
     */
    private  <T> List<T> _getQueryAll(Class<T> tClass) {
        return liteOrm.query(tClass);
    }

    /**
     * 对外提供的查询所有的方法 返回的是一个List
     *
     * @param tClass
     * @param <T>
     * @return
     */
    public  <T> List<T> getQueryAll(Class<T> tClass) {
        return _getQueryAll(tClass);
    }

    /**
     * 对内提供删除所有的方法
     *
     * @param tClass
     * @param <T>
     */
    private <T> void _deleteDataAll(Class<T> tClass) {
        liteOrm.deleteAll(tClass);
    }

    /**
     * 对外提供的删除所有的方法
     * @param tClass 参数是一个类
     * @param <T>
     */
    public  <T> void deleteDataAll(Class<T> tClass) {
        _deleteDataAll(tClass);
    }
}
