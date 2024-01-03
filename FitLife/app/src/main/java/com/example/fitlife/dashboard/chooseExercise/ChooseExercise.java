package com.example.fitlife.dashboard.chooseExercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fitlife.R;
import com.example.fitlife.dashboard.DashboardCellAdapter;
import com.example.fitlife.dashboard.DashboardList;
import com.example.fitlife.dashboard.burnCalories.BurnCalories;
import com.example.fitlife.dashboard.pickADiet.PickADiet;

import java.util.ArrayList;

public class ChooseExercise extends AppCompatActivity {
    /*initializing the lists*/
    public static ArrayList<ChooseExerciseList> chooseExerciseLists = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exercise);

        /*calling the customized methods*/
        setupData();
        setupList();
        setupOnClickListener();
    }

    private void setupList() {
        /*making a reference of the list*/
        listView = (ListView) findViewById(R.id.chooseExerciseListView);

        /*creating a new object of the cell adapter*/
        ChooseExerciseCellAdapter cellAdapter = new ChooseExerciseCellAdapter(getApplicationContext(), 0, chooseExerciseLists);

        /*setting up the adapter for the list*/
        listView.setAdapter(cellAdapter);
    }

    private void setupData() {
        /*adding the cell data to the list*/
        ChooseExerciseList  skippingRope = new ChooseExerciseList("0", "1000CAL - SKIPPING ROPE", R.drawable.skippingrope);
        chooseExerciseLists.add(skippingRope);

        ChooseExerciseList stretching = new ChooseExerciseList("1", "200CAL - STRETCHING", R.drawable.stretching);
        chooseExerciseLists.add(stretching);

        ChooseExerciseList squats = new ChooseExerciseList("2", "700CAL - SQUATS", R.drawable.squats);
        chooseExerciseLists.add(squats);

        ChooseExerciseList liftWeight = new ChooseExerciseList("2", "1200CAL - LIFT WEIGHT", R.drawable.liftweight);
        chooseExerciseLists.add(liftWeight);

        ChooseExerciseList running = new ChooseExerciseList("2", "1500CAL - RUNNING", R.drawable.running);
        chooseExerciseLists.add(running);
    }

    private void setupOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DashboardList selectedList = (DashboardList) (listView.getItemAtPosition(position));

//                if (position == 0) {
//                    Intent intent = new Intent(getApplicationContext(), BurnCalories.class);
//                    intent.putExtra("id", selectedList.getId());
//                    startActivity(intent);
//                } else if (position == 1) {
//                    Intent intent = new Intent(getApplicationContext(), ChooseExercise.class);
//                    intent.putExtra("id", selectedList.getId());
//                    startActivity(intent);
//                }else {
//                    Intent intent = new Intent(getApplicationContext(), PickADiet.class);
//                    intent.putExtra("id", selectedList.getId());
//                    startActivity(intent);
//                }
            }
        });
    }

}