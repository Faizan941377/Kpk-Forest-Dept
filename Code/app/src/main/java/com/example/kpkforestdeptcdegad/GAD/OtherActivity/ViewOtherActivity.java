package com.example.kpkforestdeptcdegad.GAD.OtherActivity;

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

import com.example.kpkforestdeptcdegad.GAD.OtherActivity.Adapter.OtherActivityAdapter;
import com.example.kpkforestdeptcdegad.Model.FetchOtherActivityDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchOtherActivityResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewOtherActivity extends AppCompatActivity {

    RecyclerView otherActivityRV;
    ProgressDialog progressDialog;
    SwipeRefreshLayout swipeRefreshLayout;
    List<FetchOtherActivityDataModel> fetchOtherActivityDataModelList;
    EditText searchET;
    OtherActivityAdapter otherActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_other);

        otherActivityRV = findViewById(R.id.rv_view_viewOtherActivity);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        searchET = findViewById(R.id.et_ViewOtherActivity_search);


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
                otherActivityAdapter.getFilter().filter(s);
            }
        });

    }

    private void setAdapter() {

        otherActivityRV.setHasFixedSize(true);
        otherActivityRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        progressDialog.show();
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);


        Call<FetchOtherActivityResponse> call = RetrofitClient.getInstance().getApi().fetchOtherActivityResponse();
        call.enqueue(new Callback<FetchOtherActivityResponse>() {
            @Override
            public void onResponse(Call<FetchOtherActivityResponse> call, Response<FetchOtherActivityResponse> response) {
                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    fetchOtherActivityDataModelList = response.body().getFetchOtherActivityDataModelList();
                    otherActivityRV.setAdapter(new OtherActivityAdapter(getApplicationContext(), fetchOtherActivityDataModelList));
                    otherActivityAdapter = new OtherActivityAdapter(getApplicationContext(),fetchOtherActivityDataModelList);
                    otherActivityRV.setAdapter(otherActivityAdapter);
                } else {
                    Toast.makeText(ViewOtherActivity.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FetchOtherActivityResponse> call, Throwable t) {
                progressDialog.dismiss();
                try {
                    Toast.makeText(ViewOtherActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}