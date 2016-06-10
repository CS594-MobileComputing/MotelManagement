package com.example.android.motelmgmtapp.activities;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.R;
import com.google.android.gms.common.api.GoogleApiClient;

import java.math.BigDecimal;

public class Facilities extends AppCompatActivity {

        private TextView amountC, amountT, amountO, totalC, totalT, totalO, calamt;
        private EditText numC, numT, numO;
        private Button addFacilitiesButton;
        private BigDecimal subT, amount, totalA, amt, c, o, t;

        private EditText room;

        public static final String FacilityData = "Facility";
        SharedPreferences sharedpreferences;
        DatabaseHandler dbh;
        /**
         * ATTENTION: This was auto-generated to implement the App Indexing API.
         * See https://g.co/AppIndexing/AndroidStudio for more information.
         */
        private GoogleApiClient client;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.facilities);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            dbh = new DatabaseHandler(this);

            amountC = (TextView) findViewById(R.id.amt_C);
            amountT = (TextView) findViewById(R.id.amt_T);
            amountO = (TextView) findViewById(R.id.amt_O);

            numC = (EditText) findViewById(R.id.noC);
            numT = (EditText) findViewById(R.id.noT);
            numO = (EditText) findViewById(R.id.noO);

            totalC = (TextView) findViewById(R.id.totC);
            totalT = (TextView) findViewById(R.id.totT);
            totalO = (TextView) findViewById(R.id.totO);

            calamt = (TextView) findViewById(R.id.calculateAmount);

            room = (EditText) findViewById(R.id.roomNo);

            numC.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        BigDecimal sbtl = new BigDecimal(Double.valueOf(numC.getText().toString()));
                        totalA = sbtl.multiply(new BigDecimal(amountC.getText().toString()));
                        totalC.setText(totalA.toString());
                    }
                }
            });

            numO.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        BigDecimal sbtl = new BigDecimal(Double.valueOf(numO.getText().toString()));
                        totalA = sbtl.multiply(new BigDecimal(amountO.getText().toString()));
                        //String totalAmountText =  NumberFormat.getCurrencyInstance().format(totalA);
                        totalO.setText(totalA + "");
                    }
                }
            });

            numT.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        BigDecimal sbtl = new BigDecimal(Double.valueOf(numT.getText().toString()));
                        totalA = sbtl.multiply(new BigDecimal(amountT.getText().toString()));
                        //String totalAmountText =  NumberFormat.getCurrencyInstance().format(totalA);
                        totalT.setText(totalA + "");
                    }
                }
            });


            Button totalbutton = (Button) findViewById(R.id.calculate);
            totalbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Float sum = Float.parseFloat(totalC.getText().toString()) + Float.parseFloat(totalT.getText().toString()) + Float.parseFloat(totalO.getText().toString());
                    calamt.setText(sum.toString());

                    dbh.insert_facility_details(room.getText().toString(), totalC.getText().toString(), totalT.getText().toString(), totalO.getText().toString(), calamt.getText().toString());

                }
            });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
