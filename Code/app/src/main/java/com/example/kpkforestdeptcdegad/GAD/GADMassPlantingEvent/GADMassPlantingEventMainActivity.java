package com.example.kpkforestdeptcdegad.GAD.GADMassPlantingEvent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.GadMassPlantingEventResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GADMassPlantingEventMainActivity extends AppCompatActivity implements View.OnClickListener {


    EditText employeeNoET;
    EditText employeeNameET;
    EditText nameOfDivisionET;
    EditText chiefGuestET;
    EditText nameOfEventET;
    EditText dateOfEventET;
    EditText locationET;
    EditText nameOfInstituteET;
    EditText noOfPlantsPlantedET;
    EditText noOfPlantsDistributedET;
    EditText noOfPlantsUtilizedET;
    LinearLayout submitBT;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_a_d_mass_planting_event_main);

        employeeNoET = findViewById(R.id.et_GadMassPlantingEvent_employeeNo);
        employeeNameET = findViewById(R.id.et_GadMassPlantingEvent_employeeName);
        nameOfDivisionET = findViewById(R.id.et_GadMassPlantingEvent_nameOfDivision);
        chiefGuestET = findViewById(R.id.et_GadMassPlantingEvent_ChiefGuest);
        nameOfEventET = findViewById(R.id.et_GadMassPlantingEvent_nameOfEvent);
        dateOfEventET = findViewById(R.id.et_GadMassPlantingEvent_dateOfEvent);
        locationET = findViewById(R.id.et_GadMassPlantingEvent_location);
        nameOfInstituteET = findViewById(R.id.et_GadMassPlantingEvent_nameOfInstitute);
        noOfPlantsPlantedET = findViewById(R.id.et_GadMassPlantingEvent_noOfPlantsPlanted);
        noOfPlantsDistributedET = findViewById(R.id.et_GadMassPlantingEvent_noOfPlantsDistributed);
        noOfPlantsUtilizedET = findViewById(R.id.et_GadMassPlantingEvent_noOfPlantsUtilized);
        submitBT = findViewById(R.id.bt_GadMassPlantingEvent_submit);

        progressDialog = new ProgressDialog(this);
        submitBT.setOnClickListener(this);

        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_GadMassPlantingEvent_submit:
                GadMassPlantingEventSubmit();
                break;
        }
    }

    private void GadMassPlantingEventSubmit() {

        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String nameOfDivision = nameOfDivisionET.getText().toString();
        String chiefGuest = chiefGuestET.getText().toString();
        String nameOfEvent = nameOfEventET.getText().toString();
        String dateOfEvent = dateOfEventET.getText().toString();
        String location = locationET.getText().toString();
        String nameOfInstitute = nameOfInstituteET.getText().toString();
        String noOfPlantsPlanted = noOfPlantsPlantedET.getText().toString();
        String noOfPlantsDistributed = noOfPlantsDistributedET.toString();
        String noOfPlantsUtilized = noOfPlantsUtilizedET.getText().toString();

        if (nameOfDivisionET.length() == 0) {
            nameOfDivisionET.setError("Enter the name of division");
        } else if (chiefGuestET.length() == 0) {
            chiefGuestET.setError("Enter the chief guest");
        } else if (nameOfEventET.length() == 0) {
            nameOfEventET.setError("Enter the name of event");
        } else if (dateOfEventET.length() == 0) {
            dateOfEventET.setError("Enter the date of event");
        } else if (locationET.length() == 0) {
            locationET.setError("Enter the location");
        } else if (nameOfInstituteET.length() == 0) {
            nameOfInstituteET.setError("Enter the name of institute");
        } else if (noOfPlantsPlantedET.length() == 0) {
            noOfPlantsPlantedET.setError("Enter the no of plants planted");
        } else if (noOfPlantsDistributedET.length() == 0) {
            noOfPlantsDistributedET.setError("Enter the no of plants distributed");
        } else if (noOfPlantsUtilizedET.length() == 0) {
            noOfPlantsUtilizedET.setError("Enter the no of plants utilized");
        } else {

            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);


            Call<GadMassPlantingEventResponse> call = RetrofitClient.getInstance().getApi().gadMassPlantingEventResponse(
                    employeeNo, employeeName, nameOfDivision, chiefGuest, nameOfEvent, dateOfEvent, location, nameOfInstitute, noOfPlantsPlanted,
                    noOfPlantsDistributed, noOfPlantsUtilized);

            call.enqueue(new Callback<GadMassPlantingEventResponse>() {
                @Override
                public void onResponse(Call<GadMassPlantingEventResponse> call, Response<GadMassPlantingEventResponse> response) {
                    GadMassPlantingEventResponse gadMassPlantingEventResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        if (gadMassPlantingEventResponse.getError().equals("200")) {
                            Toast.makeText(GADMassPlantingEventMainActivity.this, gadMassPlantingEventResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (gadMassPlantingEventResponse.getError().equals("400")) {
                            Toast.makeText(GADMassPlantingEventMainActivity.this, gadMassPlantingEventResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<GadMassPlantingEventResponse> call, Throwable t) {
                    try {
                        Toast.makeText(GADMassPlantingEventMainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}