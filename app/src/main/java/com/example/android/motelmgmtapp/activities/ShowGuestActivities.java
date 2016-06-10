package com.example.android.motelmgmtapp.activities;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.R;

/**
 * Created by ashish on 6/9/2016.
 */
public class ShowGuestActivities extends AppCompatActivity {
    public static final String GuestData = "Guest";
    SharedPreferences sharedpreferences;
    DatabaseHandler dbh;

    public static final String ChargesData = "Guest";
    SharedPreferences sharedpreferences1;


    Button credit, debit, cash;
    EditText bal;


    RadioButton pay;
    RadioGroup radioSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }
}
