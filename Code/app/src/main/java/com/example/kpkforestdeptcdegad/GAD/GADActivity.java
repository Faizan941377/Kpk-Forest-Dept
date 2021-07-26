package com.example.kpkforestdeptcdegad.GAD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kpkforestdeptcdegad.R;

public class GADActivity extends AppCompatActivity implements View.OnClickListener {

    CardView womenOrganizationBT;
    CardView youthPlantingEventBT;
    CardView formAgroForestryBT;
    CardView massPlantingEventBT;
    CardView otherActivityBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_a_d);

        womenOrganizationBT = findViewById(R.id.bt_gad_womenOrganization);
        youthPlantingEventBT = findViewById(R.id.bt_gad_youth);
        formAgroForestryBT = findViewById(R.id.bt_gad_FormAgro);
        massPlantingEventBT = findViewById(R.id.bt_gad_massPlantingEvent);
        otherActivityBT = findViewById(R.id.bt_gad_otherActivity);


        womenOrganizationBT.setOnClickListener(this);
        youthPlantingEventBT.setOnClickListener(this);
        formAgroForestryBT.setOnClickListener(this);
        massPlantingEventBT.setOnClickListener(this);
        otherActivityBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_gad_womenOrganization:
                Intent intent = new Intent(this,WemonOrganizationActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_gad_youth:
                Intent intent1 = new Intent(this,YouthWemonNurseryActivity.class);
                startActivity(intent1);
                break;

            case R.id.bt_gad_massPlantingEvent:
                Intent intent2 = new Intent(this,GADMassPlantingEventMainActivity.class);
                startActivity(intent2);
                break;

            case R.id.bt_gad_FormAgro:
                Intent intent3 = new Intent(this,FarmAgroForestryMainActivity.class);
                startActivity(intent3);
                break;

            case R.id.bt_gad_otherActivity:
                Intent intent4 = new Intent(this,OtherActivityMainActivity.class);
                startActivity(intent4);
                break;
        }
    }
}