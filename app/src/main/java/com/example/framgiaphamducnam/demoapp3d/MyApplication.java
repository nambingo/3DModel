package com.example.framgiaphamducnam.demoapp3d;

import android.app.Application;

/**
 * Created by FRAMGIA\pham.duc.nam on 03/04/2018.
 */

public class MyApplication extends Application {
    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
