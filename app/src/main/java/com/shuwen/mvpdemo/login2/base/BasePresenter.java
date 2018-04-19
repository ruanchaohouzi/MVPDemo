package com.shuwen.mvpdemo.login2.base;

/**
 * Created by ruanchao on 2018/4/19.
 */

public class BasePresenter<T extends IBaseView> {

    protected T mView;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(T mView) {
        this.mView = mView;
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        this.mView = null;
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        return mView != null;
    }

}
