package com.example.dllo.keepproject.model.net;

/**
 * Created by dllo on 16/8/12.
 */
public interface OnHttpCallback<T> {
    // 返回范型
    void onSuccess(T response);
    // 返回异常父类
    void onError(Throwable ex);
}
