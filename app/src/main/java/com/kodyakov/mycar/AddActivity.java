package com.kodyakov.mycar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    String event_str;
    Event event;

    TextView date_input;
    EditText cost_input, comment_input;
    CardView calendar_btn;
    Button add_row, cansel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        event_str = getIntent().getStringExtra("event");
        switch (event_str){
            case "car_wash":
                event = Event.CAR_WASH;
                break;
            case "refueling":
                event = Event.REFUELING;
                break;
            case "parking":
                event = Event.PARKING;
                break;
            case "toll_road":
                event = Event.TOLL_ROAD;
                break;
            case "service":
                event = Event.SERVICE;
                break;
            case "tire_fitting":
                event = Event.TIRE_FITTING;
                break;
            case "repair":
                event = Event.REPAIR;
                break;
            case "spares":
                event = Event.SPARES;
                break;
            case "fines":
                event = Event.FINES;
                break;
            case "other":
                event = Event.OTHER;
                break;
        }

        date_input = findViewById(R.id.date_input);
        cost_input = findViewById(R.id.cost_input);
        comment_input = findViewById(R.id.comment_input);
        calendar_btn = findViewById(R.id.calendar_btn);
        add_row = findViewById(R.id.add_row);
        cansel = findViewById(R.id.cancel_from_add);

        add_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                String date_to_add = date_input.getText().toString().trim();
                String cost_to_add = cost_input.getText().toString().trim();
                if (date_to_add.equals(""))
                    Toast.makeText(AddActivity.this, "Добавьте дату события", Toast.LENGTH_SHORT).show();
                else if (cost_to_add.equals(""))
                    Toast.makeText(AddActivity.this, "Добавьте расходы", Toast.LENGTH_SHORT).show();
                else{
                    myDB.addRow(
                            event,
                            date_to_add,
                            comment_input.getText().toString().trim(),
                            Double.valueOf(cost_to_add)
                    );
                    finish();
                }
            }
        });
        cansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        calendar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    protected void showDatePickerDialog(){
        DatePickerDialog cpd = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        cpd.show();
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
        date_input.setText(date);
    }
}