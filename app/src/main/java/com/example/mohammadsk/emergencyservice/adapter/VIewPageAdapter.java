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
    private ArrayList<String> tabNameList = new ArrayList<>();

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

    @Override
    public CharSequence getPageTitle(int position) {
        return tabNameList.get(position);
    }

    // add fragment and tab name
    public void addFragment(Fragment fragment, String tabName){
        fragmentList.add(fragment);
        tabNameList.add(tabName);
    }

}
