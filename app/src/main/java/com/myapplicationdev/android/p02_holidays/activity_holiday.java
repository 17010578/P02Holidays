package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class activity_holiday extends AppCompatActivity {

    TextView tvCat;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> hols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);

        tvCat = findViewById(R.id.textViewCat);
        lv = findViewById(R.id.lvHols);
        hols = new ArrayList<Holiday>();

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);

        if (position == 0){
            tvCat.setText("Secular");
            hols.add(new Holiday("New Year's Day","1 Jan 2017","new_year"));
            hols.add(new Holiday("Labour Day","1 May 2017","labour_day"));
        }
        else if (position == 1){
            tvCat.setText("Ethnic & Religion");
            hols.add(new Holiday("Chinese New Year","28-29 Jan 2017","cny"));
            hols.add(new Holiday("Good Friday","14 April 2017","good_friday"));
        }

        aa = new HolidayAdapter(this, R.layout.hols, hols);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = hols.get(position);

                Toast.makeText(activity_holiday.this, selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}
