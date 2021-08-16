package com.example.kpkforestdeptcdegad.GAD.WemonOrganization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kpkforestdeptcdegad.R;

public class WomenOrganizationActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView showImageIV;
    EditText nameOfVillageVdcET;
    EditText nameOfWOET;
    EditText dateYearOfEstablishmentET;
    EditText nameOfPresidentET;
    EditText majorActivitiesET;
    EditText totalNoOfMemberET;
    EditText contactET;
    EditText remarksET;
    LinearLayout submitBT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wemon_organization);

        showImageIV = findViewById(R.id.iv_showImage);
        nameOfVillageVdcET = findViewById(R.id.et_womenOrganization_nameOfVillageVdc);
        nameOfWOET = findViewById(R.id.et_womenOrganization_nameOfWO);
        dateYearOfEstablishmentET = findViewById(R.id.et_womenOrganization_DateYearOfEstablishment);
        nameOfPresidentET = findViewById(R.id.et_womenOrganization_nameOfPresident);
        majorActivitiesET = findViewById(R.id.et_womenOrganization_majorActivities);
        totalNoOfMemberET = findViewById(R.id.et_womenOrganization_totalNoOfMembers);
        contactET = findViewById(R.id.et_womenOrganization_contact);
        remarksET = findViewById(R.id.et_womenOrganization_remarks);
        submitBT = findViewById(R.id.bt_womenOrganization_submit);


        submitBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_womenOrganization_submit:
                submitWemonOrganization();
                break;
        }
    }

    private void submitWemonOrganization() {

        String nameOfVillageVdc = nameOfVillageVdcET.getText().toString();
        String nameOfWO = nameOfWOET.getText().toString();
        String dateYearOfEstablishment = dateYearOfEstablishmentET.getText().toString();
        String nameOfPresident = nameOfPresidentET.getText().toString();
        String majorActivities = majorActivitiesET.getText().toString();
        String totalNoOfMember = totalNoOfMemberET.getText().toString();
        String contact = contactET.getText().toString();
        String  remarks = remarksET.getText().toString();



    }
}