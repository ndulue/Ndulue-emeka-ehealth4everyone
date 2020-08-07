package com.example.ndulueemeka.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ndulueemeka.Model.FilterModel;
import com.example.ndulueemeka.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.MyViewHolder> {

    private Context context;
    private List<FilterModel> filterModelList;

    public FilterAdapter(Context context, List<FilterModel> filterModelList) {
        this.context = context;
        this.filterModelList = filterModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = (LayoutInflater.from(context).inflate(R.layout.filter_card, parent, false));
        return new FilterAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.filter_country.setText(new StringBuilder(String.valueOf(filterModelList.get(position).getColors())));
        holder.filter_gender.setText(new StringBuilder(filterModelList.get(position).getGender()));
        holder.filter_date_start.setText(new StringBuilder(filterModelList.get(position).getStartYear()));
        holder.filter_date_end.setText(new StringBuilder(filterModelList.get(position).getEndYear()));
        holder.filter_color.setText(new StringBuilder(String.valueOf(filterModelList.get(position).getColors())));
    }

    @Override
    public int getItemCount() {
        return filterModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.filter_date_start)
        TextView filter_date_start;
        @BindView(R.id.filter_date_end)
        TextView filter_date_end;
        @BindView(R.id.filter_gender)
        TextView filter_gender;
        @BindView(R.id.filter_country)
        TextView filter_country;
        @BindView(R.id.filter_color)
        TextView filter_color;
        Unbinder unbinder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}
