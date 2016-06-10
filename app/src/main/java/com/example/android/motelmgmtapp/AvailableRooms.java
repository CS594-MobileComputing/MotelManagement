package com.example.android.motelmgmtapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.motelmgmtapp.activities.GuestActivities;
import com.example.android.motelmgmtapp.activities.ShowRoomDetails;

import java.util.ArrayList;

public class AvailableRooms extends AppCompatActivity {

    public static final String room = "RoomNumber" ;
    SharedPreferences sharedpreferences;


    DatabaseHandler dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.available_rooms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        RadioButton g1,g2;
        RadioGroup group1,group2;


        group1 = (RadioGroup) findViewById(R.id.AradioGroup1);
        group2 = (RadioGroup) findViewById(R.id.AradioGroup2);

        dbh = new DatabaseHandler(this);


        Button occupiedButton = (Button) findViewById(R.id.Arefresh);
        occupiedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<Integer> li = dbh.getOccupied();
                System.out.println("inside method");

                RadioButton rbu1 =(RadioButton)findViewById(R.id.Abtn101);
                RadioButton rbu2 =(RadioButton)findViewById(R.id.Abtn102);
                RadioButton rbu3 =(RadioButton)findViewById(R.id.Abtn103);
                RadioButton rbu4 =(RadioButton)findViewById(R.id.Abtn104);
                RadioButton rbu5 =(RadioButton)findViewById(R.id.Abtn105);
                RadioButton rbu6 =(RadioButton)findViewById(R.id.Abtn106);
                RadioButton rbu7 =(RadioButton)findViewById(R.id.Abtn107);
                RadioButton rbu8 =(RadioButton)findViewById(R.id.Abtn108);
                RadioButton rbu9 =(RadioButton)findViewById(R.id.Abtn109);
                RadioButton rbu10 =(RadioButton)findViewById(R.id.Abtn110);
                RadioButton rbu11=(RadioButton)findViewById(R.id.Abtn201);
                RadioButton rbu12=(RadioButton)findViewById(R.id.Abtn202);
                RadioButton rbu13=(RadioButton)findViewById(R.id.Abtn203);
                RadioButton rbu14=(RadioButton)findViewById(R.id.Abtn204);
                RadioButton rbu15 =(RadioButton)findViewById(R.id.Abtn205);
                RadioButton rbu16=(RadioButton)findViewById(R.id.Abtn206);
                RadioButton rbu17=(RadioButton)findViewById(R.id.Abtn207);
                RadioButton rbu18=(RadioButton)findViewById(R.id.Abtn208);
                RadioButton rbu19=(RadioButton)findViewById(R.id.Abtn209);
                RadioButton rbu20=(RadioButton)findViewById(R.id.Abtn210);

                boolean b = false;
                for(int i =0;i<li.size();i++){

                    String room = li.get(i).toString();
                    if( room.equals( rbu1.getText().toString())   ){
                        rbu1.setEnabled(false);
                        //rbu1.setBackground("#000000");
                    }
                    //System.out.print("hii"+li.get(i).toString() + "   " +rbu2);

                    if( room.toString().equals(rbu2.getText().toString())  ){
                        rbu2.setEnabled(false);


                    }
                    if( room.equals( rbu3.getText().toString())  ){
                        rbu3.setEnabled(false);
                    }
                    if( room.equals( rbu4.getText().toString())  ){
                        rbu4.setEnabled(false);
                    }

                    if( room.equals( rbu5.getText().toString())  ){
                        rbu5.setEnabled(false);
                    }
                    if( room.equals( rbu6.getText().toString())  ){
                        rbu6.setEnabled(false);
                    }
                    if( room.equals( rbu7.getText().toString())  ){
                        rbu7.setEnabled(false);
                    }
                    if( room.equals( rbu8.getText().toString())  ){
                        rbu8.setEnabled(false);
                    }
                    if( room.equals( rbu9.getText().toString())  ){
                        rbu9.setEnabled(false);
                    }
                    if( room.equals( rbu10.getText().toString())  ){
                        rbu10.setEnabled(false);
                    }
                    if( room.equals( rbu11.getText().toString())  ){
                        rbu11.setEnabled(false);
                    }
                    if( room.equals( rbu12.getText().toString())  ){
                        rbu12.setEnabled(false);
                    }
                    if( room.equals( rbu13.getText().toString())  ){
                        rbu13.setEnabled(false);
                    }
                    if( room.equals( rbu14.getText().toString())  ){
                        rbu14.setEnabled(false);
                    }
                    if( room.equals( rbu15.getText().toString())  ){
                        rbu15.setEnabled(false);
                    }
                    if( room.equals( rbu16.getText().toString())  ){
                        rbu16.setEnabled(false);
                    }if( room.equals( rbu17.getText().toString())  ){
                        rbu17.setEnabled(false);
                    }
                    if( room.equals( rbu18.getText().toString())  ){
                        rbu18.setEnabled(false);
                    }
                    if( room.equals( rbu19.getText().toString())  ){
                        rbu19.setEnabled(false);
                    }
                    if( room.equals( rbu20.getText().toString())  ){
                        rbu20.setEnabled(false);
                    }

                }

            }
        });


        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                final RadioButton rb = (RadioButton) findViewById(checkedId);
                rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedpreferences = getApplicationContext().getSharedPreferences(room, Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("room_number" ,rb.getText().toString());
                        editor.commit();

                        Intent next = new Intent(AvailableRooms.this, GuestActivities.class);

                        startActivity(next);
                    }
                });
            }
        });




        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                final RadioButton rb = (RadioButton) findViewById(checkedId);
                rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sharedpreferences = getApplicationContext().getSharedPreferences(room, Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedpreferences.edit();

                        editor.putString("room_number" ,rb.getText().toString());
                        editor.commit();

                        Intent next = new Intent(AvailableRooms.this, GuestActivities.class);

                        startActivity(next);
                    }
                });
            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



}
