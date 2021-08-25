package com.example.kpkforestdeptcdegad.CD.FormForestry;

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
    EditText searchET;
    FarmForestryAdapter farmForestryAdapter;
    List<FetchFarmForestryDataModel> fetchFarmForestryDataModelList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__form_forestry_data);

        viewFormForestryRV = findViewById(R.id.rv_view_formForestry);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        searchET = findViewById(R.id.et_ViewFarmForestry_Search);

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
                farmForestryAdapter.getFilter().filter(s);
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

        Call<FetchFarmForestryResponse> call = RetrofitClient.getInstance().getApi().fetchFarmForestryResponse();
        call.enqueue(new Callback<FetchFarmForestryResponse>() {
            @Override
            public void onResponse(Call<FetchFarmForestryResponse> call, Response<FetchFarmForestryResponse> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    fetchFarmForestryDataModelList = response.body().getFetchFarmForestryDataModelList();
                    viewFormForestryRV.setAdapter(new FarmForestryAdapter(fetchFarmForestryDataModelList,getApplicationContext()));
                    farmForestryAdapter = new FarmForestryAdapter(fetchFarmForestryDataModelList,getApplicationContext());
                    viewFormForestryRV.setAdapter(farmForestryAdapter);
                }else {
                    Toast.makeText(View_FormForestry_DataActivity.this, "Please Check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchFarmForestryResponse> call, Throwable t) {
                try {
                    Toast.makeText(View_FormForestry_DataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}