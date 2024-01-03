package com.example.fitlife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

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
        DashboardList burnCalories = new DashboardList("0", "BURN CALORIES", R.drawable.calories);
        dashboardLists.add(burnCalories);

        DashboardList chooseExercise = new DashboardList("1", "CHOOSE EXERCISE", R.drawable.exercises);
        dashboardLists.add(chooseExercise);

        DashboardList pickADiet = new DashboardList("2", "PICK A DIET", R.drawable.diet);
        dashboardLists.add(pickADiet);
    }

    private void setupOnClickListener() {
    }
}