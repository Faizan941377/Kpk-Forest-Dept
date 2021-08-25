package com.example.kpkforestdeptcdegad.Extension.MassPlantingEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.Extension.MassPlantingEvent.Adapter.MassPlantingEventAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchMassPlantingEventDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchMassPlantingEventResponse;
import com.example.kpkforestdeptcdegad.user.Profile.ProfileFragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewMassPlantingEventActivity extends AppCompatActivity {

    RecyclerView massPlantingEventRV;
    SwipeRefreshLayout swipeRefreshLayout;
    List<FetchMassPlantingEventDataModel> fetchMassPlantingEventDataModelList;
    ProgressDialog progressDialog;
    EditText searchET;
    MassPlantingEventAdapter massPlantingEventAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mass_planting_event);

        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        massPlantingEventRV = findViewById(R.id.rv_massPlantingEvent);
        searchET = findViewById(R.id.et_ViewMassPlantingEvent_search);

        progressDialog = new ProgressDialog(this);


        setAdapter();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setAdapter();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                massPlantingEventAdapter.getFilter().filter(s);
            }
        });
    }

    private void setAdapter() {
        massPlantingEventRV.setHasFixedSize(true);
        massPlantingEventRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);


        Call<FetchMassPlantingEventResponse> call = RetrofitClient.getInstance().getApi().fetchMassPlantingEventResponse();
        call.enqueue(new Callback<FetchMassPlantingEventResponse>() {
            @Override
            public void onResponse(Call<FetchMassPlantingEventResponse> call, Response<FetchMassPlantingEventResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchMassPlantingEventDataModelList = response.body().getFetchMassPlantingEventDataModelList();
                    massPlantingEventRV.setAdapter(new MassPlantingEventAdapter(fetchMassPlantingEventDataModelList, getApplicationContext()));
                    massPlantingEventAdapter = new MassPlantingEventAdapter(fetchMassPlantingEventDataModelList,getApplicationContext());
                    massPlantingEventRV.setAdapter(massPlantingEventAdapter);
                }else {
                    Toast.makeText(ViewMassPlantingEventActivity.this, "Please check you internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchMassPlantingEventResponse> call, Throwable t) {
                try {
                    Toast.makeText(ViewMassPlantingEventActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}