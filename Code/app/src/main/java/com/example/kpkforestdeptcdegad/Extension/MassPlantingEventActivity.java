package com.example.kpkforestdeptcdegad.Extension;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kpkforestdeptcdegad.Network.RetrofitClient;
import com.example.kpkforestdeptcdegad.R;
import com.example.kpkforestdeptcdegad.Response.MassPlantingEventResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MassPlantingEventActivity extends AppCompatActivity implements View.OnClickListener {

    EditText locationET;
    EditText chiefGustET;
    EditText dateOfEventET;
    EditText noOfPlantsPlantedET;
    EditText noOfPlantsDistributedET;
    EditText springMoonSoonET;
    EditText totalNoOfPlantsET;
    LinearLayout submitET;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_planting_event);


        locationET = findViewById(R.id.et_massPlantingEvent_Location);
        chiefGustET = findViewById(R.id.et_massPlantingEvent_chiefGuest);
        dateOfEventET = findViewById(R.id.et_massPlantingEvent_dateOfEvent);
        noOfPlantsPlantedET = findViewById(R.id.et_massPlantingEvent_noOfPlantsPlanted);
        noOfPlantsDistributedET = findViewById(R.id.et_massPlantingEvent_noOfPlantsDistributed);
        springMoonSoonET = findViewById(R.id.et_massPlantingEvent_springMoonSoon);
        totalNoOfPlantsET = findViewById(R.id.et_massPlantingEvent_totalNoOfPlants);
        submitET = findViewById(R.id.bt_massPlantingEvent_Submit);

        progressDialog = new ProgressDialog(this);
        submitET.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_massPlantingEvent_Submit:
                submitMassPlantingEvent();
                break;
        }
    }

    private void submitMassPlantingEvent() {

        String location = locationET.getText().toString();
        String chiefGust = chiefGustET.getText().toString();
        String dateOfEvent = dateOfEventET.getText().toString();
        String noOfPlantsPlanted = noOfPlantsPlantedET.getText().toString();
        String noOfPlantsDistributed = noOfPlantsDistributedET.getText().toString();
        String springMoonSoon = springMoonSoonET.getText().toString();
        String totalNoOfPlantsPlanted = totalNoOfPlantsET.getText().toString();

        if (locationET.length() == 0) {
            locationET.setError("Enter the location");
        } else if (chiefGustET.length() == 0) {
            chiefGustET.setError("Enter the Chief Gust's");
        } else if (dateOfEventET.length() == 0) {
            dateOfEventET.setError("Enter the date of event");
        } else if (noOfPlantsPlantedET.length() == 0) {
            noOfPlantsPlantedET.setError("Enter the no of plants planted");
        } else if (noOfPlantsDistributedET.length() == 0) {
            noOfPlantsDistributedET.setError("Enter the no of plants distributed");
        } else if (springMoonSoonET.length() == 0) {
            springMoonSoonET.setError("Enter the spring moon soon");
        } else if (totalNoOfPlantsET.length() == 0) {
            totalNoOfPlantsET.setError("Enter the total no of plants");
        } else {


            progressDialog.show();
            progressDialog.setMessage("Please wait it will take few moments");
            progressDialog.setCancelable(false);
            progressDialog.setIndeterminate(true);

            Call<MassPlantingEventResponse> call = RetrofitClient.getInstance().getApi().massPlantingEventResponse(location, chiefGust,
                    dateOfEvent, noOfPlantsPlanted, noOfPlantsDistributed, springMoonSoon, totalNoOfPlantsPlanted);
            call.enqueue(new Callback<MassPlantingEventResponse>() {
                @Override
                public void onResponse(Call<MassPlantingEventResponse> call, Response<MassPlantingEventResponse> response) {
                    MassPlantingEventResponse massPlantingEventResponse = response.body();
                    if (response.isSuccessful()) {
                        progressDialog.dismiss();
                        editFieldClear();
                        if (massPlantingEventResponse.equals("200")) {
                            Toast.makeText(MassPlantingEventActivity.this, massPlantingEventResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        } else if (massPlantingEventResponse.equals("400")) {
                            Toast.makeText(MassPlantingEventActivity.this, massPlantingEventResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<MassPlantingEventResponse> call, Throwable t) {
                    try {
                        Toast.makeText(MassPlantingEventActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void editFieldClear() {
        locationET.setText("");
        chiefGustET.setText("");
        dateOfEventET.setText("");
        noOfPlantsPlantedET.setText("");
        noOfPlantsDistributedET.setText("");
        springMoonSoonET.setText("");
        totalNoOfPlantsET.setText("");
    }
}