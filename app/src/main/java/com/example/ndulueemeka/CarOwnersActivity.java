package com.example.ndulueemeka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.ndulueemeka.Adapter.CarOwnerAdapter;
import com.example.ndulueemeka.Common.CSVRead;
import com.example.ndulueemeka.Model.CarOwnerModel;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dmax.dialog.SpotsDialog;

public class CarOwnersActivity extends AppCompatActivity{

    AlertDialog spotDialog;
    CarOwnerAdapter adapter;
    CarOwnerModel model = new CarOwnerModel();
    int start = 1;
    int limit = 10;
    int count = 1;
    List<CarOwnerModel> carOwnerModelList = new ArrayList<>();
    @BindView(R.id.recycler_car_owner)
    RecyclerView recycler_car_owner;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_owners);
        init();
        initView();
        spotDialog.show();
        try {
            readCsvFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight()){
                    progress_bar.setVisibility(View.VISIBLE);
                    try {
                        readCsvFile();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    /*
    private void readCarOwner(int start, int limit) {
        InputStream inputStream = getResources().openRawResource(R.raw.car_ownsers_data);
        CsvReader csv = new CsvReader(inputStream);
        List<String[]> ownerList = csv.readList().subList(start,limit);
        //carOwnerModelList.toString() = csv.readList().subList(0,10);
        for (String[] resultList : ownerList) {
            model.setFirst_name(resultList[1]);
            model.setLast_name(resultList[2]);
            model.setEmail(resultList[3]);
            model.setCountry(resultList[4]);
            model.setCar_model(resultList[5]);
            model.setCar_model_year(resultList[6]);
            model.setCar_color(resultList[7]);
            model.setGender(resultList[8]);
            model.setJob_title(resultList[9]);
            model.setBio(resultList[10]);

        }
            carOwnerModelList.add(model);

        adapter = new CarOwnerAdapter(getApplicationContext(),  carOwnerModelList);
        adapter.notifyDataSetChanged();
        recycler_car_owner.setAdapter(adapter);
        progress_bar.setVisibility(View.GONE);

    }

     */
    
    //read Csv data and display
    public void readCsvFile() throws FileNotFoundException{
        spotDialog.dismiss();
        List<CarOwnerModel> carOwnerModelList = new CSVRead().readCsvFile();
        adapter = new CarOwnerAdapter(getApplicationContext(),  carOwnerModelList);
        adapter.notifyDataSetChanged();
        recycler_car_owner.setAdapter(adapter);
        progress_bar.setVisibility(View.GONE);
    }

    //initialize spotDialog and linearLayoutManager
    private void initView() {
        spotDialog = new SpotsDialog.Builder().setContext(CarOwnersActivity.this).setCancelable(false).build();
        //adapter = new CarOwnerAdapter( CarOwnersActivity.this, carOwnerModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycler_car_owner.setLayoutManager(linearLayoutManager);

    }

    //bind view Holder with butter knife
    private void init() {
        ButterKnife.bind(this);
    }

}
