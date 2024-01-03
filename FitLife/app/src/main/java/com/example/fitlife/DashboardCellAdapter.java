package com.example.fitlife;

//this class takes whatever it is in the cell and makes it work

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class DashboardCellAdapter extends ArrayAdapter<DashboardList> {
    public DashboardCellAdapter(Context context, int resource, List<DashboardList> dashboardLists) {
        super(context, resource, dashboardLists);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DashboardList dashboardList = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dashboard_list_cell, parent, false);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.cellName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.cellImage);

        textView.setText(dashboardList.getName());
        imageView.setImageResource(dashboardList.getImage());

        return convertView;
    }
}
