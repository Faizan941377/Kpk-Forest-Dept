package com.example.kpkforestdeptcdegad.CD.Enclosure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.Enclosure.Adapter.EnclosureAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchEnclosureDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchEnclosureResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class View_Enclosure_DataActivity extends AppCompatActivity {

    RecyclerView enclosureRV;
    SwipeRefreshLayout swipeRefreshLayout;
    List<FetchEnclosureDataModel> fetchEnclosureDataModelList;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__enclosure__data);

        enclosureRV = findViewById(R.id.rv_view_enclosure);
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
        enclosureRV.setHasFixedSize(true);
        enclosureRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchEnclosureResponse> call = RetrofitClient.getInstance().getApi().fetchEnclosureResponse();
        call.enqueue(new Callback<FetchEnclosureResponse>() {
            @Override
            public void onResponse(Call<FetchEnclosureResponse> call, Response<FetchEnclosureResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchEnclosureDataModelList = response.body().getFetchEnclosureDataModelList();
                    enclosureRV.setAdapter(new EnclosureAdapter(fetchEnclosureDataModelList, getApplicationContext()));

                }
            }

            @Override
            public void onFailure(Call<FetchEnclosureResponse> call, Throwable t) {
                try {
                    Toast.makeText(View_Enclosure_DataActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}