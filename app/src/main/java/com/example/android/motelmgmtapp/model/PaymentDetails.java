package com.example.android.motelmgmtapp.model;

/**
 * Created by ashish on 6/6/2016.
 */
public class PaymentDetails {

    int id;
    public float balance_due;
    public String payment_type;


    public PaymentDetails(int id, float balance_due, String payment_type) {
        this.id = id;
        this.balance_due = balance_due;
        this.payment_type = payment_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance_due() {
        return balance_due;
    }

    public void setBalance_due(float balance_due) {
        this.balance_due = balance_due;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }
}
