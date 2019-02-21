package com.stillfly.myimproveproject.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindService extends Service {

    private final static String TAG = "BindService";

    private MyBinder mMyBinder = new MyBinder();

    public BindService() {
        Log.i(TAG, "BindService constructor");
    }

    @Override
    public void onCreate() {
        Log.i(TAG, "BindService onCreate");
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "BindService onBind");
        Log.i(TAG, "BindService onBind " + Thread.currentThread());
        return mMyBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "BindService onStartCommand");
        Log.i(TAG, "onStartCommand" + Thread.currentThread());
        System.out.println("intent = [" + intent + "], flags = [" + flags + "], startId = [" + startId + "]");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "BindService onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "BindService onUnbind");
        return true;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "BindService onDestroy");
        super.onDestroy();
    }

    public void callService() {
        Log.i(TAG, "BindService callService");
    }

    public void stop(int startId) {
        stopSelf(startId);
    }

    public class MyBinder extends Binder {
        BindService bindService = BindService.this;

        /**
         * 返回当前绑定的 Service
         * @return
         */
        public BindService getBindService() {
            return bindService;
        }

    }
}
