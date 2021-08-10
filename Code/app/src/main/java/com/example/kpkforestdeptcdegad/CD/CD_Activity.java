package com.example.kpkforestdeptcdegad.CD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.Enclosure.EnclosureActivity;
import com.example.kpkforestdeptcdegad.CD.Enclosure.View_Enclosure_DataActivity;
import com.example.kpkforestdeptcdegad.CD.FormForestry.FormForestryActivity;
import com.example.kpkforestdeptcdegad.CD.FormForestry.View_FormForestry_DataActivity;
import com.example.kpkforestdeptcdegad.CD.JFMC.JFMCActivity;
import com.example.kpkforestdeptcdegad.CD.JFMC.JFMC_View_DataActivity;
import com.example.kpkforestdeptcdegad.CD.VDC.VDC_Activity;
import com.example.kpkforestdeptcdegad.CD.VDC.View_VDC_DataActivity;
import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.View_WaterHarvestingScheme_DataActivity;
import com.example.kpkforestdeptcdegad.CD.WaterHarvestingScheme.WaterHarvestingSchemesActivity;
import com.example.kpkforestdeptcdegad.CD.WaterSoruceDevelopmentScheme.WaterSoruceDevelopmentSchemeActivity;
import com.example.kpkforestdeptcdegad.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CD_Activity extends AppCompatActivity implements View.OnClickListener {

    CardView vcdBT;
    CardView enclosureBT;
    CardView gfmcBT;
    CardView waterHarvestingSchemesBT;
    CardView formForestryBT;
    CardView waterSourceDevelopmentSchemesBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_d);

        vcdBT = findViewById(R.id.bt_cd_vcd);
        enclosureBT = findViewById(R.id.bt_cd_enclosure);
        gfmcBT = findViewById(R.id.bt_cd_gfmc);
        waterHarvestingSchemesBT = findViewById(R.id.bt_cd_waterHarvestingSchemes);
        formForestryBT = findViewById(R.id.bt_cd_formForestry);
        waterSourceDevelopmentSchemesBT = findViewById(R.id.bt_cd_waterSourceDevelopmentSchemes);


        vcdBT.setOnClickListener(this);
        enclosureBT.setOnClickListener(this);
        gfmcBT.setOnClickListener(this);
        waterHarvestingSchemesBT.setOnClickListener(this);
        formForestryBT.setOnClickListener(this);
        waterSourceDevelopmentSchemesBT.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_cd_vcd:
                AddViewRecordVCD();
                break;

            case R.id.bt_cd_formForestry:
                AddViewRecordFormForestry();
                break;

            case R.id.bt_cd_gfmc:
                AddViewRecordJFMC();
                break;

            case R.id.bt_cd_enclosure:
                AddViewRecordEnclosure();
                break;

            case R.id.bt_cd_waterHarvestingSchemes:
                AddViewRecordWaterHarvestingSchemes();
                break;

            case R.id.bt_cd_waterSourceDevelopmentSchemes:
                Intent intent = new Intent(this, WaterSoruceDevelopmentSchemeActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void AddViewRecordVCD() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CD_Activity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VDC_Activity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), View_VDC_DataActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void AddViewRecordFormForestry() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CD_Activity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FormForestryActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), View_FormForestry_DataActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void AddViewRecordJFMC() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CD_Activity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JFMCActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JFMC_View_DataActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    public void AddViewRecordEnclosure() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CD_Activity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EnclosureActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), View_Enclosure_DataActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    public void AddViewRecordWaterHarvestingSchemes() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(CD_Activity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WaterHarvestingSchemesActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), View_WaterHarvestingScheme_DataActivity.class);
                startActivity(intent);
                Toast.makeText(CD_Activity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

}