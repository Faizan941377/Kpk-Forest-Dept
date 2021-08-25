package com.example.kpkforestdeptcdegad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kpkforestdeptcdegad.Model.FetchFarmAgroForestryDataModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> implements Filterable {

    private List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModels;
    private List<FetchFarmAgroForestryDataModel> data;
    private Context mContext;

    public AdapterClass(List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModels, Context mContext) {
        this.fetchFarmAgroForestryDataModels = fetchFarmAgroForestryDataModels;
        this.mContext = mContext;
        data = new ArrayList<>();
        data.addAll(fetchFarmAgroForestryDataModels);
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        holder.textView.setText(fetchFarmAgroForestryDataModels.get(position).getEmployee_name());
    }

    @Override
    public int getItemCount() {
        return fetchFarmAgroForestryDataModels.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    private Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<FetchFarmAgroForestryDataModel> filterList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filterList.addAll(data);
            }else {
                String filter = constraint.toString().toLowerCase().trim();
                for (FetchFarmAgroForestryDataModel dataItem:data){
                    if (dataItem.getEmployee_name().toLowerCase().contains(filter)){
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
            fetchFarmAgroForestryDataModels.clear();
            fetchFarmAgroForestryDataModels.addAll((Collection<? extends FetchFarmAgroForestryDataModel>) results.values);
            notifyDataSetChanged();
        }
    };


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
