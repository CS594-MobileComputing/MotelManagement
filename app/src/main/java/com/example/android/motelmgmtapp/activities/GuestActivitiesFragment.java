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
public class GuestActivitiesFragment extends Fragment {

    public GuestActivitiesFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_guest_details, container, false);
    }
}
