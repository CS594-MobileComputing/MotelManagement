package com.example.android.motelmgmtapp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.android.motelmgmtapp.activities.GuestActivities;
import com.example.android.motelmgmtapp.model.GuestDetails;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Button newReservationButton = (Button) findViewById(R.id.newreservation);
        newReservationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, GuestActivities.class);

                startActivity(next);
            }
        });

        Button availableButton = (Button) findViewById(R.id.available);
        availableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, AvailableRooms.class);

                startActivity(next);
            }
        });

        Button occupiedButton = (Button) findViewById(R.id.occupied);
        occupiedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, Occupied.class);

                startActivity(next);
            }
        });

        Button checkoutButton = (Button) findViewById(R.id.checkout);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, Checkout.class);

                startActivity(next);
            }
        });

        Button dirtyButton = (Button) findViewById(R.id.dirty);
        dirtyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, DirtyRooms.class);

                startActivity(next);
            }
        });

        /*Button stayDetailsButton = (Button) findViewById(R.id.stay_details);
        stayDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, StayDetails.class);

                startActivity(next);
            }
        });

        Button addGuestDetailsButton = (Button) findViewById(R.id.guest_details);
        addGuestDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this, GuestDetails.class);

                startActivity(next);
            }
        });*/

        /*Button buttonCreateCustomer = (Button) findViewById(R.id.buttonCreateCustomer);
        buttonCreateCustomer.setOnClickListener(new OnClickListenerCreateCustomer());

        countRecords();
        readRecords();*/
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.motelmgmtapp/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.android.motelmgmtapp/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    /*public void countRecords() {

        int recordCount = new TableControllerCustomer(this).count();

        TextView textViewRecordCount = (TextView) findViewById(R.id.textViewRecordCount);
        textViewRecordCount.setText(recordCount + " record found.");
    }

    public void readRecords() {

        LinearLayout linearLayoutRecords = (LinearLayout) findViewById(R.id.linearLayoutRecords);
        linearLayoutRecords.removeAllViews();

        List<ObjectCustomer> customers = new TableControllerCustomer(this).read();

        if (customers.size() > 0) {

            for (ObjectCustomer obj : customers) {

                int id = obj.id;

                String customerName = obj.name;
                String customerEmail = obj.email;
                String customerAddress = obj.address;
                String customerCheckIn = obj.check_in;
                String customerCheckOut = obj.check_out;

                String textViewContents = "NAME : " + customerName + " CHECK IN :  " + customerCheckIn + " CHECK OUT : " + customerCheckOut;

                TextView textViewCustomerItem = new TextView(this);
                textViewCustomerItem.setPadding(0, 10, 0, 10);
                textViewCustomerItem.setText(textViewContents);
                textViewCustomerItem.setTag(Integer.toString(id));
                textViewCustomerItem.setOnLongClickListener(new OnLongClickListenerCustomerRecord());

                linearLayoutRecords.addView(textViewCustomerItem);
            }

        }

        else {

            TextView locationItem = new TextView(this);
            locationItem.setPadding(8, 8, 8, 8);
            locationItem.setText("No records yet.");

            linearLayoutRecords.addView(locationItem);
        }

    }*/
}
