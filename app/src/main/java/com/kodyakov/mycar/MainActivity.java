package com.kodyakov.mycar;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout car_wash_row, refueling_row, parking_row, toll_road_row, service_row;
    ConstraintLayout tire_fitting_row, repair_row, spares_row, fines_row, other_row;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        car_wash_row = findViewById(R.id.car_wash_row);
        refueling_row = findViewById(R.id.refueling_row);
        parking_row = findViewById(R.id.parking_row);
        toll_road_row = findViewById(R.id.toll_road_row);
        service_row = findViewById(R.id.service_row);
        tire_fitting_row = findViewById(R.id.tire_fitting_row);
        repair_row = findViewById(R.id.repair_row);
        spares_row = findViewById(R.id.spares_row);
        fines_row = findViewById(R.id.fines_row);
        other_row = findViewById(R.id.other_row);

        car_wash_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "car_wash");
                startActivity(intent);
            }
        });
        refueling_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "refueling");
                startActivity(intent);
            }
        });
        parking_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "parking");
                startActivity(intent);
            }
        });
        toll_road_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "toll_road");
                startActivity(intent);
            }
        });
        service_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "service");
                startActivity(intent);
            }
        });
        tire_fitting_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "tire_fitting");
                startActivity(intent);
            }
        });
        repair_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "repair");
                startActivity(intent);
            }
        });
        spares_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "spares");
                startActivity(intent);
            }
        });
        fines_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "fines");
                startActivity(intent);
            }
        });
        other_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EventActivity.class);
                intent.putExtra("event", "other");
                startActivity(intent);
            }
        });
    }
}