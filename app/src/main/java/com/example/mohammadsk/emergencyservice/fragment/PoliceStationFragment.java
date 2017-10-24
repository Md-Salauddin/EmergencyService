package com.example.mohammadsk.emergencyservice.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mohammadsk.emergencyservice.R;

/**
 * Created by MohammadSk on 24-Oct-17.
 */

public class PoliceStationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_police_station_layout, container, false);
        return view;
    }

}
