package com.example.ndulueemeka.Retrofit;

import com.example.ndulueemeka.Model.FilterModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMYEMEKA {

    @GET()
    Call<FilterModel> getWallet();
}
