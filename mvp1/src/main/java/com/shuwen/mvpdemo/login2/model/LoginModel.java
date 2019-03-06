package com.shuwen.mvpdemo.login2.model;

import com.shuwen.mvpdemo.login2.connect.HttpClient;
import com.shuwen.mvpdemo.login2.interf.Callback;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by ruanchao on 2018/4/19.
 */

public class LoginModel {

    public void login(String url, Map<String, String> params, Callback callback) {
        UserInfo userInfo = new UserInfo("rc", "123");
        callback.onSuccess(userInfo);
    }

    public Observable<UserInfo> getUserInfo(String userId){
        return HttpClient.getInstance().getApiService().getUserInfo(userId);
    }
}
