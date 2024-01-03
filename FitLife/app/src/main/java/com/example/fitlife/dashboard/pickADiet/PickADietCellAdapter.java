package com.example.fitlife.dashboard.pickADiet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fitlife.R;

import java.util.List;

public class PickADietCellAdapter extends ArrayAdapter<PickADietList> {
    public PickADietCellAdapter(Context context, int resource, List<PickADietList> pickADietLists) {
        super(context, resource, pickADietLists);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PickADietList pickADietList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.pick_a_diet_list_cell, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.cellName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.cellImage);

        textView.setText(pickADietList.getName());
        imageView.setImageResource(pickADietList.getImage());

        return convertView;
    }
}
