package com.example.kpkforestdeptcdegad.Extension.CelebrationOfEnvironmentalPlanting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Model.LoginModel;
import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.CelebrationOfEnvironmentalPlantingEventResponse;
import com.example.kpkforestdeptcdegad.SharePrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CelebrationOfEnvironmentalPlantingActivity extends AppCompatActivity implements View.OnClickListener {

    EditText employeeNoET;
    EditText employeeNameET;
    EditText locationOfEventET;
    EditText chiefGuestET;
    EditText environmentalPlantingTypeET;
    EditText environmentalDayPlantingEventET;
    EditText dateOfEventET;
    EditText noOfPlantsPlantedET;
    LinearLayout submitBT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebration_of_environmental_planting);

        employeeNoET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_employeeNo);
        employeeNameET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_employeeName);
        locationOfEventET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_locationOfEvent);
        chiefGuestET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_chiefGuest);
        environmentalPlantingTypeET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_environmentalPlantingType);
        environmentalDayPlantingEventET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_environmentalDayPlantingEvent);
        dateOfEventET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_dateOfEvent);
        noOfPlantsPlantedET = findViewById(R.id.et_celebrationOfEnvironmentalPlanting_noOfPlantsPlanted);
        submitBT = findViewById(R.id.bt_celebrationOfEnvironmentalPlantingEvent);


        LoginModel loginModel = SharePrefManager.getInstance(this).getUsers();
        employeeNoET.setText("" + loginModel.getEmployee_no());
        employeeNameET.setText("" + loginModel.getFull_name());
        employeeNoET.setEnabled(false);
        employeeNameET.setEnabled(false);

        submitBT.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_celebrationOfEnvironmentalPlantingEvent:
                submitData();
        }
    }

    private void submitData() {
        String employeeNo = employeeNoET.getText().toString();
        String employeeName = employeeNameET.getText().toString();
        String locationOfEvent = locationOfEventET.getText().toString();
        String chiefGuest = chiefGuestET.getText().toString();
        String environmentalPlantingType = environmentalPlantingTypeET.getText().toString();
        String environmentalPlantingDayEvent = environmentalDayPlantingEventET.getText().toString();
        String dateOfEvent = dateOfEventET.getText().toString();
        String noOfPlantsPlanted = noOfPlantsPlantedET.getText().toString();

        if (locationOfEventET.length()==0){
            locationOfEventET.setError("Enter the location or Venue");
        }else if (chiefGuestET.length()==0){
            chiefGuestET.setError("Enter the chief guest name");
        }else if (environmentalPlantingTypeET.length()==0){
            environmentalPlantingTypeET.setError("Enter the environmental planting type");
        }else if (environmentalDayPlantingEventET.length()==0){
            environmentalDayPlantingEventET.setError("Enter the environmental planting event");
        }else if (dateOfEventET.length()==0){
            dateOfEventET.setError("Enter the date of event");
        }else if (noOfPlantsPlantedET.length()==0){
            noOfPlantsPlantedET.setError("Enter the no of plants planted");
        }else {

            Call<CelebrationOfEnvironmentalPlantingEventResponse> call = RetrofitClient.getInstance().getApi().celebrationOfEnvironmentalPlantingEventResponse(
                    employeeNo,employeeName,locationOfEvent,chiefGuest,environmentalPlantingType,environmentalPlantingDayEvent,
                    dateOfEvent,noOfPlantsPlanted);
            call.enqueue(new Callback<CelebrationOfEnvironmentalPlantingEventResponse>() {
                @Override
                public void onResponse(Call<CelebrationOfEnvironmentalPlantingEventResponse> call, Response<CelebrationOfEnvironmentalPlantingEventResponse> response) {
                    CelebrationOfEnvironmentalPlantingEventResponse celebrationOfEnvironmentalPlantingEventResponse = response.body();
                    if (response.isSuccessful()){
                        clearEditText();
                        if (celebrationOfEnvironmentalPlantingEventResponse.getError().equals("200")){
                            Toast.makeText(CelebrationOfEnvironmentalPlantingActivity.this, celebrationOfEnvironmentalPlantingEventResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }else if (celebrationOfEnvironmentalPlantingEventResponse.getError().equals("400")){
                            Toast.makeText(CelebrationOfEnvironmentalPlantingActivity.this, celebrationOfEnvironmentalPlantingEventResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<CelebrationOfEnvironmentalPlantingEventResponse> call, Throwable t) {
                    try {
                        Toast.makeText(CelebrationOfEnvironmentalPlantingActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void clearEditText() {
        locationOfEventET.setText("");
        chiefGuestET.setText("");
        environmentalPlantingTypeET.setText("");
        environmentalDayPlantingEventET.setText("");
        dateOfEventET.setText("");
        noOfPlantsPlantedET.setText("");
    }
}