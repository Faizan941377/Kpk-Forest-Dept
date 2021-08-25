package com.example.kpkforestdeptcdegad.GAD.WemonOrganization.Adapter;

import android.content.Context;
import android.os.Build;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kpkforestdeptcdegad.Model.FetchOtherActivityDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchWomenOrganizationDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WomenOrganizationAdapter extends RecyclerView.Adapter<WomenOrganizationAdapter.WomenOrganizationVH> implements Filterable {

    Context mContext;
    private List<FetchWomenOrganizationDataModel> fetchWomenOrganizationDataModelList;
    private List<FetchWomenOrganizationDataModel> detailWomenOrganizationDataModelList;

    public WomenOrganizationAdapter(Context mContext, List<FetchWomenOrganizationDataModel> fetchWomenOrganizationDataModelList) {
        this.mContext = mContext;
        this.fetchWomenOrganizationDataModelList = fetchWomenOrganizationDataModelList;
        detailWomenOrganizationDataModelList = new ArrayList<>();
        detailWomenOrganizationDataModelList.addAll(fetchWomenOrganizationDataModelList);
    }

    @NonNull
    @Override
    public WomenOrganizationAdapter.WomenOrganizationVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view_women_organization, parent, false);
        return new WomenOrganizationVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WomenOrganizationAdapter.WomenOrganizationVH holder, int position) {
        holder.employeeNoTV.setText(fetchWomenOrganizationDataModelList.get(position).getEmployee_no());
        holder.employeeNameTV.setText(fetchWomenOrganizationDataModelList.get(position).getEmployee_name());
        holder.nameOfVillageVDCTV.setText(fetchWomenOrganizationDataModelList.get(position).getName_of_village_vdc());
        holder.nameOfWoTV.setText(fetchWomenOrganizationDataModelList.get(position).getName_of_wo());
        holder.dateYearOfEstablishmentTV.setText(fetchWomenOrganizationDataModelList.get(position).getDate_year_of_establishment());
        holder.nameOfPresidentTV.setText(fetchWomenOrganizationDataModelList.get(position).getName_of_president());
        holder.majorActivitiesTV.setText(fetchWomenOrganizationDataModelList.get(position).getMojor_activities());
        holder.totalNoOfMembersTV.setText(fetchWomenOrganizationDataModelList.get(position).getTotal_member());
        holder.contactTV.setText(fetchWomenOrganizationDataModelList.get(position).getContact());
        holder.dateTimeTV.setText(fetchWomenOrganizationDataModelList.get(position).getTime_date());
        String path = RetrofitClient.IMAGE_BASE_URL + fetchWomenOrganizationDataModelList.get(position).getImage() + "";
        Glide.with(mContext).load(path).into(holder.siteImageIV);
    }

    @Override
    public int getItemCount() {
        return fetchWomenOrganizationDataModelList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchWomenOrganizationDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filterList.addAll(detailWomenOrganizationDataModelList);
            } else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchWomenOrganizationDataModel dataItem : detailWomenOrganizationDataModelList) {
                    if (dataItem.getName_of_village_vdc().toLowerCase().contains(filter)){
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
            fetchWomenOrganizationDataModelList.clear();
            fetchWomenOrganizationDataModelList.addAll((Collection<? extends FetchWomenOrganizationDataModel>) results.values);
            notifyDataSetChanged();
        }
    };

    public class WomenOrganizationVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView employeeNoTV;
        TextView employeeNameTV;
        TextView nameOfVillageVDCTV;
        TextView nameOfWoTV;
        TextView dateYearOfEstablishmentTV;
        TextView nameOfPresidentTV;
        TextView majorActivitiesTV;
        TextView totalNoOfMembersTV;
        TextView contactTV;
        TextView dateTimeTV;
        ImageView siteImageIV;
        TextView showMoreTV;
        CardView expendingCardView;
        LinearLayout expendableLinearLayout2;


        public WomenOrganizationVH(@NonNull View itemView) {
            super(itemView);


            employeeNoTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_Employee_No);
            employeeNameTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_empName);
            nameOfVillageVDCTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_nameOfVillageVDC);
            nameOfWoTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_nameOfWO);
            dateYearOfEstablishmentTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_dateYearOfEstablishment);
            nameOfPresidentTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_nameOfPresent);
            majorActivitiesTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_MajorActivities);
            totalNoOfMembersTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_totalNoOfMenbers);
            contactTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_rowViewWomenOrganization_contact);
            dateTimeTV = itemView.findViewById(R.id.tv_rowViewWomenOrganization_dateTime);
            siteImageIV = itemView.findViewById(R.id.iv_rowViewWomenOrganization_showImage);
            showMoreTV = itemView.findViewById(R.id.tv_rowViewVDC_showMore);
            expendingCardView = itemView.findViewById(R.id.cardView_row_vdc);
            expendableLinearLayout2 = itemView.findViewById(R.id.LL2_expendableTextView);

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
