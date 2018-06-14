package com.shuwen.mvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by ruanchao on 2018/6/14.
 */

public class MainApplication extends Application{

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}
