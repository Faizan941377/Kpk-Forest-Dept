package com.example.kpkforestdeptcdegad.GAD.WemonOrganization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.GAD.WemonOrganization.Adapter.WomenOrganizationAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchVDCDataModel;
import com.example.kpkforestdeptcdegad.Model.FetchWomenOrganizationDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchWomenOrganizationResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewWomenOrganizationActivity extends AppCompatActivity {

    RecyclerView womenOrganizationRV;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    List<FetchWomenOrganizationDataModel> fetchWomenOrganizationDataModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_women_organization);

        womenOrganizationRV = findViewById(R.id.rv_view_womenOrganization);
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
        womenOrganizationRV.setHasFixedSize(true);
        womenOrganizationRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchWomenOrganizationResponse> call = RetrofitClient.getInstance().getApi().fetchWomenOrganizationResponse();
        call.enqueue(new Callback<FetchWomenOrganizationResponse>() {
            @Override
            public void onResponse(Call<FetchWomenOrganizationResponse> call, Response<FetchWomenOrganizationResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchWomenOrganizationDataModelList = response.body().getFetchWomenOrganizationDataModelList();
                    womenOrganizationRV.setAdapter(new WomenOrganizationAdapter(getApplicationContext(), fetchWomenOrganizationDataModelList));
                }
            }

            @Override
            public void onFailure(Call<FetchWomenOrganizationResponse> call, Throwable t) {
                try {
                    Toast.makeText(ViewWomenOrganizationActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}