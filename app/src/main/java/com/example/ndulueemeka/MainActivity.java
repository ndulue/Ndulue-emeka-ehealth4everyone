package com.example.ndulueemeka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ndulueemeka.Adapter.FilterAdapter;
import com.example.ndulueemeka.Common.Common;
import com.example.ndulueemeka.Model.FilterModel;
import com.example.ndulueemeka.Retrofit.IMYEMEKA;
import com.example.ndulueemeka.Retrofit.RetrofitClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    AlertDialog dialog;
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
        getConPrice();
    }

    private void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_filter.setLayoutManager(linearLayoutManager);
        //recycler_filter.setHasFixedSize(true);
    }

    private void init() {
        ButterKnife.bind(this);
        myemeka = RetrofitClient.getInstance(Common.BASE_URL).create(IMYEMEKA.class);
        //dialog = new SpotsDialog.Builder().setContext(MainActivity.this).setCancelable(false).build();
    }

    private void getConPrice() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myemeka = retrofit.create(IMYEMEKA.class);
        Call<List<FilterModel>> filterModelCall = myemeka.geList();
        filterModelCall.enqueue(new Callback<List<FilterModel>>() {
            @Override
            public void onResponse(Call<List<FilterModel>> call, Response<List<FilterModel>> response) {
                if (response.isSuccessful() ||  response.code() == 200){

                        List<FilterModel> filterModels =  response.body();
                        adapter = new FilterAdapter(getApplicationContext(),  filterModels);
                        adapter.notifyDataSetChanged();
                        recycler_filter.setAdapter(adapter);
                        //for (FilterModel filterModel : filterModels){
                            //String end_date = String.valueOf(filterModel.getEndYear());
                            //Toast.makeText(MainActivity.this, " "+end_date, Toast.LENGTH_LONG).show();
                        //}


                }else{
                    Toast.makeText(MainActivity.this, "UnSuccessfull", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<FilterModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "eeeeeeeeeeee" + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
