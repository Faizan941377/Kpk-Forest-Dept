package com.example.kpkforestdeptcdegad.CD.FormForestry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.R;

import java.time.ZoneId;

public class FormForestryActivity extends AppCompatActivity implements View.OnClickListener {

    EditText farmAgroForestryET;
    EditText nameOfForestDivisionRangeET;
    EditText totalNoOfPlantsDistributedSoFarET;
    EditText nameOfSubDivisionRangeET;
    EditText plantsDistributedTodayET;
    EditText totalNoOfPlantsDistributedTillDateET;
    LinearLayout submitBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_forestry);

        farmAgroForestryET = findViewById(R.id.et_farm_forestry_FarmAgroForestry);
        nameOfForestDivisionRangeET =findViewById(R.id.et_farm_forestry_NameOfForestDivisionNameRange);
        totalNoOfPlantsDistributedSoFarET = findViewById(R.id.et_farm_forestry_TotalNoOfPlantsDistributedSoFar);
        nameOfSubDivisionRangeET = findViewById(R.id.et_farm_forestry_NameOfSubDivisionRange);
        plantsDistributedTodayET = findViewById(R.id.et_farm_forestry_PlantsDistributedToday);
        totalNoOfPlantsDistributedTillDateET = findViewById(R.id.et_farm_forestry_TotalNoOfPlantsDistributedTillDate);
        submitBT = findViewById(R.id.bt_Farm_Forestry_submit);

        submitBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_Farm_Forestry_submit:
                Toast.makeText(this, "Farm Forestry Submitted", Toast.LENGTH_SHORT).show();
        }
    }
}