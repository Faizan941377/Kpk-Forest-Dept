package com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.Adapter.WaterHarvestingScheme_Adapter;
import com.example.kpkforestdeptcdegad.R;

public class WaterHarvestingSchemesActivity extends AppCompatActivity implements View.OnClickListener {

    EditText waterHarvestingSchemeET;
    EditText nameOfForestDivisionET;
    EditText waterSourceDevelopmentSchemeET;
    EditText targetAsPC1ET;
    EditText achievedSoFarNoET;
    EditText vdcEstablishET;
    EditText progressTillDateET;
    LinearLayout submitBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_harvesting_schemes);

        waterHarvestingSchemeET = findViewById(R.id.et_waterHarvestingScheme_waterHarvestingScheme);
        nameOfForestDivisionET = findViewById(R.id.et_waterHarvestingScheme_NameOfForestDivision);
        waterSourceDevelopmentSchemeET = findViewById(R.id.et_waterHarvestingScheme_waterSourceDevelopmentScheme);
        targetAsPC1ET = findViewById(R.id.et_waterHarvestingScheme_TargetAsPC1);
        achievedSoFarNoET = findViewById(R.id.et_waterHarvestingScheme_AchievedSoFarNo);
        vdcEstablishET = findViewById(R.id.et_waterHarvestingScheme_vdcEstablish);
        progressTillDateET = findViewById(R.id.et_waterHarvestingScheme_progressTillDate);
        submitBT = findViewById(R.id.bt_waterHarvestingScheme_submit);

        submitBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_waterHarvestingScheme_submit:
                Toast.makeText(this, "Water Harvesting Scheme Submitted", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}