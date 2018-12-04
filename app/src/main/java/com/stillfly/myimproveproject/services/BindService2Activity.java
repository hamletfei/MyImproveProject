package com.stillfly.myimproveproject.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.stillfly.myimproveproject.R;

public class BindService2Activity extends BindServiceActivity {
    private static final String TAG = "BindService2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn_nav_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindService2Activity.class);
            startActivity(intent);
        });
    }
}
