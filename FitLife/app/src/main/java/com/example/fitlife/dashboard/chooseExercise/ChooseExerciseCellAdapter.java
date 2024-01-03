package com.example.fitlife.dashboard.chooseExercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitlife.R;

import java.util.List;

public class ChooseExerciseCellAdapter extends ArrayAdapter<ChooseExerciseList> {
    public ChooseExerciseCellAdapter(Context context, int resource, List<ChooseExerciseList> chooseExerciseLists) {
        super(context, resource, chooseExerciseLists);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChooseExerciseList chooseExerciseList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.choose_exercises_list_cell, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.cellName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.cellImage);

        textView.setText(chooseExerciseList.getName());
        imageView.setImageResource(chooseExerciseList.getImage());

        return convertView;
    }
}
