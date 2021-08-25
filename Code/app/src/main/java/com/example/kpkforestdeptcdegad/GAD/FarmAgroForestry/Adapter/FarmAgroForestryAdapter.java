package com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry.Adapter;

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

import com.example.kpkforestdeptcdegad.Model.FetchFarmAgroForestryDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FarmAgroForestryAdapter extends RecyclerView.Adapter<FarmAgroForestryAdapter.FarmAgroForestryVH> implements Filterable {

    Context mContext;
    private List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModelList;
    private List<FetchFarmAgroForestryDataModel> detailFarmAgroForestryDataModelList;

    public FarmAgroForestryAdapter(Context mContext, List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModelList) {
        this.mContext = mContext;
        this.fetchFarmAgroForestryDataModelList = fetchFarmAgroForestryDataModelList;
        detailFarmAgroForestryDataModelList = new ArrayList<>();
        detailFarmAgroForestryDataModelList.addAll(fetchFarmAgroForestryDataModelList);
    }

    @NonNull
    @Override
    public FarmAgroForestryAdapter.FarmAgroForestryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_farm_agro_forestry, parent, false);
        return new FarmAgroForestryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FarmAgroForestryAdapter.FarmAgroForestryVH holder, int position) {
        holder.employeeNoTV.setText(fetchFarmAgroForestryDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchFarmAgroForestryDataModelList.get(position).getEmployee_name());
        holder.gadAddTV.setText(fetchFarmAgroForestryDataModelList.get(position).getGad_add());
        holder.nameOfWomenOrganizationTV.setText(fetchFarmAgroForestryDataModelList.get(position).getName_of_women_organization());
        holder.nameOfMajorActivitiesTV.setText(fetchFarmAgroForestryDataModelList.get(position).getName_of_major_activities());
        holder.otherActivitiesTV.setText(fetchFarmAgroForestryDataModelList.get(position).getOther_activities());
        holder.nameOfVillageTV.setText(fetchFarmAgroForestryDataModelList.get(position).getName_of_village());
        holder.dateTimeTV.setText(fetchFarmAgroForestryDataModelList.get(position).getDate_time());
    }

    @Override
    public int getItemCount() {
        return fetchFarmAgroForestryDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchFarmAgroForestryDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length()==0){
                filterList.addAll(detailFarmAgroForestryDataModelList);
            }else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchFarmAgroForestryDataModel dataItem:detailFarmAgroForestryDataModelList){
                    if (dataItem.getGad_add().toLowerCase().contains(filter)){
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
            fetchFarmAgroForestryDataModelList.clear();
            fetchFarmAgroForestryDataModelList.addAll((Collection<? extends FetchFarmAgroForestryDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class FarmAgroForestryVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView gadAddTV;
        TextView nameOfWomenOrganizationTV;
        TextView nameOfMajorActivitiesTV;
        TextView nameOfVillageTV;
        TextView otherActivitiesTV;
        TextView dateTimeTV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;


        public FarmAgroForestryVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_empName);
            gadAddTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_gadADD);
            otherActivitiesTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_otherActivities);
            nameOfWomenOrganizationTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_nameOfWomenOrganization);
            nameOfMajorActivitiesTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_nameOfMajorActivities);
            nameOfVillageTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_nameOfVillage);
            dateTimeTV = itemView.findViewById(R.id.tv_rowViewFarmAgroForestry_dateTime);

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
