package com.shuwen.mvpdemo.login2.presenter;

import android.content.Context;

import com.shuwen.mvpdemo.login2.base.BasePresenter;
import com.shuwen.mvpdemo.login2.interf.Callback;
import com.shuwen.mvpdemo.login2.model.LoginModel;
import com.shuwen.mvpdemo.login2.model.UserInfo;
import com.shuwen.mvpdemo.login2.view.ILoginView;

import java.io.IOException;
import java.util.HashMap;

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

        mLoginModel.login("url", hashMap, new Callback<UserInfo>() {
            @Override
            public void onSuccess(UserInfo result) {
                if (isViewAttached()){

                    viewRef.get().LoginSuccess(result);
                }
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
