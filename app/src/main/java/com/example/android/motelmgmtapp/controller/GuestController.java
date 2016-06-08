package com.example.android.motelmgmtapp.controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.motelmgmtapp.DatabaseHandler;
import com.example.android.motelmgmtapp.model.GuestDetails;


/**
 * Created by ashish on 06-06-2016.
 */

public class GuestController extends DatabaseHandler {

    public GuestController(Context context) {
        super(context);
    }

    public boolean create(GuestDetails objectCustomer) {

        ContentValues values = new ContentValues();

        values.put("fname", objectCustomer.fname);
        values.put("lname", objectCustomer.lname);
        values.put("address", objectCustomer.address);
        values.put("email", objectCustomer.email);
        values.put("street", objectCustomer.street);
        values.put("city", objectCustomer.city);
        values.put("state", objectCustomer.state);
        values.put("pincode", objectCustomer.pincode);
        values.put("country", objectCustomer.country);


        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("GUESTS", null, values) > 0;
        db.close();

        return createSuccessful ;
    }
}