package com.example.kpkforestdeptcdegad.CD.VDC;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.VDC.Adapter.VDC_Adapter;
import com.example.kpkforestdeptcdegad.Model.FetchVDCDataModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.FetchVDCDataResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class View_VDC_DataActivity extends AppCompatActivity {

    RecyclerView vdcViewRV;
    SwipeRefreshLayout swipeRefreshLayout;
    EditText searchET;
    List<FetchVDCDataModel> fetchVDCDataModelList;
    VDC_Adapter vdcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__v_d_c__data);

        vdcViewRV = findViewById(R.id.rv_view_vdc);
        swipeRefreshLayout = findViewById(R.id.swipeLayout);
        searchET = findViewById(R.id.et_search);

        setAdapter();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setAdapter();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

       /* searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<FetchVDCData> filterList = new ArrayList<>();
        for (FetchVDCData item: fetchVDCDataList){
            if (item.getName_of_forest_divsion().toLowerCase().contains(text.toLowerCase())){
                filterList.add(item);
            }
        }

        vdcAdapter.filteredList(filterList);
*/
    }


    private void setAdapter() {

        vdcViewRV.setHasFixedSize(true);
        vdcViewRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Call<FetchVDCDataResponse> call = RetrofitClient.getInstance().getApi().fetchVdcDataResponse();
        call.enqueue(new Callback<FetchVDCDataResponse>() {
            @Override
            public void onResponse(Call<FetchVDCDataResponse> call, Response<FetchVDCDataResponse> response) {
                if (response.isSuccessful()) {
                    fetchVDCDataModelList = response.body().getVdcData();
                    vdcViewRV.setAdapter(new VDC_Adapter((ArrayList<FetchVDCDataModel>) fetchVDCDataModelList, getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<FetchVDCDataResponse> call, Throwable t) {
                try {
                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {

                }
            }
        });
    }
}