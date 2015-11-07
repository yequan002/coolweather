package com.example.apple.coolweather.util;

/**
 * Created by apple on 15/11/6.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
