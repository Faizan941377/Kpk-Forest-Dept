package com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
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

public class ViewGadMassPlantingEventActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView gadMassPlantingEventRV;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    List<FetchGadMassPlantingEventDataModel> fetchGadMassPlantingEventDataModelList;
    EditText searchET;
    ImageView icoBack;
    GadMassPlantingEventAdapter gadMassPlantingEventAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gad_mass_planting_event);

        gadMassPlantingEventRV = findViewById(R.id.rv_view_GadMassPlantingEvent);
        searchET = findViewById(R.id.et_ViewGADMassPlantingEvent_search);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);

        icoBack = findViewById(R.id.iv_ViewGADMassPlantingEvent_back);

        progressDialog = new ProgressDialog(this);
        icoBack.setOnClickListener(this);

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
                gadMassPlantingEventAdapter.getFilter().filter(s);
            }
        });

    }

    private void setAdapter() {

        gadMassPlantingEventRV.setHasFixedSize(true);
        gadMassPlantingEventRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);

        Call<FetchGadMassPlantingEventResponse> call = RetrofitClient.getInstance().getApi().fetchGadMassPlantingEventResponse();
        call.enqueue(new Callback<FetchGadMassPlantingEventResponse>() {
            @Override
            public void onResponse(Call<FetchGadMassPlantingEventResponse> call, Response<FetchGadMassPlantingEventResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchGadMassPlantingEventDataModelList = response.body().getFetchGadMassPlantingEventDataModelList();
                    gadMassPlantingEventRV.setAdapter(new GadMassPlantingEventAdapter(fetchGadMassPlantingEventDataModelList, getApplicationContext()));
                    gadMassPlantingEventAdapter = new GadMassPlantingEventAdapter(fetchGadMassPlantingEventDataModelList, getApplicationContext());
                    gadMassPlantingEventRV.setAdapter(gadMassPlantingEventAdapter);
                } else {
                    Toast.makeText(ViewGadMassPlantingEventActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchGadMassPlantingEventResponse> call, Throwable t) {
                progressDialog.dismiss();
                try {
                    Toast.makeText(ViewGadMassPlantingEventActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_ViewGADMassPlantingEvent_back:
                finish();
                break;
        }
    }
}