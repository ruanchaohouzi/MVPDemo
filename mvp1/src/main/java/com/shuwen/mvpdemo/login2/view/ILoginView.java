package com.shuwen.mvpdemo.login2.view;

import com.shuwen.mvpdemo.login2.base.IBaseView;
import com.shuwen.mvpdemo.login2.model.UserInfo;

/**
 * Created by ruanchao on 2018/4/19.
 */

public interface ILoginView extends IBaseView {

    void LoginSuccess(UserInfo userInfo);

    void LoginFail(String err);
}
