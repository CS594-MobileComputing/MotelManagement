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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.MainActivity;
import com.example.android.motelmgmtapp.R;

/**
 * Created by ashish on 6/6/2016.
 */
public class PaymentActivities extends AppCompatActivity {
    public static final String GuestData = "Guest";
    SharedPreferences sharedpreferences;
    DatabaseHandler dbh;

    public static final String ChargesData = "Guest";
    SharedPreferences sharedpreferences1;



    Button credit,debit,cash;
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


        dbh = new DatabaseHandler(this);



        final Button paymentButton = (Button) findViewById(R.id.rent_room);
        sharedpreferences = getApplicationContext().getSharedPreferences(GuestData, Context.MODE_PRIVATE);

        sharedpreferences1 = getApplicationContext().getSharedPreferences(ChargesData, Context.MODE_PRIVATE);


        radioSource = (RadioGroup) findViewById(R.id.radioSource);


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


                                SharedPreferences shared_charge =
                                getApplicationContext().getSharedPreferences(ChargesActivities.ChargesData, Context.MODE_PRIVATE);

                                String total_cost = shared_charge.getString("total_cost", "");
                                String total_amount = shared_charge.getString("total_amount", "");
                                String seek = shared_charge.getString("seek", "");
                                String swi = shared_charge.getString("switch", "");

                                int selectedId = radioSource.getCheckedRadioButtonId();
                                // find the radiobutton by returned id
                                RadioButton pay = (RadioButton) findViewById(selectedId);

                                SharedPreferences shared_stay =
                                        getApplicationContext().getSharedPreferences(StayActivities.StayData, Context.MODE_PRIVATE);

                                String room_no = shared_stay.getString("room_no", "");
                                String check_in = shared_stay.getString("check_in", "");
                                String check_out = shared_stay.getString("check_out", "");
                                String source = shared_stay.getString("source", "");


                                boolean isInserted = dbh.insertData(customerFirstName, customerLastName,customerID,customerEmail,customerAddress,customerStreet,customerCity,customerState,customerPincode,customerCountry);

                                boolean insertStayDetails = dbh.insert_stay_details(room_no,check_in,check_out,source);
                                boolean insertChargeDetails = dbh.insert_charge_details(total_cost,total_amount,seek,swi);



                                bal = (EditText) findViewById(R.id.editText);

                                String balance = bal.getText().toString();
                                String paym = pay.getText().toString();

                                boolean insertPaymentDetails = dbh.insert_payment_details(balance,paym);


                                if (isInserted == true && insertChargeDetails == true && insertStayDetails == true &&
                                insertPaymentDetails== true && insertPaymentDetails == true) {
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