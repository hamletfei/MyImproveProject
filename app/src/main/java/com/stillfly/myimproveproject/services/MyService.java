package com.stillfly.myimproveproject.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    private final static String TAG = MyService.class.getName();

    public MyService() {
        super();
        Log.i(TAG, "MyService Constructor");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "MyService onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("intent = [" + intent + "], flags = [" + flags + "], startId = [" + startId + "]");
        Log.i(TAG, "MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "MyService onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "MyService onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "MyService onDestroy");
        super.onDestroy();
    }
}
