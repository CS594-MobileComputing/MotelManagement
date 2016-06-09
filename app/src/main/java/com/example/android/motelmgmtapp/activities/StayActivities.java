package com.example.android.motelmgmtapp.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import com.example.android.motelmgmtapp.R;

import java.util.Calendar;

/**
 * Created by ashish on 6/7/2016.
 */
public class StayActivities extends AppCompatActivity {

    private TextView CheckInDate;
    private Button pickCheckIn;

    private TextView CheckOutDate;
    private Button pickCheckOut;

    private int year;
    private int month;
    private int day;


    public static final String StayData = "Stay";

    EditText room_no, check_in, check_out;
    RadioButton expedia,booking,hotel;
    Button b;

    static final int DATE_PICKER_IN = 1111;
    static final int DATE_PICKER_OUT = 2222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stay_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        Button chargesButton = (Button) findViewById(R.id.charge_details);
        chargesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckInDate = (TextView) findViewById(R.id.selectedcheck_in);
                pickCheckIn= (Button) findViewById(R.id.pick_date_checkIn);

                CheckOutDate = (TextView) findViewById(R.id.selectedcheck_out);
                pickCheckOut= (Button) findViewById(R.id.pick_date_checkOut);
                // Get current date by calender

                final Calendar c = Calendar.getInstance();
                year  = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day  = c.get(Calendar.DAY_OF_MONTH);

                // Button listener to show date picker dialog

                pickCheckIn.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // On button click show datepicker dialog
                        showDialog(DATE_PICKER_IN);

                    }

                });

                pickCheckOut.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        // On button click show datepicker dialog
                        showDialog(DATE_PICKER_OUT);

                    }

                });


                SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences(StayData, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedpreferences.edit();



                room_no = (EditText) findViewById(R.id.txtRoomNo);
                expedia = (RadioButton) findViewById(R.id.expedia);

                booking = (RadioButton) findViewById(R.id.bookingcom);
                hotel = (RadioButton) findViewById(R.id.hotelcom);
                expedia = (RadioButton) findViewById(R.id.expedia);
                //check_in = (EditText) findViewById(R.id.selectedcheck_in);
                //check_out = (EditText) findViewById(R.id.selectedcheck_out);



                editor.putString("room_no" ,room_no.getText().toString());
                editor.putString("expedia" , expedia.getText().toString());
                editor.putString("hotel" , hotel.getText().toString());
                editor.putString("booking" , booking.getText().toString());
                //editor.putString("check_in" ,check_in.getText().toString());

                //editor.putString("check_out" ,check_out.getText().toString());

                editor.commit();


                Intent next = new Intent(StayActivities.this, ChargesActivities.class);

                startActivity(next);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case DATE_PICKER_IN:
                return new DatePickerDialog(this, pickerListener, year, month, day);

            case DATE_PICKER_OUT:

                return new DatePickerDialog(this, pickerListener1, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day  = selectedDay;



            // Show selected date
            CheckInDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));


        }
    };

    private DatePickerDialog.OnDateSetListener pickerListener1 = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day  = selectedDay;



            // Show selected date
            CheckOutDate.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

        }
    };

}


