package com.example.roomtest.core;

import android.app.Application;
import android.content.Context;

/**
 * @author lenovo
 * 创建时间： 2021/5/22 14:06
 * 类描述：
 */
public class MyApplication extends Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }

    public static Context getContext() {
        return applicationContext;
    }
}
