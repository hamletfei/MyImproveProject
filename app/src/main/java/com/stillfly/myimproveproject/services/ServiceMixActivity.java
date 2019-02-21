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

public class ServiceMixActivity extends AppCompatActivity {

    private static final String TAG = "ServiceMixActivity";

    private ServiceConnection mServiceConnection;
    private boolean isServiceBounded = false;//用于判断是否与 Service 成功连接
    BindService.MyBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_mix);
        initServiceConnection();
        //启动服务
        findViewById(R.id.btn_service).setOnClickListener(view->{
            Intent intent = new Intent(this, BindService.class);
            startService(intent);
        });
        //停止服务
        findViewById(R.id.btn_stop_service).setOnClickListener(view -> {
//            Intent intent = new Intent(this, BindService.class);
//            stopService(intent);
            if (this.binder != null) {
                this.binder.getBindService().stop(1);
//                this.binder.getBindService().stop(2);
            }
        });

        //绑定 Service
        findViewById(R.id.btn_bind_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindService.class);
            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        });

        //解绑 Service
        findViewById(R.id.btn_unbind_service).setOnClickListener(view -> {
            safeUnbindService();
        });

        //一步 start 加 bind
        findViewById(R.id.btn_all_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindService.class);
            startService(intent);
            Intent intent2 = new Intent(this, BindService.class);
            bindService(intent2, mServiceConnection, Context.BIND_AUTO_CREATE);
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        safeUnbindService();
    }

    private void safeUnbindService() {
        if (isServiceBounded) {
            unbindService(mServiceConnection);
            isServiceBounded = false;
        }
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
                isServiceBounded = true;
                Log.i(TAG, "onServiceConnected");
                Log.i(TAG, "onServiceConnected" + Thread.currentThread());
                binder = (BindService.MyBinder) service;
                binder.getBindService().callService();
            }

            /**
             * 绑定关系解除
             * @param name
             */
            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i(TAG, "onServiceDisconnected");
                isServiceBounded = false;
            }
        };
    }
}
