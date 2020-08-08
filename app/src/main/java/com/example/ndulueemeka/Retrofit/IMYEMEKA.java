package com.example.ndulueemeka.Retrofit;

import com.example.ndulueemeka.Common.Common;
import com.example.ndulueemeka.Model.FilterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMYEMEKA {

    @GET("v3/"+ Common.apikey)
    Call<List<FilterModel>> geList();
}
