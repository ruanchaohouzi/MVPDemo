package com.shuwen.mvpdemo.login2.base;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.Subject;

/**
 * Created by ruanchao on 2018/4/19.
 */

public class BasePresenter<T extends IBaseView> {

    protected WeakReference<T> viewRef;
    private CompositeDisposable mCompositeDisposable;

    /**
     * 绑定view，一般在初始化中调用该方法
     */
    public void attachView(T view) {
        viewRef = new WeakReference<T>(view);
    }
    /**
     * 断开view，一般在onDestroy中调用
     */
    public void detachView() {
        viewRef.clear();
    }
    /**
     * 是否与View建立连接
     * 每次调用业务请求的时候都要出先调用方法检查是否与View建立连接
     */
    public boolean isViewAttached(){
        onUnSubscribe();
        return viewRef != null && viewRef.get() != null;
    }

    //RxJava取消注册，以避免内存泄露
    public void onUnSubscribe(){
        if (mCompositeDisposable != null){
            mCompositeDisposable.dispose();
        }
    }

    //加入到CompositeDisposable中
    public void addSubscription(Observable observable, DisposableObserver observer){
        if (mCompositeDisposable == null){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(observer);
        observable.subscribe(observer);
    }

}
