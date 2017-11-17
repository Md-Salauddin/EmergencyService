package com.example.mohammadsk.emergencyservice.rertrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MohammadSk on 17-Nov-17.
 */

public class ApiClient {
    public static final String BASE_URL = "https://mohammadsk.000webhostapp.com/emergency_service/api/";
    public static Retrofit retrofit = null;

    // create a method that return a instance of retrofit
    public static Retrofit getApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
