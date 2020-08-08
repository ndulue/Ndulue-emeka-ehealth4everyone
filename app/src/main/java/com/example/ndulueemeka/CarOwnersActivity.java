package com.example.ndulueemeka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.ndulueemeka.Adapter.CarOwnerAdapter;
import com.example.ndulueemeka.Adapter.FilterAdapter;
import com.example.ndulueemeka.Common.Common;
import com.example.ndulueemeka.Model.CarOwnerModel;
import com.example.ndulueemeka.Retrofit.IMYEMEKA;
import com.example.ndulueemeka.Retrofit.RetrofitClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;
import retrofit2.Retrofit;

public class CarOwnersActivity extends AppCompatActivity {

    AlertDialog spotDialog;
    CarOwnerAdapter adapter;
    Retrofit retrofit;
    IMYEMEKA myemeka;
    @BindView(R.id.recycler_car_owner)
    RecyclerView recycler_car_owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_owners);
        init();
        initView();
        spotDialog.show();
        readCarOwner();

    }

    private List<CarOwnerModel> carOwnerModelList = new ArrayList<>();
    private void readCarOwner() {
        InputStream is = getResources().openRawResource(R.raw.car_ownsers_data);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
        try {
            reader.readLine();
            while ( (line = reader.readLine()) !=  null){
                Log.d("MyActivity", "Line " + line);
                String[] tokens = line.split(",");

                CarOwnerModel model = new CarOwnerModel();
                model.setFirst_name(tokens[2]);
                model.setLast_name(tokens[2]);
                model.setEmail(tokens[2]);
                model.setGender(tokens[2]);
                model.setBio(tokens[2]);
                model.setCountry(tokens[2]);
                carOwnerModelList.add(model);
                Log.d("MyActivity", "Created " + model);
            }
        } catch (IOException e){
            Log.wtf("MyActivity", "Error");
            e.printStackTrace();
        }

    }

    private void initView() {
        spotDialog = new SpotsDialog.Builder().setContext(CarOwnersActivity.this).setCancelable(false).build();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //recycler_filter.setLayoutManager(linearLayoutManager);
    }

    private void init() {
        ButterKnife.bind(this);
        //myemeka = RetrofitClient.getInstance(Common.BASE_URL).create(IMYEMEKA.class);
    }
}
