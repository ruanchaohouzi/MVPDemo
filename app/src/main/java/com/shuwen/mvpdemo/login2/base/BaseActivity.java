package com.shuwen.mvpdemo.login2.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by ruanchao on 2018/4/19.
 */

public abstract class BaseActivity<T extends BasePresenter> extends Activity{

    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        mPresenter.attachView(mPresenter.mView);
    }

    public abstract void initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
