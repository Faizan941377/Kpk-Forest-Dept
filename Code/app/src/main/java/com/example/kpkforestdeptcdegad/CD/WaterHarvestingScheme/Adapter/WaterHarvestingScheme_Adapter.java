package com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.Model.FetchWaterHarvestingSchemeDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WaterHarvestingScheme_Adapter extends RecyclerView.Adapter<WaterHarvestingScheme_Adapter.WaterHarvestingSchemeVH> implements Filterable {

    private List<FetchWaterHarvestingSchemeDataModel> fetchWaterHarvestingSchemeDataModelList;
    private List<FetchWaterHarvestingSchemeDataModel> detailWaterHarvestingSchemeDataModelList;
    private Context mContext;

    public WaterHarvestingScheme_Adapter(List<FetchWaterHarvestingSchemeDataModel> fetchWaterHarvestingSchemeDataModelList, Context mContext) {
        this.fetchWaterHarvestingSchemeDataModelList = fetchWaterHarvestingSchemeDataModelList;
        this.mContext = mContext;
        detailWaterHarvestingSchemeDataModelList = new ArrayList<>();
        detailWaterHarvestingSchemeDataModelList.addAll(fetchWaterHarvestingSchemeDataModelList);
    }

    @NonNull
    @Override
    public WaterHarvestingScheme_Adapter.WaterHarvestingSchemeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_water_harvesting_scheme, parent, false);
        return new WaterHarvestingSchemeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaterHarvestingScheme_Adapter.WaterHarvestingSchemeVH holder, int position) {
        holder.employeeNoTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getEmployee_name());
        holder.nameOfDivisionTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getName_of_division());
        holder.nameOfForestDivisionTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getName_of_forest_division());
        holder.targetAsPC1TV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getTarget_as_pc1());
        holder.achieveSoFarNoTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getAchieved_so_far_no());
        holder.vdcEstablishedTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getVdc_established());
        holder.progressTillDateTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getProgress_till_date());
        holder.timeDateTV.setText(fetchWaterHarvestingSchemeDataModelList.get(position).getTime_date());
    }

    @Override
    public int getItemCount() {
        return fetchWaterHarvestingSchemeDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchWaterHarvestingSchemeDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(detailWaterHarvestingSchemeDataModelList);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchWaterHarvestingSchemeDataModel dataItem : detailWaterHarvestingSchemeDataModelList) {
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
            fetchWaterHarvestingSchemeDataModelList.clear();
            fetchWaterHarvestingSchemeDataModelList.addAll((Collection<? extends FetchWaterHarvestingSchemeDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class WaterHarvestingSchemeVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView nameOfDivisionTV;
        TextView nameOfForestDivisionTV;
        TextView targetAsPC1TV;
        TextView achieveSoFarNoTV;
        TextView vdcEstablishedTV;
        TextView progressTillDateTV;
        TextView timeDateTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public WaterHarvestingSchemeVH(@NonNull View itemView) {
            super(itemView);
            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowVIewWaterHarvestingScheme_empName);
            nameOfDivisionTV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_nameOfDivision);
            nameOfForestDivisionTV = itemView.findViewById(R.id.tv_rowVIewWaterHarvestingScheme_nameOfForestDivision);
            targetAsPC1TV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_targetAsPC1);
            achieveSoFarNoTV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_achieveSoFarNo);
            vdcEstablishedTV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_vdcEstablished);
            progressTillDateTV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_progressTillDate);
            timeDateTV = itemView.findViewById(R.id.tv_rowViewWaterHarvestingScheme_timeDate);

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
