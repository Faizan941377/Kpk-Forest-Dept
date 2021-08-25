package com.example.kpkforestdeptcdegad.Extension.ExtensionMaterialPrepared.Adapter;

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

import com.example.kpkforestdeptcdegad.Model.FetchExtensionMaterialPreparedDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ExtensionMaterialPreparedAdapter extends RecyclerView.Adapter<ExtensionMaterialPreparedAdapter.ExtensionMaterialPreparedVH> implements Filterable {

    private Context mContext;
    private List<FetchExtensionMaterialPreparedDataModel> fetchExtensionMaterialPreparedDataModelList;
    private List<FetchExtensionMaterialPreparedDataModel> detailExtensionMaterialPreparedDataModelList;

    public ExtensionMaterialPreparedAdapter(Context mContext, List<FetchExtensionMaterialPreparedDataModel> fetchExtensionMaterialPreparedDataModelList) {
        this.mContext = mContext;
        this.fetchExtensionMaterialPreparedDataModelList = fetchExtensionMaterialPreparedDataModelList;
        detailExtensionMaterialPreparedDataModelList = new ArrayList<>();
        detailExtensionMaterialPreparedDataModelList.addAll(fetchExtensionMaterialPreparedDataModelList);
    }

    @NonNull
    @Override
    public ExtensionMaterialPreparedAdapter.ExtensionMaterialPreparedVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_extension_material_prepared, parent, false);
        return new ExtensionMaterialPreparedVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExtensionMaterialPreparedAdapter.ExtensionMaterialPreparedVH holder, int position) {
        holder.souvenirsShieldsNoTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getSouvenirs_Shields_No());
        holder.noOfPanaflexTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getNo_of_panaflex());
        holder.squareFeetTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getSquare_feet());
        holder.monthOfPreparationTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getMonth_of_preparation());
        holder.noOfDiariesTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getNo_of_diaries());
        holder.noOfCalendersTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getNo_of_calenders());
        holder.bannersTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getBanners());
        holder.actionPlanTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getAction_plan());
        holder.keyChainTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getKey_chain());
        holder.noOfMiscellaneousExtensionMaterialTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getNo_of_miscellaneous_extension_material());
        holder.dateTimeTV.setText(fetchExtensionMaterialPreparedDataModelList.get(position).getTime_date());
    }

    @Override
    public int getItemCount() {
        return fetchExtensionMaterialPreparedDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchExtensionMaterialPreparedDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length()==0){
                filterList.addAll(detailExtensionMaterialPreparedDataModelList);
            }else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchExtensionMaterialPreparedDataModel dataItem:detailExtensionMaterialPreparedDataModelList){
                    if (dataItem.getSouvenirs_Shields_No().toLowerCase().contains(filter)){
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
            fetchExtensionMaterialPreparedDataModelList.clear();
            fetchExtensionMaterialPreparedDataModelList.addAll((Collection<? extends FetchExtensionMaterialPreparedDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class ExtensionMaterialPreparedVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;
        TextView souvenirsShieldsNoTV;
        TextView noOfPanaflexTV;
        TextView squareFeetTV;
        TextView monthOfPreparationTV;
        TextView noOfDiariesTV;
        TextView noOfCalendersTV;
        TextView bannersTV;
        TextView actionPlanTV;
        TextView keyChainTV;
        TextView noOfMiscellaneousExtensionMaterialTV;
        TextView dateTimeTV;


        public ExtensionMaterialPreparedVH(@NonNull View itemView) {
            super(itemView);


            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);
            souvenirsShieldsNoTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_souvenirsShieldsNo);
            noOfPanaflexTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_noOfPanaflex);
            squareFeetTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_squareFeet);
            monthOfPreparationTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_monthOfPreparation);
            noOfDiariesTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_diariesNo);
            noOfCalendersTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_CalendersNo);
            bannersTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_banners);
            actionPlanTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_actionPlan);
            keyChainTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_keyChain);
            noOfMiscellaneousExtensionMaterialTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_noOfMiscellaneousExtensionMaterial);
            dateTimeTV = itemView.findViewById(R.id.tv_rowViewExtensionMaterialPrepared_timeDate);

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
