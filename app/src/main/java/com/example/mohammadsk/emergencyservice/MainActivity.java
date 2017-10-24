package com.example.mohammadsk.emergencyservice;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.mohammadsk.emergencyservice.adapter.VIewPageAdapter;
import com.example.mohammadsk.emergencyservice.fragment.HospitalFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // assign with xml
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        // assign with xml
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setDataToViewPager();
        // set view pager to tab layout
        tabLayout.setupWithViewPager(viewPager);


    }


    private void setDataToViewPager() {
        VIewPageAdapter viewPagerAdapter = new VIewPageAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new HospitalFragment(), "Hospital");
        viewPager.setAdapter(viewPagerAdapter);
    }

}
