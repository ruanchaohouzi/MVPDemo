package com.shuwen.mvpdemo.login.view;

import com.shuwen.mvpdemo.login.model.UserInfo;

/**
 * Created by ruanchao on 2018/4/19.
 */

public interface ILoginView {

    void LoginSuccess(String userInfo);

    void LoginFail(String err);
}
