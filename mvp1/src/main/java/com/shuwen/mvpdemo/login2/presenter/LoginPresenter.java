package com.shuwen.mvpdemo.login2.presenter;

import android.content.Context;

import com.shuwen.mvpdemo.login2.base.BasePresenter;
import com.shuwen.mvpdemo.login2.interf.Callback;
import com.shuwen.mvpdemo.login2.model.LoginModel;
import com.shuwen.mvpdemo.login2.model.UserInfo;
import com.shuwen.mvpdemo.login2.view.ILoginView;

import java.util.HashMap;

import io.reactivex.observers.DisposableObserver;

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
                    viewRef.get().loginSuccess(result);
                }
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }

    /**
     * 采取Rxjava retrofit架构
     * @param userId
     */
    public void getUserInfo(final String userId){

        addSubscription(mLoginModel.getUserInfo(userId), new DisposableObserver<UserInfo>() {
            @Override
            public void onNext(UserInfo userInfo) {
                viewRef.get().onUserInfoSuccess(userInfo);
            }

            @Override
            public void onError(Throwable e) {
                viewRef.get().onUserInfoErr();
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
