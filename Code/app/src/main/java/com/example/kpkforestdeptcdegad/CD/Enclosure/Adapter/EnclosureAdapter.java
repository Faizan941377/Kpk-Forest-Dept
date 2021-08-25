package com.example.kpkforestdeptcdegad.CD.Enclosure.Adapter;

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
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.Model.FetchEnclosureDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnclosureAdapter extends RecyclerView.Adapter<EnclosureAdapter.EnclosureVH> implements Filterable {

    private List<FetchEnclosureDataModel> fetchEnclosureDataModelList;
    private Context mContext;
    private List<FetchEnclosureDataModel> detailEnclosureDataModelList;

    public EnclosureAdapter(List<FetchEnclosureDataModel> fetchEnclosureDataModelList, Context mContext) {
        this.fetchEnclosureDataModelList = fetchEnclosureDataModelList;
        this.mContext = mContext;
        detailEnclosureDataModelList = new ArrayList<>();
        detailEnclosureDataModelList.addAll(fetchEnclosureDataModelList);
    }

    @NonNull
    @Override
    public EnclosureAdapter.EnclosureVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_enclosure,parent,false);
        return new EnclosureVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EnclosureAdapter.EnclosureVH holder, int position) {
        holder.employeeNoTV.setText(fetchEnclosureDataModelList.get(position).getEmployee_No());
        holder.empNameTV.setText(fetchEnclosureDataModelList.get(position).getEmployee_name());
        holder.forestDivisionTV.setText(fetchEnclosureDataModelList.get(position).getForest_division());
        holder.DateTV.setText(fetchEnclosureDataModelList.get(position).getEntry_date());
        holder.targetAsPC1EnclosureTV.setText(fetchEnclosureDataModelList.get(position).getTarget_as_pc_1_enclosure());
        holder.siteForEnclosureAchievedTV.setText(fetchEnclosureDataModelList.get(position).getSite_for_enclosure_achieved());
        holder.vdcEstablishedTV.setText(fetchEnclosureDataModelList.get(position).getVdc_established());
        holder.nigehbansHiredTV.setText(fetchEnclosureDataModelList.get(position).getNigehbans_hired());
        holder.paymentUptoTV.setText(fetchEnclosureDataModelList.get(position).getPayment_upto());
        holder.balanceTargetTV.setText(fetchEnclosureDataModelList.get(position).getBalance_target());
        holder.remarksTV.setText(fetchEnclosureDataModelList.get(position).getRemarks());
        holder.timeDateTV.setText(fetchEnclosureDataModelList.get(position).getDate_time());
    }

    @Override
    public int getItemCount() {
        return fetchEnclosureDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchEnclosureDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filterList.addAll(detailEnclosureDataModelList);
            }else {
                String  filter = constraint.toString().trim();
                for (FetchEnclosureDataModel dataItem:detailEnclosureDataModelList){
                    if (dataItem.getForest_division().toLowerCase().contains(filter)){
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
            fetchEnclosureDataModelList.clear();
            fetchEnclosureDataModelList.addAll((Collection<? extends FetchEnclosureDataModel>) results.values);
            notifyDataSetChanged();
        }
    };


    public class EnclosureVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        TextView employeeNoTV;
        TextView empNameTV;
        TextView forestDivisionTV;
        TextView DateTV;
        TextView targetAsPC1EnclosureTV;
        TextView siteForEnclosureAchievedTV;
        TextView vdcEstablishedTV;
        TextView nigehbansHiredTV;
        TextView paymentUptoTV;
        TextView balanceTargetTV;
        TextView remarksTV;
        TextView timeDateTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public EnclosureVH(@NonNull View itemView) {
            super(itemView);

            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            empNameTV =itemView.findViewById(R.id.tv_rowViewEnclosure_empName);
            employeeNoTV = itemView.findViewById(R.id.tv_rowViewEnclosure_Employee_No);
            forestDivisionTV = itemView.findViewById(R.id.tv_rowViewEnclosure_ForestDivision);
            DateTV = itemView.findViewById(R.id.tv_rowViewEnclosure_Date);
            targetAsPC1EnclosureTV =itemView.findViewById(R.id.tv_rowViewEnclosure_targetAsPC1Enclosure);
            siteForEnclosureAchievedTV = itemView.findViewById(R.id.tv_rowViewEnclosure_SiteForEnclosureAchieved);
            vdcEstablishedTV = itemView.findViewById(R.id.tv_rowViewEnclosure_VDCEstablished);
            nigehbansHiredTV = itemView.findViewById(R.id.tv_rowViewEnclosure_nigehbansHired);
            paymentUptoTV = itemView.findViewById(R.id.tv_rowViewEnclosure_paymentUpto);
            balanceTargetTV = itemView.findViewById(R.id.tv_rowViewEnclosure_balanceTarget);
            remarksTV = itemView.findViewById(R.id.tv_rowViewEnclosure_remarks);
            timeDateTV =itemView.findViewById(R.id.tv_rowViewEnclosure_time);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL1_expendableTextView);



            showMoreTV.setOnClickListener(this);
        }

        public void ShowMore(View view){
            if (expendableLinearLayout2.getVisibility() == view.GONE){
                showMoreTV.setText("Show Less");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(expendingCardView,new AutoTransition());
                    expendableLinearLayout2.setVisibility(View.VISIBLE);
                }
            }else {
                showMoreTV.setText("Read More");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(expendingCardView,new AutoTransition());
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
