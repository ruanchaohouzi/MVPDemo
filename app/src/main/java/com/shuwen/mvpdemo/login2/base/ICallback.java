package com.shuwen.mvpdemo.login2.base;

/**
 * Created by ruanchao on 2018/4/19.
 */

public interface ICallback<T> {

    void onSuccess(T data);

    void onFailure(String msg);

    void onComplete();
}
