package com.example.android.motelmgmtapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.R;

import java.io.File;

/**
 * Created by ashish on 6/6/2016.
 */
public class GuestActivities extends ActionBarActivity {

    static final int  REQUEST_IMAGE_CAPTURE = 1 ;
    ImageView image;
    public static final String GuestData = "Guest" ;
    SharedPreferences sharedpreferences;
    DatabaseHandler dbh;

    EditText fname,lname,address,id_num,email,street,city,state,pincode,country;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        dbh = new DatabaseHandler(this);
        //id_num,email,street,city,state,pincode,country;
        fname = (EditText) findViewById(R.id.txtFirstName);
        lname   = (EditText) findViewById(R.id.txtLastName);
        address   = (EditText) findViewById(R.id.txtAddress);

        email   = (EditText) findViewById(R.id.txtEmailId);
        id_num = (EditText) findViewById(R.id.txtid);
        street   = (EditText) findViewById(R.id.txtStreet);
        city   = (EditText) findViewById(R.id.txtCity);
        state   = (EditText) findViewById(R.id.txtState);
        pincode   = (EditText) findViewById(R.id.txtPincode);
        country   = (EditText) findViewById(R.id.txtCountry);

        b = (Button) findViewById(R.id.stay_details);

        Button stayDetailsButton = (Button) findViewById(R.id.stay_details);
        sharedpreferences = getApplicationContext().getSharedPreferences(GuestData, Context.MODE_PRIVATE);

        stayDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            b.setOnClickListener(

                    new View.OnClickListener(){
                        @Override
                        public void onClick (View v)
                        {
                            sharedpreferences = getApplicationContext().getSharedPreferences(GuestData, Context.MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString("fname" ,fname.getText().toString());
                            editor.putString("lname" , lname.getText().toString());
                            editor.putString("address" , address.getText().toString());
                            editor.putString("email" , email.getText().toString());
                            editor.putString("id" ,id_num.getText().toString());
                            editor.putString("street" , street.getText().toString());
                            editor.putString("city" , city.getText().toString());
                            editor.putString("pincode" ,pincode.getText().toString());
                            editor.putString("state" , state.getText().toString());
                            editor.putString("country" ,country.getText().toString());

                            editor.commit();
                            Intent next = new Intent(GuestActivities.this, StayActivities.class);
                            startActivity(next);
                        }
                    }
            );



            }

        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button cameraButton = (Button)findViewById(R.id.takePic);
        image = (ImageView)findViewById(R.id.image);
    } //https://www.youtube.com/watch?v=6Z6k7X2vfhk Reference to take picture
    private File imageFile;
    public void takePic(View v) {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       /* imageFile = new File(Environment.
                getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                "ID" + r.nextInt() + ".png");
        Uri tempuri = Uri.fromFile(imageFile);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, tempuri);
        intent.putExtra(MediaStore.ACTION_VIDEO_CAPTURE, 1);*/
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            Bundle extras =data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            image.setImageBitmap(photo);
        }
    }
}



