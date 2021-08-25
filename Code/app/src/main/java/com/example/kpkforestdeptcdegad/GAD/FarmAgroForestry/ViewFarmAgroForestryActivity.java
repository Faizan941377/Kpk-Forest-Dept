package com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry;

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

import com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry.Adapter.FarmAgroForestryAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchFarmAgroForestryDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchFarmAgroForestryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewFarmAgroForestryActivity extends AppCompatActivity {

    RecyclerView farmAgroForestryRV;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    List<FetchFarmAgroForestryDataModel> fetchFarmAgroForestryDataModelList;
    EditText searchET;
    FarmAgroForestryAdapter farmAgroForestryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_farm_agro_forestry);

        progressDialog = new ProgressDialog(this);
        farmAgroForestryRV = findViewById(R.id.rv_view_farmAgroForestry);
        searchET = findViewById(R.id.et_ViewFarmAgroForestry_search);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);

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
                farmAgroForestryAdapter.getFilter().filter(s);
            }
        });
    }

    private void setAdapter() {
        farmAgroForestryRV.setHasFixedSize(true);
        farmAgroForestryRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);

        Call<FetchFarmAgroForestryResponse> call = RetrofitClient.getInstance().getApi().fetchFarmAgroForestryResponse();
        call.enqueue(new Callback<FetchFarmAgroForestryResponse>() {
            @Override
            public void onResponse(Call<FetchFarmAgroForestryResponse> call, Response<FetchFarmAgroForestryResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchFarmAgroForestryDataModelList = response.body().getFetchFarmAgroForestryDataModelList();
                    farmAgroForestryRV.setAdapter(new FarmAgroForestryAdapter(getApplicationContext(), fetchFarmAgroForestryDataModelList));
                    farmAgroForestryAdapter = new FarmAgroForestryAdapter(getApplicationContext(), fetchFarmAgroForestryDataModelList);
                    farmAgroForestryRV.setAdapter(farmAgroForestryAdapter);
                } else {
                    Toast.makeText(ViewFarmAgroForestryActivity.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchFarmAgroForestryResponse> call, Throwable t) {
                progressDialog.dismiss();
                try {
                    Toast.makeText(ViewFarmAgroForestryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}