package com.shuwen.mvvm.mvvm.viewmodel;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.shuwen.mvvm.databinding.ActivityLoginBinding;
import com.shuwen.mvvm.mvvm.bean.UserInfo;
import com.shuwen.mvvm.mvvm.model.ICallback;
import com.shuwen.mvvm.mvvm.model.UserModel;


/**
 * Created by ruanchao on 2018/4/11.
 */

public class UserViewModel {

    public Activity mActivity;
    public ActivityLoginBinding mActivityLoginBinding;
    public UserInfo userInfo;
    private UserModel userModel;

    public UserViewModel(Activity activity, ActivityLoginBinding activityLoginBinding){
        mActivity = activity;
        mActivityLoginBinding = activityLoginBinding;
        userModel = new UserModel();
        init();
    }

    private void init() {
        userInfo = new UserInfo();
        mActivityLoginBinding.setUserViewModel(this);
    }

    public void commit(View view){

        final String userName = mActivityLoginBinding.name.getText().toString();
        final String pwd = mActivityLoginBinding.name.getText().toString();

        userModel.sendUserInfo(userName,pwd, new ICallback<String>() {
            @Override
            public void onSuccess(String data) {
                //数据解析操作。。。。。
                //............
                userInfo.name.set(userName);
                userInfo.pwd.set(pwd);
                userInfo.age.set(32);
                userInfo.sex.set("男");

            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
