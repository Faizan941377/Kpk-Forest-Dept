package com.example.kpkforestdeptcdegad.CD.VDC.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.kpkforestdeptcdegad.Model.FetchVDCDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;

public class VDC_Adapter extends RecyclerView.Adapter<VDC_Adapter.VDCVH> {

     ArrayList<FetchVDCDataModel> fetchVDCDataModelList;
     Context mContext;

    public VDC_Adapter(ArrayList<FetchVDCDataModel> fetchVDCDataModelList, Context mContext) {
        this.fetchVDCDataModelList = fetchVDCDataModelList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public VDC_Adapter.VDCVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_vdc, parent, false);
        return new VDCVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VDC_Adapter.VDCVH holder, int position) {
        holder.forestDivisionTV.setText(fetchVDCDataModelList.get(position).getName_of_forest_divsion());
        holder.subDivisionRangeTV.setText(fetchVDCDataModelList.get(position).getName_of_sub_division_range());
        holder.nameOfVillageTV.setText(fetchVDCDataModelList.get(position).getName_of_village());
        holder.nameOfVDCJFMCTV.setText(fetchVDCDataModelList.get(position).getName_of_vdc_jfmc());
        holder.dateOfEstablishmentRegistrationTV.setText(fetchVDCDataModelList.get(position).getDate_of_establishment_registration());
        holder.nameOfPresidentTV.setText(fetchVDCDataModelList.get(position).getName_of_president());
        holder.contactTV.setText(fetchVDCDataModelList.get(position).getContact());
        holder.JFMCWOTV.setText(fetchVDCDataModelList.get(position).getJfmc_wo());
        holder.totalMemberTV.setText(fetchVDCDataModelList.get(position).getTotal_member());
        holder.timeDateTV.setText(fetchVDCDataModelList.get(position).getDate_time());
        String path = RetrofitClient.IMAGE_BASE_URL + fetchVDCDataModelList.get(position).getImage() + "";
        Glide.with(mContext).load(path).into(holder.siteImageIV);
    }

    @Override
    public int getItemCount() {
        try {
            return fetchVDCDataModelList.size();

        } catch (Exception e) {

            Toast.makeText(mContext, "Data Not Found", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    public class VDCVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView showMoreTV;
        TextView forestDivisionTV;
        TextView subDivisionRangeTV;
        TextView nameOfVillageTV;
        TextView nameOfVDCJFMCTV;
        TextView dateOfEstablishmentRegistrationTV;
        TextView nameOfPresidentTV;
        TextView contactTV;
        TextView JFMCWOTV;
        TextView totalMemberTV;
        TextView timeDateTV;
        ImageView siteImageIV;
        ProgressBar progressBarSiteImage;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;

        public VDCVH(@NonNull View itemView) {
            super(itemView);
            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);
            forestDivisionTV = itemView.findViewById(R.id.tv_forestDivision);
            siteImageIV = itemView.findViewById(R.id.iv_showImage);
            progressBarSiteImage = itemView.findViewById(R.id.pb_image);
            subDivisionRangeTV = itemView.findViewById(R.id.tv_viewVDC_subDivisionRange);
            nameOfVillageTV = itemView.findViewById(R.id.tv_viewVDC_nameOfVillage);
            nameOfVDCJFMCTV = itemView.findViewById(R.id.tv_viewVDC_nameOfVDC_JFMC);
            dateOfEstablishmentRegistrationTV = itemView.findViewById(R.id.tv_viewVDC_dateOfEstablishmentRegistration);
            nameOfPresidentTV = itemView.findViewById(R.id.tv_viewVDC_nameOfPresident);
            contactTV = itemView.findViewById(R.id.tv_viewVDC_contact);
            JFMCWOTV = itemView.findViewById(R.id.tv_viewVDC_JFMC_WO);
            totalMemberTV = itemView.findViewById(R.id.tv_viewVDC_totalMember);
            timeDateTV = itemView.findViewById(R.id.tv_viewVDC_dateTime);



            showMoreTV.setOnClickListener(this);
        }

// this method for read more option in recyclerview

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
