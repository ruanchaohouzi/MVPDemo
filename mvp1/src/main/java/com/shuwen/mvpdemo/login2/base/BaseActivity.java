package com.shuwen.mvpdemo.login2.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by ruanchao on 2018/4/19.
 */

public abstract class BaseActivity<V extends IBaseView,T extends BasePresenter<V>> extends Activity{

    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    public abstract T createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
