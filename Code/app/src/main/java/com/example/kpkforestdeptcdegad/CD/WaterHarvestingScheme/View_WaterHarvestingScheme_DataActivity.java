package com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.Model.FetchVDCDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchWaterHarvestingSchemeDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchVDCDataResponse;
import com.example.kpkforestdeptcdegad.Response.FetchWaterHarvestingSchemeResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class View_WaterHarvestingScheme_DataActivity extends AppCompatActivity {

    RecyclerView waterHarvestingSchemeRV;
    SwipeRefreshLayout swipeRefreshLayout;
    List<FetchWaterHarvestingSchemeDataModel> fetchWaterHarvestingSchemeDataModelList;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__water_harvesting_scheme__data);

        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        waterHarvestingSchemeRV = findViewById(R.id.rv_view_water_harvesting_scheme);
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
        waterHarvestingSchemeRV.setHasFixedSize(true);
        waterHarvestingSchemeRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchWaterHarvestingSchemeResponse> call = RetrofitClient.getInstance().getApi().fetchWaterHarvestingResponse();
        call.enqueue(new Callback<FetchWaterHarvestingSchemeResponse>() {
            @Override
            public void onResponse(Call<FetchWaterHarvestingSchemeResponse> call, Response<FetchWaterHarvestingSchemeResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchWaterHarvestingSchemeDataModelList = response.body().getFetchWaterHarvestingSchemeDataModelList();
                    waterHarvestingSchemeRV.setAdapter(new WaterHarvestingScheme_Adapter(fetchWaterHarvestingSchemeDataModelList, getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<FetchWaterHarvestingSchemeResponse> call, Throwable t) {
                try {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}