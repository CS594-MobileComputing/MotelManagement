package com.example.android.motelmgmtapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.MainActivity;
import com.example.android.motelmgmtapp.R;
//import com.example.android.motelmgmtapp.StayDetails;
import com.example.android.motelmgmtapp.controller.GuestController;
import com.example.android.motelmgmtapp.model.GuestDetails;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by ashish on 6/6/2016.
 */
public class PaymentActivities extends AppCompatActivity {
    public static final String GuestData = "Guest";
    SharedPreferences sharedpreferences;
    DatabaseHandler dbh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        dbh = new DatabaseHandler(this);



        final Button paymentButton = (Button) findViewById(R.id.rent_room);
        sharedpreferences = getApplicationContext().getSharedPreferences(GuestData, Context.MODE_PRIVATE);




        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                paymentButton.setOnClickListener(

                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences(GuestActivities.GuestData, Context.MODE_PRIVATE);

                                String customerFirstName = sharedpreferences.getString("fname", "");
                                String customerLastName = sharedpreferences.getString("lname", "");
                                String customerAddress = sharedpreferences.getString("address", "");
                                String customerEmail = sharedpreferences.getString("email", "");
                                String customerID = sharedpreferences.getString("id", "");
                                String customerStreet = sharedpreferences.getString("street", "");
                                String customerCity = sharedpreferences.getString("city", "");
                                String customerState = sharedpreferences.getString("state", "");
                                String customerPincode = sharedpreferences.getString("pincode", "");
                                String customerCountry = sharedpreferences.getString("country", "");


                                //SharedPreferences shared_stay = getApplicationContext().getSharedPreferences(StayActivities.StayData, Context.MODE_PRIVATE);

                                /*String roomno = shared_stay.getString("room_no", "");
                                String expedia = shared_stay.getString("expedia", "");
                                String hotel = shared_stay.getString("hotel", "");
                                String booking = shared_stay.getString("booking", "");
                                String check_in = shared_stay.getString("check_in", "");
                                String check_out = sharedpreferences.getString("check_out", "");
*/

//                                boolean isInserted_for_stay = dbh.insert_stay_details(roomno,expedia,hotel,booking,check_in,check_out);

                                boolean isInserted = dbh.insertData(customerFirstName, customerLastName,customerID,customerEmail,customerAddress,customerStreet,customerCity,customerState,customerPincode,customerCountry);

  /*                              if (isInserted_for_stay == true) {
                                    Toast.makeText(PaymentActivities.this, "DATA INS", Toast.LENGTH_LONG).show();
                                    //Intent next = new Intent(PaymentActivities.this, MainActivity.class);
                                    //startActivity(next);
                                }
*/

                                if (isInserted == true) {
                                    Toast.makeText(PaymentActivities.this, "DATA INS", Toast.LENGTH_LONG).show();
                                    Intent next = new Intent(PaymentActivities.this, MainActivity.class);
                                    startActivity(next);
                                } else {
                                    Toast.makeText(PaymentActivities.this, "DATA NOT INS", Toast.LENGTH_LONG).show();
                                    Intent next = new Intent(PaymentActivities.this, MainActivity.class);
                                    startActivity(next);
                                }
                            }
                        });
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
   // getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        });
    }}