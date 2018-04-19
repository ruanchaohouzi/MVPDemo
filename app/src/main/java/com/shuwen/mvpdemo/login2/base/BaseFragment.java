package com.shuwen.mvpdemo.login2.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by ruanchao on 2018/4/19.
 */

public abstract class BaseFragment<T extends BasePresenter> extends Fragment {

    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initPresenter();
        mPresenter.attachView(mPresenter.mView);
    }
    
    public abstract void initPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }


}
