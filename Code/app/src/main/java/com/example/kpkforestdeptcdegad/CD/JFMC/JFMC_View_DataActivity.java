package com.example.kpkforestdeptcdegad.CD.JFMC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_f_m_c_view_data);


        jfmcViewRV = findViewById(R.id.rv_view_jfmc);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
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

        jfmcViewRV.setHasFixedSize(true);
        jfmcViewRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Call<FetchJFMCDataResponse> call = RetrofitClient.getInstance().getApi().fetchJFMCDataResponse();
        call.enqueue(new Callback<FetchJFMCDataResponse>() {
            @Override
            public void onResponse(Call<FetchJFMCDataResponse> call, Response<FetchJFMCDataResponse> response) {
                if (response.isSuccessful()){
                    fetchJFMCDataModelList = response.body().getFetchJFMCDataModelList();
                    jfmcViewRV.setAdapter(new JFMC_Adapter(getApplicationContext(), (ArrayList<FetchJFMCDataModel>) fetchJFMCDataModelList));
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