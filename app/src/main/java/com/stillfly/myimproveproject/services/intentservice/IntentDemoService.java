package com.stillfly.myimproveproject.services.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class IntentDemoService extends IntentService {
    private static String TAG = "IntentDemoService";

    public static final String ACTION_PROGRESS = "action_progress";

    public IntentDemoService() {
        this("IntentDemoService");
    }

    public IntentDemoService(String name) {
        super(name);
        Log.i(TAG, "onHandleIntent constructor");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String task = intent.getStringExtra("task");
        Log.i(TAG, "onHandleIntent " + task);
        int progress = 0;
        //次循环用来模拟耗时操作，例如下载文件等。
        while (progress <= 100) {
            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progress++;
            //刷新UI
            setStateAndProgress(task, progress);
        }

    }

    private void setStateAndProgress(String state, int progress) {
        Intent intent = new Intent();
        intent.setAction(ACTION_PROGRESS);
        intent.putExtra("STATE", state);
        intent.putExtra("PROGRESS", progress);
        sendBroadcast(intent);
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy ");
        super.onDestroy();

    }
}
