package com.example.kpkforestdeptcdegad.CD.WaterSourceDevelopmentScheme.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.Model.FetchWaterHarvestingSchemeDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchWaterSourceDevelopSchemeDataModel;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchWaterHarvestingSchemeResponse;
import com.example.kpkforestdeptcdegad.Response.FetchWaterSourceDevelopSchemeResponse;

import java.util.List;

public class WaterSourceDevelopmentSchemeAdapter extends RecyclerView.Adapter<WaterSourceDevelopmentSchemeAdapter.WaterSourceDevelopmentVH> {

    List<FetchWaterSourceDevelopSchemeDataModel> fetchWaterSourceDevelopSchemeDataModelList;
    Context mContext;

    public WaterSourceDevelopmentSchemeAdapter(List<FetchWaterSourceDevelopSchemeDataModel> fetchWaterSourceDevelopSchemeDataModelList, Context mContext) {
        this.fetchWaterSourceDevelopSchemeDataModelList = fetchWaterSourceDevelopSchemeDataModelList;
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
        holder.employeeNoTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getEmployee_name());
        holder.nameOfDivisionTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getName_of_division());
        holder.nameOfForestDivisionTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getName_of_forest_division());
        holder.targetAsPC1TV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getTarget_as_pc_1());
        holder.achievedSoFarTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getAchieved_so_far_no());
        holder.vdcEstablishedTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getVdc_established());
        holder.progressTillDateTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getProgress_till_date());
        holder.dateTimeTV.setText(fetchWaterSourceDevelopSchemeDataModelList.get(position).getDate_time());
    }

    @Override
    public int getItemCount() {
        return fetchWaterSourceDevelopSchemeDataModelList.size();
    }

    public class WaterSourceDevelopmentVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView nameOfDivisionTV;
        TextView nameOfForestDivisionTV;
        TextView targetAsPC1TV;
        TextView achievedSoFarTV;
        TextView vdcEstablishedTV;
        TextView progressTillDateTV;
        TextView dateTimeTV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public WaterSourceDevelopmentVH(@NonNull View itemView) {
            super(itemView);
            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowVIewWaterSourceScheme_empName);
            nameOfDivisionTV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_nameOfDivision);
            nameOfForestDivisionTV = itemView.findViewById(R.id.tv_rowVIewWaterSourceScheme_nameOfForestDivision);
            targetAsPC1TV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_targetAsPC1);
            achievedSoFarTV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_achieveSoFarNo);
            vdcEstablishedTV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_vdcEstablished);
            progressTillDateTV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_progressTillDate);
            dateTimeTV = itemView.findViewById(R.id.tv_rowViewWaterSourceScheme_timeDate);

            showMoreTV.setOnClickListener(this);

        }

        private void ShowMore(View v) {

            if (expendableLinearLayout2.getVisibility() == v.GONE) {
                showMoreTV.setText("Show Less");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(expendingCardView, new AutoTransition());
                    expendableLinearLayout2.setVisibility(View.VISIBLE);
                }
            } else {
                showMoreTV.setText("Read More");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(expendingCardView, new AutoTransition());
                }
                expendableLinearLayout2.setVisibility(View.GONE);
            }
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_rowViewVDC_showMore:
                    ShowMore(v);
                    break;
            }
        }
    }
}
