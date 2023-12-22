package com.example.week10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("on-create message", "created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("on-start message", "started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("on-pause message", "paused");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("on-resume message", "resumed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("on-stop message", "stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("on-destroy message", "destroyed");
    }
}