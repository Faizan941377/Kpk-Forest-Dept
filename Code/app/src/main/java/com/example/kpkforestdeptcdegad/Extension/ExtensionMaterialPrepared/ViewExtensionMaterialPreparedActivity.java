package com.example.kpkforestdeptcdegad.Extension.ExtensionMaterialPrepared;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting.Adapter.CelebrationOfEnvironmentalPlantingEventAdapter;
import com.example.kpkforestdeptcdegad.Extension.ExtensionMaterialPrepared.Adapter.ExtensionMaterialPreparedAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchExtensionMaterialPreparedDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchExtensionMaterialPreparedResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewExtensionMaterialPreparedActivity extends AppCompatActivity {

    RecyclerView extensionMaterialPreparedRV;
    SwipeRefreshLayout swipeRefreshLayout;
    List<FetchExtensionMaterialPreparedDataModel> fetchExtensionMaterialPreparedDataModelList;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_extension_material_prepared);

        extensionMaterialPreparedRV = findViewById(R.id.rv_extensionMaterialPrepared);

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
        extensionMaterialPreparedRV.setHasFixedSize(true);
        extensionMaterialPreparedRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);

        Call<FetchExtensionMaterialPreparedResponse> call = RetrofitClient.getInstance().getApi().fetchExtensionMaterialPreparedResponse();
        call.enqueue(new Callback<FetchExtensionMaterialPreparedResponse>() {
            @Override
            public void onResponse(Call<FetchExtensionMaterialPreparedResponse> call, Response<FetchExtensionMaterialPreparedResponse> response) {
                if (response.isSuccessful()){
                    progressDialog.dismiss();
                    fetchExtensionMaterialPreparedDataModelList = response.body().getFetchExtensionMaterialPreparedDataModelList();
                    extensionMaterialPreparedRV.setAdapter(new ExtensionMaterialPreparedAdapter(getApplicationContext(), fetchExtensionMaterialPreparedDataModelList));
                }
            }

            @Override
            public void onFailure(Call<FetchExtensionMaterialPreparedResponse> call, Throwable t){
                try {
                    Toast.makeText(ViewExtensionMaterialPreparedActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}