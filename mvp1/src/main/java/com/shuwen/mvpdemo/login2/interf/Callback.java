package com.shuwen.mvpdemo.login2.interf;

/**
 * Created by ruanchao on 2018/6/14.
 */

public interface Callback<T> {
    void onSuccess(T result);
    void onFail(Exception e);
}
