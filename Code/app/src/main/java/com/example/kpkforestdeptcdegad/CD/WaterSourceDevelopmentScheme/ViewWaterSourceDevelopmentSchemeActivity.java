package com.example.kpkforestdeptcdegad.CD.WaterSourceDevelopmentScheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.kpkforestdeptcdegad.R;

public class ViewWaterSourceDevelopmentSchemeActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_water_source_development_scheme);

        swipeRefreshLayout = findViewById(R.id.swipeLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                setAdapter();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void setAdapter() {

    }
}