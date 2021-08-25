package com.example.kpkforestdeptcdegad.GAD.OtherActivity.Adapter;

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

import com.example.kpkforestdeptcdegad.Model.FetchOtherActivityDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OtherActivityAdapter extends RecyclerView.Adapter<OtherActivityAdapter.OtherActivityVH> implements Filterable {


    Context mContext;
    private List<FetchOtherActivityDataModel> fetchOtherActivityDataModelList;
    private List<FetchOtherActivityDataModel> detailOtherActivityDataModelList;

    public OtherActivityAdapter(Context mContext, List<FetchOtherActivityDataModel> fetchOtherActivityDataModelList) {
        this.mContext = mContext;
        this.fetchOtherActivityDataModelList = fetchOtherActivityDataModelList;
        detailOtherActivityDataModelList = new ArrayList<>();
        detailOtherActivityDataModelList.addAll(fetchOtherActivityDataModelList);
    }

    @NonNull
    @Override
    public OtherActivityAdapter.OtherActivityVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_other_activity, parent, false);
        return new OtherActivityVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OtherActivityAdapter.OtherActivityVH holder, int position) {
        holder.employeeNoTV.setText(fetchOtherActivityDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchOtherActivityDataModelList.get(position).getEmployee_name());
        holder.activityTitleTV.setText(fetchOtherActivityDataModelList.get(position).getActivity_title());
        holder.nameOfForestDivisionTV.setText(fetchOtherActivityDataModelList.get(position).getName_of_forest_division());
        holder.nameOfWoTV.setText(fetchOtherActivityDataModelList.get(position).getName_of_wo());
        holder.nameOfVillageTV.setText(fetchOtherActivityDataModelList.get(position).getName_of_village());
        holder.descriptionTV.setText(fetchOtherActivityDataModelList.get(position).getDescription());
        holder.dateTimeTV.setText(fetchOtherActivityDataModelList.get(position).getDate_time());
    }

    @Override
    public int getItemCount() {
        try {
            return fetchOtherActivityDataModelList.size();
        } catch (Exception e) {
            Toast.makeText(mContext, "Data Not Found!", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchOtherActivityDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() ==0){
                filterList.addAll(detailOtherActivityDataModelList);
            }else {
                String  filter = constraint.toString().toLowerCase().trim();
                for (FetchOtherActivityDataModel dataItem:detailOtherActivityDataModelList){
                    if (dataItem.getActivity_title().toLowerCase().contains(filter)){
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
            fetchOtherActivityDataModelList.clear();
            fetchOtherActivityDataModelList.addAll((Collection<? extends FetchOtherActivityDataModel>) results.values);
            notifyDataSetChanged();
        }
    };
    public class OtherActivityVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView activityTitleTV;
        TextView nameOfForestDivisionTV;
        TextView nameOfWoTV;
        TextView nameOfVillageTV;
        TextView descriptionTV;
        TextView dateTimeTV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;


        public OtherActivityVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_empName);
            activityTitleTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_activityTitle);
            nameOfForestDivisionTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_nameOfForestDivision);
            nameOfWoTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_nameOfWo);
            nameOfVillageTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_nameOfVillage);
            descriptionTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_description);
            dateTimeTV = itemView.findViewById(R.id.tv_rowViewOtherActivity_dateTime);

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
