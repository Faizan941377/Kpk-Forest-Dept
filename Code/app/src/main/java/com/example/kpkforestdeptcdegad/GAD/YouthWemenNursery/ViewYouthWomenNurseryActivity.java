package com.example.kpkforestdeptcdegad.GAD.YouthWemenNursery;

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

import com.example.kpkforestdeptcdegad.GAD.YouthWemenNursery.Adapter.YouthWomenNurseryAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchYouthWomenNurseryDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchYouthWomenNurseryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewYouthWomenNurseryActivity extends AppCompatActivity {

    RecyclerView youthWomenNurseryRV;
    SwipeRefreshLayout swipeRefreshLayout;
    ProgressDialog progressDialog;
    List<FetchYouthWomenNurseryDataModel> fetchYouthWomenNurseryDataModelList;
    EditText searchET;
    YouthWomenNurseryAdapter youthWomenNurseryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_youth_women_nursery);


        progressDialog = new ProgressDialog(this);
        youthWomenNurseryRV = findViewById(R.id.rv_view_YouthWWomenNursery);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        searchET = findViewById(R.id.et_ViewYouthWomenNurser_search);

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
                youthWomenNurseryAdapter.getFilter().filter(s);
            }
        });
    }

    private void setAdapter() {

        youthWomenNurseryRV.setHasFixedSize(true);
        youthWomenNurseryRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);

        Call<FetchYouthWomenNurseryResponse> call = RetrofitClient.getInstance().getApi().fetchYouthWomenNurseryResponse();
        call.enqueue(new Callback<FetchYouthWomenNurseryResponse>() {
            @Override
            public void onResponse(Call<FetchYouthWomenNurseryResponse> call, Response<FetchYouthWomenNurseryResponse> response) {
                if (response.isSuccessful()) {
                    fetchYouthWomenNurseryDataModelList = response.body().getFetchYouthWomenNurseryDataModelList();
                    youthWomenNurseryRV.setAdapter(new YouthWomenNurseryAdapter(getApplicationContext(), fetchYouthWomenNurseryDataModelList));
                    youthWomenNurseryAdapter = new YouthWomenNurseryAdapter(getApplicationContext(), fetchYouthWomenNurseryDataModelList);
                    youthWomenNurseryRV.setAdapter(youthWomenNurseryAdapter);
                } else {
                    Toast.makeText(ViewYouthWomenNurseryActivity.this, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchYouthWomenNurseryResponse> call, Throwable t) {
                try {
                    Toast.makeText(ViewYouthWomenNurseryActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}