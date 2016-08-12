package com.example.dllo.keepproject.model.net;

import java.util.Map;

/**
 * Created by dllo on 16/8/12.
 */
public interface DlaNetwork {
    void startRequest(String url, OnHttpCallback<String> callback);
    <T> void startRequest(String url, Class<T> clazz, OnHttpCallback<T> callback);
    <T> void startRequest(String url, Class<T> clazz, Map<String, String> headMap, OnHttpCallback<T> callback);
}
