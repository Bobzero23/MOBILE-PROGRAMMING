package com.example.fitlife.dashboard.pickADiet;

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
import com.example.fitlife.dashboard.chooseExercise.ChooseExercise;

import java.util.ArrayList;

public class PickADiet extends AppCompatActivity {
    /*initializing the lists*/
    public static ArrayList<PickADietList> pickADietLists = new ArrayList<>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_adiet);

        /*calling the customized methods*/
        setupData();
        setupList();
        setupOnClickListener();
    }

    private void setupList() {
        /*making a reference of the list*/
        listView = (ListView) findViewById(R.id.pickADietListView);

        /*creating a new object of the cell adapter*/
        PickADietCellAdapter cellAdapter = new PickADietCellAdapter(getApplicationContext(), 0, pickADietLists);

        /*setting up the adapter for the list*/
        listView.setAdapter(cellAdapter);
    }

    private void setupData() {
        /*adding the cell data to the list*/
        PickADietList meal1 = new PickADietList("0", "1500CAL\n BREAKFAST(3 EGGS)\n LUNCH(CHICKEN BREAST)\n DINNER(BEEF)", R.drawable.meal);
        pickADietLists.add(meal1);

        PickADietList meal2 = new PickADietList("1", "500CAL\n BREAKFAST(PEANUT BUTTER)\n LUNCH(RICE)\n DINNER(NOTHING)", R.drawable.meal);
        pickADietLists.add(meal2);

        PickADietList meal3 = new PickADietList("2", "1000CAL\n BREAKFAST(CEREAL)\n LUNCH(CHICKEN WINGS)\n DINNER(GRILL)", R.drawable.meal);
        pickADietLists.add(meal3);

        PickADietList meal4 = new PickADietList("3", "700CAL\n BREAKFAST(OMELETTE)\n LUNCH(MEET BALL)\n DINNER(SEA FOOD)\n", R.drawable.meal);
        pickADietLists.add(meal4);

        PickADietList meal5 = new PickADietList("4", "2000\n BREAKFAST(SMOOTHIE)\n LUNCH(LAMB MEET)\n DINNER(KFC)", R.drawable.meal);
        pickADietLists.add(meal5);
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