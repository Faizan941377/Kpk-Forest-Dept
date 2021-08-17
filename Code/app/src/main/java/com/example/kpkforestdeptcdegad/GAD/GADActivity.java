package com.example.kpkforestdeptcdegad.GAD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.CD.CD_Activity;
import com.example.kpkforestdeptcdegad.CD.VDC.VDC_Activity;
import com.example.kpkforestdeptcdegad.CD.VDC.View_VDC_DataActivity;
import com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry.FarmAgroForestryMainActivity;
import com.example.kpkforestdeptcdegad.GAD.FarmAgroForestry.ViewFarmAgroForestryActivity;
import com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent.GADMassPlantingEventMainActivity;
import com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent.ViewGadMassPlantingEventActivity;
import com.example.kpkforestdeptcdegad.GAD.OtherActivity.OtherActivityMainActivity;
import com.example.kpkforestdeptcdegad.GAD.OtherActivity.ViewOtherActivity;
import com.example.kpkforestdeptcdegad.GAD.WemonOrganization.ViewWomenOrganizationActivity;
import com.example.kpkforestdeptcdegad.GAD.WemonOrganization.WomenOrganizationActivity;
import com.example.kpkforestdeptcdegad.GAD.YouthWemenNursery.ViewYouthWomenNurseryActivity;
import com.example.kpkforestdeptcdegad.GAD.YouthWemenNursery.YouthWemonNurseryActivity;
import com.example.kpkforestdeptcdegad.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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
        switch (v.getId()) {
            case R.id.bt_gad_womenOrganization:
                AddViewRecordWomenOrganization();
                break;

            case R.id.bt_gad_youth:
                AddViewRecordYouthWomenNursery();
                break;

            case R.id.bt_gad_massPlantingEvent:
                AddViewRecordGADMassPlantingEvent();
                break;

            case R.id.bt_gad_FormAgro:
                AddViewRecordFarmAgroForestry();
                break;

            case R.id.bt_gad_otherActivity:
                AddViewRecordOtherActivity();
                break;
        }
    }

    private void AddViewRecordOtherActivity() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GADActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OtherActivityMainActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewOtherActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void AddViewRecordFarmAgroForestry() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GADActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FarmAgroForestryMainActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewFarmAgroForestryActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void AddViewRecordGADMassPlantingEvent() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GADActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GADMassPlantingEventMainActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewGadMassPlantingEventActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void AddViewRecordYouthWomenNursery() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GADActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), YouthWemonNurseryActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewYouthWomenNurseryActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void AddViewRecordWomenOrganization() {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(GADActivity.this
                , R.style.BottomSheetDialogTheme);

        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_layout, (LinearLayout) findViewById(R.id.bottom_sheet_container));
        bottomSheetView.findViewById(R.id.bt_bottom_sheet_enterNewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WomenOrganizationActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "Add new Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();

        bottomSheetView.findViewById(R.id.bt_bottom_sheet_viewRecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ViewWomenOrganizationActivity.class);
                startActivity(intent);
                Toast.makeText(GADActivity.this, "View Record", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}