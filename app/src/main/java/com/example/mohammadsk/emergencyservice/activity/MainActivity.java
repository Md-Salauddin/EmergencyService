package com.example.mohammadsk.emergencyservice.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mohammadsk.emergencyservice.R;
import com.example.mohammadsk.emergencyservice.adapter.VIewPageAdapter;
import com.example.mohammadsk.emergencyservice.fragment.FireServiceFragment;
import com.example.mohammadsk.emergencyservice.fragment.HospitalFragment;
import com.example.mohammadsk.emergencyservice.fragment.PoliceStationFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] icons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icons = new int[]{
                R.drawable.ic_hospital,
                R.drawable.ic_fire_service,
                R.drawable.ic_police_station
        };

        // assign with xml
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        // assign with xml
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setDataToViewPager();
        // set view pager to tab layout
        tabLayout.setupWithViewPager(viewPager);
        // set icon
        tabLayout.getTabAt(0).setIcon(icons[0]);
        tabLayout.getTabAt(1).setIcon(icons[1]);
        tabLayout.getTabAt(2).setIcon(icons[2]);

    }


    private void setDataToViewPager() {
        // create object of a class
        VIewPageAdapter viewPagerAdapter = new VIewPageAdapter(getSupportFragmentManager());
        // add fragment class with title
        viewPagerAdapter.addFragment(new HospitalFragment());
        viewPagerAdapter.addFragment(new FireServiceFragment());
        viewPagerAdapter.addFragment(new PoliceStationFragment());
        // set into adapter
        viewPager.setAdapter(viewPagerAdapter);

    }

}
