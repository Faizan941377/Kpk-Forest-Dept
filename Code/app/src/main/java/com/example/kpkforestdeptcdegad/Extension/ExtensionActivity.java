package com.example.kpkforestdeptcdegad.Extension;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kpkforestdeptcdegad.R;

public class ExtensionActivity extends AppCompatActivity implements View.OnClickListener {

    CardView massPlantingEventBT;
    CardView celebrationOfEnvironmentalBT;
    CardView extensionMaterialPreparedBT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extension);

        massPlantingEventBT = findViewById(R.id.bt_cd_mass_planting_event);
        celebrationOfEnvironmentalBT = findViewById(R.id.bt_cd_CelebrationOfEnvironmental);
        extensionMaterialPreparedBT =findViewById(R.id.bt_cd_ExtensionMaterialPrepared);


        massPlantingEventBT.setOnClickListener(this);
        celebrationOfEnvironmentalBT.setOnClickListener(this);
        extensionMaterialPreparedBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_cd_mass_planting_event:
                Intent intent = new Intent(this, MassPlantingEventActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_cd_CelebrationOfEnvironmental:
                Intent intent1 = new Intent(this,CelebrationOfEnvironmentalPlantingActivity.class);
                startActivity(intent1);
                break;

            case  R.id.bt_cd_ExtensionMaterialPrepared:
                Intent intent2 = new Intent(this,ExtensionMaterialPreparedActivity.class);
                startActivity(intent2);
                break;
        }

    }
}