package com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.R;

public class View_WaterHarvestingScheme_DataActivity extends AppCompatActivity {

    RecyclerView waterHarvestingSchemeRV;
    WaterHarvestingScheme_Adapter waterHarvestingScheme_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__water_harvesting_scheme__data);

        waterHarvestingSchemeRV = findViewById(R.id.rv_view_water_harvesting_scheme);

        setAdapter();
    }

    private void setAdapter() {
        waterHarvestingScheme_adapter = new WaterHarvestingScheme_Adapter(this);
        waterHarvestingSchemeRV.setLayoutManager(new LinearLayoutManager(this));
        waterHarvestingSchemeRV.setAdapter(waterHarvestingScheme_adapter);
    }
}