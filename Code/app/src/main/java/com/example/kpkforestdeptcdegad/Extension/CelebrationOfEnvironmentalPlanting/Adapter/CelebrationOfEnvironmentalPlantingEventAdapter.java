package com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.Model.FetchCelebrationOfEnvironmentalPlantingEventDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.List;

public class CelebrationOfEnvironmentalPlantingEventAdapter extends RecyclerView.Adapter<CelebrationOfEnvironmentalPlantingEventAdapter.CelebrationOfEnvironmentalPlantingEventVH> {

    Context mContext;
    List<FetchCelebrationOfEnvironmentalPlantingEventDataModel> fetchCelebrationOfEnvironmentalPlantingEventDataModelList;

    public CelebrationOfEnvironmentalPlantingEventAdapter(Context mContext, List<FetchCelebrationOfEnvironmentalPlantingEventDataModel> fetchCelebrationOfEnvironmentalPlantingEventDataModelList) {
        this.mContext = mContext;
        this.fetchCelebrationOfEnvironmentalPlantingEventDataModelList = fetchCelebrationOfEnvironmentalPlantingEventDataModelList;
    }

    @NonNull
    @Override
    public CelebrationOfEnvironmentalPlantingEventAdapter.CelebrationOfEnvironmentalPlantingEventVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_celebrationefenvironmentalevent,parent,false);
        return new CelebrationOfEnvironmentalPlantingEventVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CelebrationOfEnvironmentalPlantingEventAdapter.CelebrationOfEnvironmentalPlantingEventVH holder, int position) {
        holder.employeeNo.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getEmployee_no());
    }

    @Override
    public int getItemCount() {
        return fetchCelebrationOfEnvironmentalPlantingEventDataModelList.size();
    }

    public class CelebrationOfEnvironmentalPlantingEventVH extends RecyclerView.ViewHolder {

        TextView employeeNo;

        public CelebrationOfEnvironmentalPlantingEventVH(@NonNull View itemView) {
            super(itemView);

            employeeNo = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_employeeNo);
        }
    }
}
