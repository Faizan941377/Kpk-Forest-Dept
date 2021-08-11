package com.example.kpkforestdeptcdegad.CD.WaterSourceDevelopmentScheme.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.R;

public class WaterSourceDevelopmentSchemeAdapter extends RecyclerView.Adapter<WaterSourceDevelopmentSchemeAdapter.WaterSourceDevelopmentVH> {

    Context mContext;

    public WaterSourceDevelopmentSchemeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public WaterSourceDevelopmentSchemeAdapter.WaterSourceDevelopmentVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_water_source_development_scheme, parent, false);
        return new WaterSourceDevelopmentSchemeAdapter.WaterSourceDevelopmentVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaterSourceDevelopmentSchemeAdapter.WaterSourceDevelopmentVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class WaterSourceDevelopmentVH extends RecyclerView.ViewHolder {
        public WaterSourceDevelopmentVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
