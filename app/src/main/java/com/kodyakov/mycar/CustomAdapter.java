package com.kodyakov.mycar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    String event;

    private Context context;
    private ArrayList id, date, comment, cost;
    private Activity activity;

    public CustomAdapter(Activity activity, Context context, ArrayList id, ArrayList date, ArrayList comment, ArrayList cost, String event) {
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.cost = cost;
        this.event = event;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.rv_row, parent, false);
        return new MyViewHolder(v);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date_on_row, comment_on_row, cost_on_row;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date_on_row = itemView.findViewById(R.id.date_on_row);
            comment_on_row = itemView.findViewById(R.id.comment_on_row);
            cost_on_row = itemView.findViewById(R.id.cost_on_row);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.date_on_row.setText(String.valueOf(date.get(position)));
        holder.comment_on_row.setText(String.valueOf(comment.get(position)));
        holder.cost_on_row.setText(String.valueOf(cost.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateDeleteActivity.class);

                intent.putExtra("id", String.valueOf(id.get(position)));
                intent.putExtra("date", String.valueOf(date.get(position)));
                intent.putExtra("comment", String.valueOf(comment.get(position)));
                intent.putExtra("cost", String.valueOf(cost.get(position)));
                intent.putExtra("event", event);

                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }
}
