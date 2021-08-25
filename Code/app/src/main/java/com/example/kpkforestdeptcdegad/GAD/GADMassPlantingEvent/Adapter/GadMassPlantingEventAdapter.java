package com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.Model.FetchGadMassPlantingEventDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GadMassPlantingEventAdapter extends RecyclerView.Adapter<GadMassPlantingEventAdapter.GadMassPlantingEventVH> implements Filterable {

    private List<FetchGadMassPlantingEventDataModel> fetchGadMassPlantingEventDataModelList;
    private List<FetchGadMassPlantingEventDataModel> detailGadMassPlantingEventDataModelList;
    Context mContext;

    public GadMassPlantingEventAdapter(List<FetchGadMassPlantingEventDataModel> fetchGadMassPlantingEventDataModelList, Context mContext) {
        this.fetchGadMassPlantingEventDataModelList = fetchGadMassPlantingEventDataModelList;
        this.mContext = mContext;
        detailGadMassPlantingEventDataModelList = new ArrayList<>();
        detailGadMassPlantingEventDataModelList.addAll(fetchGadMassPlantingEventDataModelList);
    }

    @NonNull
    @Override
    public GadMassPlantingEventAdapter.GadMassPlantingEventVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_gad_mass_planting_event, parent, false);
        return new GadMassPlantingEventVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GadMassPlantingEventAdapter.GadMassPlantingEventVH holder, int position) {
        holder.employeeNoTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getEmployee_name());
        holder.nameOfDivisionTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getName_of_division());
        holder.nameOfChiefGuestTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getChief_guest());
        holder.nameOfEventTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getName_of_event());
        holder.dateOfEventTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getDate_of_event());
        holder.locationTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getLocation());
        holder.nameOfInstituteTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getName_of_institute());
        holder.noOfPlantsPlantedTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getNo_of_plants_planted());
        holder.noOfPlantsDistributedTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getNo_of_plants_distributed());
        holder.noOfPlantsUtilizedTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getNo_of_plants_utilized());
        holder.dateTimeTV.setText(fetchGadMassPlantingEventDataModelList.get(position).getTime_date());
    }

    @Override
    public int getItemCount() {
        return fetchGadMassPlantingEventDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchGadMassPlantingEventDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(detailGadMassPlantingEventDataModelList);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchGadMassPlantingEventDataModel dataItem : detailGadMassPlantingEventDataModelList) {
                    if (dataItem.getName_of_division().toLowerCase().contains(filter)) {
                        filterList.add(dataItem);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            fetchGadMassPlantingEventDataModelList.clear();
            fetchGadMassPlantingEventDataModelList.addAll((Collection<? extends FetchGadMassPlantingEventDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class GadMassPlantingEventVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView nameOfDivisionTV;
        TextView nameOfChiefGuestTV;
        TextView nameOfEventTV;
        TextView dateOfEventTV;
        TextView locationTV;
        TextView nameOfInstituteTV;
        TextView noOfPlantsPlantedTV;
        TextView noOfPlantsDistributedTV;
        TextView noOfPlantsUtilizedTV;
        TextView dateTimeTV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;


        public GadMassPlantingEventVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_employeeNo);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_employeeName);
            nameOfDivisionTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_nameOfDivision);
            nameOfChiefGuestTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_chiefGuest);
            nameOfEventTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_nameOfEvent);
            dateOfEventTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_dateOfEvent);
            locationTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_location);
            nameOfInstituteTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_nameOfInstitute);
            noOfPlantsPlantedTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_noOfPlantsPlanted);
            noOfPlantsDistributedTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_noOfPlantsDistributed);
            noOfPlantsUtilizedTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_noOfPlantsUtilized);
            dateTimeTV = itemView.findViewById(R.id.tv_rowViewGadMassPlantingEvent_dateTime);

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
