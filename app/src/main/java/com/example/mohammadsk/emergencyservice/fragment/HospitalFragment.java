package com.example.mohammadsk.emergencyservice.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.mohammadsk.emergencyservice.interface_api_call.ApiInterface;
import com.example.mohammadsk.emergencyservice.model.Hospital;
import com.example.mohammadsk.emergencyservice.R;
import com.example.mohammadsk.emergencyservice.adapter.HospitalAdapter;
import com.example.mohammadsk.emergencyservice.rertrofit.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by MohammadSk on 24-Oct-17.
 */

public class HospitalFragment extends Fragment {

    private ListView listView;
    private ApiInterface apiInterface;
    private List<Hospital> hospitals = new ArrayList<>();
    private ArrayList<Hospital> hospitalsData = new ArrayList<>();
    private Hospital hospital;
    private HospitalAdapter hospitalAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_hospital_layout, container, false);
        listView = (ListView) view.findViewById(R.id.hospital_list_view);

        // create interface instance object
        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Hospital>> call = apiInterface.getHospitals();
        call.enqueue(new Callback<List<Hospital>>() {
            @Override
            public void onResponse(Call<List<Hospital>> call, Response<List<Hospital>> response) {
                hospitals = response.body();

                if (response.isSuccessful())
                    showIntoListView();
                else
                    Toast.makeText(getContext(),"Failed to load data",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Hospital>> call, Throwable t) {
                Toast.makeText(getContext(),"Failed to load data",Toast.LENGTH_SHORT).show();
            }
        });

        // set onclick listener when a list view being pressed
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.search_bar);

        SearchView searchView = new SearchView(getContext());
        MenuItemCompat.setActionView(searchItem, searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                hospitalAdapter.filter(s);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

    // method : show hospital details
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

    // show into list view
    public void showIntoListView() {

        for (int i = 0; i < hospitals.size(); i++) {
            String name = hospitals.get(i).getHospitalName();
            String mobileNo = hospitals.get(i).getHospitalMobileNo();
            String address = hospitals.get(i).getHospitalAddress();
            String zone = hospitals.get(i).getHospitalZone();
            String district = hospitals.get(i).getHospitalDistrict();
            String latitude = hospitals.get(i).getHospitalLatitude();
            String longitude = hospitals.get(i).getHospitalLongitude();

            hospital = new Hospital(name, mobileNo, address, zone, district, latitude, longitude, R.mipmap.location, R.mipmap.call);
            hospitalsData.add(hospital);
        }
        hospitalAdapter = new HospitalAdapter(getContext(), R.layout.custom_hospital_list_view, hospitalsData);
        listView.setAdapter(hospitalAdapter);
    }

}
