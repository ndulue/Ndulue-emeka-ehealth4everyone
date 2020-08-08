package com.example.ndulueemeka.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ndulueemeka.Model.CarOwnerModel;
import com.example.ndulueemeka.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CarOwnerAdapter extends RecyclerView.Adapter<CarOwnerAdapter.MyViewHolder> {

    private Context context;
    private List<CarOwnerModel> carOwnerModelList;

    public CarOwnerAdapter(Context context, List<CarOwnerModel> carOwnerModelList) {
        this.context = context;
        this.carOwnerModelList = carOwnerModelList;
    }

    @NonNull
    @Override
    public CarOwnerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = (LayoutInflater.from(context).inflate(R.layout.car_owners_card, parent, false));
        return new CarOwnerAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarOwnerAdapter.MyViewHolder holder, int position) {
        holder.full_name_co.setText(new StringBuilder(carOwnerModelList.get(position).getFirst_name().isEmpty() ? "All" : carOwnerModelList.get(position).getFirst_name()));
        holder.email_co.setText(new StringBuilder(carOwnerModelList.get(position).getEmail().isEmpty() ? "All" : carOwnerModelList.get(position).getEmail()));
        holder.country_co.setText(new StringBuilder(carOwnerModelList.get(position).getCountry().isEmpty() ? "All" : carOwnerModelList.get(position).getCountry()));
        holder.car_details_co.setText(new StringBuilder(carOwnerModelList.get(position).getCar_color().isEmpty() ? "All" : carOwnerModelList.get(position).getCar_color()));
        holder.gender_co.setText(new StringBuilder(carOwnerModelList.get(position).getGender().isEmpty() ? "All" : carOwnerModelList.get(position).getGender()));
        holder.job_title_co.setText(new StringBuilder(carOwnerModelList.get(position).getJob_title().isEmpty() ? "All" : carOwnerModelList.get(position).getJob_title()));
        holder.bio_co.setText(new StringBuilder(carOwnerModelList.get(position).getBio().isEmpty() ? "All" : carOwnerModelList.get(position).getBio()));
    }

    @Override
    public int getItemCount() {
        return carOwnerModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.full_name_co)
        TextView full_name_co;
        @BindView(R.id.email_co)
        TextView email_co;
        @BindView(R.id.country_co)
        TextView country_co;
        @BindView(R.id.car_details_co)
        TextView car_details_co;
        @BindView(R.id.gender_co)
        TextView gender_co;
        @BindView(R.id.job_title_co)
        TextView job_title_co;
        @BindView(R.id.bio_co)
        TextView bio_co;
        Unbinder unbinder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}