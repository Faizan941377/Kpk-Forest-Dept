package com.example.kpkforestdeptcdegad.CD.JFMC.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.Model.FetchJFMCDataModel;
import com.example.kpkforestdeptcdegad.R;

import java.util.List;

public class JFMC_Adapter extends RecyclerView.Adapter<JFMC_Adapter.JFMCVH> {

    Context mContext;
    List<FetchJFMCDataModel> fetchJFMCDataModelList;

    public JFMC_Adapter(Context mContext, List<FetchJFMCDataModel> fetchJFMCDataModelList) {
        this.mContext = mContext;
        this.fetchJFMCDataModelList = fetchJFMCDataModelList;
    }

    @NonNull
    @Override
    public JFMC_Adapter.JFMCVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_jfmc,parent,false);
        return new JFMCVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JFMC_Adapter.JFMCVH holder, int position) {
        holder.employeeNoTV.setText(fetchJFMCDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchJFMCDataModelList.get(position).getEmployee_name());
        holder.forestDivisionTV.setText(fetchJFMCDataModelList.get(position).getName_of_forest_division());
        holder.subDivisionRangeTV.setText(fetchJFMCDataModelList.get(position).getName_of_sub_division_range());
        holder.nameOfVillageTV.setText(fetchJFMCDataModelList.get(position).getName_of_village_vdc());
        holder.nameOfVDCJFMCTV.setText(fetchJFMCDataModelList.get(position).getName_of_jfmc());
        holder.dateOfEstablishmentRegistrationTV.setText(fetchJFMCDataModelList.get(position).getDate_of_establishment_registration());
        holder.nameOfPresidentTV.setText(fetchJFMCDataModelList.get(position).getName_of_president());
        holder.contactTV.setText(fetchJFMCDataModelList.get(position).getContact());
        holder.timeDateTV.setText(fetchJFMCDataModelList.get(position).getTime_date());
    }

    @Override
    public int getItemCount() {
        try {
            return fetchJFMCDataModelList.size();
        }catch (Exception e){
            Toast.makeText(mContext, "Data Not Found", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    public class JFMCVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView showMoreTV;
        TextView forestDivisionTV;
        TextView subDivisionRangeTV;
        TextView nameOfVillageTV;
        TextView nameOfVDCJFMCTV;
        TextView dateOfEstablishmentRegistrationTV;
        TextView nameOfPresidentTV;
        TextView contactTV;
        TextView timeDateTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public JFMCVH(@NonNull View itemView) {
            super(itemView);

            employeeNoTV = itemView.findViewById(R.id.tv_rowViewJfmc_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewJfmc_empName);
            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);
            forestDivisionTV = itemView.findViewById(R.id.tv_ViewJFMC_forestDivision);
            subDivisionRangeTV = itemView.findViewById(R.id.tv_viewJFMC_subDivisionRange);
            nameOfVillageTV = itemView.findViewById(R.id.tv_viewJFMC_nameOfVillage);
            nameOfVDCJFMCTV = itemView.findViewById(R.id.tv_viewJFMC_nameOfJFMC);
            dateOfEstablishmentRegistrationTV = itemView.findViewById(R.id.tv_viewJFMC_dateOfEstablishmentRegistration);
            nameOfPresidentTV = itemView.findViewById(R.id.tv_viewJFMC_nameOfPresident);
            contactTV = itemView.findViewById(R.id.tv_viewJFMC_contact);
            timeDateTV = itemView.findViewById(R.id.tv_viewJFMC_timeDate);


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
