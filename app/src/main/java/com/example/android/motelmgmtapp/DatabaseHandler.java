package com.example.android.motelmgmtapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Dhanashri on 18-05-2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "Motel_Management";
    //protected static final String DATABASE_NAME = "Motel";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //String name,address, email,street,city,state,pincode,country;

        String guest_details = "CREATE TABLE GUESTS_DETAILS " +
                "( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fname TEXT, " +
                "lname TEXT, " +
                "id_num TEXT, " +
                "email TEXT, " +
                "address TEXT, " +
                "street TEXT, " +
                "city TEXT, " +
                "state TEXT, " +
                "pincode TEXT, " +
                "country TEXT ) ";

        db.execSQL(guest_details);

        String stay_details = "CREATE TABLE STAY_DETAILS " +
                "( id INTEGER PRIMARY KEY , " +
                "check_in TEXT, " +
                "check_out TEXT, " +
                "room TEXT, " +
                "source TEXT, " +
                "FOREIGN KEY(id) REFERENCES GUESTS_DETAILS(id)) ";

        db.execSQL(stay_details);

        //total_cost,discount_percentage,tax_excempt,total_amount;

        String charge_details = "CREATE TABLE CHARGE_DETAILS " +
                "( id INTEGER PRIMARY KEY , " +
                "total_cost TEXT, " +
                "discount_percentage TEXT, " +
                "tax_excempt TEXT, " +
                "total_amount TEXT, " +
                "FOREIGN KEY(id) REFERENCES GUESTS_DETAILS(id)) ";

        db.execSQL(charge_details);


        String payment_details = "CREATE TABLE PAYMENT_DETAILS " +
                "( id INTEGER PRIMARY KEY , " +
                "balance_due TEXT, " +
                "payment_type TEXT, " +
                "FOREIGN KEY(id) REFERENCES GUESTS_DETAILS(id)) ";

        db.execSQL(payment_details);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        String sql1 = "DROP TABLE IF EXISTS GUESTS_DETAILS";
        db.execSQL(sql1);

        String sql2 = "DROP TABLE IF EXISTS STAY_DETAILS";
        db.execSQL(sql2);

        String sql3 = "DROP TABLE IF EXISTS CHARGE_DETAILS";
        db.execSQL(sql3);


        String sql = "DROP TABLE IF EXISTS PAYMENT_DETAILS";
        db.execSQL(sql);


        onCreate(db);
    }

    public int getLastInsertedId(SQLiteDatabase db){


        String query = "SELECT * FROM GUESTS_DETAILS WHERE ID = (SELECT MAX(ID) FROM GUESTS_DETAILS);";;
        Cursor c = db.rawQuery(query, null);
        int lastInsertedId = 0;
        while(c.moveToNext()){

            lastInsertedId = c.getInt(0);

        }
        c.close();

        return lastInsertedId;

    }

    public boolean insertData(String fname,String lname,String address,String email,String id,String street,String state,String city,String pincode,String coutry)
    {

     SQLiteDatabase db = this.getWritableDatabase();

        //onUpgrade(db,1,2);

        ContentValues cv= new ContentValues();
        cv.put("fname",fname);
        cv.put("lname",lname);
        cv.put("address",address);
        cv.put("email",email);
        cv.put("id_num",id);
        cv.put("street",street);
        cv.put("city",city);
        cv.put("state",state);
        cv.put("pincode",pincode);
        cv.put("country",coutry);
        Long result = db.insert("GUESTS_DETAILS",null,cv);

        //db.execSQL(max_id);



        if (result==-1)
            return false;
        else return true;
    }




    public boolean insert_stay_details(String room_no,String expedia,String hotel,String booking,String check_in,String check_out)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        String source="";

        if(expedia != null){
            source = "expedia";
        }
        else if (booking!= null){
            source="booking.com";
        }
        else if(hotel!=null) {
            source = "hotel.com";
        }

        int max_id = getLastInsertedId(db);

        cv.put("id",max_id);
        cv.put("check_in",check_in);
        cv.put("check_out",check_out);
        cv.put("room",room_no);
        cv.put("source",source);

        Long result = db.insert("STAY_DETAILS",null,cv);

        if (result==-1)
            return false;
        else return true;
    }

    public boolean insert_payment_details(String bal,String credit,String debit,String cash){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        String payment="";

        if(credit != null){
            payment = "credit";
        }
        else if (debit!= null){
            payment="debit";
        }
        else if(cash!=null) {
            payment = "cash";
        }


        int max_id = getLastInsertedId(db);
        cv.put("id",max_id);
        cv.put("balance_due", bal  );
        cv.put("payment_type",payment);
        Long result = db.insert("PAYMENT_DETAILS",null,cv);

        if (result==-1)
            return false;
        else return true;
    }




    public boolean insert_charge_details(String total_cost,String total_amount,String seek,String swi)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv= new ContentValues();

        int max_id = getLastInsertedId(db);

        if(max_id == 0 ){
            max_id = 1;
        }

        cv.put("id",max_id);
        cv.put("total_cost",total_cost   );
        cv.put("discount_percentage",seek);
        cv.put("tax_excempt",swi);
        cv.put("total_amount",total_amount);
        Long result = db.insert("CHARGE_DETAILS",null,cv);


        //int max_id = getLastInsertedId(db);
        //db.execSQL(max_id);



        if (result==-1)
            return false;
        else return true;
    }


}