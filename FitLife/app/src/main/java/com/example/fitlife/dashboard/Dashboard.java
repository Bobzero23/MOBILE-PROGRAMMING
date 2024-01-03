package com.example.fitlife.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        DashboardList burnCalories = new DashboardList("0", "BURN CALORIES", R.drawable.calories);
        dashboardLists.add(burnCalories);

        DashboardList chooseExercise = new DashboardList("1", "CHOOSE EXERCISE", R.drawable.exercises);
        dashboardLists.add(chooseExercise);

        DashboardList pickADiet = new DashboardList("2", "PICK A DIET", R.drawable.diet);
        dashboardLists.add(pickADiet);
    }

    private void setupOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DashboardList selectedList = (DashboardList) (listView.getItemAtPosition(position));

                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), BurnCalories.class);
                    intent.putExtra("id", selectedList.getId());
                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), ChooseExercise.class);
                    intent.putExtra("id", selectedList.getId());
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getApplicationContext(), PickADiet.class);
                    intent.putExtra("id", selectedList.getId());
                    startActivity(intent);
                }


            }
        });
    }
}