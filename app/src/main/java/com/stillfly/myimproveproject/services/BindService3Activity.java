package com.stillfly.myimproveproject.services;

import android.content.Intent;
import android.os.Bundle;

import com.stillfly.myimproveproject.R;

public class BindService3Activity extends BindServiceActivity {
    private static final String TAG = "BindService2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        findViewById(R.id.btn_nav_service).setOnClickListener(view -> {
            Intent intent = new Intent(this, BindService3Activity.class);
            startActivity(intent);
        });
    }
}
