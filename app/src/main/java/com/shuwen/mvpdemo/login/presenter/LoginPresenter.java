package com.shuwen.mvpdemo.login.presenter;

import android.content.Context;

import com.shuwen.mvpdemo.login.model.LoginModel;
import com.shuwen.mvpdemo.login.model.UserInfo;
import com.shuwen.mvpdemo.login.view.ILoginView;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ruanchao on 2018/4/19.
 */

public class LoginPresenter {

    private Context mContext;
    private ILoginView mView;
    private LoginModel mLoginModel;

    public LoginPresenter(Context context, ILoginView view) {
        mContext = context;
        mView = view;
        mLoginModel = new LoginModel();
    }

    public void login(String userName, String pwd) {
        HashMap hashMap = new HashMap();
        hashMap.put("userName", userName);
        hashMap.put("pwd", pwd);

        mLoginModel.login("url", hashMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mView.LoginFail("登录超时");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String body = response.body().string();
                //json解析、数据处理。。。。。。。。
                UserInfo userInfo= new UserInfo("rc", "123456");
                mView.LoginSuccess(userInfo);
            }
        });
    }
}
