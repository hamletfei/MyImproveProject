package com.stillfly.myimproveproject.thread;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class ThreadOne extends Thread {

    private Handler mHandleOne;
    private Handler mHandleTwo;
    private Handler mHandleThree;
    private Context mContext;


    public ThreadOne(Context context) {
        this.mContext = context;
        mHandleOne = new Handler();
        Log.e("handleOne", mHandleOne.getLooper().toString());
    }

    @Override
    public void run() {
//        mHandleThree = new Handler();
//        Log.e("handleThree", mHandleThree.getLooper().toString());
        Looper.prepare();
        Toast.makeText(mContext,  "Toast show", Toast.LENGTH_SHORT).show();
        mHandleTwo = new Handler();
        Log.e("handleTwo", mHandleTwo.getLooper().toString());
        Looper.loop();
    }
}
