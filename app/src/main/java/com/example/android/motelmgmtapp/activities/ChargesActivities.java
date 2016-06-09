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
import android.widget.SeekBar;
import android.widget.Switch;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.R;

public class ChargesActivities extends AppCompatActivity {

    public static final String ChargesData = "Charge" ;
    SharedPreferences sharedpreferences;
    DatabaseHandler dbh;

    EditText total_cost,total_amount;
    boolean taxe;
    float discount;

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charges);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        dbh = new DatabaseHandler(this);


        // total_cost,discount_percentage,tax_excempt,total_amount
        final SeekBar seek = (SeekBar) findViewById(R.id.txtSeekbar);
        final Switch s = (Switch)   findViewById(R.id.txtTaxE);
        final String taxe = s.toString();
        total_cost = (EditText) findViewById(R.id.txtTotal);
        total_amount   = (EditText) findViewById(R.id.txtTotalAmount);

        b = (Button) findViewById(R.id.payment);

        Button payment = (Button) findViewById(R.id.payment);
        sharedpreferences = getApplicationContext().getSharedPreferences(ChargesData, Context.MODE_PRIVATE);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b.setOnClickListener(

                        new View.OnClickListener(){
                            @Override
                            public void onClick (View v)
                            {
                                sharedpreferences = getApplicationContext().getSharedPreferences(ChargesData, Context.MODE_PRIVATE);

                                SharedPreferences.Editor editor = sharedpreferences.edit();

                                editor.putString("total_cost" ,total_cost.getText().toString());
                                editor.putString("total_amount" , total_amount.getText().toString());
                                editor.putString("seek" , seek.toString());
                                editor.putString("switch" , taxe);

                                editor.commit();
                                Intent next = new Intent(ChargesActivities.this, PaymentActivities.class);
                                startActivity(next);
                            }
                        }
                );



            }

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charges);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button paymentButton = (Button) findViewById(R.id.payment);
        paymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(ChargesActivities.this, PaymentActivities.class);

                startActivity(next);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
*/

}
