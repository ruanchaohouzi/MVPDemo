package com.shuwen.mvpdemo.login2.connect;


import com.shuwen.mvpdemo.login2.model.UserInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {

    @GET("adat/sk/{userId}.html")
    Observable<UserInfo> getUserInfo(@Path("userId") String userId);
}
