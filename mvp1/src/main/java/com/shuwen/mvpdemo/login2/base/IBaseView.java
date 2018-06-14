package com.shuwen.mvpdemo.login2.base;

import android.content.Context;

/**
 * Created by ruanchao on 2018/4/19.
 */

public interface IBaseView {

    /**
     * 显示提示
     *
     * @param msg
     */
    void showToast(String msg);

    /**
     * 显示请求错误提示
     */
    void showErr();

}
