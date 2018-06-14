package com.shuwen.mvpdemo.login2.model;

import com.shuwen.mvpdemo.login2.connect.HttpMethods;
import com.shuwen.mvpdemo.login2.interf.Callback;

import java.util.Map;

/**
 * Created by ruanchao on 2018/4/19.
 */

public class LoginModel {

    public void regist(String url, Map<String, String> params, Callback callback) {
        //....
        UserInfo userInfo = new UserInfo("rc", "123");
        callback.onSuccess(userInfo);
    }

    public void login(String url, Map<String, String> params, Callback callback) {
        UserInfo userInfo = new UserInfo("rc", "123");
        callback.onSuccess(userInfo);
    }
}
