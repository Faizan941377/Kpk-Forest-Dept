package com.example.kpkforestdeptcdegad.CD.FormForestry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.kpkforestdeptcdegad.CD.FormForestry.Adapter.FarmForestryAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchFarmForestryDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchFarmForestryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class View_FormForestry_DataActivity extends AppCompatActivity {

    RecyclerView viewFormForestryRV;
    SwipeRefreshLayout swipeRefreshLayout;
    List<FetchFarmForestryDataModel> fetchFarmForestryDataModelList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__form_forestry_data);

        viewFormForestryRV = findViewById(R.id.rv_view_formForestry);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        progressDialog = new ProgressDialog(this);
        setAdapter();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setAdapter();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void setAdapter() {
        viewFormForestryRV.setHasFixedSize(true);
        viewFormForestryRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchFarmForestryResponse> call = RetrofitClient.getInstance().getApi().fetchFetchFarmForestryResponse();
        call.enqueue(new Callback<FetchFarmForestryResponse>() {
            @Override
            public void onResponse(Call<FetchFarmForestryResponse> call, Response<FetchFarmForestryResponse> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    fetchFarmForestryDataModelList = response.body().getFetchFarmForestryDataModelList();
                    viewFormForestryRV.setAdapter(new FarmForestryAdapter(fetchFarmForestryDataModelList,getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<FetchFarmForestryResponse> call, Throwable t) {

            }
        });
    }
}