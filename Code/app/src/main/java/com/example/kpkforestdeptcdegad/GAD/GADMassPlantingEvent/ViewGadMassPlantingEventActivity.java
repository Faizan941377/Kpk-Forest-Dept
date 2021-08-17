package com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent.Adapter.GadMassPlantingEventAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchGadMassPlantingEventDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchGadMassPlantingEventResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewGadMassPlantingEventActivity extends AppCompatActivity {

    RecyclerView gadMassPlantingEventRV;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    List<FetchGadMassPlantingEventDataModel> fetchGadMassPlantingEventDataModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gad_mass_planting_event);

        gadMassPlantingEventRV = findViewById(R.id.rv_view_GadMassPlantingEvent);
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

        gadMassPlantingEventRV.setHasFixedSize(true);
        gadMassPlantingEventRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);

        Call<FetchGadMassPlantingEventResponse> call = RetrofitClient.getInstance().getApi().fetchGadMassPlantingEventResponse();
        call.enqueue(new Callback<FetchGadMassPlantingEventResponse>() {
            @Override
            public void onResponse(Call<FetchGadMassPlantingEventResponse> call, Response<FetchGadMassPlantingEventResponse> response) {
                fetchGadMassPlantingEventDataModelList = response.body().getFetchGadMassPlantingEventDataModelList();
                gadMassPlantingEventRV.setAdapter(new GadMassPlantingEventAdapter(fetchGadMassPlantingEventDataModelList, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<FetchGadMassPlantingEventResponse> call, Throwable t) {
                try {
                    Toast.makeText(ViewGadMassPlantingEventActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}