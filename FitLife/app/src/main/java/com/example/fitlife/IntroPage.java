package com.example.fitlife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
    }

    public void nextActivityHandler(View view) {
        Intent intent = new Intent(IntroPage.this, Dashboard.class);
        startActivity(intent);
    }
}