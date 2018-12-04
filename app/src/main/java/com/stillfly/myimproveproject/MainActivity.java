package com.stillfly.myimproveproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stillfly.myimproveproject.services.BindServiceActivity;
import com.stillfly.myimproveproject.services.MyService;
import com.stillfly.myimproveproject.services.ServiceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //启动服务
        findViewById(R.id.btnService).setOnClickListener(view -> {
            Intent intent = new Intent(this, MyService.class);
            startService(intent);
        });
        //停止服务
        findViewById(R.id.btn_stop_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, MyService.class);
            stopService(intent);
        });

        findViewById(R.id.btn_start_act).setOnClickListener(view -> {
            Intent intent = new Intent(this, ServiceActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_bind_act).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindServiceActivity.class);
            startActivity(intent);
        });
    }
}
