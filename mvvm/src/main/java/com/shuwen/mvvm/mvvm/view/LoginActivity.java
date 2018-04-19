package com.shuwen.mvvm.mvvm.view;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shuwen.mvvm.R;
import com.shuwen.mvvm.databinding.ActivityLoginBinding;
import com.shuwen.mvvm.mvvm.viewmodel.UserViewModel;


public class LoginActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();
    private UserViewModel mUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mUserViewModel = new UserViewModel(this, activityLoginBinding);
        initView();
    }

    private void initView() {
        /**
         * 制作UI界面部分的操作，不涉及数据的操作
         */
    }
}
