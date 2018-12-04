package com.stillfly.myimproveproject.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.stillfly.myimproveproject.R;

public class BindServiceActivity extends AppCompatActivity {
    private static final String TAG = "BindServiceActivity";

    private ServiceConnection mServiceConnection;
    private BindService mBindService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);
        initServiceConnection();
        //绑定 Service
        findViewById(R.id.btn_bind_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindService.class);
            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        });

        //解绑 Service
        findViewById(R.id.btn_unbind_service).setOnClickListener(view -> {
            unbindService(mServiceConnection);
        });

        findViewById(R.id.btn_nav_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindService2Activity.class);
            startActivity(intent);
        });
    }

    private void initServiceConnection() {
        mServiceConnection = new ServiceConnection() {

            /**
             * 绑定关系已经建立
             * @param name
             * @param service
             */
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i(TAG, "onServiceConnected");
                BindService.MyBinder binder = (BindService.MyBinder) service;
                mBindService = binder.getBindService();
                mBindService.callService();
            }

            /**
             * 绑定关系解除
             * @param name
             */
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "onServiceDisconnected");
            }
        };
    }
}
