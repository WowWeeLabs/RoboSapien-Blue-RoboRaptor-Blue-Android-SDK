package com.wowwee.roboremotebluesampleproject;

import android.app.Application;
import android.os.Handler;

public class App extends Application {
    private static App context;
    private static Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();

        context = this;
        handler = new Handler();
    }

    public static App getContext() {
        return context;
    }
}
