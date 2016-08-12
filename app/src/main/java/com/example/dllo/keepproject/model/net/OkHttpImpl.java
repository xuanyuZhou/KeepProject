package com.example.dllo.keepproject.model.net;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by dllo on 16/8/12.
 */
public class OkHttpImpl implements DlaNetwork {

        private OkHttpClient mClient;
    // 这样初始化的Handler,无论在哪个线程new的,他都属于主线程
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private Gson mGson;

    OkHttpImpl() {
        // 初始化gson
        mGson = new Gson();

        // 获取sd卡目录
        File cacheDir = Environment.getExternalStorageDirectory();
        mClient = new OkHttpClient.Builder()
                // 设置网络请求的缓存目录
                .cache(new Cache(cacheDir, 10 * 1024 * 1024))
                // 连接超时时间
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public void startRequest(String url,final OnHttpCallback<String> callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String resultStr = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resultStr);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> clazz, final OnHttpCallback<T> callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String resultStr = response.body().string();
                // 解析
                final T resultEntity = mGson.fromJson(resultStr,clazz);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resultEntity);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> clazz, Map<String, String> headMap, final OnHttpCallback<T> callback) {
        Request request = new Request.Builder()
                .url(url)
                .headers(Headers.of(headMap))
                .build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String resultStr = response.body().string();
                // 解析
                final T resultEntity = mGson.fromJson(resultStr,clazz);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(resultEntity);
                    }
                });
            }
        });
    }
}
