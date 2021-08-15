package com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting.Adapter.CelebrationOfEnvironmentalPlantingEventAdapter;
import com.example.kpkforestdeptcdegad.Extension.MassPlantingEvent.Adapter.MassPlantingEventAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchCelebrationOfEnvironmentalPlantingEventDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchCelebrationOfEnvironmentalPlantingEventResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCelebrationOfEnvironmentalPlantingActivity extends AppCompatActivity {


    RecyclerView celebrationOfEnvironmentalPlantingEventRV;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    List<FetchCelebrationOfEnvironmentalPlantingEventDataModel> fetchCelebrationOfEnvironmentalPlantingEventDataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_celebration_of_environmental_planting);

        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        celebrationOfEnvironmentalPlantingEventRV = findViewById(R.id.rv_celebrationOfEnvironmentalPlantingEvent);

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
        celebrationOfEnvironmentalPlantingEventRV.setHasFixedSize(true);
        celebrationOfEnvironmentalPlantingEventRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchCelebrationOfEnvironmentalPlantingEventResponse> call = RetrofitClient.getInstance().getApi().fetchCelebrationOfEnvironmentalPlantingEvent();
        call.enqueue(new Callback<FetchCelebrationOfEnvironmentalPlantingEventResponse>() {
            @Override
            public void onResponse(Call<FetchCelebrationOfEnvironmentalPlantingEventResponse> call, Response<FetchCelebrationOfEnvironmentalPlantingEventResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchCelebrationOfEnvironmentalPlantingEventDataModelList = response.body().getFetchCelebrationOfEnvironmentalPlantingEventDataModelList();
                    celebrationOfEnvironmentalPlantingEventRV.setAdapter(new CelebrationOfEnvironmentalPlantingEventAdapter(getApplicationContext(), fetchCelebrationOfEnvironmentalPlantingEventDataModelList));
                }
            }

            @Override
            public void onFailure(Call<FetchCelebrationOfEnvironmentalPlantingEventResponse> call, Throwable t) {

            }
        });
    }
}