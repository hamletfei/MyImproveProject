package com.stillfly.myimproveproject.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stillfly.myimproveproject.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        //启动服务
        findViewById(R.id.btn_service).setOnClickListener(view->{
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        });
        //停止服务
        findViewById(R.id.btn_stop_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        });

    }
}
