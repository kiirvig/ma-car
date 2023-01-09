package com.kodyakov.mycar;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    String event_str;
    Event event;

    RecyclerView rv;
    FloatingActionButton add_button;

    TextView cost_all_row;

    ImageView no_data_img;
    TextView no_data_mes;

    MyDatabaseHelper myDB;
    ArrayList<String> id, date, comment, cost;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ActionBar ab = getSupportActionBar();

        event_str = getIntent().getStringExtra("event");
        switch (event_str){
            case "car_wash":
                event = Event.CAR_WASH;
                ab.setTitle("Мойка");
                break;
            case "refueling":
                event = Event.REFUELING;
                ab.setTitle("Заправка");
                break;
            case "parking":
                event = Event.PARKING;
                ab.setTitle("Платная парковка");
                break;
            case "toll_road":
                event = Event.TOLL_ROAD;
                ab.setTitle("Платная дорога");
                break;
            case "service":
                event = Event.SERVICE;
                ab.setTitle("Плановое ТО");
                break;
            case "tire_fitting":
                event = Event.TIRE_FITTING;
                ab.setTitle("Шиномонтаж");
                break;
            case "repair":
                event = Event.REPAIR;
                ab.setTitle("Ремонт");
                break;
            case "spares":
                event = Event.SPARES;
                ab.setTitle("Запчасти и расходники");
                break;
            case "fines":
                event = Event.FINES;
                ab.setTitle("Штрафы");
                break;
            case "other":
                event = Event.OTHER;
                ab.setTitle("Разное");
                break;
        }
        rv = findViewById(R.id.rv);
        add_button = findViewById(R.id.add_button);

        cost_all_row = findViewById(R.id.cost_all_row);

        no_data_img = findViewById(R.id.no_data_img);
        no_data_mes = findViewById(R.id.no_data_mes);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventActivity.this, AddActivity.class);
                intent.putExtra("event", event_str);
                EventActivity.this.startActivityForResult(intent,1);
            }
        });

        myDB = new MyDatabaseHelper(EventActivity.this);
        id = new ArrayList<>();
        date = new ArrayList<>();
        comment = new ArrayList<>();
        cost = new ArrayList<>();

        storeDataInArrays();

        double all_cost = 0;
        for (String cost : cost){
            all_cost += Double.valueOf(cost);
        }
        switch (event){
            case CAR_WASH:
                cost_all_row.setText("Общие затраты на мойку машины: " + String.valueOf(all_cost));
                break;
            case REFUELING:
                cost_all_row.setText("Общие затраты на заправку машины: " + String.valueOf(all_cost));
                break;
            case PARKING:
                cost_all_row.setText("Общие затраты на платную парковку: " + String.valueOf(all_cost));
                break;
            case TOLL_ROAD:
                cost_all_row.setText("Общие затраты на платную дорогу: " + String.valueOf(all_cost));
                break;
            case SERVICE:
                cost_all_row.setText("Общие затраты на плановое ТО: " + String.valueOf(all_cost));
                break;
            case TIRE_FITTING:
                cost_all_row.setText("Общие затраты на шиномонтаж: " + String.valueOf(all_cost));
                break;
            case REPAIR:
                cost_all_row.setText("Общие затраты на ремонт: " + String.valueOf(all_cost));
                break;
            case SPARES:
                cost_all_row.setText("Общие затраты на запчасти и расходники: " + String.valueOf(all_cost));
                break;
            case FINES:
                cost_all_row.setText("Общие затраты на штрафы: " + String.valueOf(all_cost));
                break;
            case OTHER:
                cost_all_row.setText("Общие затраты на прочее: " + String.valueOf(all_cost));
                break;
        }
        customAdapter = new CustomAdapter(EventActivity.this, this, id, date, comment, cost, event_str);
        rv.setAdapter(customAdapter);
        rv.setLayoutManager(new LinearLayoutManager(EventActivity.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
            recreate();
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData(event);;

        if (cursor.getCount() == 0){
            no_data_img.setVisibility(View.VISIBLE);
            no_data_mes.setVisibility(View.VISIBLE);
        } else {
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                date.add(cursor.getString(1));
                comment.add(cursor.getString(2));
                cost.add(cursor.getString(3));
            }
            no_data_img.setVisibility(View.GONE);
            no_data_mes.setVisibility(View.GONE);
        }
    }
}