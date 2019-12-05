package com.oreo.busreservation.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {
    private Retrofit retrofit;
    private ApiService apiService;
    private static final String BASE_URL = "http://34.92.59.172:8000";
    public static NetworkHelper networkHelper = new NetworkHelper();

    public NetworkHelper() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static NetworkHelper getInstance() {
        return networkHelper;
    }

    public ApiService getApiService() {
        return apiService;
    }
}