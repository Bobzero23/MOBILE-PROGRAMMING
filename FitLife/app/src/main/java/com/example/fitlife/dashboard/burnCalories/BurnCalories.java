package com.example.fitlife.dashboard.burnCalories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fitlife.R;
import com.example.fitlife.dashboard.Dashboard;

public class BurnCalories extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burn_calories);
        editText = findViewById(R.id.editTextText);
    }

    public void burnCalorieHandler(View view) {
        Intent intent = new Intent(this, Dashboard.class);
        intent.putExtra("calories", editText.getText().toString());
        /**this is a better way to do it, instead of starting new intent each time*/
        setResult(RESULT_OK, intent);
        finish();
    }
}