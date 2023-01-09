package com.kodyakov.mycar;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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

public class UpdateDeleteActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    String event_str;
    Event event;

    TextView date_input;
    EditText comment_input, cost_input;
    Button update_button, delete_button, cancel;
    CardView calendar_btn;

    String id, date, comment, cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

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

        date_input = findViewById(R.id.date_input_update);
        comment_input = findViewById(R.id.comment_input_update);
        cost_input = findViewById(R.id.cost_input_update);
        calendar_btn = findViewById(R.id.calendar_btn_update);
        update_button = findViewById(R.id.update_row);
        delete_button = findViewById(R.id.delete_row);
        cancel = findViewById(R.id.cancel);
        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateDeleteActivity.this);
                date = date_input.getText().toString().trim();
                comment = comment_input.getText().toString().trim();
                cost = cost_input.getText().toString().trim();
                if(date.equals(""))
                    Toast.makeText(UpdateDeleteActivity.this, "Добавьте дату события", Toast.LENGTH_SHORT).show();
                else if (cost.equals(""))
                    Toast.makeText(UpdateDeleteActivity.this, "Добавьте расходы", Toast.LENGTH_SHORT).show();
                else{
                    myDB.updateData(event, id, date, comment, cost);
                    finish();
                }
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });
        calendar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    void getAndSetIntentData(){
        if ( getIntent().hasExtra("id") && getIntent().hasExtra("date") &&
                getIntent().hasExtra("comment") && getIntent().hasExtra("cost"))
        {
            id = getIntent().getStringExtra("id");
            date = getIntent().getStringExtra("date");
            comment = getIntent().getStringExtra("comment");
            cost = getIntent().getStringExtra("cost");

            date_input.setText(date);
            comment_input.setText(comment);
            cost_input.setText(cost);
        } else {
            Toast.makeText(this, "Нет данных", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить запись?");
        builder.setMessage("Вы уверены, что хотите удалить запись?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateDeleteActivity.this);
                myDB.deleteRow(event, id);
                finish();
            }
        });
        builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
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