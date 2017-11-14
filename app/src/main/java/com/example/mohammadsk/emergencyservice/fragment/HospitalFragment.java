package com.example.mohammadsk.emergencyservice.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mohammadsk.emergencyservice.Hospital;
import com.example.mohammadsk.emergencyservice.R;
import com.example.mohammadsk.emergencyservice.adapter.HospitalAdapter;

import java.util.ArrayList;

/**
 * Created by MohammadSk on 24-Oct-17.
 */

public class HospitalFragment extends Fragment {

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_hospital_layout, container, false);
        listView = (ListView) view.findViewById(R.id.hospital_list_view);

        Hospital hospitalOne = new Hospital("Ad-din Medical College","+88-02-9353391-3","2 Bara Maghbazar, Dhaka-1217, Bangladesh","Mogbazar","Dhaka","23.748479","90.405737", R.mipmap.location, R.mipmap.call);
        Hospital hospitalTwo = new Hospital("Uttara Central Hospital & Diagnostic Center","+8801711-182522","House 01, Road 07 Jashim Uddin Over Bridge, Dhaka 1230","Uttara","Dhaka","23.857718","90.402099", R.mipmap.location, R.mipmap.call);
        Hospital hospitalThree = new Hospital("Medical College For Women and Hospita","02-8913939","Road-8/9, Sector-1, Plot-4, Uttara Model Town, Dhaka-1230, Bangladesh","Uttara","Dhaka","23.858187","90.400898", R.mipmap.location, R.mipmap.call);
        Hospital hospitalFour = new Hospital("Hi-Care General Hospital","+8801778949055-6","House-24 & 26 , Lake Drive Road, Sector-7, Uttara Model Town -1230. Dhaka","Uttara","Dhaka","23.868940","90.393602", R.mipmap.location, R.mipmap.call);
        Hospital hospitalFive = new Hospital("Uttara Adhunik Medical College and Hospital","+8802-8932330","Rd No. 4, Dhaka-1230, Bangladesh","Uttara","Dhaka","23.874982","90.396778", R.mipmap.location, R.mipmap.call);


        final ArrayList<Hospital> hospitals = new ArrayList<>();
        hospitals.add(hospitalOne);
        hospitals.add(hospitalTwo);
        hospitals.add(hospitalThree);
        hospitals.add(hospitalFour);
        hospitals.add(hospitalFive);

        final HospitalAdapter hospitalAdapter = new HospitalAdapter(getContext(), R.layout.custom_hospital_list_view, hospitals);
        listView.setAdapter(hospitalAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String hospitalName = hospitals.get(i).getHospitalName().toString();
                String hospitalMobileNO = hospitals.get(i).getHospitalMobileNo().toString();
                String hospitalAddress = hospitals.get(i).getHospitalAddress().toString();
                String hospitalZone = hospitals.get(i).getHospitalZone().toString();
                String hospitalDistrict = hospitals.get(i).getHospitalDistrict().toString();

                Hospital hospital = new Hospital(hospitalName, hospitalMobileNO, hospitalAddress, hospitalZone, hospitalDistrict);
                showDetails(hospital.toString());
            }
        });

        return view;
    }

    public void showDetails(String message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
        alertDialogBuilder.setTitle("Hospital Details");
        alertDialogBuilder.setMessage(""+message);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
