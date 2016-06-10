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
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.R;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class ChargesActivities extends AppCompatActivity {

    public static final String ChargesData = "Charge" ;
    SharedPreferences sharedpreferences;
    DatabaseHandler dbh;

    EditText total_cost ,total_amount, percentDiscount;
    boolean taxe;
    Switch s;

    SeekBar seekBar;

    Button calculate;
    BigDecimal totalAmount, discountAmount, addTaxExmpt;
    double discountPercent = 0.00;
    double switchval = 0.15;

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.charges);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        dbh = new DatabaseHandler(this);


        percentDiscount = (EditText) findViewById(R.id.discountValue);
        total_cost = (EditText) findViewById(R.id.txtTotal);
        total_amount = (EditText) findViewById(R.id.txtTotalAmount);

        seekBar = (SeekBar) findViewById(R.id.txtSeekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentDiscount.setText("%" + String.valueOf(i));
                discountPercent = i*.01;
                BigDecimal sbtl = new BigDecimal(Double.valueOf(total_cost.getText().toString()));
                discountAmount = sbtl.multiply(new BigDecimal(discountPercent));
                totalAmount = sbtl.subtract(discountAmount);
                //String tipAmountText = NumberFormat.getCurrencyInstance().format(discountAmount);
                //discountVal.setText(tipAmountText);
                String totalAmountText =  NumberFormat.getCurrencyInstance().format(totalAmount);
                total_amount.setText(totalAmountText);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        s = (Switch)   findViewById(R.id.txtTaxE);
        //final String taxe = s.toString();

        //set the switch to OFF
        s.setChecked(false);
        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if(isChecked){
                    taxe = false;

                }else{
                    taxe = true;
                }

            }
        });


        if(s.isChecked()){
            taxe = false;
        }
        else {
            taxe = true;
        }

        calculate = (Button) findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (total_cost.getText() != null) {
                    BigDecimal sbtl = new BigDecimal(Double.valueOf(total_cost.getText().toString()));
                    discountAmount = sbtl.multiply(new BigDecimal(discountPercent));
                    totalAmount = sbtl.subtract(discountAmount);
                    if(taxe == true)
                    {
                        addTaxExmpt = totalAmount.multiply(new BigDecimal (switchval)).add(totalAmount);
                        String totalAmountText =  NumberFormat.getCurrencyInstance().format(addTaxExmpt);
                        //Log.d("Hi",totalAmountText );
                        total_amount.setText(totalAmountText);
                    }
                    else{
                        String totalAmountText =  NumberFormat.getCurrencyInstance().format(totalAmount);
                        total_amount.setText(totalAmountText);
                    }
                }
            }
        });

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
                                editor.putString("discount_percentage" , percentDiscount.getText().toString());
                                editor.putString("switch" , taxe+"");

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

}

