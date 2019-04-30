package com.myapplicationdev.android.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> aaHols;
    ArrayList<String> alHols = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = this.findViewById(R.id.listView);

        alHols.add("Secular");
        alHols.add("Ethnic & Religion");

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aaHols = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, alHols);
        listView.setAdapter(aaHols);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(),activity_holiday.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Food selectedFood = food.get(position);
//
//                Toast.makeText(MainActivity.this, selectedFood.getName()
//                                + " Star: " + selectedFood.isStar(),
//                        Toast.LENGTH_LONG).show();
//
//            }
//        });


    }
}
