package com.example.ndulueemeka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.app.AlertDialog;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ndulueemeka.Adapter.FilterAdapter;
import com.example.ndulueemeka.Common.Common;
import com.example.ndulueemeka.Model.FilterModel;
import com.example.ndulueemeka.Retrofit.IMYEMEKA;
import com.example.ndulueemeka.Retrofit.RetrofitClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    AlertDialog spotDialog;
    FilterAdapter adapter;
    Retrofit retrofit;
    IMYEMEKA myemeka;
    @BindView(R.id.recycler_filter)
    RecyclerView recycler_filter;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        initView();
        spotDialog.show();
        getFilter();
    }

    private void initView() {
        spotDialog = new SpotsDialog.Builder().setContext(MainActivity.this).setCancelable(false).build();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_filter.setLayoutManager(linearLayoutManager);
        recycler_filter.setAdapter(adapter);
    }

    private void init() {
        ButterKnife.bind(this);
        myemeka = RetrofitClient.getInstance(Common.BASE_URL).create(IMYEMEKA.class);
    }

    private void getFilter() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myemeka = retrofit.create(IMYEMEKA.class);
        Call<List<FilterModel>> filterModelCall = myemeka.geList();
        filterModelCall.enqueue(new Callback<List<FilterModel>>() {
            @Override
            public void onResponse(Call<List<FilterModel>> call, Response<List<FilterModel>> response) {
                spotDialog.dismiss();
                if (response.isSuccessful() ||  response.code() == 200){
                        List<FilterModel> filterModels =  response.body();
                        Log.d("Query", "APi: " + response.body());
                        adapter = new FilterAdapter(getApplicationContext(),  filterModels);
                        adapter.notifyDataSetChanged();
                        recycler_filter.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, "UnSuccessfull", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<FilterModel>> call, Throwable t) {
                spotDialog.dismiss();
                Toast.makeText(MainActivity.this, "Cant Fetch details, check your internet connection" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
