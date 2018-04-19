package com.shuwen.mvpdemo.login2.presenter;

import android.content.Context;

import com.shuwen.mvpdemo.login2.base.BasePresenter;
import com.shuwen.mvpdemo.login2.model.LoginModel;
import com.shuwen.mvpdemo.login2.model.UserInfo;
import com.shuwen.mvpdemo.login2.view.ILoginView;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by ruanchao on 2018/4/19.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {

    private Context mContext;
    private LoginModel mLoginModel;

    public LoginPresenter(Context context) {
        super();
        mContext = context;
        mLoginModel = new LoginModel();
    }

    public void login(String userName, String pwd) {
        HashMap hashMap = new HashMap();
        hashMap.put("userName", userName);
        hashMap.put("pwd", pwd);

        mLoginModel.login("url", hashMap, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (isViewAttached()) {
                    mView.LoginFail("登录超时");
                }
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String body = response.body().string();
                //json解析、数据处理。。。。。。。。
                //。。。。。

                UserInfo userInfo= new UserInfo("rc", "123456");
                if (isViewAttached()) {
                    mView.LoginSuccess(userInfo);
                }
            }
        });
    }
}
