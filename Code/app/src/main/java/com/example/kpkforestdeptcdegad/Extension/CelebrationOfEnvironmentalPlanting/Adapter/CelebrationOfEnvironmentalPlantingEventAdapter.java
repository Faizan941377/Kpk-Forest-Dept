package com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting.Adapter;

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
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_celebrationefenvironmentalevent, parent, false);
        return new CelebrationOfEnvironmentalPlantingEventVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CelebrationOfEnvironmentalPlantingEventAdapter.CelebrationOfEnvironmentalPlantingEventVH holder, int position) {
        holder.employeeNoTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getEmployee_name());
        holder.locationTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getLocation_of_event_name_of_institute());
        holder.chiefGuestTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getChief_guest());
        holder.environmentalPlantingTypeTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getEnvironmental_planting_type());
        holder.environmentalDayPlantingEventTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getEnvironmental_day_planting_event());
        holder.dateOfEventTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getDate_of_event());
        holder.noOfPlantsPlantedTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getNo_of_planted());
        holder.dateTimeTV.setText(fetchCelebrationOfEnvironmentalPlantingEventDataModelList.get(position).getTime_date());
    }

    @Override
    public int getItemCount() {
        return fetchCelebrationOfEnvironmentalPlantingEventDataModelList.size();
    }

    public class CelebrationOfEnvironmentalPlantingEventVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;
        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView locationTV;
        TextView chiefGuestTV;
        TextView environmentalPlantingTypeTV;
        TextView environmentalDayPlantingEventTV;
        TextView dateOfEventTV;
        TextView noOfPlantsPlantedTV;
        TextView dateTimeTV;

        public CelebrationOfEnvironmentalPlantingEventVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_employeeNo);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_employeeName);
            locationTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_location);
            chiefGuestTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_chiefGuest);
            environmentalPlantingTypeTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_environmentalPlantingType);
            environmentalDayPlantingEventTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_environmentalDayPlantingEvent);
            dateOfEventTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_dateOfEvent);
            noOfPlantsPlantedTV = itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_noOfPlantsPlanted);
            dateTimeTV =itemView.findViewById(R.id.tv_rowViewCelebrationOfEnvironmental_timeDate);

            showMoreTV.setOnClickListener(this);
        }

        public void ShowMore(View view) {
            if (expendableLinearLayout2.getVisibility() == view.GONE) {
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
            switch (v.getId()) {
                case R.id.tv_rowViewVDC_showMore:
                    ShowMore(v);
                    break;
            }
        }
    }
}
