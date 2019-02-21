package com.stillfly.myimproveproject.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ProgressBar;

import com.stillfly.myimproveproject.R;
import com.stillfly.myimproveproject.services.intentservice.IntentDemoService;

public class IntentServiceActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    AppCompatTextView mTextView;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        findViewById(R.id.btn_task_1).setOnClickListener(view->{
            Intent intent = new Intent(this, IntentDemoService.class);
            intent.putExtra("task", "task_1");
            startService(intent);
        });

        findViewById(R.id.btn_task_2).setOnClickListener(view->{
            Intent intent = new Intent(this, IntentDemoService.class);
            intent.putExtra("task", "task_2");
            startService(intent);
        });

        findViewById(R.id.btn_stop_task).setOnClickListener(view->{
            Intent intent = new Intent(this, IntentDemoService.class);
            stopService(intent);
        });

        mProgressBar = findViewById(R.id.pb);
        mProgressBar.setMax(100);
        mTextView = findViewById(R.id.tv_task);
        registerBroadCastReceiver();
    }

    private void registerBroadCastReceiver() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int progress = intent.getIntExtra("PROGRESS", 0);
                String state = intent.getStringExtra("STATE");
                mTextView.setText("当前任务" + state);
                mProgressBar.setProgress(progress);
            }
        };

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IntentDemoService.ACTION_PROGRESS);
        registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }
}
