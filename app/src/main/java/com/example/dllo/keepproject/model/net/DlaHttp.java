package com.example.dllo.keepproject.model.net;

import java.util.Map;

/**
 * Created by dllo on 16/8/12.
 */
public class DlaHttp implements DlaNetwork {

    //***********************************
    // 静态内部类形式的单例
    private static final class SingletonHolder {
        private static final DlaHttp INSTANCE = new DlaHttp();
    }

    // 静态内部类形式的单例
    public static DlaHttp getInstance() {
        return SingletonHolder.INSTANCE;
    }
    //*************************************

    // 重新声明一个借口类型的对象
    private DlaNetwork tool;

//    private OkHttpClient mClient;
//    // 这样初始化的Handler,无论在哪个线程new的,他都属于主线程
//    private Handler mHandler = new Handler(Looper.getMainLooper());
//
//    private Gson mGson;

    private DlaHttp() {
        tool = new OkHttpImpl();
//        // 初始化gson
//        mGson = new Gson();
//
//        // 获取sd卡目录
//        File cacheDir = Environment.getExternalStorageDirectory();
//        mClient = new OkHttpClient.Builder()
//                // 设置网络请求的缓存目录
//                .cache(new Cache(cacheDir, 10 * 1024 * 1024))
//                // 连接超时时间
//                .connectTimeout(5, TimeUnit.SECONDS)
//                .build();
    }

    public void startRequest(String url, final OnHttpCallback<String> callback) {
        tool.startRequest(url, callback);
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        mClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, final IOException e) {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callback.onError(e);
//                    }
//                });
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                final String resultStr = response.body().string();
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callback.onSuccess(resultStr);
//                    }
//                });
//            }
//        });
    }

    public <T> void startRequest(String url, final Class<T> clazz, final OnHttpCallback<T> callback) {
        tool.startRequest(url, clazz, callback);
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        mClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, final IOException e) {
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callback.onError(e);
//                    }
//                });
//            }
//
//            @Override
//            public void onResponse(Call call, final Response response) throws IOException {
//                final String resultStr = response.body().string();
//                // 解析
//                final T resultEntity = mGson.fromJson(resultStr,clazz);
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        callback.onSuccess(resultEntity);
//                    }
//                });
//            }
//        });
    }

    @Override
    public <T> void startRequest(String url, Class<T> clazz, Map<String, String> headMap, OnHttpCallback<T> callback) {
        tool.startRequest(url,clazz,headMap,callback);
    }
}
