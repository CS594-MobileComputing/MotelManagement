package com.example.android.motelmgmtapp.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.motelmgmtapp.R;

/**
 * Created by ashish on 6/6/2016.
 */
public class PaymentActivitiesFragment extends Fragment{

    public PaymentActivitiesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment, container, false);
    }
}
