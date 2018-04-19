package com.shuwen.mvpdemo.login2.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.shuwen.mvpdemo.R;
import com.shuwen.mvpdemo.login2.base.BaseActivity;
import com.shuwen.mvpdemo.login2.model.UserInfo;
import com.shuwen.mvpdemo.login2.presenter.LoginPresenter;

public class LoginActivity3 extends Activity implements View.OnClickListener, ILoginView {

    private EditText mUserName;
    private EditText mPwd;
    private Button mLogin;
    private Button mRegister;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mPresenter = new LoginPresenter(LoginActivity3.this);
        mPresenter.attachView(this);
    }

    private void initView() {
        mUserName = findViewById(R.id.et_user_name);
        mPwd = findViewById(R.id.et_pwd);
        mLogin = findViewById(R.id.btn_login);
        mLogin.setOnClickListener(this);
        mRegister = findViewById(R.id.btn_regist);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                login(mUserName.getText().toString(), mPwd.getText().toString());
                break;
                default:
                    break;
        }
    }

    private void login(String userName, String pwd) {
        //一些UI界面处理，比如进度条、弹框等.............
        //.........
        mPresenter.login(userName, pwd);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    public void LoginSuccess(UserInfo userInfo) {
        //做一些UI的更新操作。。。。。。
        //..........
        Toast.makeText(LoginActivity3.this, "登录成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void LoginFail(String err) {
        //做一些UI的更新操作。。。。。。
        //..........
        Toast.makeText(LoginActivity3.this, "登录失败：" + err, Toast.LENGTH_LONG).show();
    }


    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showErr() {

    }
}
