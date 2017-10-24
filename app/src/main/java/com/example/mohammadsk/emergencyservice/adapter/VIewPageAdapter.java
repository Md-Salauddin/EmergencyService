package com.example.mohammadsk.emergencyservice.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by MohammadSk on 24-Oct-17.
 */

public class VIewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentList = new ArrayList<>();

    public VIewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }

}
