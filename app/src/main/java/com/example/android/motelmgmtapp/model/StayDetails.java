package com.example.android.motelmgmtapp.model;

import java.util.Date;

/**
 * Created by Ashish on 04-06-2016.
 */
public class StayDetails {

    int id,room_number;
    public String source;
    public Date check_in,check_out;

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StayDetails(){

    }

    public StayDetails(int id, int room_number, String source, Date check_in, Date check_out) {
        this.id = id;
        this.room_number = room_number;
        this.source = source;
        this.check_in = check_in;
        this.check_out = check_out;
    }
}