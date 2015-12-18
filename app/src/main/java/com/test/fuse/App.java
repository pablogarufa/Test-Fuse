package com.test.fuse;

import android.app.Application;

import com.test.fuse.network.RestClient;

public class App extends Application{

    public static RestClient restClient;

    @Override
    public void onCreate() {

        super.onCreate();

        // Singleton class
        restClient = new RestClient();
    }
}
