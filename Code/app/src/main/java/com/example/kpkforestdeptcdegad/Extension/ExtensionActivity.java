package com.example.kpkforestdeptcdegad.Extension;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting.CelebrationOfEnvironmentalPlantingActivity;
import com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting.ViewCelebrationOfEnvironmentalPlantingActivity;
import com.example.kpkforestdeptcdegad.Extension.ExtensionMaterialPrepared.ExtensionMaterialPreparedActivity;
import com.example.kpkforestdeptcdegad.Extension.ExtensionMaterialPrepared.ViewExtensionMaterialPreparedActivity;
import com.example.kpkforestdeptcdegad.Extension.MassPlantingEvent.MassPlantingEventActivity;
import com.example.kpkforestdeptcdegad.Extension.MassPlantingEvent.ViewMassPlantingEventActivity;
import com.example.kpkforestdeptcdegad.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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
                extensionMassPlantingEvent();
                break;

            case R.id.bt_cd_CelebrationOfEnvironmental:
                extensionCelebrationOfEnvironmental();
                break;

            case  R.id.bt_cd_ExtensionMaterialPrepared:
                extensionMaterialPrepared();
                break;
        }

    }

    private void extensionMaterialPrepared() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ExtensionActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ExtensionMaterialPreparedActivity.class);
                startActivity(intent);
                Toast.makeText(ExtensionActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewExtensionMaterialPreparedActivity.class);
                startActivity(intent);
                Toast.makeText(ExtensionActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void extensionCelebrationOfEnvironmental() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ExtensionActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CelebrationOfEnvironmentalPlantingActivity.class);
                startActivity(intent);
                Toast.makeText(ExtensionActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewCelebrationOfEnvironmentalPlantingActivity.class);
                startActivity(intent);
                Toast.makeText(ExtensionActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }

    private void extensionMassPlantingEvent() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ExtensionActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MassPlantingEventActivity.class);
                startActivity(intent);
                Toast.makeText(ExtensionActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewMassPlantingEventActivity.class);
                startActivity(intent);
                Toast.makeText(ExtensionActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

    }
}