package com.example.android.motelmgmtapp.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.motelmgmtapp.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class DirtyRoomFragment extends Fragment {

    public DirtyRoomFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dirty_room, container, false);
    }
}
