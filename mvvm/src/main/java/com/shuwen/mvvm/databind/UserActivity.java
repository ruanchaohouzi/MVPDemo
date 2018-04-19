package com.shuwen.mvvm.databind;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuwen.mvvm.R;
import com.shuwen.mvvm.databinding.ActivityUserBinding;
import com.shuwen.mvvm.mvvm.bean.UserInfo;

public class UserActivity extends AppCompatActivity {

    UserInfo mUserInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_user);

        ActivityUserBinding userBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);
        mUserInfo = new UserInfo();
        userBinding.setUser(mUserInfo);
        init();
    }

    private void init() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                    mUserInfo.name.set("侠客行");
                    mUserInfo.sex.set("不确定");
                    mUserInfo.age.set(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
