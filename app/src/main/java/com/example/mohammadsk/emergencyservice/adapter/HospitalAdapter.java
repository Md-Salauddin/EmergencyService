package com.example.mohammadsk.emergencyservice.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mohammadsk.emergencyservice.model.Hospital;
import com.example.mohammadsk.emergencyservice.R;

import java.util.List;

/**
 * Created by MohammadSk on 12-Nov-17.
 */

public class HospitalAdapter extends ArrayAdapter<Hospital> {

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    static class ViewHolder {
        TextView hospital_name;
        TextView hospital_mobile_no;
        ImageView show_icon;
        ImageView call_icon;
    }

    public HospitalAdapter(@NonNull Context context, int resource, @NonNull List<Hospital> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final String hospitalName = getItem(position).getHospitalName();
        final String hospitalMobileNo = getItem(position).getHospitalMobileNo();
        final String hospitalAddress = getItem(position).getHospitalAddress();
        final String hospitalZone = getItem(position).getHospitalZone();
        final String hospitalDistrict = getItem(position).getHospitalDistrict();
        final String hospitalLatitude = getItem(position).getHospitalLatitude();
        final String hospitalLongitude = getItem(position).getHospitalLongitude();

        int showLocationIcon = getItem(position).getShowLocationIcon();
        int callIcon = getItem(position).getCallIcon();

        Hospital hospital = new Hospital(hospitalName, hospitalMobileNo, hospitalAddress, hospitalZone, hospitalDistrict, hospitalLatitude, hospitalLongitude, showLocationIcon, callIcon);

        ViewHolder holder;
        final View result;

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(R.layout.custom_hospital_list_view, parent, false);

        holder = new ViewHolder();

        holder.hospital_name = (TextView) convertView.findViewById(R.id.hospital_name_field);
        holder.hospital_mobile_no = (TextView) convertView.findViewById(R.id.hospital_phoneNumber);
        holder.show_icon =  (ImageView) convertView.findViewById(R.id.hospital_location_button);
        holder.call_icon =  (ImageView) convertView.findViewById(R.id.hospital_call_button);

        result = convertView;
        convertView.setTag(holder);

        // animated the list view
        Animation animation = AnimationUtils.loadAnimation(getContext(),
                (position > lastPosition) ? R.anim.loading_down_anim : R.anim.loading_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.hospital_name.setText(hospital.getHospitalName());
        holder.hospital_mobile_no.setText(hospital.getHospitalMobileNo());
        holder.show_icon.setImageResource(hospital.getShowLocationIcon());
        holder.call_icon.setImageResource(hospital.getCallIcon());

        holder.call_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call(hospitalMobileNo);
            }
        });

        holder.show_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showIntoMap(hospitalLatitude, hospitalLongitude);
            }
        });

        return convertView;
    }

    public void call(String phoneNumber){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        mContext.startActivity(intent);
    }

    public void showIntoMap(String latitude, String longitude){
        Intent intent, selector;
        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<"+latitude +">,<"+longitude+">?q=<"+latitude +">,<"+longitude+">"));
        selector = Intent.createChooser(intent, "Select Map Launcher"); // it will create a option if don't have google map
        mContext.startActivity(selector);
    }

}
