package com.example.android.motelmgmtapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dhanashri on 18-05-2016.
 */

    public class TableControllerCustomer extends DatabaseHandler {

        public TableControllerCustomer(Context context) {
            super(context);
        }

    public boolean create(ObjectCustomer objectCustomer) {

        ContentValues values = new ContentValues();

        values.put("name", objectCustomer.name);
        values.put("email", objectCustomer.email);
        values.put("address", objectCustomer.address);
        values.put("check_in", objectCustomer.check_in);
        values.put("check_out", objectCustomer.check_out);

        SQLiteDatabase db = this.getWritableDatabase();

        boolean createSuccessful = db.insert("customers", null, values) > 0;
        db.close();

        return createSuccessful;
    }

    public int count() {

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM customers";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();

        return recordCount;

    }

    public List<ObjectCustomer> read() {

        List<ObjectCustomer> recordsList = new ArrayList<ObjectCustomer>();

        String sql = "SELECT * FROM customers ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String customerName = cursor.getString(cursor.getColumnIndex("name"));
                String customerEmail = cursor.getString(cursor.getColumnIndex("email"));
                String customerAddress = cursor.getString(cursor.getColumnIndex("address"));
                String customerCheckIn = cursor.getString(cursor.getColumnIndex("check_in"));
                String customerCheckOut = cursor.getString(cursor.getColumnIndex("check_out"));

                ObjectCustomer objectCustomer = new ObjectCustomer();
                objectCustomer.id = id;
                objectCustomer.name = customerName;
                objectCustomer.email = customerEmail;
                objectCustomer.address = customerAddress;
                objectCustomer.check_in = customerCheckIn;
                objectCustomer.check_out = customerCheckOut;

                recordsList.add(objectCustomer);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return recordsList;
    }

    public ObjectCustomer readSingleRecord(int customerId) {

        ObjectCustomer objectCustomer = null;

        String sql = "SELECT * FROM customers WHERE id = " + customerId;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.moveToFirst()) {

            int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));

            String customerName = cursor.getString(cursor.getColumnIndex("name"));
            String customerEmail = cursor.getString(cursor.getColumnIndex("email"));
            String customerAddress = cursor.getString(cursor.getColumnIndex("address"));
            String customerCheckIn = cursor.getString(cursor.getColumnIndex("check_in"));
            String customerCheckOut = cursor.getString(cursor.getColumnIndex("check_out"));

            objectCustomer = new ObjectCustomer();
            objectCustomer.id = id;
            objectCustomer.name = customerName;
            objectCustomer.email = customerEmail;
            objectCustomer.address = customerAddress;
            objectCustomer.check_in = customerCheckIn;
            objectCustomer.check_out = customerCheckOut;

        }

        cursor.close();
        db.close();

        return objectCustomer;

    }

    public boolean update(ObjectCustomer objectCustomer) {

        ContentValues values = new ContentValues();

        values.put("name", objectCustomer.name);
        values.put("email", objectCustomer.email);
        values.put("address", objectCustomer.address);
        values.put("check_in", objectCustomer.check_in);
        values.put("check_out", objectCustomer.check_out);

        String where = "id = ?";

        String[] whereArgs = { Integer.toString(objectCustomer.id) };

        SQLiteDatabase db = this.getWritableDatabase();

        boolean updateSuccessful = db.update("customers", values, where, whereArgs) > 0;
        db.close();

        return updateSuccessful;

    }

}