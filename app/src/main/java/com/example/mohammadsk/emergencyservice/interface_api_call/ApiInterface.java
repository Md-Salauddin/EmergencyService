package com.example.mohammadsk.emergencyservice.interface_api_call;

import com.example.mohammadsk.emergencyservice.model.Hospital;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by MohammadSk on 17-Nov-17.
 */

public interface ApiInterface {

    @POST("hospital.php")
    Call<List<Hospital>> getHospitals();

}
