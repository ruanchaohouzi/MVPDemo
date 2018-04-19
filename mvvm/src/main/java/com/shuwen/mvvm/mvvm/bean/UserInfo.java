package com.shuwen.mvvm.mvvm.bean;

import android.databinding.ObservableField;
import android.os.Handler;


/**
 * Created by ruanchao on 2018/4/11.
 */

public class UserInfo {

    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> pwd = new ObservableField<>();
    public ObservableField<String> sex = new ObservableField<>();
    public ObservableField<Integer> age = new ObservableField<>();


}
