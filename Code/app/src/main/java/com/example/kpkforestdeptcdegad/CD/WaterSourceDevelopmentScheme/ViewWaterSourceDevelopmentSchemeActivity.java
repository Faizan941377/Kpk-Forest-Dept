package com.example.kpkforestdeptcdegad.CD.WaterSourceDevelopmentScheme;

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
import com.example.kpkforestdeptcdegad.CD.WaterSourceDevelopmentScheme.Adapter.WaterSourceDevelopmentSchemeAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchWaterSourceDevelopSchemeDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchWaterSourceDevelopSchemeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewWaterSourceDevelopmentSchemeActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView waterSourceDevelopSchemeRV;
    ProgressDialog progressDialog;
    WaterSourceDevelopmentSchemeAdapter waterSourceDevelopmentSchemeAdapter;
    EditText searchET;
    List<FetchWaterSourceDevelopSchemeDataModel> fetchWaterSourceDevelopSchemeDataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_water_source_development_scheme);

        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        waterSourceDevelopSchemeRV = findViewById(R.id.rv_view_water_source_scheme);
        searchET = findViewById(R.id.et_ViewWaterSouceDevelopmentScheme_search);

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
                waterSourceDevelopmentSchemeAdapter.getFilter().filter(s);
            }
        });
    }

    private void setAdapter() {
        waterSourceDevelopSchemeRV.setHasFixedSize(true);
        waterSourceDevelopSchemeRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchWaterSourceDevelopSchemeResponse> call = RetrofitClient.getInstance().getApi().fetchWaterSourceDevelopSchemeResponse();
        call.enqueue(new Callback<FetchWaterSourceDevelopSchemeResponse>() {
            @Override
            public void onResponse(Call<FetchWaterSourceDevelopSchemeResponse> call, Response<FetchWaterSourceDevelopSchemeResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchWaterSourceDevelopSchemeDataModelList = response.body().getFetchWaterSourceDevelopSchemeDataModelList();
                    waterSourceDevelopSchemeRV.setAdapter(new WaterSourceDevelopmentSchemeAdapter(fetchWaterSourceDevelopSchemeDataModelList, getApplicationContext()));
                    waterSourceDevelopmentSchemeAdapter = new WaterSourceDevelopmentSchemeAdapter(fetchWaterSourceDevelopSchemeDataModelList, getApplicationContext());
                    waterSourceDevelopSchemeRV.setAdapter(waterSourceDevelopmentSchemeAdapter);
                } else {
                    Toast.makeText(ViewWaterSourceDevelopmentSchemeActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchWaterSourceDevelopSchemeResponse> call, Throwable t) {
                try {
                    Toast.makeText(ViewWaterSourceDevelopmentSchemeActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}