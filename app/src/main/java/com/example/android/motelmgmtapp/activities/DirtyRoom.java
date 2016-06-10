package com.example.android.motelmgmtapp.activities;

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

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.R;

import java.util.ArrayList;

public class DirtyRoom extends AppCompatActivity {

    public static final String room = "RoomNumber" ;
    SharedPreferences sharedpreferences;

    DatabaseHandler dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dirty_room);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        RadioButton g1,g2;
        RadioGroup group1,group2;

        dbh = new DatabaseHandler(this);

        Button b;

        group1 = (RadioGroup) findViewById(R.id.DradioGroup1);
        group2 = (RadioGroup) findViewById(R.id.DradioGroup2);



        System.out.println("aaaa"+ dbh.getOccupied().size());

        //RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);




        Button occupiedButton = (Button) findViewById(R.id.Drefresh);
        occupiedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ArrayList<Integer> li = dbh.getDirty();
                System.out.println("inside method");

                RadioButton rbu1 =(RadioButton)findViewById(R.id.Dbtn101);
                RadioButton rbu2 =(RadioButton)findViewById(R.id.Dbtn102);
                RadioButton rbu3 =(RadioButton)findViewById(R.id.Dbtn103);
                RadioButton rbu4 =(RadioButton)findViewById(R.id.Dbtn104);
                RadioButton rbu5 =(RadioButton)findViewById(R.id.Dbtn105);
                RadioButton rbu6 =(RadioButton)findViewById(R.id.Dbtn106);
                RadioButton rbu7 =(RadioButton)findViewById(R.id.Dbtn107);
                RadioButton rbu8 =(RadioButton)findViewById(R.id.Dbtn108);
 ;;                RadioButton rbu9 =(RadioButton)findViewById(R.id.Dbtn109);
                RadioButton rbu10 =(RadioButton)findViewById(R.id.Dbtn110);
                RadioButton rbu11=(RadioButton)findViewById(R.id.Dbtn201);
                RadioButton rbu12=(RadioButton)findViewById(R.id.Dbtn202);
                RadioButton rbu13=(RadioButton)findViewById(R.id.Dbtn203);
                RadioButton rbu14=(RadioButton)findViewById(R.id.Dbtn204);
                RadioButton rbu15 =(RadioButton)findViewById(R.id.Dbtn205);
                RadioButton rbu16=(RadioButton)findViewById(R.id.Dbtn206);
                RadioButton rbu17=(RadioButton)findViewById(R.id.Dbtn207);
                RadioButton rbu18=(RadioButton)findViewById(R.id.Dbtn208);
                RadioButton rbu19=(RadioButton)findViewById(R.id.Dbtn209);
                RadioButton rbu20=(RadioButton)findViewById(R.id.Dbtn210);


                for(int i =0;i<li.size();i++){

                    String room = li.get(i).toString();
                    if( room.equals( rbu1.getText().toString())  ){
                        rbu1.setEnabled(true);
                    }
                    //System.out.print("hii"+li.get(i).toString() + "   " +rbu2);

                    if( room.toString().equals(rbu2.getText().toString())  ){
                        rbu2.setEnabled(true);
                    }
                    if( room.equals( rbu3.getText().toString())  ){
                        rbu3.setEnabled(true);
                    }
                    if( room.equals( rbu4.getText().toString())  ){
                        rbu4.setEnabled(true);
                    }

                    if( room.equals( rbu5.getText().toString())  ){
                        rbu5.setEnabled(true);
                    }
                    if( room.equals( rbu6.getText().toString())  ){
                        rbu6.setEnabled(true);
                    }
                    if( room.equals( rbu7.getText().toString())  ){
                        rbu7.setEnabled(true);
                    }
                    if( room.equals( rbu8.getText().toString())  ){
                        rbu8.setEnabled(true);
                    }
                    if( room.equals( rbu9.getText().toString())  ){
                        rbu9.setEnabled(true);
                    }
                    if( room.equals( rbu10.getText().toString())  ){
                        rbu10.setEnabled(true);
                    }
                    if( room.equals( rbu11.getText().toString())  ){
                        rbu11.setEnabled(true);
                    }
                    if( room.equals( rbu12.getText().toString())  ){
                        rbu12.setEnabled(true);
                    }
                    if( room.equals( rbu13.getText().toString())  ){
                        rbu13.setEnabled(true);
                    }
                    if( room.equals( rbu14.getText().toString())  ){
                        rbu14.setEnabled(true);
                    }
                    if( room.equals( rbu15.getText().toString())  ){
                        rbu15.setEnabled(true);
                    }
                    if( room.equals( rbu16.getText().toString())  ){
                        rbu16.setEnabled(true);
                    }if( room.equals( rbu17.getText().toString())  ){
                        rbu17.setEnabled(true);
                    }
                    if( room.equals( rbu18.getText().toString())  ){
                        rbu18.setEnabled(true);
                    }
                    if( room.equals( rbu19.getText().toString())  ){
                        rbu19.setEnabled(true);
                    }
                    if( room.equals( rbu20.getText().toString())  ){
                        rbu20.setEnabled(true);
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



                        dbh.setAvailable(rb.getText().toString());
                        rb.setEnabled(false);

                        Intent next = new Intent(DirtyRoom.this, DirtyRoom.class);
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


                        dbh.setRoomDirty(rb.getText().toString());
                        rb.setEnabled(false);

                        Intent next = new Intent(DirtyRoom.this, DirtyRoom.class);
                        startActivity(next);
                    }
                });
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
