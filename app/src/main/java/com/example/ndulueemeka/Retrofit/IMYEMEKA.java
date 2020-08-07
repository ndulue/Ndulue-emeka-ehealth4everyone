package com.example.ndulueemeka.Retrofit;

import com.example.ndulueemeka.Model.FilterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMYEMEKA {

    @GET("b4cdeed3-327b-4591-9b06-aaf043e65497")
    Call<List<FilterModel>> geList();
}
