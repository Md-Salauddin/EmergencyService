package com.example.mohammadsk.emergencyservice.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MohammadSk on 12-Nov-17.
 */

public class Hospital {
    @SerializedName("name")
    private String hospitalName;
    @SerializedName("phoneNumber")
    private String hospitalMobileNo;
    @SerializedName("address")
    private String hospitalAddress;
    @SerializedName("zone")
    private String hospitalZone;
    @SerializedName("district")
    private String hospitalDistrict;
    @SerializedName("latitude")
    private String hospitalLatitude;
    @SerializedName("longitude")
    private String hospitalLongitude;

    private int showLocationIcon;
    private int callIcon;

    public Hospital(String hospitalName, String hospitalMobileNo, String hospitalAddress, String hospitalZone, String hospitalDistrict, String hospitalLatitude, String hospitalLongitude, int showLocationIcon, int callIcon) {
        this.hospitalName = hospitalName;
        this.hospitalMobileNo = hospitalMobileNo;
        this.hospitalAddress = hospitalAddress;
        this.hospitalZone = hospitalZone;
        this.hospitalDistrict = hospitalDistrict;
        this.hospitalLatitude = hospitalLatitude;
        this.hospitalLongitude = hospitalLongitude;
        this.showLocationIcon = showLocationIcon;
        this.callIcon = callIcon;
    }

    public Hospital(String hospitalName, String hospitalMobileNo, String hospitalAddress, String hospitalZone, String hospitalDistrict) {
        this.hospitalName = hospitalName;
        this.hospitalMobileNo = hospitalMobileNo;
        this.hospitalAddress = hospitalAddress;
        this.hospitalZone = hospitalZone;
        this.hospitalDistrict = hospitalDistrict;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalMobileNo() {
        return hospitalMobileNo;
    }

    public void setHospitalMobileNo(String hospitalMobileNo) {
        this.hospitalMobileNo = hospitalMobileNo;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalZone() {
        return hospitalZone;
    }

    public void setHospitalZone(String hospitalZone) {
        this.hospitalZone = hospitalZone;
    }

    public String getHospitalDistrict() {
        return hospitalDistrict;
    }

    public void setHospitalDistrict(String hospitalDistrict) {
        this.hospitalDistrict = hospitalDistrict;
    }

    public String getHospitalLatitude() {
        return hospitalLatitude;
    }

    public void setHospitalLatitude(String hospitalLatitude) {
        this.hospitalLatitude = hospitalLatitude;
    }

    public String getHospitalLongitude() {
        return hospitalLongitude;
    }

    public void setHospitalLongitude(String hospitalLongitude) {
        this.hospitalLongitude = hospitalLongitude;
    }

    public int getShowLocationIcon() {
        return showLocationIcon;
    }

    public void setShowLocationIcon(int showLocationIcon) {
        this.showLocationIcon = showLocationIcon;
    }

    public int getCallIcon() {
        return callIcon;
    }

    public void setCallIcon(int callIcon) {
        this.callIcon = callIcon;
    }

    @Override
    public String toString() {
        return  hospitalName +"\n"+
                hospitalMobileNo +"\n\n"+
                hospitalAddress +"\n\n"+
                hospitalZone +"\n"+
                hospitalDistrict +"\n";
    }
}
