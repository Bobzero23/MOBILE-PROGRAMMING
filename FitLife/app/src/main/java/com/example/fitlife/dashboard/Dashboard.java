package com.example.fitlife.dashboard;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fitlife.R;
import com.example.fitlife.dashboard.burnCalories.BurnCalories;
import com.example.fitlife.dashboard.chooseExercise.ChooseExercise;
import com.example.fitlife.dashboard.pickADiet.PickADiet;

import java.util.ArrayList;


public class Dashboard extends AppCompatActivity {
    /*initializing the lists*/
    public static ArrayList<DashboardList> dashboardLists = new ArrayList<>();
    private ListView listView;
    public static int totalCalories = 0;
    public static int targetCalories = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        /*calling the customized methods*/
        setupData();
        setupList();
        setupOnClickListener();
    }

    private void setupList() {
        /*making a reference of the list*/
        listView = (ListView) findViewById(R.id.dashboardListView);

        /*creating a new object of the cell adapter*/
        DashboardCellAdapter cellAdapter = new DashboardCellAdapter(getApplicationContext(), 0, dashboardLists);

        /*setting up the adapter for the list*/
        listView.setAdapter(cellAdapter);
    }

    private void setupData() {
        /*adding the cell data to the list*/
        if (dashboardLists.isEmpty()) {
            DashboardList burnCalories = new DashboardList("0", "BURN CALORIES", R.drawable.calories);
            dashboardLists.add(burnCalories);

            DashboardList chooseExercise = new DashboardList("1", "CHOOSE EXERCISE", R.drawable.exercises);
            dashboardLists.add(chooseExercise);

            DashboardList pickADiet = new DashboardList("2", "PICK A DIET", R.drawable.diet);
            dashboardLists.add(pickADiet);
        }
    }

    private ActivityResultLauncher<Intent> burnCaloriesLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String calories = data.getStringExtra("calories");
                        Log.d("TARGETED CALORIES", calories + "");
                        targetCalories = Integer.valueOf(calories);
                    }
                }
            }
    );

    private ActivityResultLauncher<Intent> chooseExerciseLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String selectedExerciseId = data.getStringExtra("selectedId");
                        if (selectedExerciseId.equals("0")) {
                            totalCalories = totalCalories + 1000;
                            Log.d("SELECTED EXERCISE ID", "0");
                        } else if (selectedExerciseId.equals("1")) {
                            totalCalories = totalCalories + 200;
                            Log.d("SELECTED EXERCISE ID", "1");
                        }else if (selectedExerciseId.equals("2")) {
                            totalCalories = totalCalories + 700;
                            Log.d("SELECTED EXERCISE ID", "2");
                        }else if (selectedExerciseId.equals("3")) {
                            totalCalories = totalCalories + 1200;
                            Log.d("SELECTED EXERCISE ID", "3");
                        }else {
                            totalCalories = totalCalories + 1500;
                            Log.d("SELECTED EXERCISE ID", "5");
                        }
                    }
                }
            }
    );

    private ActivityResultLauncher<Intent> pickADietLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    if (data != null) {
                        String pickedDietId = data.getStringExtra("selectedId");
                        if (pickedDietId.equals("0")) {
                            totalCalories = totalCalories - 500;
                            Log.d("SELECTED DIET ID", "0");
                        } else if (pickedDietId.equals("1")) {
                            totalCalories = totalCalories - 200;
                            Log.d("SELECTED DIET ID", "1");
                        }else if (pickedDietId.equals("2")) {
                            totalCalories = totalCalories - 400;
                            Log.d("SELECTED DIET ID", "2");
                        }else if (pickedDietId.equals("3")) {
                            totalCalories = totalCalories - 300;
                            Log.d("SELECTED DIET ID", "3");
                        }else {
                            totalCalories = totalCalories - 700;
                            Log.d("SELECTED DIET ID", "4");
                        }

                        int remainingCalories = targetCalories - totalCalories;
                        Log.d("REMAINING CALORIES", remainingCalories + "");
                        showResultDialog(remainingCalories);
                    }
                }
            }
    );


    private void setupOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DashboardList selectedList = (DashboardList) (listView.getItemAtPosition(position));

                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), BurnCalories.class);
                    burnCaloriesLauncher.launch(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), ChooseExercise.class);
                    chooseExerciseLauncher.launch(intent);
                }else {
                    Intent intent = new Intent(getApplicationContext(), PickADiet.class);
                    pickADietLauncher.launch(intent);
                }
            }
        });
    }

    private void showResultDialog(int remainingCalories) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (remainingCalories > 0) {
            builder.setMessage("You need to eat some snacks!");

        } else if (remainingCalories < 0) {
            builder.setMessage("You can do some walking!");
        } else {
            builder.setMessage("Congratulations! You reached your calorie burning goal.");
            mediaPlayer = MediaPlayer.create(this, R.raw.congratulations);
        }

        // Play the sound when the dialog is shown
        mediaPlayer.start();

        // Set a listener to release resources after the sound finishes playing
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });

        builder.setPositiveButton("OK", (dialog, which) -> {
            // Handle the OK button click if needed
            dialog.dismiss();
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}