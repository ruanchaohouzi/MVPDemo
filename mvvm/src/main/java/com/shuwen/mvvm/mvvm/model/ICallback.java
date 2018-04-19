package com.shuwen.mvvm.mvvm.model;

/**
 * Created by ruanchao on 2018/4/19.
 */

public interface ICallback<T> {

    void onSuccess(T data);

    void onFailure(String msg);

    void onComplete();
}
