package com.example.android.motelmgmtapp.model;

/**
 * Created by ashish on 6/6/2016.
 */
public class ChargeDetails {

    int id;
    public float total_cost,discount_percentage,tax_excempt,total_amount;

    //public ChargeDetails

    public ChargeDetails(int id, float total_cost, float discount_percentage, float tax_excempt, float total_amount) {
        this.id = id;
        this.total_cost = total_cost;
        this.discount_percentage = discount_percentage;
        this.tax_excempt = tax_excempt;
        this.total_amount = total_amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(float total_cost) {
        this.total_cost = total_cost;
    }

    public float getDiscount_percentage() {
        return discount_percentage;
    }

    public void setDiscount_percentage(float discount_percentage) {
        this.discount_percentage = discount_percentage;
    }

    public float getTax_excempt() {
        return tax_excempt;
    }

    public void setTax_excempt(float tax_excempt) {
        this.tax_excempt = tax_excempt;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }
}
