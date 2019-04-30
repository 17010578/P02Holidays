package com.myapplicationdev.android.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holidays;
    private Context context;
    private TextView tvYear;
    private TextView tvDay;
    private ImageView ivImg;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context,resource,objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.hols, parent, false);


        tvDay = rowView.findViewById(R.id.textViewDay);
        tvYear = rowView.findViewById(R.id.textViewYear);
        ivImg = rowView.findViewById(R.id.imageViewCNY);


        Holiday currentHol = holidays.get(position);


        tvDay.setText(currentHol.getName());
        tvYear.setText((currentHol.getDate()));
        // Set the image to star or nostar accordingly
        if(currentHol.getImg() == "cny") {
            ivImg.setImageResource(R.drawable.cny);
        }
        else if (currentHol.getImg() == "labour_day"){
            ivImg.setImageResource(R.drawable.labour_day);
        }
        else if (currentHol.getImg() == "new_year"){
            ivImg.setImageResource(R.drawable.new_year);
        }
        else if (currentHol.getImg() == "good_friday"){
            ivImg.setImageResource(R.drawable.good_friday);

        }
        // Return the nicely done up View to the ListView
        return rowView;
    }

}
