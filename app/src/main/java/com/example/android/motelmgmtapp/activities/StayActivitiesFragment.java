package com.example.android.motelmgmtapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.motelmgmtapp.R;

/**
 * Created by ashish on 6/7/2016.
 */
public class StayActivitiesFragment extends Fragment {

    public StayActivitiesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stay_details, container, false);
    }
}

