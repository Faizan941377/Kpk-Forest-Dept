package com.example.kpkforestdeptcdegad.GAD.YouthWemenNursery.Adapter;

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

import com.example.kpkforestdeptcdegad.Model.FetchYouthWomenNurseryDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class YouthWomenNurseryAdapter extends RecyclerView.Adapter<YouthWomenNurseryAdapter.YouthNurseryAdapterVH> implements Filterable {

    Context mContext;
    private List<FetchYouthWomenNurseryDataModel> fetchYouthWomenNurseryDataModelList;
    private List<FetchYouthWomenNurseryDataModel> detailYouthWomenNurseryDataModelList;

    public YouthWomenNurseryAdapter(Context mContext, List<FetchYouthWomenNurseryDataModel> fetchYouthWomenNurseryDataModelList) {
        this.mContext = mContext;
        this.fetchYouthWomenNurseryDataModelList = fetchYouthWomenNurseryDataModelList;
        detailYouthWomenNurseryDataModelList = new ArrayList<>();
        detailYouthWomenNurseryDataModelList.addAll(fetchYouthWomenNurseryDataModelList);
    }

    @NonNull
    @Override
    public YouthWomenNurseryAdapter.YouthNurseryAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_youth_women_nursery, parent, false);
        return new YouthNurseryAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YouthWomenNurseryAdapter.YouthNurseryAdapterVH holder, int position) {
        holder.employeeNoTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getEmployee_name());
        holder.nameOfDivisionTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getName_of_division());
        holder.nameOfSubDivisionRangeTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getName_of_sub_division_range());
        holder.vdcWOTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getVdc_wo());
        holder.nameOfNurseryOwnerTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getName_of_nursery_owner());
        holder.locationVillageNameTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getLocation_village_name());
        holder.limitTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getLimits());
        holder.timeDateTV.setText(fetchYouthWomenNurseryDataModelList.get(position).getTime_date());
    }

    @Override
    public int getItemCount() {
        return fetchYouthWomenNurseryDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchYouthWomenNurseryDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(detailYouthWomenNurseryDataModelList);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchYouthWomenNurseryDataModel dataItem : detailYouthWomenNurseryDataModelList) {
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
            fetchYouthWomenNurseryDataModelList.clear();
            fetchYouthWomenNurseryDataModelList.addAll((Collection<? extends FetchYouthWomenNurseryDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class YouthNurseryAdapterVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView nameOfDivisionTV;
        TextView nameOfSubDivisionRangeTV;
        TextView vdcWOTV;
        TextView nameOfNurseryOwnerTV;
        TextView locationVillageNameTV;
        TextView limitTV;
        TextView timeDateTV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public YouthNurseryAdapterVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_empName);
            nameOfDivisionTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_nameOfDivision);
            nameOfSubDivisionRangeTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_nameOfSubDivisionRange);
            vdcWOTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_vdcWo);
            nameOfNurseryOwnerTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_nameOfNurseryOwner);
            locationVillageNameTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_locationVillageName);
            limitTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_limit);
            timeDateTV = itemView.findViewById(R.id.tv_rowViewYouthWomenNursery_dateTime);


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
