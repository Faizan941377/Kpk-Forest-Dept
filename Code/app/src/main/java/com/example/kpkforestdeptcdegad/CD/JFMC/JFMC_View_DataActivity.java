package com.example.kpkforestdeptcdegad.CD.JFMC;

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

import com.example.kpkforestdeptcdegad.CD.JFMC.Adapter.JFMC_Adapter;
import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.Model.FetchJFMCDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchVDCDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchJFMCDataResponse;
import com.example.kpkforestdeptcdegad.Response.FetchVDCDataResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JFMC_View_DataActivity extends AppCompatActivity {

    RecyclerView jfmcViewRV;
    List<FetchJFMCDataModel> fetchJFMCDataModelList;
    SwipeRefreshLayout swipeRefreshLayout;
    EditText searchET;
    JFMC_Adapter jfmcAdapter;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_f_m_c_view_data);

        progressDialog = new ProgressDialog(this);

        jfmcViewRV = findViewById(R.id.rv_view_jfmc);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        searchET = findViewById(R.id.et_viewJFMC_search);
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
                jfmcAdapter.getFilter().filter(s);
            }
        });
    }

    private void setAdapter() {

        jfmcViewRV.setHasFixedSize(true);
        jfmcViewRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        Call<FetchJFMCDataResponse> call = RetrofitClient.getInstance().getApi().fetchJFMCDataResponse();
        call.enqueue(new Callback<FetchJFMCDataResponse>() {
            @Override
            public void onResponse(Call<FetchJFMCDataResponse> call, Response<FetchJFMCDataResponse> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    fetchJFMCDataModelList = response.body().getFetchJFMCDataModelList();
                    jfmcViewRV.setAdapter(new JFMC_Adapter(getApplicationContext(),fetchJFMCDataModelList));
                    jfmcAdapter = new JFMC_Adapter(getApplicationContext(), fetchJFMCDataModelList);
                    jfmcViewRV.setAdapter(jfmcAdapter);
                }else {
                    Toast.makeText(JFMC_View_DataActivity.this, "Please check you internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchJFMCDataResponse> call, Throwable t) {
                try {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
    }
}