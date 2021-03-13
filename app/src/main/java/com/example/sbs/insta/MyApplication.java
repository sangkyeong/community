package com.example.sbs.insta;

import com.example.sbs.insta.Util.Util;

import android.app.Application;

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Util.init(this);
    }
}
