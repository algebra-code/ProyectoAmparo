package com.amparo.films;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.amparo.films.model.Film;

import java.util.ArrayList;


public class FilmAdapter extends ArrayAdapter<Film> {

    int layoutResourceId;
    Context context;
    ArrayList<Film> data;
    public FilmAdapter(Context context, int layoutResourceId, ArrayList<Film> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        TextView tv_title = row.findViewById(R.id.tv_title);
        TextView tv_points = row.findViewById(R.id.tv_points);

        String title = data.get(position).getTitle();
        int point = data.get(position).getPoint();
        tv_title.setText(title);
        tv_points.setText(String.valueOf(point));

        //change color points
        if (point==4 || point==5) {
            tv_points.setTextColor((context).getResources().getColor(R.color.green));
        }
        if (point==2 || point==3) {
            tv_points.setTextColor((context).getResources().getColor(R.color.black));
        }
        if (point==0 || point==1) {
            tv_points.setTextColor((context).getResources().getColor(R.color.red));
        }

        return row;
    }
}
