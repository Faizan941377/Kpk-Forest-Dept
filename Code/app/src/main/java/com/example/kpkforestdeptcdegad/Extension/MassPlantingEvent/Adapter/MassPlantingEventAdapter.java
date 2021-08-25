package com.example.kpkforestdeptcdegad.Extension.MassPlantingEvent.Adapter;

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

import com.example.kpkforestdeptcdegad.Model.FetchMassPlantingEventDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.zip.Inflater;

public class MassPlantingEventAdapter extends RecyclerView.Adapter<MassPlantingEventAdapter.MassPlantingViewVH> implements Filterable {

    private List<FetchMassPlantingEventDataModel> fetchMassPlantingEventDataModelList;
    private List<FetchMassPlantingEventDataModel> detailMassPlantingEventDataModelList;
    Context mContext;

    public MassPlantingEventAdapter(List<FetchMassPlantingEventDataModel> fetchMassPlantingEventDataModelList, Context mContext) {
        this.fetchMassPlantingEventDataModelList = fetchMassPlantingEventDataModelList;
        this.mContext = mContext;
        detailMassPlantingEventDataModelList = new ArrayList<>();
        detailMassPlantingEventDataModelList.addAll(fetchMassPlantingEventDataModelList);
    }

    @NonNull
    @Override
    public MassPlantingEventAdapter.MassPlantingViewVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_extension_mass_planting_event, parent, false);
        return new MassPlantingViewVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MassPlantingEventAdapter.MassPlantingViewVH holder, int position) {
        holder.employeeNoTV.setText(fetchMassPlantingEventDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchMassPlantingEventDataModelList.get(position).getEmployee_name());
        holder.locationTV.setText(fetchMassPlantingEventDataModelList.get(position).getLocation_venu());
        holder.chiefGuestTV.setText(fetchMassPlantingEventDataModelList.get(position).getChief_guest());
        holder.dateOfEventTV.setText(fetchMassPlantingEventDataModelList.get(position).getDate_of_event());
        holder.noOfPlantsPlantedTV.setText(fetchMassPlantingEventDataModelList.get(position).getNo_of_plants_planted());
        holder.noOfPlantsDistributedTV.setText(fetchMassPlantingEventDataModelList.get(position).getNo_of_plants_distributed());
        holder.springMoonSoonTV.setText(fetchMassPlantingEventDataModelList.get(position).getSpring_moon_soon());
        holder.totalNoOfPlantsTV.setText(fetchMassPlantingEventDataModelList.get(position).getTotal_no_of_plants());
    }

    @Override
    public int getItemCount() {
        return fetchMassPlantingEventDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchMassPlantingEventDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filterList.addAll(detailMassPlantingEventDataModelList);
            }else {
                String  filter = constraint.toString().toLowerCase().trim();
                for (FetchMassPlantingEventDataModel dataItem:detailMassPlantingEventDataModelList){
                    if (dataItem.getLocation_venu().toLowerCase().contains(filter)){
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
            fetchMassPlantingEventDataModelList.clear();
            fetchMassPlantingEventDataModelList.addAll((Collection<? extends FetchMassPlantingEventDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class MassPlantingViewVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView locationTV;
        TextView chiefGuestTV;
        TextView dateOfEventTV;
        TextView noOfPlantsPlantedTV;
        TextView noOfPlantsDistributedTV;
        TextView springMoonSoonTV;
        TextView totalNoOfPlantsTV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public MassPlantingViewVH(@NonNull View itemView) {
            super(itemView);
            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_employeeNo);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_employeeName);
            locationTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_location);
            chiefGuestTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_chiefGuest);
            dateOfEventTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_dateOfEvent);
            noOfPlantsPlantedTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_NoOfPlantsPlanted);
            noOfPlantsDistributedTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_NoOfPlantsDistributed);
            springMoonSoonTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_springMoonSoon);
            totalNoOfPlantsTV = itemView.findViewById(R.id.tv_rowViewExtensionMassPlantingEvent_totalNoOfPlants);

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
