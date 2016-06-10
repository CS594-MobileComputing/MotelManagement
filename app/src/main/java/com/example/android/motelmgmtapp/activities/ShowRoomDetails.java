package com.example.android.motelmgmtapp.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.Occupied;
import com.example.android.motelmgmtapp.R;

import java.util.ArrayList;
import java.util.List;

public class ShowRoomDetails extends AppCompatActivity {
    DatabaseHandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_room_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbh = new DatabaseHandler(this);

        SharedPreferences sharedpreferences;

        sharedpreferences = getApplicationContext().getSharedPreferences(Occupied.room, Context.MODE_PRIVATE);

        String room_no = sharedpreferences.getString("room_number", "");
        TextView available_room_no = (TextView) findViewById(R.id.available_room_no);

        TextView available_check_in = (TextView) findViewById(R.id.available_check_in);
        TextView available_check_out = (TextView) findViewById(R.id.available_check_out);
        TextView available_guest_name = (TextView) findViewById(R.id.available_guest_name);
        TextView available_total_amount = (TextView) findViewById(R.id.available_total_amount);


        ArrayList list = dbh.getDatabyRoom(room_no);

        available_room_no.setText(room_no);

        for (int i = 0; i < list.size(); i++) {
            available_guest_name.setText(list.get(0).toString());
            available_check_in.setText(list.get(1).toString());
            available_check_out.setText(list.get(2).toString());
            available_total_amount.setText(list.get(3).toString());
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
