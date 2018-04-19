package com.shuwen.mvpdemo.login.model;

import com.shuwen.mvpdemo.login.connect.HttpMethods;

import java.util.Map;

import okhttp3.Callback;


/**
 * Created by ruanchao on 2018/4/19.
 */

public class LoginModel {

    public void regist(String url, Map<String, String> params, Callback callback) {
        HttpMethods.getInstance().post(url, params, callback);
    }

    public void login(String url, Map<String, String> params, Callback callback) {
        HttpMethods.getInstance().post(url, params, callback);
    }
}
